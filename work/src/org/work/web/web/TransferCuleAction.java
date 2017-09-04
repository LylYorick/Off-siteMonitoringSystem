package org.work.web.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Transfersource;
import org.work.web.service.transfercule.ITransferculeService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class TransferCuleAction extends JsonBaseAction implements ModelDriven<Transfersource>{

	private Transfersource transfersource = new Transfersource();
	
	private Integer tsid;
	private String transfersymbol;
	private String subjectname;
	private String isplacedonfile;
	private String receivingunit;
	private String starttime;
	private String endtime;
	private File transfersourceFile;
	private String transfersourceFileFileName;
	private ITransferculeService transferculeService;
	
	public Integer getTsid() {
		return tsid;
	}

	public void setTsid(Integer tsid) {
		this.tsid = tsid;
	}

	@JSON(serialize = false)
	public String getTransfersymbol() {
		return transfersymbol;
	}

	public void setTransfersymbol(String transfersymbol) {
		this.transfersymbol = transfersymbol;
	}

	@JSON(serialize = false)
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@JSON(serialize = false)
	public String getIsplacedonfile() {
		return isplacedonfile;
	}

	public void setIsplacedonfile(String isplacedonfile) {
		this.isplacedonfile = isplacedonfile;
	}

	@JSON(serialize = false)
	public String getReceivingunit() {
		return receivingunit;
	}

	public void setReceivingunit(String receivingunit) {
		this.receivingunit = receivingunit;
	}

	@JSON(serialize = false)
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@JSON(serialize = false)
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public File getTransfersourceFile() {
		return transfersourceFile;
	}

	public void setTransfersourceFile(File transfersourceFile) {
		this.transfersourceFile = transfersourceFile;
	}

	public String getTransfersourceFileFileName() {
		return transfersourceFileFileName;
	}

	public void setTransfersourceFileFileName(String transfersourceFileFileName) {
		this.transfersourceFileFileName = transfersourceFileFileName;
	}

	@Override
	public List getGridModel() {
		// TODO Auto-generated method stub
		return gridModel;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getRecords() {
		// TODO Auto-generated method stub
		return this.record;
	}

	@Override
	public Integer getRows() {
		// TODO Auto-generated method stub
		return this.rows;
	}

	@Override
	public String getSidx() {
		// TODO Auto-generated method stub
		return this.sidx;
	}

	@Override
	public String getSord() {
		// TODO Auto-generated method stub
		return this.sord;
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return this.total;
	}

	@JSON(serialize = false)
	public Transfersource getModel() {
		// TODO Auto-generated method stub
		return transfersource;
	}

	public void setTransferculeService(ITransferculeService transferculeService) {
		this.transferculeService = transferculeService;
	}
	/**
	 * 线索移交
	 * @return
	 */
	public String entry() {
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        session.remove("transfersymbol");
        session.remove("subjectname");
        session.remove("isplacedonfile");
        session.remove("receivingunit");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	
	public String add(){
		return SUCCESS;
	}
	
	public String save() {
		transferculeService.saveTransferSource(transfersource,transfersourceFile,transfersourceFileFileName);
		info("添加成功...");
		log("保存线索移交信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        if(transfersymbol!=null){
        	session.put("transfersymbol", transfersymbol);
        }
        if(subjectname!=null){
        	session.put("subjectname", subjectname);
        }
        if(isplacedonfile!=null){
        	session.put("isplacedonfile", isplacedonfile);
        }
        if(receivingunit!=null){
        	session.put("receivingunit", receivingunit);
        }
        if(starttime!=null){
        	session.put("starttime", starttime);
        }
        if(endtime!=null){
        	session.put("endtime", endtime);
        }
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));
		params.put("transfersymbol", session.get("transfersymbol"));
		params.put("subjectname", session.get("subjectname"));
		params.put("isplacedonfile", session.get("isplacedonfile"));
		params.put("receivingunit", session.get("receivingunit"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = transferculeService.getTransferSourceInfo(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		return JSON;
	}
	
	public String modify(){
		if(tsid==null)
			throw new ServiceException("没有指定信息");
		Transfersource ts = transferculeService.findById(tsid);
		this.put("info", ts);
		return SUCCESS;
	}
	
	public String update(){
		transferculeService.update(transfersource);
		return OK;
	}
	
	public String delete(){
		if(tsid==null)
			throw new ServiceException("没有指定信息");
		transferculeService.deleteById(tsid);
		return OK;
	}
	
}
