<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报文导出</title>
	<script type="text/javascript">
		$(document).ready(function() {
			$("input[name='xmltype']").change(function(){
				if($(this+"[checked]").val()=="1"){
					$("#quater").parent().parent().hide();
				}else{
					$("#quater").parent().parent().show();
				}
			});
		});
		
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
			<legend>
				报文导出
			</legend>
			<br>
			<s:form namespace="/report" action="report_exportxml" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:radio label="导出报文类型" list='@org.work.web.constants.Constants@REPORT_TYPE' name="xmltype" listKey="key" listValue="value" required="true" value="2"/>
				<s:textfield label="年份" name="reportyear" value='%{@org.work.web.util.DateUtil@getCurrentYear()}'></s:textfield>
				<s:select label="季度" name="reportquater" id="quater" list='@org.work.web.constants.Constants@REPORT_QUATER'  listKey="key" listValue="value"></s:select>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				 <s:hidden name="active.reportswitch.switchid" value="%{switchid}"></s:hidden>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
				</td></tr>
			</s:form>
		</fieldset><br/>
	</div>
</body>
