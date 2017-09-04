<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索来自总行或兄弟行修改</title>
</head>
<body>
	<script type="text/javascript"> 
	$(document).ready(function() {
  	 	$("#date").datepicker({
				changeMonth: true,
				changeYear: true
  	 		});
  	 	$("#feedbackdate").datepicker({changeMonth: true,changeYear: true});
	});
	</script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				线索来自总行或兄弟行修改
			</legend>
			<br>
			<s:form namespace="/headcule" action="headcule_update" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>				
				<s:hidden name="hosid" value="%{#info.hosid}"></s:hidden>
				<s:textfield name="hid" value="%{#info.hid}" label="案件总编号" required="true"></s:textfield>
				<s:textfield name="surveyname" value="%{#info.surveyname}" label="调查名称" required="true"></s:textfield>
				<s:textfield name="involvenum" value="%{#info.involvenum}" label="涉及账户数" required="true"></s:textfield>
				<s:textfield name="source" value="%{#info.source}" label="来源" required="true"></s:textfield>
				<s:textfield id="date" name="date" value="%{#info.date}" label="时间" required="true"></s:textfield>
				<s:textfield name="sponsor" value="%{#info.sponsor}" label="来函单位主办人" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="amountSituation" value="%{#info.amountSituation}" label="涉案金额（元）、立案情况" required="true"></s:textarea>
				<s:textfield name="isinvolved" value="%{#info.isinvolved}" label="是否涉案" required="true"></s:textfield>
				<s:textfield name="letterid" value="%{#info.letterid}" label="立案决定书编号" required="true"></s:textfield>
				<s:textfield name="antisponsor" value="%{#info.antisponsor}" label="反洗钱处主办人" required="true"></s:textfield>
				<s:textfield name="paymentletterid" value="%{#info.paymentletterid}" label="支付处查询书编号" required="true"></s:textfield>
				<s:textfield name="investigation" value="%{#info.investigation}" label="向异地人民银行协查" required="true"></s:textfield>
				<s:textfield name="approvalno" value="%{#info.approvalno}" label="反洗钱调查审批表编号" required="true"></s:textfield>
				<s:textfield name="finaname" value="%{#info.finaname}" label="涉及的金融机构名称" required="true"></s:textfield>
				<s:textfield name="finannum" value="%{#info.finannum}" label="涉及金融机构数" required="true"></s:textfield>
				<s:textfield name="sendresearch" value="%{#info.sendresearch}" label="向金融机构发出反洗钱调查通知书" required="true"></s:textfield>
				<s:textfield name="accountnum" value="%{#info.accountnum}" label="调查通知书账户数" required="true"></s:textfield>
				<s:textfield id="feedbackdate" name="feedbackdate" value="%{#info.feedbackdate}" label="我行反馈时间" required="true"></s:textfield>
				<s:textfield name="feedbackno" value="%{#info.feedbackno}" label="反馈资料文书号" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="dealresult" value="%{#info.dealresult}" label="处理结果" required="true"></s:textarea>
				<s:textfield name="recordeno" value="%{#info.recordeno}" label="存档案号" required="true"></s:textfield>
				<s:textfield name="subjectname" value="%{#info.subjectname}" label="主体名称" required="true"></s:textfield>
				<s:textfield name="idnumber" value="%{#info.idnumber}" label="证件号" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="notes" value="%{#info.notes}" label="备注" required="true"></s:textarea>
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
