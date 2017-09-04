package org.work.web.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.work.web.util.Paginater;


/**
 * paginater tag.
 * 
 * @author fred.du
 *
 */
public class Paginate extends SimpleTagSupport {
	private int formIndex;
	private boolean showSummary = true;
	private boolean tidy;
	private String navigateStyle;

	public void setNavigateStyle(String navigateStyle) {
		this.navigateStyle = navigateStyle;
	}

	public void setFormIndex(int formIndex) {
		this.formIndex = formIndex;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer html = new StringBuffer();
		
		appendPageHeader(html);
		appendFormIndexHtml(html);
		appendPageIndexHtml(html);
		appendPageNavigationHtml(html);
		appendPageTail(html);
		
		this.getJspContext().getOut().write(html.toString());
	}

	/**
	 * page html tail.
	 * 
	 * @param html
	 */
	private void appendPageTail(StringBuffer html) {
		html.append("</div>");
	}

	/**
	 * page html header.
	 * 
	 * @param html
	 */
	private void appendPageHeader(StringBuffer html) {
		html.append("<div id=\"paginaterLayer\">");
	}

	/**
	 * page navigation.
	 * 
	 * @param html
	 */
	private void appendPageNavigationHtml(StringBuffer html) {
		HttpServletRequest request = (HttpServletRequest) ((PageContext) this.getJspContext()).getRequest();
		Paginater p = (Paginater) request.getAttribute(Paginater.PAGINATER);
		if (p.getMaxPage() < 2) {
			return;
		}
		
		if (showSummary) {
			appendPageSummaryHtml(html, p);
		}
		
		HtmlNavigator navigator = HtmlNavigatorFactory.getInstance(navigateStyle);
		html.append(navigator.getHtmlNavigation(request.getContextPath(), p, tidy));
	}

	/**
	 * navigation summary.
	 * 
	 * @param p
	 * @return
	 */
	private void appendPageSummaryHtml(StringBuffer html, Paginater p) {
		html.append("<div id=\"pageSummary\">");
		
		if (tidy) {
			html.append("第" + p.getCurrentPage() + "/" + p.getMaxPage() + "页&nbsp;&nbsp;");
			html.append("共" + p.getMaxRowCount() + "笔");
		}
		else {
			html.append("第" + p.getCurrentPage() + "页&nbsp;&nbsp;");
			html.append("共" + p.getMaxPage() + "页&nbsp;&nbsp;");
			html.append("共" + p.getMaxRowCount() + "笔");
		}
		
		html.append("</div>");
	}

	/**
	 * page index.
	 * 
	 * @return
	 */
	private void appendPageIndexHtml(StringBuffer html) {
		html.append("<input type=\"hidden\" id=\"" + Paginater.PAGE_NUMBER + "\" name=\"" + Paginater.PAGE_NUMBER + "\" />");
	}

	/**
	 * form index.
	 * 
	 * @return
	 */
	private void appendFormIndexHtml(StringBuffer html) {
		html.append("<input type=\"hidden\" id=\"pageFormIndex\" value=\"" + formIndex + "\" />");
	}

	public void setShowSummary(boolean showSummary) {
		this.showSummary = showSummary;
	}

	public void setTidy(boolean tidy) {
		this.tidy = tidy;
	}
}
