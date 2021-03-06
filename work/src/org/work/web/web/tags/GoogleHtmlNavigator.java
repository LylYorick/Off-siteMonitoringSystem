package org.work.web.web.tags;

import java.util.Iterator;
import java.util.List;

import org.work.web.util.Paginater;




/**
 * google html navigator.
 * 
 * <pre>[上一页]1 2 3 4 5 6 7 8 9 [下一页]</pre>
 * @author fred.du
 *
 */
public class GoogleHtmlNavigator implements HtmlNavigator {
	private final int BATCH_SIZE = 10;
	
	public String getHtmlNavigation(String contextPath, Paginater p, boolean tidy) {
		StringBuffer html = new StringBuffer();
		html.append("<div id=\"pageNavigation\">");
		
		if (tidy) {
			html.append("<a href=\"javascript: Paginater.toPage(" + p.getCurrentPage() + ")\" id=\"_refresh\" style=\"display:none\">[刷新]</a>");
			html.append(getBatchPages(p));
		}
		else {
			html.append("<a href=\"javascript: Paginater.toPage(" + p.getCurrentPage() + ")\" id=\"_refresh\">[刷新]</a>");
			
			if (p.getCurrentPage() != p.getFirstPage()) {
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getPriorPage() + ")\">[上一页]</a>");
			}
			
			html.append(getBatchPages(p));
			
			if (p.getCurrentPage() != p.getLastPage()) {
				html.append("<a href=\"javascript: Paginater.toPage(" + p.getNextPage() + ")\">[下一页]</a>");
			}
		}
		
		html.append("</div>");
		
		return html.toString();
	}

	private StringBuffer getBatchPages(Paginater p) {
		List batchPages = p.getBatchPages(BATCH_SIZE);
		StringBuffer pages = new StringBuffer();
		
		for (Iterator i = batchPages.iterator(); i.hasNext();) {
			String page = (String) i.next();
			
			if (p.getCurrentPage() == Integer.parseInt(page)) {
				pages.append(" " + page + " ");
			}
			else {
				pages.append(" <a href=\"javascript: Paginater.toPage(" + page + ")\">" + page + "</a> ");
			}
		}
		
		return pages;
	}

}
