<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构基本信息新增</title>
	<script type="text/javascript">
	
	</script>
	
</head>
<body>

	<br>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构基本信息录入
			</legend>
			<br>
			<s:form namespace="/archives" action="archives_basesave" method="post" target="_self">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{3}" />
				</s:bean>
			<tr>
				<input type="hidden" name="archives.catalogNew.id.bfirstid" value="00" id="archives_save_archives_catalogNew_id_bfirstid">
				<input type="hidden" name="archives.catalogNew.id.bsecondid" value="00" id="archives_save_archives_catalogNew_id_bsecondid">
				<input type="hidden" name="archives.catalogNew.id.bthirdid" value="00" id="archives_save_archives_catalogNew_id_bthirdid">
			</tr>
			<s:textfield label="金融机构名称" required="true" name="archives.bname" size="60">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:select label="评级类别" required="true" name="archives.rateType" list='@org.work.web.constants.Constants@RATE_TYPE' listKey="key" listValue="value">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:select>
			<tr><td colspan="3" align="center">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
			</s:form>
		</fieldset><br/>
	</div>
</body>
