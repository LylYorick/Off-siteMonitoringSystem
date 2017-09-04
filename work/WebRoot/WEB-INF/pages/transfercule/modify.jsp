<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索移交修改</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function() {
  	 	$("#transferdate").datepicker({changeMonth: true,changeYear: true});
	});
    </script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				线索移交修改
			</legend>
			<br>
			<s:form namespace="/transfercule" action="transfercule_update" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<s:hidden name="tsid" value="%{#info.tsid}"></s:hidden>
				<s:textfield name="transfersymbol" value="%{#info.transfersymbol}" label="移送文号" required="true"></s:textfield>
				<s:textfield name="sourcecase" value="%{#info.sourcecase}" label="案件来源" required="true"></s:textfield>
				<s:textfield name="transferamout" value="%{#info.transferamout}" label="移送金额" required="true"></s:textfield>
				<s:textfield id="transferdate" name="transferdate" value="%{#info.transferdate}" label="移送时间" required="true"></s:textfield>
				<s:textfield name="handledby" value="%{#info.handledby}" label="经手人" required="true"></s:textfield>
				<s:textfield name="receivingunit" value="%{#info.receivingunit}" label="接受单位" required="true"></s:textfield>
				<s:textfield name="handledperson" value="%{#info.handledperson}" label="接受单位经手人" required="true"></s:textfield>
				<s:textfield name="isplacedonfile" value="%{#info.isplacedonfile}" label="是否立案" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="dealresult" value="%{#info.dealresult}" label="处理结果" required="true"></s:textarea>
				<s:textfield name="subjectname" value="%{#info.subjectname}" label="主体名称" required="true" ></s:textfield>
				<s:textfield name="idnumber" value="%{#info.idnumber}" label="证件号" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="notes" value="%{#info.notes}" label="备注" required="true"></s:textarea>
				<s:submit align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>
		</fieldset><br/>
	</div>
</body>
