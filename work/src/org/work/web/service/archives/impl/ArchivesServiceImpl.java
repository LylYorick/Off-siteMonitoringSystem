package org.work.web.service.archives.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.classfile.Constant;
import org.work.web.constants.ConstantMethods;
import org.work.web.constants.Constants;
import org.work.web.dao.archives.ArchivesDao;
import org.work.web.dao.archives.IArchivesHisDao;
import org.work.web.dao.manage.ICatalogDao;
import org.work.web.dao.manage.ICatalogNewDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Archives;
import org.work.web.po.ArchivesHis;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Archives;
import org.work.web.po.CatalogNew;
import org.work.web.po.Information;
import org.work.web.po.Informationhis;
import org.work.web.po.Role;
import org.work.web.service.archives.ArchivesService;
import org.work.web.service.manage.IManageService;
import org.work.web.util.BeanCompare;
import org.work.web.util.PaginaterList;

public class ArchivesServiceImpl implements ArchivesService {
	private static final Logger logger = Logger.getLogger(ArchivesServiceImpl.class);
	private ICatalogNewDao catalogNewDao;
	private ArchivesDao archivesDao;
	private IArchivesHisDao iArchivesHisDao;
	private IManageService manageService;
	
 	
	public IManageService getManageService() {
		return manageService;
	}

	public void setManageService(IManageService manageService) {
		this.manageService = manageService;
	}

	public IArchivesHisDao getiArchivesHisDao() {
		return iArchivesHisDao;
	}

	public void setiArchivesHisDao(IArchivesHisDao iArchivesHisDao) {
		this.iArchivesHisDao = iArchivesHisDao;
	}
	
	

	public ICatalogNewDao getCatalogNewDao() {
		return catalogNewDao;
	}

	public void setCatalogNewDao(ICatalogNewDao catalogNewDao) {
		this.catalogNewDao = catalogNewDao;
	}

	public ArchivesDao getArchivesDao() {
		return archivesDao;
	}


	public void setArchivesDao(ArchivesDao archivesDao) {
		this.archivesDao = archivesDao;
	}


	@Override
	public List<CatalogNew> findAllFirstCatname() {
		logger.info("查询所有金融机构一级类别");
		return catalogNewDao.findAllFirstCatname();
	}

	@Override
	public List<CatalogNew> findSecondCatname(String  bfirstid) {
		logger.info(" 通过金融机构的一级类别查询二级类别");
		return catalogNewDao.findSecondCatname(bfirstid);
	}

	
	@Override
	public List<CatalogNew> findThirdCatname(String bfirstid, String bscondid) {
		logger.info("通过金融机构的一级类和二级类别查询三级机构类别");
		return catalogNewDao.findThirdCatname(bfirstid, bscondid);
	}

	@Override
	public Archives findByOid(Integer oid) {
		logger.info("查询金融机构开始");
		return (Archives)archivesDao.findById(oid);
	}

	@Override
	public void updateInformation(Archives information1, Archives information2) {
		try {
			//申明历史変更信息对象
			ArchivesHis archivesHis= null;
			//将原档案信息和新档案信息进行比较 获得穷档案信息的変更情况
			archivesHis = (ArchivesHis) BeanCompare.compareArchives(information1, information2);
			if (archivesHis == null) {
				return;
			}
			archivesDao.merge(information2);
			logger.info("保存金融机构信息");
			archivesHis.setBupdatetime(information2.getBupdatetime());
			archivesHis.setBupdateuser(information2.getBupdateuser());
			archivesHis.setArchives(information2);
			//TODO 先只修改档案表
			//archivesHis.setBOrgCatalog(information2.getBOrgCatalog());
			iArchivesHisDao.save(archivesHis);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new ServiceException("保存异常");
		}
	}
	public List findByBoid(String information) {
		List list = archivesDao.findByBoid(information);
		return list;
	}
	public void addInformation(Archives archives) {
		logger.info("人民银行用户增加金融机构基本信息，只增加金融机构ID与金融机构名称");
		//判断机构类型是否是法人机构类型
		if (ConstantMethods.isCorporation(archives.getCatalogNew().getId())) {
			archives.setCorporationType(Constants.IS_CORPORATION);
		}else{
			archives.setCorporationType(Constants.IS_BRANCH);
		}
		archivesDao.save(archives);
		//新增金融机构用户
		//自评者角色
		BankUser user1 = new BankUser();
		//复评者角色
		BankUser user2 = new BankUser();
		//金融机构用户名称 如何定 机构id+角色id
		//自评者角色
		String userName = archives.getOid()+"11";
		user1.setBuname(userName);
		user1.setArchives(archives);
		Set<Role> roles = new HashSet<Role>();
		Role role = manageService.findRoleById("11");
		roles.add(role);
		user1.setTPubRoleusers(roles);
		user1.setBrname(archives.getBname()+"自评者");
		manageService.saveUser(user1);
		//复评者角色
		userName = archives.getOid()+"12";
		user2.setBuname(userName);
		user2.setArchives(archives);
		Set<Role> roles2 = new HashSet<Role>();
		Role role2 = manageService.findRoleById("12");
		roles.add(role2);
		user2.setTPubRoleusers(roles2);
		user2.setBrname(archives.getBname()+"复评者");
		manageService.saveUser(user2);

	}

	@Override
	public PaginaterList getHistoryFinancial(Map<String, Object> params,
			Integer page) {
		logger.info("人民银行用户查看金融机构变更历史");	
		return iArchivesHisDao.getHistoryFinancial(params,page);
	}

	@Override
	public CatalogNew findCatalogNewById(CatalogNew catalogNew) {
		return (CatalogNew) catalogNewDao.findById(catalogNew.getId());
	}

	@Override
	public PaginaterList getArchivesinformation(Map<String, Object> params,
			Integer page) {
		return archivesDao.getArchivesinformation(params, page);
	}

	@Override
	public List findArchivesByBfirstid(String bfirstid) {
		return archivesDao.findArchivesByBfirstid(bfirstid);
	}
	
	

}
