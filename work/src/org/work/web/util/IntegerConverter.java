
package org.work.web.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class IntegerConverter extends StrutsTypeConverter {
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return Integer.valueOf(values[0]);
	}

	@Override
	public String convertToString(Map context, Object o) {
		return o.toString();
	}
}