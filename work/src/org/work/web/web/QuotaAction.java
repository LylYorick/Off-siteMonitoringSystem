package org.work.web.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;

public class QuotaAction   extends JsonBaseAction {

	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(QuotaAction.class);
	
	@Override
	public List getGridModel() {
		return this.gridModel;
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

	
	public String list(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		Map<String, Object> params = new HashMap<String, Object>();
	  /*  if(oid==null || oid==9999){
			if(session.get("oid")==null || "9999".equals(String.valueOf(oid)))
				session.put("oid",null);
		}else {
	        session.put("oid", oid);
		}
		if(bid!=null)
	        session.put("bid", bid);
		if(starttime!=null && !"".equals(starttime)){
	        session.put("starttime", starttime);
		}
		if(endtime!=null && !"".equals(endtime)){
	        session.put("endtime", endtime);
		}*/
		params.put("oid",  getSessionUserInformation()==null?session.get("oid"):getSessionUserInformation());
		params.put("bid", session.get("bid"));	
		params.put("starttime",session.get("starttime"));
		params.put("endtime",session.get("endtime"));		
		//PaginaterList list =  institutionService.findInstitutionMsg(params, this.getPage());
		//Long maxRecord = list.getPaginater().getMaxRowCount();
		//this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		//setTotal(list.getPaginater().getMaxPage());
		//setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		return  JSON;
	}
}
