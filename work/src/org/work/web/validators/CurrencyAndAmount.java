
package org.work.web.validators;

import org.work.web.util.AmtDisplay;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class CurrencyAndAmount extends FieldValidatorSupport {

    public void validate(Object object) throws ValidationException {
    	 String fieldName = getFieldName();
    	 Object value = this.getFieldValue(fieldName, object);
    	 if (value == null) {
             return;
         }
    	 String val = value.toString().trim();
    	 try{
    		 Double v =Double.valueOf(val);
    		 val = AmtDisplay.convert(v);
    	 }catch (Exception e) {
			 
		 }
    	
    	 if (val.equals("")) {
    		 return;
    	 }
    	 if (!val.matches("(\\d{1,18})|(\\d{1,18}\\.)|(\\d{1,17}\\.\\d{0,1})|(\\d{1,16}\\.\\d{0,2})|(\\.\\d{1,2})")) {
    		 addFieldError(fieldName, object);
    	 }
    	 
    }
}
