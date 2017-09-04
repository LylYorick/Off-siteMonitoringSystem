/**
 * 
 */
package org.work.web.util;

import java.util.Comparator;

import org.work.web.po.PNav;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
@SuppressWarnings("unchecked")
public class NodeComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		PNav nav1 = (PNav) o1;
		PNav nav2 = (PNav) o2;
		return nav1.getVid().compareTo(nav2.getVid());
	}

}
