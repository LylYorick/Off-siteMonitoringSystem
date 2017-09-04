<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->金融机构反洗钱工作内部审计情况</title>
	<script type="text/javascript">
	     $.subscribe('add', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  		window.location.href="<%=request.getContextPath()%>/report/report_inneraudit.shtml?switchid="+<s:property value="switchid"/>;
  		}
  	});
  	  	 $.subscribe('zero', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  	 	if(window.confirm("确定零记录吗？标注信息将自动清空")){
   			window.location.href="<%=request.getContextPath()%>/report/report_zeroia.shtml?switchid="+<s:property value="switchid"/>;
    	}
    	}
  	});
     $.subscribe('edit', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
		var s = $("#gridtable").jqGrid('getGridParam','selrow');
       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
   		var r = $("#gridtable").jqGrid('getRowData',s);     		 		
  		window.location.href="<%=request.getContextPath()%>/report/report_innerauditmodify.shtml?id="+r.audid+"&switchid="+<s:property value="switchid"/>;;
  		}
  	});
     $.subscribe('del', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
		var s = $("#gridtable").jqGrid('getGridParam','selrow');
       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
   		var r = $("#gridtable").jqGrid('getRowData',s);     		 		
  		window.location.href="<%=request.getContextPath()%>/report/report_innerauditdel.shtml?id="+r.audid+"&switchid="+<s:property value="switchid"/>;
  		}
  	});
     $.subscribe('import', function(event,data) {
  		window.location.href="<%=request.getContextPath()%>/report/report_innerauditimport.shtml?switchid="+<s:property value="switchid"/>;
  	});
  	
  	function toggle(){
		var options = {};
		$("#toggle").toggle("blind",options,500);
	}
	function togglebz(){
		var options = {};
		$("#togglebz").toggle("blind",options,500);
	}
	
  	  	var isExtendsValidate = true;	//如果要试用扩展表单验证的话，该属性一定要申明
	function extendsValidate(){	//函数名称，固定写法
		if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}
	}
     $.subscribe('updateuser', function(event,data) {
     	if($.trim($('#report_updateUser_name').val())=='' || $.trim($('#report_updateUser_tel').val())==''){
     		alert("制表人名字或电话不能为空");
     	}else{
	     	var params = {name:$('#report_updateUser_name').val(),tel:$('#report_updateUser_tel').val()};
	     	$.post("<%=request.getContextPath()%>/report/report_updateuser.shtml?switchid="+<s:property value="switchid"/>,params,function(data){
	     		alert(data);
	     		window.location.reload(true);
	     	}
	     	);
     	}
  	});
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend onclick="toggle()">
			金融机构反洗钱工作内部审计情况
		</legend><div id="toggle">
		<br>
		<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						数据类别：
					</td>
					<td>
						E
					</td>
					<td class="tdLabel">
						数据来源：
					</td>
					<td>
						<s:if test="#reportswitch.BOrgInformation.ishead == 0">
						F
					</s:if>
					<s:else>
						Z
					</s:else>
					</td>

				</tr>
				<tr>
					<td class="tdLabel">
						年度/季度
					</td>
					<td>
						<s:property value="#reportswitch.year"/>/<s:property value="#reportswitch.quater"/>
					</td>
					<td class="tdLabel">
						金融机构类别代码：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.bcatid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						填报单位名称：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.bname" />
					</td>
					<td class="tdLabel">
						填报单位机构代码：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.boid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						制表人：
					</td>
					<td>
						<input type="text" name="name" value="<s:property value="#reportswitch.name" />" id="report_updateUser_name"/>
					</td>
					<td class="tdLabel">
						 联系电话：
					</td>
					<td>
						<input type="text" name="tel" value="<s:property value="#reportswitch.tel" />" id="report_updateUser_tel"/>
					</td>
				</tr>
				<tr><td colspan="4" align="center">
					
					<s:if test="#reportswitch.status == 1">
					<sj:submit id="grid_updateuser_colsbutton" value="保存" onClickTopics="updateuser" button="true" />
					</s:if>
				</td></tr>
			</table></div>
		<br/>
		</fieldset><br/>
		
				<fieldset>
		<legend onclick="togglebz()">
			标注填报
		</legend><br><div id="togglebz">
<s:form namespace="/report" action="report_innerauditflagsave" method="post" theme="simple">
<table width="100%" frame="void" class="wwFormTable">
  <tr>
    <td rowspan="3" class="tdLabel">内部审计结论</td>
    <td class="tdLabel">内控制度不完善:</td>
    <td>
		<s:select required="true" name="innerauditflag.ia1" list="@org.work.web.constants.Constants@REPORT_CHOOSE" listKey="key" listValue="value" headerKey="3" headerValue="未选择" tip="必选" reg="[^3]"></s:select>
    </td>
    <td class="tdLabel">大额可疑交易漏报:</td>
    <td>
    	<s:select required="true" name="innerauditflag.ia2" list="@org.work.web.constants.Constants@REPORT_CHOOSE" listKey="key" listValue="value" headerKey="3" headerValue="未选择" tip="必选" reg="[^3]"></s:select>
	</td>
  </tr>
  <tr>
    <td class="tdLabel">客户身份识别不到位:</td>
    <td><s:select required="true" name="innerauditflag.ia3" list="@org.work.web.constants.Constants@REPORT_CHOOSE" listKey="key" listValue="value" headerKey="3" headerValue="未选择" tip="必选" reg="[^3]"></s:select></td>
    <td class="tdLabel">宣传培训不到位:</td>
    <td><s:select required="true" name="innerauditflag.ia4" list="@org.work.web.constants.Constants@REPORT_CHOOSE" listKey="key" listValue="value" headerKey="3" headerValue="未选择" tip="必选" reg="[^3]"></s:select></td>
  </tr>
  <tr>
    <td class="tdLabel">客户资料保存不全:</td>
    <td><s:select required="true" name="innerauditflag.ia5" list="@org.work.web.constants.Constants@REPORT_CHOOSE" listKey="key" listValue="value" headerKey="3" headerValue="未选择" tip="必选" reg="[^3]"></s:select></td>
    <td class="tdLabel">其他问题:</td>
    <td><s:select required="true" name="innerauditflag.ia6" list="@org.work.web.constants.Constants@REPORT_CHOOSE" listKey="key" listValue="value" headerKey="3" headerValue="未选择" tip="必选" reg="[^3]"></s:select></td>
  </tr>
  <tr><td colspan="5" align="center">
  <s:hidden name="innerauditflag.iaid"></s:hidden>
  <s:hidden name="innerauditflag.reportswitch.switchid" value="%{switchid}"></s:hidden>
    <s:hidden name="switchid" value="%{switchid}"></s:hidden>
		<s:if test="#session.userinfo.information.bname != ''"><s:submit theme="simple" align="center"  value="保存" cssClass="ui-button ui-state-default ui-corner-all"></s:submit></s:if>
</td></tr>
</table>
</s:form></div>
	</fieldset><br/>
	<s:if test="#session.userinfo.information.bname != ''">
		<sj:submit id="grid_add_colsbutton" value="数据新增" onClickTopics="add" button="true" />
		<sj:submit id="grid_edit_colsbutton" value="数据修改" onClickTopics="edit" button="true" />
		<sj:submit id="grid_del_colsbutton" value="数据删除" onClickTopics="del" button="true" />
		<sj:submit id="grid_zero_colsbutton" value="零报告提交" onClickTopics="zero" button="true" />
		<sj:submit id="grid_import_colsbutton" value="数据导入" onClickTopics="import" button="true" />
		</s:if>
		<s:url id="remoteurl" action="report_innerauditlist.shtml" escapeAmp="false"></s:url>
		<sj:grid id="gridtable" caption="金融机构反洗钱工作内部审计情况" dataType="json"
			href="%{remoteurl}" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="audid" index="audid" title="序号" sortable="true" width="100" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="auddept" index="auddept" title="审计部门名称" sortable="false" width="150" />
			<sj:gridColumn name="audprid" index="audprid" title="审计期限" sortable="false" width="100" />
			<sj:gridColumn name="audcnt" index="audcnt" title="审计项目名称及主要内容" sortable="false" width="330" />
			<sj:gridColumn name="audprbm" index="audprbm" title="审计发现的主要问题" sortable="false" width="100" />
			<sj:gridColumn name="audmod" index="audmod" title="问题整改情况" sortable="false" width="150" />
		</sj:grid>
	</div>
</body>
