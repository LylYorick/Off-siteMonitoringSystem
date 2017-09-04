package org.work.web.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.StringLengthFieldValidator;

public class Max20Text extends StringLengthFieldValidator {
	@Override
	public void validate(Object object) throws ValidationException {
		this.setMaxLength(20);
		super.validate(object);
	}
}