<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>角色管理>>角色修改</title>
</head>
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			角色修改
		</legend>
		<br>
		<s:form namespace="/role" action="role_update" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:hidden name="rid" value="%{rid}"></s:hidden>
			<s:textfield label="角色名称" required="true" name="rname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textarea label="角色说明" required="true" name="rmark" cols="40" rows="4">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textarea>		
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center"  value="角色修改" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
