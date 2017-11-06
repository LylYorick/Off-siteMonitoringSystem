package org.work.web.service.institution;

import java.io.File;
import java.util.Map;

import org.work.web.po.Information;
import org.work.web.po.Institution;
import org.work.web.po.Upload;
import org.work.web.util.PaginaterList;

/**
 * 制度管理服务层
 * @author Administrator
 *
 */
public interface IInstitutionService {
	
	/**
	 * 通过参数查询制度管理表，返回制度管理信息
	 * @param params 查询参数
	 * @param page	具体页数
	 * @return
	 */
	public PaginaterList findInstitutionMsg(Map<String, Object> params,Integer page);
	/**
	 * 保存更新制度管理表，包括记录以及保存文件
	 * @param infomation 金融机构信息
	 * @param InstitutionFile	上传的制度管理文件
	 * @param InstitutionFileFileName	上传的制度管理文件名
	 * @param path	保存路径
	 * @param buname 上传人
	 */
	public void uploadInstitution(Information infomation, File[] InstitutionFile,String[] InstitutionFileFileName, String path, String buname);

	/**
	 * 根据ID查询制度管理表信息
	 * @param uid 制度管理表id
	 * @return
	 */
	public Institution findById(Integer ins_id);
	
	/**
	 * 删除制度管理信息
	 * @param institution 制度管理表信息
	 */
	public void delete(Institution institution);
	
	/**
	 * 自增下载次数
	 * @param institution 制度管理表信息
	 */
	void updateCnt(Institution institution);
}
