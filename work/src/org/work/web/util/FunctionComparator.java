/**
 * 
 */
package org.work.web.util;

import java.util.Comparator;

import org.work.web.po.PNode;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
@SuppressWarnings("unchecked")
public class FunctionComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		PNode node1 = (PNode) o1;
		PNode node2 = (PNode) o2;
		return node1.getNid().compareTo(node2.getNid());
	}

}
