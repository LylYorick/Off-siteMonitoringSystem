package org.work.web.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author fred.du
 *
 */
public class Js extends SimpleTagSupport {
	private static final long serialVersionUID = 1L;
	private String src;
	
	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String contextPath = ((HttpServletRequest) ((PageContext) this.getJspContext()).getRequest()).getContextPath();
		this.getJspContext().getOut().write("<script type=\"text/javascript\" src=\"" + contextPath + src + "\"></script>");
	}
}
