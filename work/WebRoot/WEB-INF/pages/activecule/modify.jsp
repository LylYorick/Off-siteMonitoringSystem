<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索来主动调查报修改</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function() {
  	 	$("#date").datepicker({
				changeMonth: true,
				changeYear: true
  	 		});
  	 	$("#feedbackdate").datepicker({
				changeMonth: true,
				changeYear: true
  	 		});
	});
	</script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				线索来主动调查修改
			</legend>
			<br>
			<s:form namespace="/activecule" action="activecule_update"
				method="post" enctype="multipart/form-data" >
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<s:hidden name="asid" value="%{#info.asid}"></s:hidden>
				<s:textfield cssStyle="width:200px" name="aid" label="案件总编号" required="true" value="%{#info.aid}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="surveyname" label="调查名称" required="true" value="%{#info.surveyname}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="involvenum" label="涉及账户数" required="true" value="%{#info.involvenum}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="source" label="来源" required="true" value="%{#info.source}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="date" id="date" label="时间" required="true" value="%{#info.date}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="sponsor" label="来函单位主办人" required="true" value="%{#info.sponsor}"></s:textfield>
				<s:textarea rows="5" cols="30" name="amountSituation" label="涉案金额（元）、立案情况" required="true" value="%{#info.amountSituation}"></s:textarea>
				<s:textfield cssStyle="width:200px" name="isinvolved" label="是否涉案" required="true" value="%{#info.isinvolved}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="letterid" label="立案决定书编号" required="true" value="%{#info.letterid}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="antisponsor" label="反洗钱处主办人" required="true" value="%{#info.antisponsor}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="paymentletterid" label="支付处查询书编号" required="true" value="%{#info.paymentletterid}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="investigation" label="向异地人民银行协查" required="true" value="%{#info.investigation}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="approvalno" label="反洗钱调查审批表编号" required="true" value="%{#info.approvalno}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="finaname" label="涉及的金融机构名称" required="true" value="%{#info.finaname}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="finannum" label="涉及金融机构数" required="true" value="%{#info.finannum}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="sendresearch" label="向金融机构发出反洗钱调查通知书" required="true" value="%{#info.sendresearch}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="accountnum" label="调查通知书账户数" required="true" value="%{#info.accountnum}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="feedbackdate" id="feedbackdate" label="我行反馈时间" required="true" value="%{#info.feedbackdate}"></s:textfield>
				<s:textfield cssStyle="width:200px" name="feedbackno" label="反馈资料文书号" required="true" value="%{#info.feedbackno}"></s:textfield>
				<s:textarea rows="5" cols="30" name="dealresult" label="处理结果" required="true" value="%{#info.dealresult}"></s:textarea>
				<s:textfield name="recordeno" label="存档案号" required="true" value="%{#info.recordeno}"></s:textfield>
				<s:textfield name="subjectname" value="%{#info.subjectname}" label="主体名称" required="true"></s:textfield>
				<s:textfield name="idnumber" value="%{#info.idnumber}" label="证件号" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="notes" label="备注" required="true" value="%{#info.notes}"></s:textarea>
				<s:submit align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>
		</fieldset><br/>
	</div>
</body>
