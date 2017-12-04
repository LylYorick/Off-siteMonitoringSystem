/**
 * 
 */
package org.work.web.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.work.web.constants.Constants;
import org.work.web.po.BankUser;
import org.work.web.po.LogInfo;
import org.work.web.service.userlog.IUserLogService;
import org.work.web.util.DateUtil;
import org.work.web.util.NavButton;
import org.work.web.util.ReflectUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
public abstract class JsonBaseAction extends ActionSupport {
	private static final Logger logger = Logger.getLogger(JsonBaseAction.class);
	protected static final String OK = "OK";
	protected static final String ERROR = "ERROR";
	protected static final String JSON = "JSON";
	private IUserLogService userLogService;
	protected List btList = new ArrayList();
	protected String successMessage;
	protected List gridModel;
	@SuppressWarnings("unused")
	protected Integer rows = 0;
	@SuppressWarnings("unused")
	protected Integer page = 0;
	@SuppressWarnings("unused")
	protected Long total = 0l;
	@SuppressWarnings("unused")
	protected Integer record = 0;
	@SuppressWarnings("unused")
	protected String sord;
	@SuppressWarnings("unused")
	protected String sidx;
	@SuppressWarnings("unused")
	protected String searchField;
	@SuppressWarnings("unused")
	protected String searchString;
	@SuppressWarnings("unused")
	protected String searchOper;
	public abstract List getGridModel();
	public void setGridModel(List gridModel) {
		this.gridModel = gridModel;
	}
	public abstract Integer getRows();
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public abstract Integer getPage();
	public void setPage(Integer page) {
		this.page = page;
	}
	public abstract Long getTotal();
	public void setTotal(Long total) {
		this.total = total;
	}
	public abstract Integer getRecords();//总记录数
	public void setRecord(Integer record) {
		this.record = record;
	}
	public abstract String getSord();
	public void setSord(String sord) {
		this.sord = sord;
	}
	public abstract String getSidx();
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public String getSearchOper() {
		return searchOper;
	}
	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}
	protected void put(String key, Object value) {
		ActionContext.getContext().getContextMap().put(key, value);
	}
	/**
	 * 
	 * @return 获取用户基本信息
	 */
	protected BankUser getSessionUserCode() {
		BankUser user =  (BankUser) ActionContext.getContext().getSession().get(Constants.SESSION_USER);
		return user;
	}
	/**
	 * 
	 * @return 获取用户的oid
	 */
	protected Integer getSessionUserInformation() {
		BankUser user =  getSessionUserCode();
		if(user.getInformation()==null){
			return null;
		}else {
			return user.getInformation().getOid();
		}
	}
	/**
	 * 添加导航按钮
	 */
	protected void addNaviButton(String name,String url){
		NavButton navButton = new NavButton();
		navButton.set_btName(name);
		navButton.set_btUrl(url);
		btList.add(navButton);
	}
	/**
	 * info日志
	 */
	protected void info(String message) {
		Logger log = null;
		try {
			log = (Logger) ReflectUtil.getFieldValue(this, "logger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (log == null) {
			log = logger;
		}
		log.info("用户[" + getSessionUserCode().getBuname() + "] 操作:"  + message);
	}
	protected void log(String loginfo,String logtype) {
		LogInfo log = new LogInfo();
		log.setOperatedetail(loginfo);
		log.setOperatetype(logtype);
		log.setOperatorid(getSessionUserCode().getBuid());
		log.setOperatorname(getSessionUserCode().getBuname());
		log.setTime(DateUtil.getCurrentPrettyDateTime());
		userLogService.saveLogInfo(log);
	}
	/**
	 * 获取季报的截止日期
	 */
	protected int getEndday(){
		return userLogService.getReportEndDay(Integer.valueOf(Constants.REPORT_TYPE_QUATER));
	}
	public void setUserLogService(IUserLogService userLogService) {
		this.userLogService = userLogService;
	}
	public IUserLogService getUserLogService() {
		return userLogService;
	}
	public List getBtList() {
		return btList;
	}
	public void setBtList(List btList) {
		this.btList = btList;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	
	/**
	 * 向成功的界面插入提示信息
	 * @param successMessage
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
}