/**
 * 
 */
package org.work.web.service.document.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.work.web.dao.upload.IUploadDao;
import org.work.web.po.Information;
import org.work.web.po.Upload;
import org.work.web.service.document.IDocumentService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.Parameter;
import org.work.web.util.XlsUtil;
import org.work.web.exception.ServiceException;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class DocumentServiceImpl implements IDocumentService{
	private static final Logger logger = Logger.getLogger(DocumentServiceImpl.class);
	private IUploadDao uploadDao;

	public void setUploadDao(IUploadDao uploadDao) {
		this.uploadDao = uploadDao;
	}

	public PaginaterList findByOid(Map<String, Object> params,Integer page) {
		logger.info("查询资料上报开始");
		return uploadDao.findByOId(params,page);
	}

	public Upload getDocumentByID(Integer uid) {
		logger.info("查询资料上报");
		return (Upload) uploadDao.findById(uid);
	}

	public void saveDocument(Upload upload) {
		logger.info("保存上报资料信息");
		uploadDao.save(upload);

	}

	public void uploadDocument(Information infomation, File[] documentFile,String[] documentFileFileName, String path, String buname) {
		logger.info("金融机构用户保存上报资料信息");
		Upload fileItem;
		for(int i = 0;i<documentFile.length;i++){
			fileItem = new Upload();						
			String filename1 = System.currentTimeMillis()  + "_rn_" + documentFileFileName[i];//把文件加个前缀，应对文件名重复的情况
			String filename = path +"/"+ filename1;
			logger.info(filename);
			fileItem.setBOrgInformation(infomation);
			fileItem.setFilename(filename1);
			fileItem.setUpdateuser(buname);
			fileItem.setUpdatetime(DateUtil.formatDateTime());	
			fileItem.setCnt(0);
			File newFile = new File(filename);
			try {
				FileUtils.copyFile(documentFile[i], newFile);
				uploadDao.save(fileItem);				
			} catch (IOException e) {
				logger.error(e.getMessage());
				throw new ServiceException("保存文件异常");
			}
			logger.info("保存成功");
		}		
	}

	public PaginaterList findAllUpload(Map<String, Object> params, Integer page) {
		logger.info("查询上报资料");
		return uploadDao.findAllUpload(params, page);
	}

	public String buildXls(String username, String path,Map<String, Object> params) {		
		logger.info("导出金融机构上报的资料到excel");				
		String filename = "";
		Map map = new HashMap();
		Map map2 = new HashMap();		

		List headlist = new ArrayList();
		List valueList = new ArrayList();
		int columnCount = 0;

		headlist.add("序号");
		headlist.add("上报金融机构名称");
		headlist.add("文件名");
		headlist.add("上报时间");
		headlist.add("上报人");
			
		columnCount = headlist.size();

		List<Upload> uploads = uploadDao.getAllUpload(params);
		for(Upload upload : uploads){
			List tmpList2 = new ArrayList();
			Parameter parameter = new Parameter();

			tmpList2.add(upload.getUid().toString());			
			tmpList2.add(upload.getBOrgInformation().getBname());
			tmpList2.add(upload.getFilename());			
			tmpList2.add(upload.getUpdatetime());
			tmpList2.add(upload.getUpdateuser());			

			parameter.setList(tmpList2);			
			valueList.add(parameter);
		}

		map.put("ColumnName", headlist);
		map.put("DataContent", valueList);
		map.put("ColumnCount", columnCount);

		List nameList = new ArrayList();
		nameList.add("上报资料列表");		
		List countList = new ArrayList();
		countList.add("5");		

		map2.put("nameList", nameList);
		map2.put("countList", countList);

		XlsUtil xls = new XlsUtil();		
		filename = xls.build(DateUtil.formatDateTime(), path, "上报资料信息", "", username, map, map2);		
		logger.info("生成的  filename ::  "+filename);		

		return filename;
	}

	public Upload findById(Integer uid) {		
		return (Upload)uploadDao.findById(uid);
	}

	public void deleteDocument(Upload upload, String path) {
		logger.info("金融机构用户删除上报资料信息");
		File delFile = new File(path);
		try {
			FileUtils.forceDelete(delFile);
			uploadDao.delete(upload);				
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new ServiceException("删除文件异常");
		}
		logger.info("删除成功");		
	}

	public void updateDocument(Upload upload) {
		logger.info("下载资料次数增加");
		upload.setCnt(upload.getCnt()+1);
		uploadDao.saveOrUpdate(upload);
	}


}
