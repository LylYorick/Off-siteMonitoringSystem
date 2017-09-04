<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>指标管理>>指标新增</title>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			新增指标
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_indexsave" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:textfield label="考核项目" required="true" name="ascproject">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:select list="#list" label="上层项目" required="true" name="ascpid" listKey="acsid" listValue="ascproject" headerKey="0" headerValue="根项目">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textarea label="考核细项" required="true" name="ascdesc" cols="40" rows="8">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textarea>
			<s:textfield label="加分极值" required="true" name="ascadd">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="减分极值" required="true" name="asccut">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textarea label="备注说明" required="true" name="ascremark" cols="40" rows="8">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textarea>
			<s:textfield label="字段名" required="true" name="ascfiled">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
