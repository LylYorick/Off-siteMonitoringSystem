<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>统计>>可疑交易报告统计表</title>
</head>
<body>
	<script type="text/javascript"> 
 
  	  	$(getsort);   
function getsort(){   
    var cid=$("#bpid").val();   
    var time=new Date();   
    $.ajax({   
        cache:false,   
        url:'<%=request.getContextPath()%>/financial/financial_findInformation.shtml',    
        type:'post',   
        dataType:'json',   
        data:{cid:cid,t:time},   
        success:update_c   
    });   
}
function update_c(json){
   var sort=json.informationSet;   
   var cbanner=json.bname;   
   var s_root=document.getElementById('bannerid');   
   s_root.options.length=0; 
   
   var option = document.createElement("option");    
   option.text="---请选择---";   
   option.value="";   
   s_root.options[s_root.options.length] =option;  
           
   for(var i in sort){   
       var option = document.createElement("option");   
       var value=sort[i].oid;      
       var text=sort[i].bname;   
           option.text=text;   
           option.value=value;   
           s_root.options[s_root.options.length] =option;   
   }   
}
    </script>
	<br>
		<fieldset>
			<legend>
				可疑交易报告统计表
			</legend>
			<br>
			<s:form namespace="/jsonlist" action="cacul_listsusreport" method="post">

				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{4}" />
				</s:bean>
				<s:select list="#list" label="金融机构类别" id="bpid" name="bid"
					headerKey="" headerValue="所有" listKey="bid" listValue="catname"
					onchange="getsort()">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:select>
				<s:select list="#{'':'--请选择--'}" label="金融机构名称" id="bannerid"
					name="oid" cssStyle="width:240px">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:select>
				<s:textfield label="年份" name="year"></s:textfield>
				<s:textfield label="季度" name="quater"></s:textfield>
				<tr><td colspan="4" align="center">
				<s:submit align="center" value="查 询" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
					</td></tr>
			</s:form>
			

		</fieldset>
		<br />
		<s:if test="#listp.size != 0">
			<table width="3500" class="list-table" style="width: 3000px">
				  <tr>
    <th colspan="2" rowspan="5" height="84">金融机构类别</th>
    <th colspan="16" width="1226">反洗钱可疑交易报告情况</th>
    <th colspan="3" width="216">协助有关部门打击洗钱活动情况</th>
  </tr>
  <tr height="15">
    <th colspan="8" height="15" width="606">人民币可疑交易报告情况</th>
    <th colspan="8" width="620">外币可疑交易报告情况</th>
    <th rowspan="4" width="72">协助公安<br />
      机关打击<br />
      洗钱活动<br />
      （次）</th>
    <th rowspan="4" width="72">协助其他<br />
      机关打击<br />
      洗钱活动<br />
      （次）</th>
    <th rowspan="4" width="72">合计</th>
  </tr>
  <tr height="18">
    <th colspan="4" height="18" width="305">当期可疑交易报告</th>
    <th colspan="4" width="301">其中：向当地公安机关报告</th>
    <th colspan="4" width="332">当期可疑交易报告</th>
    <th colspan="4" width="288">其中：向当地公安机关报告</th>
  </tr>
  <tr height="18">
    <th colspan="2" height="18" width="149">单位可疑交易报告</th>
    <th colspan="2" width="156">个人可疑交易报告</th>
    <th colspan="2" width="152">单位可疑交易报告</th>
    <th colspan="2" width="149">个人可疑交易报告</th>
    <th colspan="2" width="172">单位可疑 交易报告</th>
    <th colspan="2" width="160">个人可疑交易报告</th>
    <th colspan="2" width="144">单位可疑交易报告</th>
    <th colspan="2" width="144">个人可疑交易报告</th>
  </tr>
  <tr height="15">
    <th height="15" width="72">份数</th>
    <th width="77">金额（万）</th>
    <th width="79">份数</th>
    <th width="77">金额（万）</th>
    <th width="75">份数</th>
    <th width="77">金额（万）</th>
    <th width="72">份数</th>
    <th width="77">金额（万）</th>
    <th width="91">份数</th>
    <th width="81">金额（万美元）</th>
    <th width="88">份数</th>
    <th width="72">金额（万美元）</th>
    <th width="72">份数</th>
    <th width="72">金额（万美元）</th>
    <th width="72">份数</th>
    <th width="72">金额（万美元）</th>
  </tr>
				<s:iterator value="listp" status="index" var="l">
					<s:if test="#index.odd==true">
									<tr style="background-color: #ffffff">
				  </s:if>
								<s:else>
									<tr>
								</s:else>
     <td width="50"><s:property value="#l[3]" /></td>
    <td width="100"><s:property value="#l[4]" /></td>
    <td><s:property value="#l[7]" /></td>
    <td><s:property value="#l[8]" /></td>
    <td><s:property value="#l[9]" /></td>
    <td><s:property value="#l[10]" /></td>
    <td><s:property value="#l[11]" /></td>
    <td><s:property value="#l[12]" /></td>
    <td><s:property value="#l[13]" /></td>
    <td><s:property value="#l[14]" /></td>
    
    <td><s:property value="#l[16]" /></td>
    <td><s:property value="#l[17]" /></td>
    <td><s:property value="#l[18]" /></td>
    <td><s:property value="#l[19]" /></td>
    <td><s:property value="#l[20]" /></td>
    <td><s:property value="#l[21]" /></td>
    <td><s:property value="#l[22]" /></td>
    <td><s:property value="#l[23]" /></td>
    
    <td><s:property value="#l[27]" /></td>
    <td><s:property value="#l[28]" /></td>
    <td><s:property value="#l[29]" /></td>
  </tr>
				</s:iterator>
			</table>
			<jsp:include flush="true" page="/WEB-INF/layout/paginater.jsp"></jsp:include>
		</s:if>
		<s:else>
			<font color="red">对不起，没有查询到您想要的数据！</font>
		</s:else>
</body>
