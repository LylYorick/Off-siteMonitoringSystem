package org.work.web.service.reportForm;

import java.io.File;
import java.util.Map;

import org.work.web.po.Information;
import org.work.web.po.ReportForm;
import org.work.web.po.Upload;
import org.work.web.util.PaginaterList;

/**
 * 制度管理服务层
 * @author Administrator
 *
 */
public interface IReportFormService {
	
	/**
	 * 通过参数查询制度管理表，返回制度管理信息
	 * @param params 查询参数
	 * @param page	具体页数
	 * @return
	 */
	public PaginaterList findReportFormMsg(Map<String, Object> params,Integer page);
	/**
	 * 保存更新制度管理表，包括记录以及保存文件
	 * @param infomation 金融机构信息
	 * @param ReportFormFile	上传的制度管理文件
	 * @param ReportFormFileFileName	上传的制度管理文件名
	 * @param path	保存路径
	 * @param buname 上传人
	 */
	public void uploadReportForm(Information infomation, File[] ReportFormFile,String[] ReportFormFileFileName, String path, String buname);

	/**
	 * 根据ID查询制度管理表信息
	 * @param uid 制度管理表id
	 * @return
	 */
	public ReportForm findById(Integer ins_id);
	
	/**
	 * 删除制度管理信息
	 * @param ReportForm 制度管理表信息
	 */
	public void delete(ReportForm reportForm);
	
	/**
	 * 自增下载次数
	 * @param ReportForm 制度管理表信息
	 */
	void updateCnt(ReportForm reportForm);
}
