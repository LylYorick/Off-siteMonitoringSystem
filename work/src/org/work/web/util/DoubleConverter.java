
package org.work.web.util;

import java.text.NumberFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DoubleConverter extends StrutsTypeConverter {
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return Double.valueOf(values[0]);
	}

	@Override
	public String convertToString(Map context, Object o) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(6);
		nf.setGroupingUsed(false);
		return nf.format(o);
	}
}