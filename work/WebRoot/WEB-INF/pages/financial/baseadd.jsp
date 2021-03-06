<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构基本信息新增</title>
</head>
<body>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构基本信息录入
			</legend>
			<br>
			<s:form namespace="/financial" action="financial_basesave" method="post" target="_self">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:select label="金融机构类别" list="#list" name="BOrgCatalog.bid" listKey="bid" listValue="catname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield label="金融机构代码" required="true" name="boid" size="20">
			</s:textfield>
			<s:textfield label="金融机构名称" required="true" name="bname" size="60">
			</s:textfield>
			<s:textfield label="金融机构类别代码" required="true" name="bcatid" size="20">
			</s:textfield>
			<s:textfield label="金融机构拼音缩写" required="true" name="bmininame" size="20">
				<s:param name="remark" value="%{getText('financialField.mininame')}" />
			</s:textfield>
			<s:select label="是否总行" required="true" name="ishead" list='@org.work.web.constants.Constants@REPORT_CHOOSE' listKey="key" listValue="value">
			</s:select>
			<s:select label="是否报送报表" required="true" name="isneed" list='@org.work.web.constants.Constants@REPORT_CHOOSE' listKey="key" listValue="value">
			</s:select>
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
			</s:form>
		</fieldset><br/>
	</div>
</body>
