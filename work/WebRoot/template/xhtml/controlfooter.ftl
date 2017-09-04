${parameters.after?if_exists}<#t/>  
<#assign sys_remark = parameters.remark?default('') />  
<#--  
    Only show message if errors are available.  
    This will be done if ActionSupport is used.  
-->  
<#assign hasFieldErrors = parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists/>  
<#if hasFieldErrors> 
<br/>
<#assign error=fieldErrors[parameters.name].get(0)>  
<span errorFor="${parameters.id}" class="errorMessage" style="color:#ff0000;font-weight:bold">&nbsp;&nbsp;错误提示:${error?html}</span><#t/> 
<#else>
<span >${sys_remark}
</span><#t/> 
</#if>
</td><#lt/><#-- Write out the closing td for the html input -->  
<#include "/${parameters.templateDir}/${parameters.theme}/controlfooter-trlogic.ftl" />  