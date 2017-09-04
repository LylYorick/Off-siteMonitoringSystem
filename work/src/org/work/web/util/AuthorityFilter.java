package org.work.web.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.util.WebUtils;
import org.work.web.constants.Constants;
import org.work.web.po.BankUser;



/**
 * 用户登录权限过滤.
 * 
 * @author fred.du
 *
 */
public class AuthorityFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuthorityFilter.class);

	private FilterConfig filterConfig;
	private static final String OVERTIME_URL = "/common/overtime.jsp";
	private static final String INVALID_URL = "/common/invalid.jsp";

	// Handle the passed-in FilterConfig
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	// Process the request/response pair
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) {
		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			/**
			 * p代表父节点；q代表子节点
			 */
			String p = request.getParameter("p");
			String q = request.getParameter("q");
			WebUtils.setSessionAttribute(request, "p", StringUtils.isEmpty(p)?WebUtils.getSessionAttribute(request, "p"):p);
			WebUtils.setSessionAttribute(request, "q", StringUtils.isEmpty(p)?WebUtils.getSessionAttribute(request, "q"):q);
			
			// 公共资源.
			if (isPublicUri(request)) {
				filterChain.doFilter(servletRequest, servletResponse);
				
				return;
			}
			
			// 是否已登录.
			if (!isLogin(request)) {
				response.sendRedirect(request.getContextPath() + OVERTIME_URL);
				
				return;
			}
			filterChain.doFilter(servletRequest, servletResponse);
			// 是否具有访问权限.
			/*if (hasAuthority(request)) {
				filterChain.doFilter(servletRequest, servletResponse);
			}
			else {
				response.sendRedirect(request.getContextPath() + INVALID_URL);
			}*/
		} catch (ServletException sx) {
			filterConfig.getServletContext().log(sx.getMessage());
		} catch (IOException iox) {
			filterConfig.getServletContext().log(iox.getMessage());
		}
	}

	private String getUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		
		return uri = uri.substring(request.getContextPath().length());
	}
	
	/**
	 * 是否有权限访问.
	 * 
	 * @param request
	 * @return
	 */
	private boolean hasAuthority(HttpServletRequest request) {
		BankUser user = (BankUser) WebUtils.getSessionAttribute(request, Constants.SESSION_USER);
		String uri = request.getRequestURI();
		String subUri = uri.substring(request.getContextPath().length()+1);
		Map privileges = (Map) WebUtils.getSessionAttribute(request, Constants.SESSION_USERPRIVILETE);
		
		if (MapUtils.getObject(privileges, subUri) == null) {
			logger.info("用户[" + user.getBuname() + "]没有权限[" + subUri);
			return false;
		}
		
		return true;
	}

	/**
	 * 是否已登录.
	 * 
	 * @param session
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		return request.getSession().getAttribute(Constants.SESSION_USER) != null;
	}

	/**
	 * 未登录也允许访问的url.
	 * 
	 * @param request
	 * @return
	 */
	private boolean isPublicUri(HttpServletRequest request) {
		String uri = getUri(request);
		String action = request.getParameter("method");
		
		if (action == null) {
			action = "";
		}
		
		for (int i = 0; i < ALLOW_URLS.length; i++) {
			String[] uris = ALLOW_URLS[i];
			
			if (PatternMatchUtils.simpleMatch(uris[0], uri) && uris[1].equals(action)) {
				return true;
			}
		}
		
		return false;
	}

	private static final String[][] ALLOW_URLS = new String[][] {
		{"/", ""},
		{"/login.jsp", ""},
		{"/default.jsp", ""},
		{"/system/*.shtml", ""},
		{"/work/*.shtml", ""},
		{"/common/*.jsp", ""}
	};
	
	// Clean up resources
	@Override
	public void destroy() {
		this.filterConfig = null;
	}
}
