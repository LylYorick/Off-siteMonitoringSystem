/**
 * 
 */
package org.work.web.service.report.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.work.web.constants.Constants;
import org.work.web.dao.report.IActiveDao;
import org.work.web.dao.report.IBlowflagDao;
import org.work.web.dao.report.IIdentityKyDao;
import org.work.web.dao.report.IIdentityRsbDao;
import org.work.web.dao.report.IIdentitySbDao;
import org.work.web.dao.report.IInnerAuditDao;
import org.work.web.dao.report.IInnerAuditFlagDao;
import org.work.web.dao.report.IInnerControlDao;
import org.work.web.dao.report.IOrgandPostDao;
import org.work.web.dao.report.IPublicsDao;
import org.work.web.dao.report.IReportDao;
import org.work.web.dao.report.IReportTypeDao;
import org.work.web.dao.report.ISusreportDao;
import org.work.web.dao.report.ISusreportFlagDao;
import org.work.web.dao.report.ITrainDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Active;
import org.work.web.po.Blowflag;
import org.work.web.po.Identityky;
import org.work.web.po.Identityrsb;
import org.work.web.po.Indentitysb;
import org.work.web.po.Inneraudit;
import org.work.web.po.Innerauditflag;
import org.work.web.po.Innercontrol;
import org.work.web.po.Organdpost;
import org.work.web.po.Publics;
import org.work.web.po.Report;
import org.work.web.po.Reportswitch;
import org.work.web.po.Susreport;
import org.work.web.po.Susreportflag;
import org.work.web.po.Train;
import org.work.web.service.report.IReportService;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public class ReportServiceImpl implements IReportService{
	private static final Logger logger = Logger.getLogger(ReportServiceImpl.class);
	private IReportDao reportDao;
	private IReportTypeDao reportTypeDao;
	private IInnerControlDao innerControlDao;
	private IIdentitySbDao identitySbDao;
	private IIdentityRsbDao identityRsbDao;
	private IIdentityKyDao identityKyDao;
	private ISusreportDao susreportDao;
	private ISusreportFlagDao susreportFlagDao;
	private IPublicsDao publicsDao;
	private IBlowflagDao blowflagDao;
	private IOrgandPostDao organdPostDao;
	private IActiveDao activeDao;
	private ITrainDao trainDao;
	private IInnerAuditDao innerAuditDao;
	private IInnerAuditFlagDao innerAuditFlagDao;
	
	public void setOrgandPostDao(IOrgandPostDao organdPostDao) {
		this.organdPostDao = organdPostDao;
	}

	public void setActiveDao(IActiveDao activeDao) {
		this.activeDao = activeDao;
	}

	public void setTrainDao(ITrainDao trainDao) {
		this.trainDao = trainDao;
	}

	public void setInnerAuditDao(IInnerAuditDao innerAuditDao) {
		this.innerAuditDao = innerAuditDao;
	}

	public void setInnerAuditFlagDao(IInnerAuditFlagDao innerAuditFlagDao) {
		this.innerAuditFlagDao = innerAuditFlagDao;
	}

	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public void setPublicsDao(IPublicsDao publicsDao) {
		this.publicsDao = publicsDao;
	}

	public void setBlowflagDao(IBlowflagDao blowflagDao) {
		this.blowflagDao = blowflagDao;
	}

	public void setSusreportDao(ISusreportDao susreportDao) {
		this.susreportDao = susreportDao;
	}

	public void setSusreportFlagDao(ISusreportFlagDao susreportFlagDao) {
		this.susreportFlagDao = susreportFlagDao;
	}

	public void setIdentityKyDao(IIdentityKyDao identityKyDao) {
		this.identityKyDao = identityKyDao;
	}

	public void setIdentityRsbDao(IIdentityRsbDao identityRsbDao) {
		this.identityRsbDao = identityRsbDao;
	}

	public void setIdentitySbDao(IIdentitySbDao identitySbDao) {
		this.identitySbDao = identitySbDao;
	}

	public void setInnerControlDao(IInnerControlDao innerControlDao) {
		this.innerControlDao = innerControlDao;
	}

	public void setReportTypeDao(IReportTypeDao reportTypeDao) {
		this.reportTypeDao = reportTypeDao;
	}

	public PaginaterList getReport(Map<String, Object> params, Integer page) {
		logger.info("getReport(Map<String, Object> params, Integer page)正在执行");
		return reportDao.getReport(params, page);
	}

	public PaginaterList getInnerControl(Map<String, Object> params, Integer page) {
		logger.info("getInnerControl(Map<String, Object> params, Integer page)正在执行");
		return innerControlDao.getInnerControl(params, page);
	}

	public List<Report> getAllReport() {
		logger.info("getAllReport()正在执行");
		return reportTypeDao.findAll();
	}

	public Reportswitch getreportSwitchById(Integer switchid) {
		logger.info("getreportSwitchById(String switchid)正在执行");
		return (Reportswitch) reportDao.findById(switchid);
	}
	public void saveInnerControl(Innercontrol innercontrol) {
		logger.info("saveInnerControl(Innercontrol innercontrol)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(innercontrol.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		innerControlDao.save(innercontrol);
	}
	public Innercontrol getInnerControlById(Long id) {
		logger.info("getInnerControlById(String id)正在执行"+id);
		return (Innercontrol) innerControlDao.findById(id);
	}
	public void updateInnerControl(Innercontrol innercontrol) {
		logger.info("updateInnerControl(Innercontrol innercontrol)正在执行");
		innerControlDao.update(innercontrol);
	}
	public void deleteInnerControl(Long id,Integer switchid) {
		logger.info("innerControlDelete(Long id)正在执行"+id);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		if(reportswitch.getInnercontrols().size()==1){
			reportswitch.setIsreport(null);
		}
		innerControlDao.deleteById(id);
	}
	public Indentitysb getIdentitySbBySwitchId(Integer id) {
		logger.info("getIdentitySbById(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return identitySbDao.getIndentitysbBySwitchid(id);
	}

	public void saveOrupdateIndentitySb(Indentitysb indentitysb) {
		logger.info("saveOrupdateIndentitySb(Indentitysb idindentitysb)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(indentitysb.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		identitySbDao.saveOrUpdate(indentitysb);
	}
	public Identityrsb getIdentityRsbBySwitchId(Integer id) {
		logger.info("getIdentityRsbBySwitchId(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return identityRsbDao.getIndentityrsbBySwitchid(id);
	}

	public void saveOrupdateIdentityRsb(Identityrsb identityrsb) {
		logger.info("saveOrupdateIdentityRsb(Indentitysb idindentitysb)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(identityrsb.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		identityRsbDao.saveOrUpdate(identityrsb);
	}
	public Identityky getIdentityKyBySwitchId(Integer id) {
		logger.info("getIdentityKyBySwitchId(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return identityKyDao.getIdentitykyBySwitchid(id);
	}

	public void saveOrupdateIdentityKy(Identityky identityky) {
		logger.info("saveOrupdateIndentitySb(Identityky identityky)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(identityky.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		identityKyDao.saveOrUpdate(identityky);
	}
	
	public Susreport getSusreportBySwitchId(Integer id) {
		logger.info("getSusreportBySwitchId(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return susreportDao.getSusreportBySwitchId(id);
	}
	public void saveOrupdateSusreport(Susreport susreport) {
		logger.info("saveOrupdateSusreport(Susreport susreport)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(susreport.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		susreportDao.saveOrUpdate(susreport);
	}
	
	public Susreportflag getSusreportFlagBySwitchId(Integer id) {
		logger.info("getSusreportFlagBySwitchId(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return susreportFlagDao.getSusreportFlagBySwitchId(id);
	}
	public void saveOrupdateSusreportflag(Susreportflag susreportflag) {
		logger.info("saveOrupdateSusreport(Susreport susreport)正在执行");
		susreportFlagDao.saveOrUpdate(susreportflag);
	}

	public Blowflag getBlowflagBySwitchId(Integer id) {
		logger.info("getBlowflagBySwitchId(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return blowflagDao.getBlowflagBySwitchId(id);
	}

	public Publics getPublicsBySwitchId(Integer id) {
		logger.info("getPublicsBySwitchId(Integer id)正在执行"+id);
		if(id==null)
			throw new ServiceException("请正确输入参数");
		return publicsDao.getPublicsBySwitchId(id);
	}

	public void saveOrupdateBlowflag(Blowflag blowflag) {
		logger.info("saveOrupdateBlowflag(Blowflag blowflag)正在执行");
		blowflagDao.saveOrUpdate(blowflag);
	}
	public void saveOrupdatePublics(Publics publics) {
		logger.info("saveOrupdatePublics(Publics publics)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(publics.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		publicsDao.saveOrUpdate(publics);
	}

	public PaginaterList getPublics(Map<String, Object> params, Integer page) {
		logger.info("getPublics(Map<String, Object> params, Integer page)正在执行");
		return publicsDao.getPublics(params, page);
	}
	public Publics getPublicsById(Integer valueOf) {
		logger.info("getPublicsById(Integer valueOf)正在执行");
		return (Publics)publicsDao.findById(valueOf);
	}
	public void updatePublics(Publics publics) {
		logger.info("updatePublics(Publics publics)正在执行");
		publicsDao.update(publics);
	}

	public void deletePublics(Integer valueOf,Integer switchid) {
		logger.info("deletePublics(Integer valueOf)正在执行"+valueOf);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		if(reportswitch.getPublicses().size()==1){
			reportswitch.setIsreport(null);
		}
		publicsDao.deleteById(valueOf);
	}
	public PaginaterList getOrgandPost(Map<String, Object> params, Integer page) {
		logger.info("getOrgandPost(Map<String, Object> params, Integer page)正在执行");
		return organdPostDao.getOrgandPost(params, page);
	}

	public void deleteOrgandPost(Long valueOf,Integer switchid) {
		logger.info("deleteOrgandPost(Long valueOf)正在执行"+valueOf);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		if(reportswitch.getOrgandposts().size()==1){
			reportswitch.setIsreport(null);
		}
		organdPostDao.deleteById(valueOf);
	}
	public Organdpost getOrgandpostById(Long valueOf) {
		logger.info("getOrgandpostById(Long valueOf)正在执行");
		return (Organdpost)organdPostDao.findById(valueOf);
	}

	public void saveOrupdateOrgandPost(Organdpost organdpost) {
		logger.info("saveOrupdateOrgandPost(Organdpost organdpost)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(organdpost.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		organdPostDao.saveOrUpdate(organdpost);
	}

	public void updateOrgandPost(Organdpost organdpost) {
		logger.info("updateOrgandPost(Organdpost organdpost)正在执行");
		organdPostDao.update(organdpost);
	}

	public void deleteActive(Long valueOf,Integer switchid) {
		logger.info("deleteActive(Long valueOf)正在执行"+valueOf);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		if(reportswitch.getActives().size()==1){
			reportswitch.setIsreport(null);
		}
		activeDao.deleteById(valueOf);
	}

	public PaginaterList getActive(Map<String, Object> params, Integer page) {
		logger.info("getActive(Map<String, Object> params, Integer page)正在执行");
		return activeDao.getActive(params, page);
	}

	public Active getActiveById(Long valueOf) {
		logger.info("getActiveById(Long valueOf)正在执行");
		return (Active)activeDao.findById(valueOf);
	}

	public void saveOrupdateActive(Active active) {
		logger.info("saveOrupdateActive(Active active)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(active.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		activeDao.saveOrUpdate(active);
	}

	public void updateActive(Active active) {
		logger.info("updateActive(Active active)正在执行");
		activeDao.update(active);
	}

	public void deleteTrain(Long valueOf, Integer switchid) {
		logger.info("getTrainById(Long valueOf)正在执行"+valueOf);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		if(reportswitch.getTrain().size()==1){
			reportswitch.setIsreport(null);
		}
		trainDao.deleteById(valueOf);
	}
	public Train getTrainById(Long valueOf) {
		logger.info("getTrainById(Long valueOf)正在执行");
		return (Train)trainDao.findById(valueOf);
	}

	public void saveOrupdateTrain(Train train) {
		logger.info("saveOrupdateTrain(Train train)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(train.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		trainDao.saveOrUpdate(train);
	}

	public void updateTrain(Train train) {
		logger.info("updateTrain(Train train)正在执行");
		trainDao.update(train);
	}

	public PaginaterList getTrain(Map<String, Object> params, Integer page) {
		logger.info("getTrain(Map<String, Object> params, Integer page)正在执行");
		return trainDao.getTrain(params, page);
	}

	public void deleteInneraudit(Long valueOf,Integer switchid) {
		logger.info("deleteInneraudit(Long valueOf)正在执行"+valueOf);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		if(reportswitch.getInneraudits().size()==1){
			reportswitch.setIsreport(null);
		}
		innerAuditDao.deleteById(valueOf);
	}

	public PaginaterList getInneraudit(Map<String, Object> params, Integer page) {
		logger.info("getInneraudit(Map<String, Object> params, Integer page)正在执行");
		return innerAuditDao.getInnerAudit(params, page);
	}

	public Inneraudit getInnerauditById(Long valueOf) {
		logger.info("getInnerauditById(Long valueOf)正在执行");
		return (Inneraudit)innerAuditDao.findById(valueOf);
	}

	public Innerauditflag getInnerauditFlagBySwitchId(Integer valueOf) {
		logger.info("getInnerauditFlagBySwitchId(Integer id)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		return innerAuditFlagDao.getInnerauditFlagBySwitchId(valueOf);
	}

	public void saveOrupdateInnerauditFlag(Innerauditflag innerauditflag) {
		logger.info("saveOrupdateInnerauditFlag(Innerauditflag innerauditflag)正在执行");
		innerAuditFlagDao.saveOrUpdate(innerauditflag);
	}

	public void updateInneraudit(Inneraudit inneraudit) {
		logger.info("updateInneraudit(Inneraudit inneraudit)正在执行");
		innerAuditDao.update(inneraudit);
	}

	public void saveOrupdateInneraudit(Inneraudit inneraudit) {
		logger.info("saveOrupdateInneraudit(Inneraudit inneraudit)正在执行");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(inneraudit.getReportswitch().getSwitchid());
		reportswitch.setIsreport(Constants.REPORT_CHOOSE_YES);
		innerAuditDao.saveOrUpdate(inneraudit);
	}

	public void updateZeroReport(Integer valueOf) {
		logger.info("zeroInnerControl(Integer valueOf)正在执行"+valueOf);
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(valueOf);
		reportswitch.setStatus(Constants.REPORT_STATUS_UPLOAD);
		reportDao.update(reportswitch);
	}
	public void deleteInnerauditFlag(Integer valueOf) {
		logger.info("deleteInnerauditFlag(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Innerauditflag entity = innerAuditFlagDao.getInnerauditFlagBySwitchId(valueOf);
		if(entity!=null)
			innerAuditFlagDao.delete(entity);
	}
	public void deleteIdentitySb(Integer valueOf) {
		logger.info("deleteIdentitySb(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Indentitysb entity = identitySbDao.getIndentitysbBySwitchid(valueOf);
		if(entity!=null)
			identitySbDao.delete(entity);
	}
	public void deleteIdentityKy(Integer valueOf) {
		logger.info("deleteIdentityKy(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Identityky entity = identityKyDao.getIdentitykyBySwitchid(valueOf);
		if(entity!=null)
			identityKyDao.delete(entity);
	}
	public void deleteIdentityRsb(Integer valueOf) {
		logger.info("deleteIdentityRsb(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Identityrsb entity = identityRsbDao.getIndentityrsbBySwitchid(valueOf);
		if(entity!=null)
			identityRsbDao.delete(entity);
	}
	public void deletePublicsFlag(Integer valueOf) {
		logger.info("deletePublicsFlag(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Blowflag blowflag = blowflagDao.getBlowflagBySwitchId(valueOf);
		if(blowflag!=null)
			blowflagDao.delete(blowflag);
	}
	public void deleteSusreport(Integer valueOf) {
		logger.info("deleteSusreport(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Susreport susreport = susreportDao.getSusreportBySwitchId(valueOf);
		if(susreport!=null)
			susreportDao.delete(susreport);
	}
	public void deleteSusreportFlag(Integer valueOf) {
		logger.info("deleteSusreportFlag(Integer valueOf)正在执行"+valueOf);
		if(valueOf==null)
			throw new ServiceException("请正确输入参数");
		Susreportflag susreportflag = susreportFlagDao.getSusreportFlagBySwitchId(valueOf);
		if(susreportflag!=null)
			susreportFlagDao.delete(susreportflag);
	}
	public void updateSwitch(String name, String tel, Integer switchid) {
		logger.info("updateSwitch(String name, String tel, String switchid)正在执行");
		if(switchid==null)
			throw new ServiceException("无法修改");
		Reportswitch reportswitch = (Reportswitch) reportDao.findById(switchid);
		reportswitch.setName(name);
		reportswitch.setTel(tel);
		reportDao.update(reportswitch);
	}

	public List getReportIsreport(Map<String, Object> params) {
		return reportDao.getReporAccountGroupBy(params);
	}
}
