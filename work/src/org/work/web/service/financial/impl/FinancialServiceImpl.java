/**
 * 
 */
package org.work.web.service.financial.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.work.web.dao.information.IInformationDao;
import org.work.web.dao.information.IInformationHisDao;
import org.work.web.dao.information.IInformationTaiDao;
import org.work.web.dao.manage.ICatalogDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.po.Informationhis;
import org.work.web.po.Tai;
import org.work.web.service.financial.IFinancialService;
import org.work.web.util.BeanCompare;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.Parameter;
import org.work.web.util.XlsUtil;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class FinancialServiceImpl implements IFinancialService{
	private static final Logger logger = Logger.getLogger(FinancialServiceImpl.class);
	private IInformationDao informationDao;
	private ICatalogDao catalogDao;
	private IInformationHisDao informationHisDao;
	private IInformationTaiDao informationTaiDao;


	public void setInformationTaiDao(IInformationTaiDao informationTaiDao) {
		this.informationTaiDao = informationTaiDao;
	}

	public void setInformationDao(IInformationDao informationDao) {
		this.informationDao = informationDao;
	}

	public void setCatalogDao(ICatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}

	public void setInformationHisDao(IInformationHisDao informationHisDao) {
		this.informationHisDao = informationHisDao;
	}

	public Catalog findByCatalogId(int cid) {
		logger.info("查询金融机构类别开始");
		return (Catalog) catalogDao.findById(cid);
	}

	public Information findByOid(Integer oid) {
		logger.info("查询金融机构开始");
		return (Information)informationDao.findById(oid);
	}

	public List<Catalog> findByCatalog() {
		logger.info("查询所有金融机构类别");
		return catalogDao.findAllSort();
	}

	public void addInformation(Information information) {
		logger.info("人民银行用户增加金融机构基本信息，只增加金融机构ID与金融机构名称");
		informationDao.save(information);

	}

	public void updateInformation(Information information1,Information information2){
		try {
			Informationhis informationhis = null;
			informationhis = (Informationhis) BeanCompare.compareInformation(information1, information2);
			if (informationhis == null) {
				return;
			}
			informationDao.saveOrUpdate(information2);
			logger.info("保存金融机构信息");
			informationhis.setBupdatetime(information2.getBupdatetime());
			informationhis.setBupdateuser(information2.getBupdateuser());
			informationhis.setBOrgInformation(information2);
			informationhis.setBOrgCatalog(information2.getBOrgCatalog());
			informationHisDao.save(informationhis);	
		} catch (Exception e) {
			logger.info(e);
			throw new ServiceException("保存异常");
		}
	}

	public void updateInformation(Information information) {
		// TODO Auto-generated method stub

	}

	
	public PaginaterList getInformationFinancial(Map<String, Object> params,Integer page) {
		logger.info("人民银行用户查询金融机构信息");	
		return informationDao.getInformationFinancial(params,page);
	}

	public PaginaterList getHistoryFinancial(Map<String, Object> params,Integer page) {
		logger.info("人民银行用户查看金融机构变更历史");	
		return informationHisDao.getHistoryFinancial(params,page);
	}

	public String buildXls(String username,String path,Map<String, Object> params) {		
		logger.info("人民银行用户导出金融机构信息到excel");				
		String filename = "";
		Map map = new HashMap();
		Map map2 = new HashMap();		
		
		List headlist = new ArrayList();
		List valueList = new ArrayList();
		int columnCount = 0;
		
		headlist.add("机构代码");
		headlist.add("机构名称");
		headlist.add("办公地址");
		headlist.add("分管领导");
		headlist.add("领导职务");
		headlist.add("反洗钱部门");
		headlist.add("部分负责人");
		headlist.add("反洗钱联系人");
		headlist.add("联系电话");		
		columnCount = headlist.size();
		
		List<Information> financials = informationDao.getInformationFinancialAll(params);

		for(Information info : financials){
			List tmpList2 = new ArrayList();
			Parameter parameter = new Parameter();
			tmpList2.add(info.getBoid());			
			tmpList2.add(info.getBname());
			tmpList2.add(info.getBaddr());			
			tmpList2.add(info.getBlead());
			tmpList2.add(info.getBleadpst());			
			tmpList2.add(info.getBdept());
			tmpList2.add(info.getBdeptlead());
			tmpList2.add(info.getBwork());
			tmpList2.add(info.getBworktel());
			parameter.setList(tmpList2);			
			valueList.add(parameter);
		}
		
		map.put("ColumnName", headlist);
		map.put("DataContent", valueList);
		map.put("ColumnCount", columnCount);
		
		List nameList = new ArrayList();
		nameList.add("用户列表");		
		List countList = new ArrayList();
		countList.add("9");		
		
		map2.put("nameList", nameList);
		map2.put("countList", countList);
		
		XlsUtil xls = new XlsUtil();		
		filename = xls.build(DateUtil.formatDateTime(), path, "金融机构信息", "", username, map, map2);		
		System.out.println("-------------  filename ::  "+filename);		
		
		return filename;
	}

	public PaginaterList findTai(Map<String, Object> params, Integer page) {
		return informationTaiDao.getInformationTai(params, page);
	}

	public void saveTai(Tai tai) {
		informationTaiDao.saveOrUpdate(tai);
	}

	public Tai findTai(Integer taidi) {
		return (Tai) informationTaiDao.findById(taidi);
	}

	public List findByBoid(String information) {
		List list = informationDao.findByBoid(information);
		return list;
	}

}
