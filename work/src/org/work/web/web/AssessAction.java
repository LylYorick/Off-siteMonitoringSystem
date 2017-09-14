/**
 * 
 */
package org.work.web.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Assess;
import org.work.web.po.AssessIndex;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.service.assess.IAssessService;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.financial.impl.FinancialServiceImpl;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.work.year.Year;

/* 
 * @author ThinkPad 
 * date : Jun 24, 2010 11:15:41 AM 
 */
public class AssessAction  extends JsonBaseAction implements ModelDriven<AssessIndex>,ServletRequestAware{
	private HttpServletRequest request;
	private AssessIndex assessIndex = new AssessIndex();
	private IAssessService assessService;
	private IFinancialService financialService;
	private Integer acsid;
	private Integer bid;//金融机构类别
	private List gridModelassess;
	private Integer oid;//金融机构ID
	private String year;//考核年度
	private String level;//考核登记
	
	private static final Logger logger = Logger.getLogger(AssessAction.class);
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@JSON(serialize = false)
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public void setAcsid(Integer acsid) {
		if(acsid == null) return;
		assessIndex = assessService.getAssessIndexByID(acsid);
		if(assessIndex == null){
			info("没有找到指标项"+acsid);
			this.acsid = 0;
		}else{
			this.acsid = acsid;
		}
	}
	
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}
	public void setAssessService(IAssessService assessService) {
		this.assessService = assessService;
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
	@Override
	public List getGridModel() {
		
		return this.gridModel;
	}
	/**
	 * 评分列表
	 */
	public List getGridModelassess() {
		return gridModelassess;
	}
	public void setGridModelassess(List gridModelassess) {
		this.gridModelassess = gridModelassess;
	}
	@JSON(serialize = false)
	public AssessIndex getModel() {
		return this.assessIndex;
	}
	/**
	 * 评分：综合评分
	 * @return
	 */
	public String add() {
		
		Information information = financialService.findByOid(oid);
		Map<String, Object> params = new HashMap<String, Object>();
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");
		params.put("oid", oid);
		params.put("year", year);
		/**added by liuxz at 2017-03-01 特殊处理：区分 总行评分 和 机构自评*/
		params.put("selfevalflag", request.getParameter("selfevalflag"));
		List list = assessService.getAssessIndex(params);
		put("list", list);
		put("information", information);
		return SUCCESS;
	}
	/**
	 * 查看评分: 综合评分 或自评评分
	 * @return
	 */
	public String view() {
		
		logger.info("----oid: "+oid+"\t year: "+year);		
		Information information = financialService.findByOid(oid);
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", oid);
		params.put("year", (null!=year&&!"".equals(year))?year:"9999");
		/**added by liuxz at 2017-03-01 特殊处理：区分 总行评分 和 机构自评*/
		params.put("selfevalflag", request.getParameter("selfevalflag"));
		
		List list = assessService.getAssessView(params);
		put("list", list);
		put("information", information);
		
		return SUCCESS;
	}
	/**
	 * 评分进入
	 */
	public String entry(){
		
		logger.info("***综合评分管理功能***");
		List<Catalog> list = this.financialService.findByCatalog();
		List<AssessIndex> alist = assessService.getAssessIndexByPID(0);
		put("list", list);
		put("alist", alist);
		log("查询评分", Constants.LOG_TYPE_SELECT);
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("oid", null);
        session.put("acsid", null);
        session.put("year", null);
        session.put("bid", null);
        session.put("level", null);
		return SUCCESS;
	}
	/**
	 * 评分列表:综合评分 或自评评分
	 */
	public String list() {
		logger.info("***综合评分管理-“金融机构评分列表”***");
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if(oid==null || oid==9999){
			if(session.get("oid")==null || "9999".equals(String.valueOf(oid)))
				session.put("oid",null);
		}else {
	        session.put("oid", oid);
		}
		if(bid!=null)
	        session.put("bid", bid);
		if(level!=null)
	        session.put("level", level);
		if(acsid!=null)
			session.put("acsid", acsid==0?null:acsid);
		if(year!=null && !"".equals(year)){
	        session.put("year", year);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		int i = 0;
		/*List list1 = new ArrayList();
		list1 = assessService.getAssessIndexByPID((Integer) session.get("acsid"));//TODO:修改标记
		Integer[] acsids = new Integer[list1.size()];
		for(Iterator<AssessIndex> iterator = list1.iterator();iterator.hasNext();){
			acsids[i] = iterator.next().getAcsid();
			i++;
		}
		params.put("ascid", acsids);*/
		params.put("oid", session.get("oid"));
		params.put("level", session.get("level"));
		params.put("bid", session.get("bid"));
		params.put("year", session.get("year")==null||"".equals(session.get("year"))?DateUtil.getCurrentYear():session.get("year"));
		params.put("order",this.getSidx());
		params.put("sord",this.getSord());
		PaginaterList list = assessService.getInformationAssess(params,this.getPage());
		List<Map> result = new ArrayList<Map>();
		Map<String,Object> item;
		
		String sfevalflag=request.getParameter("selfevalflag");
		for(Iterator<Object[]> iterator = list.getList().iterator();iterator.hasNext();){
			Object[] array = iterator.next();
			item = new HashMap<String,Object>();
			item.put("oid", array[1]);
			item.put("bname", array[2]);
			item.put("xxyear", array[3]);
			item.put("xx", array[5]);
			
			Double double1=0d;
			if("b".equals(sfevalflag)){
				double1=(Double)(array[6]==null?0.00:array[6])+Constants.DEFAULT_SCORE;
				item.put("level",array[7]);
			}else{
				double1=(Double)(array[4]==null?0.00:array[4])+Constants.DEFAULT_SCORE;
				item.put("level",array[5]);
				//综合评分-还要显示自评得分
				Double double2=(Double)(array[6]==null?0.00:array[6])+Constants.DEFAULT_SCORE;
				item.put("selfevalscore", double2);
			}
			item.put("score",double1);
			
			
			//logger.info(array[1]+"\t"+array[2]+"\t"+array[3]+"\t"+array[4]+"\t"+array[5]+"\t"+array[6]+"\t"+array[7]);
			result.add(item);
		}
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModelassess(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		return JSON;
	}
	/**
	 *保存评分
	 */
	public String save() {
		
		List<AssessIndex> list = assessService.getAssessIndex();//查综合评分指标
		logger.info("--------list.size(): "+list.size());
		String value;//得分
		String remark;//得分说明
		String orgZpvalue;//得分2
		String orgZpRemark;//得分说明2
		
		Assess result;
		Information information = financialService.findByOid(oid);
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");
		//TODO:需要保存在内存中，给业务处理层处理，首先删除原得分记录，再添加，同一个事务处理
		for(Iterator<AssessIndex> iterator = list.iterator();iterator.hasNext();){
			AssessIndex item = iterator.next();
			if(item.getAscfiled() != null){
				value = request.getParameter(item.getAscfiled());
				remark = request.getParameter("input"+item.getAscfiled());
				orgZpvalue = request.getParameter("orgZpScore_"+item.getAscfiled());
				orgZpRemark = request.getParameter("orgzPRemark_"+item.getAscfiled());
				
				result = new Assess();
				result.setAssessindex(item);
				result.setScore(value);
				result.setRemark(remark);
				result.setBOrgInformation(information);
				result.setYear(year);
				
				result.setSelevalscore(orgZpvalue);
				result.setSelevalremark(orgZpRemark);
				assessService.saveAssess(result);
			}
		}
		log("保存评分", Constants.LOG_TYPE_ADD);
		return OK;
	}
	/**
	 * 进入指标查询列表
	 * @return
	 */
	public String indexentry() {
		return SUCCESS;
	}
	/**
	 * 指标查询显示
	 * @return json
	 */
	public String indexlist(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("order",this.getSidx());
		params.put("sord",this.getSord());
		PaginaterList list = assessService.getAssessIndex(params,this.getPage());
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(20);
		return JSON;
	}
	/**
	 * 进入指标新增页面
	 * @return
	 */
	public String indexadd() {
		List list = assessService.getAssessIndexByPID(0);
		put("list", list);
		return SUCCESS;
	}
	/**
	 * 保存新增指标
	 * @return
	 */
	public String indexsave() {
		assessService.saveAssessIndex(assessIndex);
		return OK;
	}
	/**
	 * 进入指标修改页面
	 */
	public String indexmodify() {
		if("0".equals(acsid))
			throw new ServiceException("没有指定指标!");
		return SUCCESS;
	}
	/**
	 * 保存修改指标
	 */
	public String indexupdate() {
		assessService.saveAssessIndex(assessIndex);
		return OK;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
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
	 * 自评管理进入
	 * added by liuxianze at 2017-2-16
	 */
	public String selfevalentry(){

		logger.info("----selfevalentry: "+year+"\t"+"oid: "+oid);
		
        Integer qoid=getSessionUserInformation();
		Information information = financialService.findByOid(qoid);
		Map<String, Object> params = new HashMap<String, Object>();
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");
		
		String defaultYear=DateUtil.getCurrentYear();//默认当前年份
		if(null==year||"-1".equals(year)){
			year=defaultYear;
		}
		
		params.put("oid", null!=oid?oid:qoid);
		params.put("year", year);
		List list = assessService.getAssessIndex2(params);//只查询自评用到的指标
		
		List sumlist=assessService.getSelfEvalueScore(params);//查看当前得分
		Double double1=(Double)(sumlist.get(0)==null?0.00:sumlist.get(0))+Constants.DEFAULT_SCORE;
		
		put("information", information);//取机构名称
		put("defaultYear", defaultYear);//默认年份
		put("s_evalScore", double1);//当前自评分数
		
		put("oid", null!=oid?oid:qoid);//机构代码
		put("list", list);//展示的列表
		
		
		ArrayList<String> yearList=new ArrayList<String>();
		for(int i=1990;i<2118;i++){
			yearList.add(String.valueOf(i));
		}
		put("yearList",yearList);
		
		return SUCCESS;
	}
	
	/**
	 *保存机构自评评分
	 */
	public String save2() {
		
		logger.info("----save2_year: "+year+"\t"+"oid: "+oid);
		
		if("-1".equals(year)){
			year=DateUtil.getCurrentYear();//默认当前年份;
		}
	
		List<AssessIndex> list = assessService.getAssessIndex2();//查自评指标
		String value;//得分
		String remark;//得分说明
		String rhValue;
		String rhRemark;
		
		Assess result;
		Information information = financialService.findByOid(oid);
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");
		//TODO:需要保存在内存中，给业务处理层处理，首先删除原得分记录，再添加，同一个事务处理
		for(Iterator<AssessIndex> iterator = list.iterator();iterator.hasNext();){
			AssessIndex item = iterator.next();
			if(item.getAscfiled() != null){
				value = request.getParameter(item.getAscfiled());
				remark = request.getParameter("input"+item.getAscfiled());
				result = new Assess();
				result.setAssessindex(item);
				result.setSelevalscore(value);
				result.setSelevalremark(remark);
				result.setBOrgInformation(information);
				result.setYear(year);
				
				rhValue = request.getParameter("orgScore_"+item.getAscfiled());
				rhRemark = request.getParameter("orgRemark_"+item.getAscfiled());
				result.setScore(rhValue);
				result.setRemark(rhRemark);
				
				logger.info(result.toString());
				assessService.saveAssess(result);
			}
		}
		log("保存机构自评评分", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	/**
	 * 机构自评管理
	 */
	public String selfevalmgrentry(){
		
		logger.info("***");
		
		logger.info("进入综合评分管理功能");
		List<Catalog> list = this.financialService.findByCatalog();
		List<AssessIndex> alist = assessService.getAssessIndexByPID2(0,"b");//自评指标ascfeild字段里面才包含“b”
		put("list", list);
		put("alist", alist);
		log("查询评分", Constants.LOG_TYPE_SELECT);
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("oid", null);
        session.put("acsid", null);
        session.put("year", null);
        session.put("bid", null);
        session.put("level", null);
		return SUCCESS;
	}
	/**
	 *一级指标管理
	 */
	public String oneClassIndex(){
		logger.info("***");
		
		logger.info("进入一级指标管理");
		return SUCCESS;
	}
	/**新增一级指标管理
	 * @return
	 */
	public String addOneClassIndex(){
		logger.info("***");
		
		logger.info("进入新增一级指标管理");
		return SUCCESS;
	}
	/**
	 * @return
	 */
	public String alterOneClassIndex(){
		logger.info("***");
		
		logger.info("进入新增一级指标管理");
		return SUCCESS;
	}

	/**
	 *二级指标管理
	 */
	public String twoClassIndex(){
		logger.info("***");
		logger.info("进入二级指标管理");
		return SUCCESS;
	}
	/**
	 *新增二级指标管理
	 */
	public String addTwoClassIndex(){
		logger.info("***");
		logger.info("进入新增二级指标管理");
		return SUCCESS;
	}
	/**
	 *修改二级指标
	 */
	public String alterTwoClassIndex(){
		logger.info("***");
		logger.info("进入修改二级指标");
		return SUCCESS;
	}
	/**
	 *初评管理
	 */
	public String peopleBankFirstRate(){
		logger.info("***");
		
		logger.info("进入初评管理");
		return SUCCESS;
	}
	/**
	 *初评管理明细
	 */
	public String peopleBankFirstRateList(){
		logger.info("***");
		
		logger.info("进入初评管理明细");
		return SUCCESS;
	}
	
	/**
	 *查看初评管理
	 */
	public String peopleBankFirstRateView(){
		logger.info("***");
		
		logger.info("查看初评管理");
		return SUCCESS;
	}
	
	/**
	 *初评管理直接评定等级
	 */
	public String directRate(){
		logger.info("***");
		
		logger.info("进入初评管理-直接评定等级");
		return SUCCESS;
	}
	
	/**
	 *附件管理
	 */
	public String fileManager(){
		logger.info("***");
		
		logger.info("附件管理");
		return SUCCESS;
	}
	
	/**
	 *金融机构自评管理
	 */
	public String selfAssessment(){
		logger.info("***");
		
		logger.info("进入金融机构自评管理");
		return SUCCESS;
	}
	/**
	 * 查看金融机构自评
	 */
	public String listSelfAssessment(){
		logger.info("***");
		
		logger.info("进入查看金融机构自评");
		return SUCCESS;
	}
	
	/**
	 * 金融机构自评
	 */
	public String selfAssessmentDo(){
		logger.info("***");
		
		logger.info("进入金融机构自评");
		return SUCCESS;
	}
	/**
	 * 金融机构自评附件上传
	 */
	public String selfAssessmentUpload(){
		logger.info("***");
		
		logger.info("进入金融机构自评附件上传");
		return SUCCESS;
	}
	/**
	 * 金融机构复核
	 */
	public String selfAssessmentCheck(){
		logger.info("***");
		
		logger.info("进入金融机构复核");
		return SUCCESS;
	}
	/**
	 * 金融机构异议申请查询界面
	 */
	public String applyOppositionList(){
		logger.info("***");
		
		logger.info("进入金融机构异议申请查询界面");
		return SUCCESS;
	}
	
	/**
	 * 监管意见书管理(人行端)
	 */
	public String superviseOpinionManager(){
		logger.info("***");
		
		logger.info("进入监管意见书管理(人行端)");
		return SUCCESS;
	}
	
	/**
	 * 上传监管意见书
	 */
	public String superviseOpinionAdd(){
		logger.info("***");
		
		logger.info("上传监管意见书");
		return SUCCESS;
	}
	
	/**
	 * 监管意见书管理(机构端)
	 */
	public String superviseOpinionBankManager(){
		logger.info("***");
		
		logger.info("进入监管意见书管理(机构端)");
		return SUCCESS;
	}
	
	/**
	 * 整改报告管理(人行端)
	 */
	public String rectificationReportManager(){
		logger.info("***");
		
		logger.info("进入整改报告管理(人行端)");
		return SUCCESS;
	}
	
	
	/**
	 * 整改报告管理(机构端)
	 */
	public String rectificationReportBankManager(){
		logger.info("***");
		
		logger.info("进入整改报告管理(机构端)");
		return SUCCESS;
	}
	
	/**
	 * 上传整改报告
	 */
	public String rectificationReportAdd(){
		logger.info("***");
		
		logger.info("上传整改报告");
		return SUCCESS;
	}
	/**
	 * 金融机构提出异议申请 二级指标评分异议
	 */
	public String applyOppositionAdd(){
		logger.info("***");
		
		logger.info("进入金融机构提出异议申请-二级指标评分异议 界面");
		return SUCCESS;
	}
	/**
	 * 金融机构提出异议申请 评级等级异议
	 */
	public String applyOppositionForAssess(){
		logger.info("***");
		
		logger.info("进入金融机构提出异议申请-评级等级异议 界面");
		return SUCCESS;
	}
	/**
	 * 异议申请处理查询界面
	 */
	public String manageOppositionList(){
		logger.info("***");
		
		logger.info("进入异议申请处理查询界面");
		return SUCCESS;
	}
	/**
	 * 处理 二级指标评分异议
	 */
	public String manageOppositionDeal(){
		logger.info("***");
		
		logger.info("进入处理二级指标评分异议界面");
		return SUCCESS;
	}
	/**
	 * 处理评级等级异议
	 */
	public String manageOppositionDealAssess(){
		logger.info("***");
		
		logger.info("进入评级等级异议界面");
		return SUCCESS;
	}
	/**
	 * 评级状态管理
	 */
	public String assessmentStatusManager(){
		logger.info("***");
		
		logger.info("进入评级等级异议界面");
		return SUCCESS;
	}
	
	/**
	 * 异议申请查询界面(金融机构)
	 */
	public String manageOppositionBankList(){
		logger.info("***");
		
		logger.info("进入异议申请查询界面(金融机构)");
		return SUCCESS;
	}
	/**
	 * 异议申请界面(金融机构)
	 */
	public String manageOppositionApply(){
		logger.info("***");
		
		logger.info("进入异议申请界面(金融机构)");
		return SUCCESS;
	}

	/**
	 * 指标管理 --
	 */
	public String quotaManagerList(){
		logger.info("***");
		
		logger.info("指标管理");
		return SUCCESS;
	}
	
	/**
	 *新增指标
	 */
	public String addQuota(){
		logger.info("***");
		logger.info("新增指标");
		return SUCCESS;
	}
	/**
	 *初评复核
	 */
	public String rateVerify(){
		logger.info("***");
		logger.info("新增指标");
		return SUCCESS;
	}
	/**
	 *评级总览
	 */
	public String rateList(){
		logger.info("***");
		logger.info("评级总览");
		return SUCCESS;
	}
	/**
	 *评级状态管理
	 */
	public String assessStatusManager(){
		logger.info("***");
		logger.info("评级总览");
		return SUCCESS;
	}
	
	
	/**
	 *评级管理(复评)
	 */
	public String peopleBankFirstRateTwo(){
		logger.info("***");
		
		logger.info("进入评级管理(复评)");
		return SUCCESS;
	}
	
	/**
	 *评级管理(公示后)
	 */
	public String peopleBankFirstRateThree(){
		logger.info("***");
		
		logger.info("进入评级管理(公示后)");
		return SUCCESS;
	}
	
	/**
	 *金融机构评级管理-复核
	 */
	public String selfAssessmentTwo(){
		logger.info("***");
		
		logger.info("进入金融机构评级管理-复核");
		return SUCCESS;
	}
	
	/**
	 *金融机构评级管理-复评
	 */
	public String selfAssessmentThree(){
		logger.info("***");
		
		logger.info("进入金融机构评级管理-复评");
		return SUCCESS;
	}
	
	/**
	 *金融机构评级管理-公示后
	 */
	public String selfAssessmentFour(){
		logger.info("***");
		
		logger.info("进入金融机构评级管理-公示后");
		return SUCCESS;
	}
}
