
package org.work.web.util;

import java.text.NumberFormat;

import org.work.web.exception.ServiceException;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class AmtDisplay {
	public static String convert(Double d){
		if(d==null)
			return null;
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false);
		return nf.format(d);
	}
	public static String convert(Double d,boolean groupused){
		if(d==null)
			throw new ServiceException("数据异常！");
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(groupused);
		return nf.format(d);
	}
	public static String convert(Double d,int max){
		if(d==null)
			throw new ServiceException("数据异常！");
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(max);
		nf.setGroupingUsed(false);
		return nf.format(d);
	}
	public static String convertT(Double d,boolean groupused){
		if(d==null)
			throw new ServiceException("数据异常！");
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(groupused);
		return nf.format(d/10000);
	}
}
