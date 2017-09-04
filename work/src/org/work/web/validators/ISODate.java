package org.work.web.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class ISODate extends FieldValidatorSupport {

    private boolean doTrim = true;

    public void setTrim(boolean trim) {
        doTrim = trim;
    }

    public boolean getTrim() {
        return doTrim;
    }

    public void validate(Object object) throws ValidationException {
        String fieldName = getFieldName();
        String val = (String) getFieldValue(fieldName, object);

        if (val == null || val.length() <= 0) {
            // use a required validator for these
            return;
        }
        if (doTrim) {
            val = val.trim();
            if (val.length() <= 0) { 
            	// use a required validator
            	return;
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
			sdf.parse(val);
		} catch (ParseException e) {
			addFieldError(fieldName, object);
		}
    }
}
