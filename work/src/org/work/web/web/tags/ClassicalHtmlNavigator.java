package org.work.web.web.tags;

import org.work.web.util.Paginater;




/**
 * classical html navigator.
 * 
 * <pre>[首页][上一页][下一页][末页]</pre>
 * @author fred.du
 *
 */
public class ClassicalHtmlNavigator implements HtmlNavigator {

	public String getHtmlNavigation(String contextPath, Paginater p, boolean tidy) {
		StringBuffer html = new StringBuffer();
		html.append("<div id=\"pageNavigation\">");
		
		if (tidy) {
			html.append("<a href=\"javascript: Paginater.toPage(" + p.getCurrentPage() + ")\" id=\"_refresh\" style=\"display:none\">[刷新]</a>");
			
			if (p.getCurrentPage() != p.getFirstPage()) {
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getFirstPage() + ")\">[首页]</a>");
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getPriorPage() + ")\">[上一页]</a>");
			}
			
			if (p.getCurrentPage() != p.getLastPage()) {
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getNextPage() + ")\">[下一页]</a>");
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getLastPage() + ")\">[末页]</a>");
			}
		}
		else {
			html.append("<a href=\"javascript: Paginater.toPage(" + p.getCurrentPage() + ")\" id=\"_refresh\">[刷新]</a>");
			
			if (p.getCurrentPage() == p.getFirstPage()) {
				html.append("[首页][上一页]");
			}
			else {
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getFirstPage() + ")\">[首页]</a>");
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getPriorPage() + ")\">[上一页]</a>");
			}
			
			if (p.getCurrentPage() == p.getLastPage()) {
				html.append("[下一页][末页]");
			}
			else {
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getNextPage() + ")\">[下一页]</a>");
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getLastPage() + ")\">[末页]</a>");
			}
		}
		
		html.append("&nbsp;&nbsp;转至第<input type=\"text\" id=\"goPageIndex\" size=\"3\" />页");
		html.append("<img src=\"" + contextPath + "/images/jumpto.bmp\" onclick=\"Paginater.goPage()\" style=\"cursor: hand\" />");
		
		html.append("</div>");
		
		return html.toString();
	}

}
