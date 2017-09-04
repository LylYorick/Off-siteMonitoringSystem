<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>请求总行或者兄弟行协查名单录入</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#senddate").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
		$("#backdate").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
		function customRange(input) {
            return {minDate: (input.id == 'backdate' ? $('#senddate').datepicker('getDate') : null),
                maxDate: (input.id == 'senddate' ? $('#backdate').datepicker('getDate') : null)};
        }
	})
	</script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				请求总行或者兄弟行协查名单录入
			</legend>
			<br>
			<s:form namespace="/investigation" action="investigation_update" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<s:hidden name="crid" value="%{#info.crid}"></s:hidden>
				<s:textfield name="checkid" label="协查函号" required="true" value="%{#info.checkid}"></s:textfield>
				<s:textarea rows="5" cols="30" name="description" label="可疑交易描述" required="true" value="%{#info.description}"></s:textarea>
				<s:textarea rows="5" cols="30" name="content" label="协查内容" required="true" value="%{#info.content}"></s:textarea>
				<s:textfield id="senddate" name="senddate" label="发函时间" required="true" value="%{#info.senddate}"></s:textfield>
				<s:textfield name="unit" label="协查单位" required="true" value="%{#info.unit}"></s:textfield>
				<s:textfield name="handledby" label="经手人" required="true" value="%{#info.handledby}"></s:textfield>
				<s:textfield name="backdate" id="backdate" label="实际回函时间" required="true" value="%{#info.backdate}"></s:textfield>
				<s:textfield name="subjectname" id="subjectname" label="主体名称" required="true" value="%{#info.subjectname}"></s:textfield>
				<s:textfield name="idnumber" id="idnumber" label="证件号" required="true" value="%{#info.idnumber}"></s:textfield>
				<s:textarea rows="5" cols="30" name="note" label="备注" required="true" value="%{#info.note}"></s:textarea>
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
