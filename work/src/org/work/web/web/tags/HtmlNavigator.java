package org.work.web.web.tags;

import org.work.web.util.Paginater;



public interface HtmlNavigator {
	String getHtmlNavigation(String contextPath, Paginater p, boolean tidy);
}
