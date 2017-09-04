<#assign inputColumnSpan = parameters.inputcolspan?default(1) />  
<#assign sys_remark = parameters.remark?default('') /> 
<#include "/${parameters.templateDir}/${parameters.theme}/controlheader-core.ftl" />  
<#if inputColumnSpan!=0>
    <td  
    colspan="${inputColumnSpan}"<#t/>  
</#if>
<#if inputColumnSpan !=0>
<#if parameters.align?exists>  
    align="${parameters.align?html}"<#t/>  
</#if>
><#t/>
</#if>