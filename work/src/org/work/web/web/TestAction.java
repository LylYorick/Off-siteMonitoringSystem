/**
 * 
 */
package org.work.web.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONException;

import org.apache.log4j.Logger;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.po.TestPo;
import org.work.web.service.manage.IManageService;
import org.work.web.util.Paginater;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class TestAction extends JsonBaseAction implements ModelDriven<TestPo> {
	private static final Logger logger = Logger.getLogger(TestAction.class);
	private TestPo test = new TestPo();
	private Integer navid;
	private IManageService manageService;
	
	public void setManageService(IManageService manageService) {
		this.manageService = manageService;
	}
	
	public Integer getNavid() {
		return navid;
	}

	public void setNavid(Integer navid) {
		this.navid = navid;
	}

	public String list() throws JSONException{
		info("ajax开始取数...");
		Paginater paginater = new Paginater(100,this.getPage());
		TestPo testPo;
		List<TestPo> tlist = new ArrayList<TestPo>();
		if("a".equals(test.getName())){
		for(int i=20;i>0;i--){
			testPo = new TestPo();
			testPo.setAddress("地址"+test.getName()+i);
			testPo.setAge("年龄"+i);
			testPo.setCompany("公司阿萨德发撒地方爱上打发收到伐士大夫撒"+i);
			testPo.setEmail("邮件"+i);
			testPo.setName("名称"+i);
			testPo.setTel("电话"+i);
			testPo.setTitle("头衔"+i);
			tlist.add(testPo);
		}
		setGridModel(tlist);
		setPage(1);
		setRows(10);
		setTotal(2l);
		setRecord(20);
		setSidx("");
		setSord("asc");
		}else{
			for(int i=30;i>0;i--){
				testPo = new TestPo();
				testPo.setAddress("地址"+test.getName()+i);
				testPo.setAge("年龄"+i);
				testPo.setCompany("公司阿萨德发撒地方爱上打发收到伐士大夫撒"+i);
				testPo.setEmail("邮件"+i);
				testPo.setName("名称"+i);
				testPo.setTel("电话"+i);
				testPo.setTitle("头衔"+i);
				tlist.add(testPo);
			}
			setGridModel(tlist);
			setPage(1);
			setRows(10);
			setTotal(2l);
			setRecord(20);
			setSidx("");
			setSord("asc");
		}
        return SUCCESS;
	}
	public String LoadSideNav() throws IOException{
		/*ActionContext.getContext().getSession().put("navid", navid);
		PFunction pFunction = manageService.getByFunctionId(navid);
		StringBuffer sb = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Set<PNode> nodeSet = pFunction.getPNodes();
		int i = 0;
		String context = ServletActionContext.getRequest().getContextPath();
		for(Iterator<PNode> iterator = nodeSet.iterator();iterator.hasNext();){
			PNode p = iterator.next();
			sb.append("<li class=\"menu\"><h3><a href=\"#\">"+p.getNName()+"</a></h3><div><ul>");
			Set<PNav> navSet = p.getPNavs();
			for(Iterator<PNav> it = navSet.iterator();it.hasNext();){
				PNav n = it.next();
				
				sb.append("<li><a  id=Menu_"+n.getVid()+" href="+context+n.getUrl()+" onclick=ChangeMenu('Menu_"+n.getVid()+"',"+i+")>"+n.getVname()+"</a></li>");
			}
			sb.append("</ul></div></li>");
			i++;
		}
		out.write(sb.toString());
		System.out.println(sb.toString());*/
		return null;
	}
	public String entryadd(){
		return SUCCESS;
	}
	public String add(){
		System.out.println("----"+test.getName());
		System.out.println(ActionContext.getContext().getValueStack());
		return OK;
	}
	public String listx() throws JSONException{
		info("ajax开始取数...");
		Paginater paginater = new Paginater(100,this.getPage());
		TestPo testPo;
		List<TestPo> tlist = new ArrayList<TestPo>();
		for(int i=200;i>0;i--){
			testPo = new TestPo();
			testPo.setAddress("add"+i);
			testPo.setAge("age"+i);
			testPo.setCompany("company"+i);
			testPo.setEmail("email"+i);
			testPo.setName("name"+i);
			testPo.setTel("tel"+i);
			testPo.setTitle("title"+i);
			tlist.add(testPo);
		}
		setGridModel(tlist);
		setPage(1);
		setRows(10);
		setTotal(2l);
		setRecord(20);
		setSidx("");
		setSord("asc");
        return SUCCESS;
	}
	public String getJSON()
	  {
	    return list();
	  }
	public String entry(){
		return SUCCESS;
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
	public List<TestPo> getGridModel() {
		
		return this.gridModel;
	}
	@JSON(serialize = false)
	public TestPo getModel() {
		return test;
	}

}
