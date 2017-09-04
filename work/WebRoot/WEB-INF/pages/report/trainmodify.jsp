<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构反洗钱培训活动情况修改</title>
</head>
<body>
	<script type="text/javascript"> 
		$(document).ready(function() {
  	 		$('#report_trainupdate_train_trcnt').maxlength();
		});
    </script>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构反洗钱培训活动情况修改
			</legend>
			<br>
			<s:form namespace="/report" action="report_trainupdate" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:textfield label="培训时间" required="true" name="train.trdate" id="starttime" size="40">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:textfield>
				<s:textarea label="培训内容" required="true" name="train.trcnt" rows="8" cols="40">
				</s:textarea>
				<s:textfield label="培训对象" required="true" name="train.trobjt">
				</s:textfield>
				<s:textfield label="参加人数" required="true" name="train.trnum" reg="^\d{1,6}$" tip="只允许输入数字">
				</s:textfield>
				<s:textfield label="培训方式" required="true" name="train.trmethod">
				</s:textfield>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				 <s:hidden name="train.reportswitch.switchid" value="%{train.reportswitch.switchid}"></s:hidden>
				<s:hidden name="train.trdid" value="%{id}"></s:hidden>
				<s:hidden name="id" value="%{id}"></s:hidden>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
				</td></tr>
			</s:form>

		</fieldset><br/>
	</div>
</body>
