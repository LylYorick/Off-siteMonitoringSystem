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
import org.work.web.po.Information;
import org.work.web.po.Insurancedetail;
import org.work.web.service.suspiciousinsurance.ISuspiciousInsuranceService;
import org.work.web.util.PaginaterList;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class SuspiciousInsuranceDetailAction extends JsonBaseAction implements ModelDriven<Insurancedetail>{
	private Insurancedetail insurancedetail = new Insurancedetail();	
	private ISuspiciousInsuranceService suspiciousinsuranceService;	

	private Integer id;
	private Long dssid;
	private List gridModelInsuranceDetail;//证券业明细数据json		

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
	 * 添加保险业可疑交易信息明细
	 * @return
	 */
	public String save() {
		suspiciousinsuranceService.addInsuranceDetail(insurancedetail);
		info("添加成功...");
		log("保存保险业可疑交易明细数据", Constants.LOG_TYPE_ADD);
		return OK;
	}

	public String modify() {	
		System.out.println(" this.getDsid() ::  "+this.getDssid());
		String organname = getSessionUserCode().getInformation().getBname();
		Insurancedetail info = suspiciousinsuranceService.findDetailByDid(this.getDssid());		
		this.put("organname", organname);
		this.put("info", info);		
		return SUCCESS;
	}

	/**
	 * 修改保险业可疑交易明细数据
	 * @return
	 */
	public String update(){
		suspiciousinsuranceService.updateInsuranceDetail(insurancedetail);
		info("修改成功...");
		log("修改保险业可疑交易明细数据", Constants.LOG_TYPE_UPDATE);
		return OK;
	}

	/**
	 * 保险业可疑交易明细列表
	 * @return
	 */
	public String insurancedetaillist(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", this.getId());
		PaginaterList list = suspiciousinsuranceService.getInsuranceBaseDetailInfoById(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModelInsuranceDetail(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("查询保险业可疑交易明细信息", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	
	public String delete(){		
		suspiciousinsuranceService.deleteInsurancedetailById(this.getDssid());
		log("删除保险业可疑交易明细信息", Constants.LOG_TYPE_DELETE);
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
	public Insurancedetail getModel() {
		return insurancedetail;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List getGridModelInsuranceDetail() {
		return gridModelInsuranceDetail;
	}

	public void setGridModelInsuranceDetail(List gridModelInsuranceDetail) {
		this.gridModelInsuranceDetail = gridModelInsuranceDetail;
	}

	public void setSuspiciousinsuranceService(
			ISuspiciousInsuranceService suspiciousinsuranceService) {
		this.suspiciousinsuranceService = suspiciousinsuranceService;
	}

	public Long getDssid() {
		return dssid;
	}

	public void setDssid(Long dssid) {
		this.dssid = dssid;
	}
	
}
