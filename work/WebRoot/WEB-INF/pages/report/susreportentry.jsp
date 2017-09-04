<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->金融机构可疑交易报告情况统计表</title>
	<script type="text/javascript">
		$(document).ready(function() {
  	 		$('#report_susreportsave_susreport_sp18').maxlength();
  	 		$('#report_susreportsave_susreport_sp9').maxlength();
		});
		function toggle(){
		var options = {};
		$("#toggle").toggle("blind",options,500);
	}
	function togglebz(){
		var options = {};
		$("#togglebz").toggle("blind",options,500);
	}
	function toggletb(){
		var options = {};
		$("#toggletb").toggle("blind",options,500);
	}
	 $.subscribe('zero', function(event,data) {
	if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  	 	if(window.confirm("确定零记录吗？")){
   			window.location.href="<%=request.getContextPath()%>/report/report_zerosus.shtml?switchid="+<s:property value="switchid"/>;
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
		<legend onclick="toggle()">
			金融机构可疑交易报告情况统计表
		</legend>
		<br><div id="toggle">
		<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						数据类别：
					</td>
					<td>
						I
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
		<s:form namespace="/report" action="report_susreportflagsave" method="post" theme="simple" >
<table width="100%" frame="void" class="wwFormTable">
  <tr>
    <td class="tdLabel">人民币重点可疑交易份数：</td>
    <td><s:textfield name="susreportflag.sbz1" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
    <td class="tdLabel">金额：</td>
    <td><s:textfield name="susreportflag.sbz2" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$" tip="只允许输入金额,如:1111.11"></s:textfield>(单位:万元)</td>
  </tr>
  <tr>
    <td class="tdLabel">外币重点可疑交易份数：</td>
    <td><s:textfield name="susreportflag.sbz3" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
    <td class="tdLabel">金额：</td>
    <td><s:textfield name="susreportflag.sbz4" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$" tip="只允许输入金额,如:1111.11"></s:textfield>(单位:万元)</td>
  </tr>
    <tr><td colspan="4" align="center">
  <s:hidden name="susreportflag.sbzid"></s:hidden>
  <s:hidden name="susreportflag.reportswitch.switchid" value="%{switchid}"></s:hidden>
  <s:hidden name="switchid" value="%{switchid}"></s:hidden>
		<s:if test="#session.userinfo.information.bname != ''"><s:submit theme="simple" align="center"  value="保存标注" cssClass="ui-button ui-state-default ui-corner-all"></s:submit></s:if>
</td></tr>
</table></s:form></div>
		</fieldset><br/>
		
		<fieldset>
		<legend onclick="toggletb()">
			数据填报
		</legend><br><div id="toggletb">
		<sj:submit id="grid_zero_colsbutton" value="零报告提交" onClickTopics="zero" button="true" cssStyle="margin-left:10px" /><span style="color:#ff0000"><s:property value="%{getText('zero.remark')}"/></span>
<s:form namespace="/report" action="report_susreportsave" method="post" theme="simple">
<table width="100%" frame="void" class="wwFormTable">
  <tr>
    <td rowspan="9" class="tdLabel">人民币可疑交易</td>
    <td rowspan="4" class="tdLabel">当期可疑交易报告</td>
    <td class="tdLabel">单位可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp1" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">单位可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp2" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(单位:万元)</td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp3" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp4" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(单位:万元)</td>
  </tr>
  <tr>
    <td rowspan="5" class="tdLabel">其中向当地公安机关报告</td>
    <td class="tdLabel">单位可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp5" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">单位可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp6" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(单位:万元)</td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp7" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp8" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(单位:万元)</td>
  </tr>
  <tr>
    <td class="tdLabel">公安机关反馈情况</td>
    <td><s:textarea name="susreport.sp9" rows="4" cols="40"></s:textarea></td>
  </tr>
  <tr>
    <td rowspan="9" class="tdLabel">外汇可疑交易</td>
    <td rowspan="4" class="tdLabel">当期可疑交易报告</td>
    <td class="tdLabel">单位可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp10" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">单位可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp11" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(金额:万美元)</td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp12" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp13" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(单位:万美元)</td>
  </tr>
  <tr>
    <td rowspan="5" class="tdLabel">其中向当地公安机关报告</td>
    <td class="tdLabel">单位可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp14" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">单位可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp15" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(金额:万美元)</td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(份数)</td>
    <td><s:textfield name="susreport.sp16" tip="只允许输入数字" reg="^\d{1,6}$"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">个人可疑交易报告(金额)</td>
    <td><s:textfield name="susreport.sp17" tip="只允许输入金额,如:1111.11" reg="^(([1-9]\d*)|0)(\.\d{1,2})?$"></s:textfield>(单位:万美元)</td>
  </tr>
  <tr>
    <td class="tdLabel">公安机关反馈情况</td>
    <td><s:textarea name="susreport.sp18" rows="4" cols="40"></s:textarea></td>
  </tr>
 
  <tr><td colspan="4" align="center">
  <s:hidden name="susreport.spid"></s:hidden>
  <s:hidden name="susreport.reportswitch.switchid" value="%{switchid}"></s:hidden>
  <s:hidden name="switchid" value="%{switchid}"></s:hidden>
		<s:if test="#session.userinfo.information.bname != ''"><s:submit theme="simple" align="center"  value="保存" cssClass="ui-button ui-state-default ui-corner-all"></s:submit></s:if>
</td></tr>
</table>
</s:form></div>
	</fieldset><br/>
	</div>
</body>
