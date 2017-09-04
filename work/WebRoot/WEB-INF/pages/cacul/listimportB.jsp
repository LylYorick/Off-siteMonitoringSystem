<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>统计>>重点可疑交易统计表</title>
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
        data:{cid:1,t:time},   
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
</head>
<body>
<div>
	<br>
		<fieldset>
			<legend>
				重点可疑交易统计表
			</legend>
			<br>
			<s:form namespace="/jsonlist" action="cacul_listimportB" method="post">

				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{4}" />
				</s:bean>
				
				<s:select list="#{'':'--请选择--'}" label="金融机构名称" id="bannerid"
					name="oid" cssStyle="width:240px">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{3}" />
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
			<table class="list-table">
				  <tr>
    <th>金融机构</th>
    <th>本币笔数</th>
    <th>本币金额</th>
    <th>外币笔数</th>
    <th>外币金额</th>
  </tr>
				<s:iterator value="listp" status="index" var="l">
					<s:if test="#index.odd==true">
									<tr style="background-color: #ffffff">
				  </s:if>
								<s:else>
									<tr>
								</s:else>
     <td><s:property value="#l[1]" /></td>
    <td><s:property value="#l[2]" /></td>
    <td><s:property value="#l[3]" /></td>
    <td><s:property value="#l[4]" /></td>
    <td><s:property value="#l[5]" /></td>
  </tr>
				</s:iterator>
			</table>
			<jsp:include flush="true" page="/WEB-INF/layout/paginater.jsp"></jsp:include>
		</s:if>
		<s:else>
			<font color="red">对不起，没有查询到您想要的数据！</font>
		</s:else>
		</div>
</body>
