/**
 * 
 */
package org.work.web.web;

import java.util.List;

/* 
 * @author ThinkPad 
 * date : Jun 24, 2010 11:15:41 AM 
 */
public class ParaAction  extends JsonBaseAction{

	private Integer yearendday;
	private Integer quaterendday;
	
	public Integer getYearendday() {
		return yearendday;
	}
	public void setYearendday(Integer yearendday) {
		this.yearendday = yearendday;
	}
	public Integer getQuaterendday() {
		return quaterendday;
	}
	public void setQuaterendday(Integer quaterendday) {
		this.quaterendday = quaterendday;
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

	public String update(){
		Integer year = this.getUserLogService().getReportEndDay(1);
		Integer quater = this.getUserLogService().getReportEndDay(2);
		put("year",year);
		put("quater",quater);
		return SUCCESS;
	}
	public String updateEndday(){
		this.getUserLogService().updateEndDay(quaterendday,yearendday);
		return OK;
	}
	@Override
	public List getGridModel() {
		return null;
	}
}
