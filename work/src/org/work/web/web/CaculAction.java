/**
 * 
 */
package org.work.web.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.work.web.po.Catalog;
import org.work.web.service.cacul.ICaculService;
import org.work.web.service.financial.IFinancialService;
import org.work.web.util.DateUtil;
import org.work.web.util.Paginater;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class CaculAction extends JsonBaseAction{
	
	private IFinancialService financialService;
	private ICaculService caculService;

	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别
	private String year;//报表年份
	private String quater;//报表季度
	
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getQuater() {
		return quater;
	}

	public void setQuater(String quater) {
		this.quater = quater;
	}

	public void setCaculService(ICaculService caculService) {
		this.caculService = caculService;
	}

	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}


	/**
	 * 报表上报情况统计
	 * @return
	 */
	public String  reportstatus() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}
	public String list() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", getSessionUserInformation()==null?this.getOid():getSessionUserInformation());
		params.put("bid",getBid());
		params.put("year",getYear());
		params.put("quater",getQuater()==null||"".equals(getQuater())?DateUtil.getSeason(getEndday()):getQuater());
		List<Map> result = new ArrayList<Map>();
		Map<String,Object> item;
		List list = caculService.getReportstatus(params);
		for(Iterator<Object[]> iterator = list.iterator();iterator.hasNext();){
			Object[] array = iterator.next();
			item = new HashMap<String,Object>();
			item.put("oid", array[0]);
			item.put("r1", array[1]);
			item.put("r2", array[2]);
			item.put("r3", array[3]);
			item.put("r4", array[4]);
			item.put("r5", array[5]);
			item.put("r6", array[6]);
			item.put("r7", array[7]);
			item.put("r8", array[8]);
			item.put("r9", array[9]);
			item.put("r10", array[10]);
			result.add(item);
		}
		this.setGridModel(result);
		setRows(getRows());
		setRecord(list.size());
		return JSON;
	}
	/**
	 * 重点可疑交易报表
	 */
	public String  reportimport() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}
	public String listimport() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", getSessionUserInformation()==null?this.getOid():getSessionUserInformation());
		params.put("bid",getBid());
		params.put("year",getYear());
		params.put("quater",getQuater()==null||"".equals(getQuater())?DateUtil.getSeason(getEndday()):getQuater());
		PaginaterList listp = caculService.getReportImport(params,this.getPage());
		put("listp",listp.getList());
		put(Paginater.PAGINATER, listp.getPaginater());
		return SUCCESS;
	}
	public String listimportB() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", getSessionUserInformation()==null?this.getOid():getSessionUserInformation());
		params.put("bid",getBid());
		params.put("year",getYear());
		params.put("quater",getQuater()==null||"".equals(getQuater())?DateUtil.getSeason(getEndday()):getQuater());
		PaginaterList listp = caculService.getReportImportB(params,this.getPage());
		List list1 = listp.getList();
		int a = 0,b=0;
		double c = 0d,d=0d;
		for(Iterator iterator = list1.iterator();iterator.hasNext();){
			Object[] objects = (Object[]) iterator.next();
			System.out.println(objects[0]+"...................");
			a+=Integer.valueOf(null==objects[2]?"0":objects[2].toString());
			b+=Integer.valueOf(null==objects[4]?"0":objects[4].toString());
			c+=Double.valueOf(null==objects[3]?"0":objects[3].toString());
			d+=Double.valueOf(null==objects[5]?"0":objects[5].toString());
		}
		Object[] aim = {"","合计",a,c,b,d};
		list1.add(aim);
		put("listp",list1);
		put(Paginater.PAGINATER, listp.getPaginater());
		return SUCCESS;
	}
	/**
	 * 可疑交易报表
	 */
	public String  reportsus() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}
	public String listsusreport() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", getSessionUserInformation()==null?this.getOid():getSessionUserInformation());
		params.put("bid",getBid());
		params.put("year",getYear());
		params.put("quater",getQuater()==null||"".equals(getQuater())?DateUtil.getSeason(getEndday()):getQuater());
		PaginaterList listp = caculService.getReportSusreport(params,this.getPage());
		put("listp",listp.getList());
		put(Paginater.PAGINATER, listp.getPaginater());
		return SUCCESS;
	}
	@Override
	public List getGridModel() {
		
		return this.gridModel;
	}

	@Override
	public Integer getPage() {
		
		return this.page;
	}

	@Override
	public Integer getRecords() {
		
		return this.record;
	}

	@Override
	public Integer getRows() {
		
		return this.rows;
	}

	@Override
	public String getSidx() {
		
		return this.sidx;
	}

	@Override
	public String getSord() {
		
		return this.sord;
	}

	@Override
	public Long getTotal() {
		
		return this.total;
	}
}
