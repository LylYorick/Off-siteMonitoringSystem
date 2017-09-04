
package org.work.web.validators;

import com.opensymphony.xwork2.validator.ValidationException;

public class NumericText extends RegexStringLength {
	@Override
	public void validate(Object object) throws ValidationException {
		this.setExpression("\\d+");
		super.validate(object);
	}
}
