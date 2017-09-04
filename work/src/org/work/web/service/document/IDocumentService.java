/**
 * 
 */
package org.work.web.service.document;

import java.io.File;
import java.util.Map;

import org.work.web.po.Information;
import org.work.web.po.Upload;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IDocumentService {

	PaginaterList findByOid(Map<String, Object> params,Integer page);
	
	PaginaterList findAllUpload(Map<String, Object> params,Integer page);

	Upload getDocumentByID(Integer uid);

	void saveDocument(Upload upload);

	void uploadDocument(Information infomation, File[] documentFile,String[] documentFileFileName, String path, String buname);

	String buildXls(String buname, String path, Map<String, Object> params);

	Upload findById(Integer uid);

	void deleteDocument(Upload upload, String path);

	/**
	 * @param upload
	 */
	void updateDocument(Upload upload);
}
