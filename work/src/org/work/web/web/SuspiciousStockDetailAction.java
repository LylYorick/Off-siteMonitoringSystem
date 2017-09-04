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
import org.work.web.po.Stockdetail;
import org.work.web.service.suspiciousstock.ISuspiciousStockService;
import org.work.web.util.PaginaterList;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class SuspiciousStockDetailAction extends JsonBaseAction implements ModelDriven<Stockdetail>{
	private Stockdetail stockdetail = new Stockdetail();	
	private ISuspiciousStockService suspiciousstockService;	

	private Integer id;
	private Long dsid;
	private List gridModelStockDetail;//证券业明细数据json		

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
	 * 添加证券业可疑交易信息明细
	 * @return
	 */
	public String save() {
		suspiciousstockService.addStockDetail(stockdetail);
		info("添加成功...");
		log("保存证券业可疑交易明细数据", Constants.LOG_TYPE_ADD);
		return OK;
	}

	public String modify() {	
		System.out.println(" this.getDsid() ::  "+this.getDsid());
		String organname = getSessionUserCode().getInformation().getBname();
		Stockdetail info = suspiciousstockService.findDetailByDid(this.getDsid());		
		this.put("organname", organname);
		this.put("info", info);		
		return SUCCESS;
	}

	/**
	 * 修改证券业可疑交易明细数据
	 * @return
	 */
	public String update(){
		suspiciousstockService.updateStockDetail(stockdetail);
		info("修改成功...");
		log("修改证券业可疑交易明细数据", Constants.LOG_TYPE_UPDATE);
		return OK;
	}

	/**
	 * 证券业可疑交易明细列表
	 * @return
	 */
	public String stockdetaillist(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", this.getId());
		PaginaterList list = suspiciousstockService.getStockBaseDetailInfoById(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModelStockDetail(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("查询证券业可疑交易明细信息", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	
	public String delete(){		
		suspiciousstockService.deleteStockdetailById(this.getDsid());
		log("删除证券业可疑交易明细信息", Constants.LOG_TYPE_DELETE);
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
	public Stockdetail getModel() {
		return stockdetail;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List getGridModelStockDetail() {
		return gridModelStockDetail;
	}

	public void setGridModelStockDetail(List gridModelStockDetail) {
		this.gridModelStockDetail = gridModelStockDetail;
	}

	public void setSuspiciousstockService(
			ISuspiciousStockService suspiciousstockService) {
		this.suspiciousstockService = suspiciousstockService;
	}

	public Long getDsid() {
		return dsid;
	}

	public void setDsid(Long dsid) {
		this.dsid = dsid;
	}

}
