package org.work.web.service.archives.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.work.web.dao.archives.ArchivesDao;
import org.work.web.dao.archives.IArchivesHisDao;
import org.work.web.dao.manage.ICatalogDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Archives;
import org.work.web.po.ArchivesHis;
import org.work.web.po.Catalog;
import org.work.web.po.Archives;
import org.work.web.po.Information;
import org.work.web.po.Informationhis;
import org.work.web.service.archives.ArchivesService;
import org.work.web.util.BeanCompare;
import org.work.web.util.PaginaterList;

public class ArchivesServiceImpl implements ArchivesService {
	private static final Logger logger = Logger.getLogger(ArchivesServiceImpl.class);
	private ICatalogDao catalogDao;
	private ArchivesDao archivesDao;
	private IArchivesHisDao iArchivesHisDao;
	
 	
	public IArchivesHisDao getiArchivesHisDao() {
		return iArchivesHisDao;
	}

	public void setiArchivesHisDao(IArchivesHisDao iArchivesHisDao) {
		this.iArchivesHisDao = iArchivesHisDao;
	}

	public ICatalogDao getCatalogDao() {
		return catalogDao;
	}

	public void setCatalogDao(ICatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}
	
	public ArchivesDao getArchivesDao() {
		return archivesDao;
	}


	public void setArchivesDao(ArchivesDao archivesDao) {
		this.archivesDao = archivesDao;
	}


	@Override
	public List<Catalog> findByCatalog() {
		logger.info("查询所有金融机构类别");
		return catalogDao.findAllSort();
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
			archivesHis = (ArchivesHis) BeanCompare.compareInformation(information1, information2);
			if (archivesHis == null) {
				return;
			}
			archivesDao.merge(information2);
			logger.info("保存金融机构信息");
			archivesHis.setBupdatetime(information2.getBupdatetime());
			archivesHis.setBupdateuser(information2.getBupdateuser());
			archivesHis.setArchives(information2);
			archivesHis.setBOrgCatalog(information2.getBOrgCatalog());
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
	public void addInformation(Archives information) {
		logger.info("人民银行用户增加金融机构基本信息，只增加金融机构ID与金融机构名称");
		archivesDao.save(information);
	}

	@Override
	public PaginaterList getHistoryFinancial(Map<String, Object> params,
			Integer page) {
		logger.info("人民银行用户查看金融机构变更历史");	
		return iArchivesHisDao.getHistoryFinancial(params,page);
	}
	

}
