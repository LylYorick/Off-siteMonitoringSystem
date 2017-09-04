/**
 * 
 */
package org.work.web.service.cacul;

import java.util.List;
import java.util.Map;

import org.work.web.util.PaginaterList;

/**
 * @作者 ThinkPad
 * @创建日期 Oct 11, 2010
 * @版本 work V1.0
 */
public interface ICaculService {

	public List getReportstatus(Map<String, Object> params);

	public PaginaterList getReportImport(Map<String, Object> params,int page);

	public PaginaterList getReportSusreport(Map<String, Object> params,int page);

	public PaginaterList getReportImportB(Map<String, Object> params,
			Integer page);
}
