/**
 *  $id MaxMin12NumericText.java Feb 4, 2010 4:22:10 PM ldj
 */
package org.work.web.validators;

import com.opensymphony.xwork2.validator.ValidationException;

public class MaxMin12NumericText extends NumericText {
	@Override
	public void validate(Object object) throws ValidationException {
		this.setMaxLength(12);
		this.setMinLength(12);
		super.validate(object);
	}
}
