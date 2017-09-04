<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->金融机构客户身份识别情况(涉及可疑交易识别情况)</title>
			<script type="text/javascript">
	 $.subscribe('zero', function(event,data) {
	if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  	 	if(window.confirm("确定零记录吗？")){
   			window.location.href="<%=request.getContextPath()%>/report/report_zeroky.shtml?switchid="+<s:property value="switchid"/>;
    	}
    	}
  	});
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
		<legend>
			金融机构客户身份识别情况(涉及可疑交易识别情况)
		</legend>
		<br>
		<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						数据类别：
					</td>
					<td>
						H
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
			</table>
		<br/>
		<s:if test="#session.userinfo.information.bname != ''">
		<sj:submit id="grid_zero_colsbutton" value="零报告提交" onClickTopics="zero" button="true" cssStyle="margin-left:10px" /><span style="color:#ff0000"><s:property value="%{getText('zero.remark')}"/></span>
		</s:if>
<s:form namespace="/report" action="report_identitykysave" method="post">
<tr>
					<td class="slabel">
						新建立业务关系和提供一次性服务中识别的
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="新建业务可疑数" required="true" name="identityky.pp1" reg="^\d{1,9}$" tip="只允许输入数字">
								<s:param name="labelcolspan" value="%{1}" />
								<s:param name="inputcolspan" value="%{1}" />
							</s:textfield>
							<s:textfield label="限额以上一次性服务可疑数" required="true" name="identityky.pp2" reg="^\d{1,9}$" tip="只允许输入数字">
								<s:param name="labelcolspan" value="%{1}" />
								<s:param name="inputcolspan" value="%{1}" />
							</s:textfield>
						</table>
					</td>
				</tr>
<tr>
					<td class="slabel">
						客户身份重新识别中发现的
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="客户身份可疑数" required="true" name="identityky.pp3" reg="^\d{1,9}$" tip="只允许输入数字">
								<s:param name="labelcolspan" value="%{1}" />
								<s:param name="inputcolspan" value="%{1}" />
							</s:textfield>
							<s:textfield label="客户交易行为可疑数" required="true" name="identityky.pp4" reg="^\d{1,9}$" tip="只允许输入数字">
								<s:param name="labelcolspan" value="%{1}" />
								<s:param name="inputcolspan" value="%{1}" />
							</s:textfield>
						</table>
					</td>
				</tr>
  <tr><td colspan="4" align="center">
  <s:hidden name="identityky.ppid"></s:hidden>
  <s:hidden name="reportid" value="%{reportid}"></s:hidden>
  <s:hidden name="switchid" value="%{switchid}"></s:hidden>
  <s:hidden name="identityky.reportswitch.switchid" value="%{switchid}"></s:hidden>
		<s:submit theme="simple" align="center"  value="保存" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
</td></tr>
</s:form>
	</fieldset><br/>
	</div>
</body>
