<#assign inputColumnSpan = parameters.inputcolspan?default(1) />  
<#assign labelColumnSpan = parameters.labelcolspan?default(1) />  
<#assign remark = parameters.remark?default('') />  
<#if qTableLayout?exists && qTableLayout.tablecolspan?exists >  
  
    <#assign columnCount = qTableLayout.currentColumnCount + labelColumnSpan + inputColumnSpan />    
    <#assign tablecolspan = qTableLayout.tablecolspan />  
    <#if (columnCount >= qTableLayout.tablecolspan) >  
        </tr><#-- Write out the closing tr. -->  
        <#assign columnCount = 0 />  
    </#if>  
    ${stack.setValue('#qTableLayout.currentColumnCount', columnCount)}  
</#if>  