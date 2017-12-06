/*****************************************************************
 * jQuery Validate扩展验证方法 --只适合于反洗钱项目 
 * Modified by yorick Lee
 * Date modified:01/01/2017  
*****************************************************************/
$(function(){
    // 判断整数value是否等于0 
   jQuery.validator.addMethod("isIntEqZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value==0;       
    }, "整数必须为0"); 
}