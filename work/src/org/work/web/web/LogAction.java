/**
 * 
 */
package org.work.web.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.work.web.po.Catalog;
import org.work.web.service.financial.IFinancialService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class LogAction extends JsonBaseAction{
	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别
	private String operatorname;
	
	private IFinancialService financialService;

	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/**
	 * 金融机构用户维护显示列表
	 * @return
	 */
	public String list() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		if(operatorname!=null){
	        session.put("operatorname", operatorname);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operatorname", session.get("operatorname"));		
		PaginaterList list = getUserLogService().findAllLog(params,this.getPage());
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		return JSON;
	}
	/**
	 * 进入查询
	 * @return
	 */
	public String  entry() {
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("operatorname", null);
		return SUCCESS;
	}
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
}
