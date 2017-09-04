package org.work.web.web.tags;

import org.work.web.util.Paginater;



/**
 * image html navigator.
 * 
 * @author fred.du
 *
 */
public class ImageHtmlNavigator implements HtmlNavigator {

	public String getHtmlNavigation(String contextPath, Paginater p, boolean tidy) {
		StringBuffer html = new StringBuffer();
		html.append("<div id=\"pageNavigation\">");
		
		if (tidy) {
			html.append("<img src=\"" + contextPath + "/images/refresh.gif\" onclick=\"javascript: Paginater.toPage(" + p.getCurrentPage() + ")\" id=\"_refresh\" style=\"display:none\" />");
			
			if (p.getCurrentPage() != p.getFirstPage()) {
				html.append("<img src=\"" + contextPath + "/images/page-first.gif\" onclick=\"javascript: Paginater.toPage(" + p.getFirstPage() + ")\" />");
				html.append("<img src=\"" + contextPath + "/images/page-prev.gif\" onclick=\"javascript: Paginater.toPage(" + p.getPriorPage() + ")\" />");
			}
			
			if (p.getCurrentPage() != p.getLastPage()) {
				html.append("<img src=\"" + contextPath + "/images/page-next.gif\" onclick=\"javascript: Paginater.toPage(" + p.getNextPage() + ")\" />");
				html.append("<img src=\"" + contextPath + "/images/page-last.gif\" onclick=\"javascript: Paginater.toPage(" + p.getLastPage() + ")\" />");
			}
		}
		else {
			html.append("<img src=\"" + contextPath + "/images/refresh.gif\" onclick=\"javascript: Paginater.toPage(" + p.getCurrentPage() + ")\" id=\"_refresh\" />");
			html.append("&nbsp;&nbsp;");
			
			if (p.getCurrentPage() == p.getFirstPage()) {
				html.append("<img src=\"" + contextPath + "/images/page-first-disabled.gif\" />");
				html.append("&nbsp;");
				html.append("<img src=\"" + contextPath + "/images/page-prev-disabled.gif\" />");
				html.append("&nbsp;");
			}
			else {
				html.append("<img src=\"" + contextPath + "/images/page-first.gif\" onclick=\"javascript: Paginater.toPage(" + p.getFirstPage() + ")\" />");
				html.append("&nbsp;");
				html.append("<img src=\"" + contextPath + "/images/page-prev.gif\" onclick=\"javascript: Paginater.toPage(" + p.getPriorPage() + ")\" />");
				html.append("&nbsp;");
			}
			
			if (p.getCurrentPage() == p.getLastPage()) {
				html.append("<img src=\"" + contextPath + "/images/page-next-disabled.gif\" />");
				html.append("&nbsp;");
				html.append("<img src=\"" + contextPath + "/images/page-last-disabled.gif\" />");
				html.append("&nbsp;");
			}
			else {
				html.append("<img src=\"" + contextPath + "/images/page-next.gif\" onclick=\"javascript: Paginater.toPage(" + p.getNextPage() + ")\" />");
				html.append("&nbsp;");
				html.append("<img src=\"" + contextPath + "/images/page-last.gif\" onclick=\"javascript: Paginater.toPage(" + p.getLastPage() + ")\" />");
				html.append("&nbsp;");
			}
		}
		
		html.append("&nbsp;&nbsp;转至第<input type=\"text\" id=\"goPageIndex\" size=\"3\" />页");
		html.append("<img src=\"" + contextPath + "/images/jumpto.bmp\" onclick=\"Paginater.goPage()\" style=\"cursor: hand\" />");
		
		html.append("</div>");
		
		return html.toString();
	}

}
