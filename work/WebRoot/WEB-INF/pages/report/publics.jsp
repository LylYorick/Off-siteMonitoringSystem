<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构协助公安机关、其他机关打击洗钱活动情况录入</title>
</head>
<body>
	<script type="text/javascript"> 
    	$(document).ready(function() {
  	 		//$("#starttime").datepicker({changeMonth: true,changeYear: true});
  	 		$('#report_publicssave_publics_xp3').maxlength();
  	 		$('#report_publicssave_publics_xp4').maxlength();
		});
    </script>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构协助公安机关、其他机关打击洗钱活动情况录入
			</legend>
			<br>
			<s:form namespace="/report" action="report_publicssave" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:textfield label="被协助部门" required="true" name="publics.xp1">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:textfield>
				<s:textfield label="协助时间" required="true" id="starttime" name="publics.xp2" rows="8" cols="40">
				</s:textfield>
				<s:textarea label="协助内容" required="true" cols="80" rows="10" name="publics.xp3">
				</s:textarea>
				<s:textarea label="效果" required="true" cols="80" rows="10" name="publics.xp4">
				</s:textarea>
				<s:select label="协助单位" required="true" name="publics.xp5" list="@org.work.web.constants.Constants@REPORT_ORG"  listKey="key" listValue="value">
					<s:param name="remark" value="%{getText('reportFile.publics')}" />
				</s:select>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				<s:hidden name="publics.reportswitch.switchid" value="%{switchid}"></s:hidden>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
				</td></tr>
			</s:form>

		</fieldset><br/>
	</div>
</body>
