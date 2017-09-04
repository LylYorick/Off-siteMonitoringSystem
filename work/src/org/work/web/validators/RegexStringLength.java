
package org.work.web.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class RegexStringLength extends FieldValidatorSupport {
	
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
        Object value = this.getFieldValue(fieldName, object);

        if (value == null) {
            return;
        }
        String val = "";
        if (value instanceof String) {
            val = (String)value;
        } else if (value instanceof Integer) {
        	val = String.valueOf(value);        	
        } else {
        	return;
        }
        
        if (doTrim) {
            val = val.trim();
            if (val.length() <= 0) { 
            	// use a required validator
            	return;
            }
        }

        if ((minLength > -1) && (val.length() < minLength)) {
            addFieldError(fieldName, object);
        } else if ((maxLength > -1) && (val.length() > maxLength)) {
            addFieldError(fieldName, object);
        }
        
        Pattern pattern;
        if (isCaseSensitive()) {
            pattern = Pattern.compile(expression);
        } else {
            pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        }

        Matcher matcher = pattern.matcher( val );

        if (!matcher.matches()) {
            addFieldError(fieldName, object);
        }
    }
	
	private boolean doTrim = true;
    private int maxLength = -1;
    private int minLength = -1;
    private boolean caseSensitive = true;
    private String expression;
	
    public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setTrim(boolean trim) {
        doTrim = trim;
    }

    public boolean getTrim() {
        return doTrim;
    }
}
