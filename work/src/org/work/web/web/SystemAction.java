package org.work.web.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.work.web.constants.Constants;
import org.work.web.po.BankUser;
import org.work.web.po.LogInfo;
import org.work.web.po.Privilege;
import org.work.web.po.Resource;
import org.work.web.po.Role;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.manage.IManageService;
import org.work.web.service.report.IReportService;
import org.work.web.service.userlog.IUserLogService;
import org.work.web.util.ComparatorMenu;
import org.work.web.util.Comparatorpm;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.PrivilegeMenu;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 登录、退出处理
 * 
 * @author aps-dux
 * 
 */
@SuppressWarnings("serial")
public class SystemAction extends ActionSupport implements ServletRequestAware {
	private static final Logger logger = Logger.getLogger(SystemAction.class);
	private HttpServletRequest request;
	private IUserLogService userLogService;
	private IFinancialService financialService;
	private String usernm;
	private String passwd;
	private IManageService manageService;
	private IReportService reportService;

	public void setReportService(IReportService reportService) {
		this.reportService = reportService;
	}
	public IManageService getManageService() {
		return manageService;
	}
	public void setManageService(IManageService manageService) {
		this.manageService = manageService;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@SuppressWarnings("unchecked")
	public void setErrorMsg(String errorMsg) {
		try {
			Map session = ActionContext.getContext().getSession();
			session.put("usernm", usernm);
			session.put("errors", errorMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户登录
	 */
	@SuppressWarnings("unchecked")
	public String login() {
		String result = SUCCESS;
		Integer uoidString;
		String status;
		Map session = ActionContext.getContext().getSession();
		if (usernm==null || passwd==null || "".equals(usernm) ||"".equals(passwd)) {
			return INPUT;
		}
		/**
		 * f:通用平台单点登录验证
		 */
		String referer = request.getHeader("referer")==null?"":request.getHeader("referer");
		if(referer.startsWith(Constants.SYSTEM_URL)){
			logger.info("通用平台过来的数据...");
		}
		// f:end
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", usernm);
		params.put("password", passwd);

		Set<Privilege> privileges = new HashSet<Privilege>();
		Map<String, Resource> auth = new HashMap<String, Resource>();

		BankUser user = null;
		List users = manageService.findBy(params);

		if (users.size() > 0) {
			user = (BankUser) users.get(0);

			if (!passwd.equals(user.getBupswd())) {
				setErrorMsg("您的密码错误！");
				return INPUT;
			}
		} else {
			setErrorMsg("用户名或者密码错误!");
			return INPUT;
		}
		// 用户拥有的角色
		Set<Role> roles = user.getTPubRoleusers();
		Role role = null;
		Privilege prlg = null;
		// 循环取出每个角色中的权限
		Iterator<Role> it = roles.iterator();
		while (it.hasNext()) {
			role = it.next();
			Iterator<Privilege> itr = role.getTPubRoleprivileges().iterator();
			while (itr.hasNext()) {
				prlg = itr.next();
				Set<Resource> resources = prlg.getTPubResources();
				for (Iterator<Resource> iterator = resources.iterator(); iterator.hasNext();) {
					Resource resource = iterator.next();
					auth.put(resource.getPrurl(), resource);
				}
				privileges.add(prlg);
			}
		}
		// 用户拥有的菜单资源
		Set<PrivilegeMenu> menus = new HashSet<PrivilegeMenu>(10);
		Iterator<Privilege> iter = privileges.iterator();
		// 对用户所拥有的权限进行循环
		while (iter.hasNext()) {
			Privilege p = iter.next();
			// 如果该资源不是菜单类资源，则不加入菜单集合 (1为菜单资源)
			if (null != p.getPismenu() && p.getPismenu() != 1) {
				continue;
			}
			if (p.getTPubResources().size() <= 0) {
				// 菜单权限
				PrivilegeMenu pm = new PrivilegeMenu();
				pm.setId(String.valueOf(p.getPid()));// 菜单Id号
				if (p.getPpid() == 9999) {
					pm.setPid("-1");
				} else {
					pm.setPid(String.valueOf(p.getParent().getPid()));
				}
				pm.setName(p.getPname());
				menus.add(pm);
			} else {
				// 该项权限所拥有的资源集合
				Set<Resource> src = p.getTPubResources();
				Iterator iterator = src.iterator();
				while (iterator.hasNext()) {
					Resource r = (Resource) iterator.next();
					// 如果该资源不是菜单类资源，则不加入菜单集合 (1为菜单资源)
					if (null != p.getPismenu() && p.getPismenu() != 1) {
						continue;
					}
					// 菜单权限
					PrivilegeMenu pm = new PrivilegeMenu();
					pm.setId(String.valueOf(p.getPid()));// 菜单Id号
					if (p.getParent() == null) {
						pm.setPid("-1");
					} else {
						pm.setPid(String.valueOf(p.getParent().getPid()));
					}
					pm.setName(p.getPname());
					if (r == null) {
						pm.setUrl("");
					} else {
						pm.setUrl(r.getPrurl());
					}

					menus.add(pm);
				}
			}

		}
		// 用于排序
		ComparatorMenu comparator = new ComparatorMenu();
		Comparatorpm pmcomparator = new Comparatorpm();

		Map<String, List> map = new HashMap<String, List>();

		List list = new ArrayList();
		for (Iterator<PrivilegeMenu> itr = menus.iterator(); itr.hasNext();) {
			PrivilegeMenu pm = itr.next();
			if ("0".equals(pm.getPid().trim())) {
				List subList = map.get(pm.getId());
				if (subList == null)
					subList = new ArrayList();
				map.put(pm.getId(), subList);
				Collections.sort(subList, pmcomparator);
				list.add(new Object[]{pm, subList});
			} else {
				List subList = map.get(pm.getPid());
				if (subList == null) {
					subList = new ArrayList();
					map.put(pm.getPid(), subList);
					subList.add(pm);
				} else {
					subList.add(pm);
				}
				Collections.sort(subList, pmcomparator);
			}
		}

		Collections.sort(list, comparator);

		/**
		 * 获取金融机构更新信息记录
		 */
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("oid", user.getInformation()==null?null:user.getInformation().getOid());
		PaginaterList history = financialService.getHistoryFinancial(param, 1);
		ActionContext.getContext().getContextMap().put("history",history);
		List reportlist;
		/**
		 * 人行用户只显示待上报的报表
		 */
		if(user.getInformation()==null){
			uoidString = null;
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("year", DateUtil.getCurrentYear());
			param1.put("quater", DateUtil.getSeason(userLogService.getReportEndDay(Integer.valueOf(Constants.REPORT_TYPE_QUATER))));
			status = Constants.REPORT_STATUS_TOUPLOAD;
			reportlist = reportService.getReportIsreport(param1);
		}else {
			uoidString = user.getInformation().getOid();
			status = null;
			reportlist = getReortList(uoidString,status);
		}
		System.out.println("----uoidString: "+uoidString);
		user.setAllprlgs(privileges);// 所有权限集合
		user.setMenus(list);// 所有菜单权限集合
		session.put(Constants.SESSION_USER, user);
		session.put(Constants.SESSION_USERPRIVILETE, auth);
		BankUser updateUser = manageService.findById(user.getBuid());
		updateUser.setLoadtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		manageService.updateUser(updateUser);
		ActionContext.getContext().getContextMap().put("reportlist", reportlist);
		logger.info("用户登录" + user.getBuname());
		LogInfo log = new LogInfo();
		log.setOperatedetail("用户登录");
		log.setOperatetype(Constants.LOG_TYPE_LOGIN);
		log.setOperatorid(user.getBuid());
		log.setOperatorname(user.getBuname());
		log.setTime(DateUtil.getCurrentPrettyDateTime());
		userLogService.saveLogInfo(log);
		return result;
	}

	private List getReortList(Integer oid,String status){
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();

        Integer[] quater={0,DateUtil.getSeason(userLogService.getReportEndDay(Integer.valueOf(Constants.REPORT_TYPE_QUATER)))};
		params.put("oid",oid );
		params.put("reportstatus",status );
		params.put("reportquater",quater);
		params.put("order","oid" );
		params.put("sord","asc" );
		params.put("reportyear",DateUtil.getCurrentYear());
		PaginaterList list = reportService.getReport(params,1);	
		return list.getList();
	}
	/**
	 * 用户退出
	 */
	public String logout() {
		String result = SUCCESS;
		ActionContext.getContext().getSession().remove(Constants.SESSION_USER);
		ActionContext.getContext().getSession().remove("p");
		ActionContext.getContext().getSession().remove("q");
		ActionContext.getContext().getSession().clear();
		logger.info("用户退出");
		return result;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setUserLogService(IUserLogService userLogService) {
		this.userLogService = userLogService;
	}
	public IFinancialService getFinancialService() {
		return financialService;
	}
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}

}
