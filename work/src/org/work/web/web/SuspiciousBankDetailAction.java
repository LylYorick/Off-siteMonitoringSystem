/**
 * 
 */
package org.work.web.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.po.BankUser;
import org.work.web.po.Basedetail;
import org.work.web.po.Information;
import org.work.web.service.suspicious.ISuspiciousService;
import org.work.web.util.PaginaterList;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class SuspiciousBankDetailAction extends JsonBaseAction implements ModelDriven<Basedetail>{
	private Basedetail basedetail = new Basedetail();	
	private ISuspiciousService suspiciousService;	

	private Integer id;
	private Long did;
	private List gridModelBankDetail;//银行业明细数据json		

	public String entry() {
		return SUCCESS;
	}

	public String add() {		
		BankUser bankUser = getSessionUserCode();
		Information information = bankUser.getInformation();		
		this.put("info", information);
		this.put("id", this.getId());
		return SUCCESS;
	}	

	/**
	 * 添加银行业可疑交易信息明细
	 * @return
	 */
	public String save() {
		suspiciousService.addBankDetail(basedetail);
		info("添加成功...");
		log("保存银行业可疑交易明细数据", Constants.LOG_TYPE_ADD);
		return OK;
	}

	public String modify() {		
		Basedetail info = suspiciousService.findDetailByDid(this.getDid());		
		this.put("info", info);		
		return SUCCESS;
	}

	/**
	 * 修改银行业可疑交易明细数据
	 * @return
	 */
	public String update(){
		suspiciousService.updateBankDetail(basedetail);
		info("修改成功...");
		log("修改银行业可疑交易明细数据", Constants.LOG_TYPE_UPDATE);
		return OK;
	}

	/**
	 * 银行业可疑交易明细列表
	 * @return
	 */
	public String bankdetaillist(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", this.getId());
		PaginaterList list = suspiciousService.getBankBaseDetailInfoById(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModelBankDetail(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("查询银行业可疑交易明细信息", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	
	public String delete(){		
		suspiciousService.deleteBasedetailById(this.getDid());
		log("删除银行业可疑交易明细信息", Constants.LOG_TYPE_DELETE);
		return OK;
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

	@JSON(serialize = false)
	public Basedetail getModel() {
		return basedetail;
	}

	public void setSuspiciousService(ISuspiciousService suspiciousService) {
		this.suspiciousService = suspiciousService;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List getGridModelBankDetail() {
		return gridModelBankDetail;
	}

	public void setGridModelBankDetail(List gridModelBankDetail) {
		this.gridModelBankDetail = gridModelBankDetail;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

}
