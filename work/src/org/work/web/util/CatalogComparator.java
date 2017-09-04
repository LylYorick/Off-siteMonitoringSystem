/**
 * 
 */
package org.work.web.util;

import java.util.Comparator;

import org.work.web.po.Information;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class CatalogComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		Information de1 = (Information) o1;
		Information de2 = (Information) o2;
		return de1.getOid().compareTo(de2.getOid());
	}

}
