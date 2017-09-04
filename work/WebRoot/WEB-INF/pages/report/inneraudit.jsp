<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构反洗钱工作内部审计情况录入</title>
</head>
<body>
	<script type="text/javascript"> 
		$(document).ready(function() {
  	 		$('#report_innerauditsave_inneraudit_audcnt').maxlength();
  	 		$('#report_innerauditsave_inneraudit_audprbm').maxlength();
  	 		$('#report_innerauditsave_inneraudit_audmod').maxlength();
		});
    </script>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构反洗钱工作内部审计情况录入
			</legend>
			<br>
			<s:form namespace="/report" action="report_innerauditsave" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:textfield label="审计部门名称" required="true" name="inneraudit.auddept" size="60">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:textfield>
				<s:textfield label="审计期限" required="true" name="inneraudit.audprid" size="60">
				</s:textfield>
				<s:textarea cols="60" rows="4" label="审计项目名称及主要内容" required="true" name="inneraudit.audcnt">
				</s:textarea>
				<s:textarea cols="60" rows="4" label="审计发现的主要问题" required="true" name="inneraudit.audprbm">
				</s:textarea>
				<s:textarea cols="60" rows="4" label="问题整改情况" required="true" name="inneraudit.audmod">
				</s:textarea>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				 <s:hidden name="inneraudit.reportswitch.switchid" value="%{switchid}"></s:hidden>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
				</td></tr>
			</s:form>

		</fieldset><br/>
	</div>
</body>
