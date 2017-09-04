<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构反洗钱宣传活动情况录入</title>
</head>
<body>
	<script type="text/javascript"> 
		$(document).ready(function() {
  	 		$('#report_activesave_active_actcnt').maxlength();
  	 		$('#report_activesave_active_actmtd').maxlength();
		});
    </script>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构反洗钱宣传活动情况录入
			</legend>
			<br>
			<s:form namespace="/report" action="report_activesave" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:textfield label="活动时间" required="true" name="active.actdate" id="starttime" size="40">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:textfield>
				<s:textarea label="宣传内容" required="true" name="active.actcnt" maxlength="120">
				</s:textarea>
				<s:textfield label="参加人数" required="true" name="active.actnum" reg="^\d{1,6}$" tip="只允许输入数字">
				</s:textfield>
				<s:textarea label="宣传方式" required="true" name="active.actmtd" rows="8" cols="80">
				</s:textarea>
				<s:textfield label="发放材料份数" required="true" name="active.actdatanum"  reg="^\d{1,6}$" tip="只允许输入数字">
				</s:textfield>
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
