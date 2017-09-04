/**
 * 
 */
package org.work.web.service.report;

import java.util.List;
import java.util.Map;

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
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public interface IReportService {

	public List getReportIsreport(Map<String, Object> params);
	/**
	 * 查询所有报表情况
	 * @param params
	 * @param page
	 * @return
	 */
	public PaginaterList getReport(Map<String, Object> params, Integer page);
	/**
	 * 查询内控制度情况
	 * @param params
	 * @param page
	 * @return
	 */
	public PaginaterList getInnerControl(Map<String, Object> params, Integer page);
	/**
	 * @return 获取所有报表类型
	 */
	public List<Report> getAllReport();
	/**
	 * @param switchid
	 * @return 返回报表开关表
	 */
	public Reportswitch getreportSwitchById(Integer switchid);
	/**
	 * @param innercontrol 添加内控制度
	 */
	public void saveInnerControl(Innercontrol innercontrol);
	/**
	 * @param id
	 * @return 根据id查询内控制度记录
	 */
	public Innercontrol getInnerControlById(Long id);
	/**
	 * @param innercontrol 更新内控制度记录
	 */
	public void updateInnerControl(Innercontrol innercontrol);
	/**
	 * @param innercontrol 删除内控制度
	 */
	public void deleteInnerControl(Long id,Integer switchid);
	/**
	 * @param id
	 * @return 根据id查询金融机构客户身份识别情况（识别客户）
	 */
	public Indentitysb getIdentitySbBySwitchId(Integer id);
	/**
	 * @param id
	 * @return 更新金融机构客户身份识别情况（识别客户）
	 */
	public void saveOrupdateIndentitySb(Indentitysb indentitysb);
	/**
	 * @param id
	 * @return 根据id查询金融机构客户身份识别情况(重新识别客户)
	 */
	public Identityrsb getIdentityRsbBySwitchId(Integer id);
	/**
	 * @param id
	 * @return 更新金融机构客户身份识别情况(重新识别客户)
	 */
	public void saveOrupdateIdentityRsb(Identityrsb identityrsb);
	/**
	 * @param id
	 * @return 根据id查询金融机构客户身份识别情况(涉及可疑交易识别情况)
	 */
	public Identityky getIdentityKyBySwitchId(Integer id);
	/**
	 * @param id
	 * @return 更新金融机构客户身份识别情况(涉及可疑交易识别情况)
	 */
	public void saveOrupdateIdentityKy(Identityky identityky);
	/**
	 * @param valueOf
	 * @return 根据id查询金融机构可疑交易报告情况统计表
	 */
	public Susreport getSusreportBySwitchId(Integer id);
	/**
	 * @return 更新金融机构可疑交易报告情况统计表
	 */
	public void saveOrupdateSusreport(Susreport susreport);
	/**
	 * @param valueOf
	 * @return 根据id查询金融机构可疑交易报告情况统计表标注
	 */
	public Susreportflag getSusreportFlagBySwitchId(Integer id);
	/**
	 * @return 更新金融机构可疑交易报告情况统计表标注
	 */
	public void saveOrupdateSusreportflag(Susreportflag susreportflag);
	/**
	 * @param valueOf
	 * @return 根据id查询金金融机构协助公安机关、其他机关打击洗钱活动情况
	 */
	public Publics getPublicsBySwitchId(Integer id);
	/**
	 * @param valueOf
	 * @return 查询金金融机构协助公安机关、其他机关打击洗钱活动情况
	 */
	public PaginaterList getPublics(Map<String, Object> params, Integer page);
	/**
	 * @return 更新金融机构协助公安机关、其他机关打击洗钱活动情况
	 */
	public void saveOrupdatePublics(Publics publics);
	/**
	 * @param valueOf
	 * @return 根据id查询金金融机构协助公安机关、其他机关打击洗钱活动情况标注
	 */
	public Blowflag getBlowflagBySwitchId(Integer id);
	/**
	 * @return 更新金融机构协助公安机关、其他机关打击洗钱活动情况标注
	 */
	public void saveOrupdateBlowflag(Blowflag blowflag);
	/**
	 * @param valueOf
	 * @return
	 */
	public Publics getPublicsById(Integer valueOf);
	/**
	 * @param publics
	 */
	public void updatePublics(Publics publics);
	/**
	 * @param valueOf
	 */
	public void deletePublics(Integer valueOf,Integer switchid);
	/**
	 * @param params
	 * @param page
	 * @return
	 */
	public PaginaterList getOrgandPost(Map<String, Object> params, Integer page);
	/**
	 * @param organdpost
	 */
	public void saveOrupdateOrgandPost(Organdpost organdpost);
	/**
	 * @param valueOf
	 * @return
	 */
	public Organdpost getOrgandpostById(Long valueOf);
	/**
	 * @param organdpost
	 */
	public void updateOrgandPost(Organdpost organdpost);
	/**
	 * @param valueOf
	 */
	public void deleteOrgandPost(Long valueOf,Integer switchid);
	/**
	 * @param active
	 */
	public void saveOrupdateActive(Active active);
	/**
	 * @param active
	 */
	public void updateActive(Active active);
	/**
	 * @param valueOf
	 */
	public void deleteActive(Long valueOf,Integer switchid);
	/**
	 * @param params
	 * @param page
	 * @return
	 */
	public PaginaterList getActive(Map<String, Object> params, Integer page);
	/**
	 * @param valueOf
	 * @return
	 */
	public Active getActiveById(Long valueOf);
	/**
	 * @param train
	 */
	public void saveOrupdateTrain(Train train);
	/**
	 * @param valueOf
	 * @return
	 */
	public Train getTrainById(Long valueOf);
	/**
	 * @param train
	 */
	public void updateTrain(Train train);
	/**
	 * @param valueOf
	 */
	public void deleteTrain(Long valueOf,Integer switchid);
	/**
	 * @param params
	 * @param page
	 * @return
	 */
	public PaginaterList getTrain(Map<String, Object> params, Integer page);
	/**
	 * @param valueOf
	 * @return
	 */
	public Innerauditflag getInnerauditFlagBySwitchId(Integer valueOf);
	/**
	 * @param params
	 * @param page
	 * @return
	 */
	public PaginaterList getInneraudit(Map<String, Object> params, Integer page);
	/**
	 * @param valueOf
	 * @return
	 */
	public Inneraudit getInnerauditById(Long valueOf);
	/**
	 * @param inneraudit
	 */
	public void updateInneraudit(Inneraudit inneraudit);
	/**
	 * @param valueOf
	 */
	public void deleteInneraudit(Long valueOf,Integer switchid);
	/**
	 * @param innerauditflag
	 */
	public void saveOrupdateInnerauditFlag(Innerauditflag innerauditflag);
	/**
	 * @param inneraudit
	 */
	public void saveOrupdateInneraudit(Inneraudit inneraudit);
	/**
	 * @param valueOf
	 */
	public void updateZeroReport(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deleteInnerauditFlag(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deleteIdentitySb(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deleteIdentityRsb(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deleteIdentityKy(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deleteSusreport(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deleteSusreportFlag(Integer valueOf);
	/**
	 * @param valueOf
	 */
	public void deletePublicsFlag(Integer valueOf);
	/**
	 * @param name
	 * @param tel
	 * @param switchid
	 */
	public void updateSwitch(String name, String tel, Integer switchid);
}
