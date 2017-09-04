<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>台账修改</title>
		<script type="text/javascript">

	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			台账修改
		</legend>
		<br>
		<s:form namespace="/financial" action="financial_taimodifysave" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:textarea label="事由" required="true" name="taireason" cols="80" rows="20" value="%{#tai.taireason}"  reg="^[\s|\S]{1,1000}$" tip="不能为空">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textarea>
			<s:hidden name="taidi"></s:hidden>
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center"  value="修改台账" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
