<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>台账管理</title>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			台账管理
		</legend>
		<br>
		<s:form namespace="/financial" action="financial_taisave" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:textarea label="事由" required="true" name="taireason" cols="80" rows="20" id="taireason" reg="^[\s|\S]{1,2000}$" tip="不能为空">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textarea>
			<s:hidden name="oid"></s:hidden>
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center"  value="新增台账" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
