<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索来自举报或专报录入</title>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
  	 	$("#date").datepicker({changeMonth: true,changeYear: true});
  	 	$("#feedbackdate").datepicker({changeMonth: true,changeYear: true});
	});
</script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				线索来自举报修改
			</legend>
			<br>
			<s:form namespace="/reportcule" action="reportcule_update"
				method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<!--<s:textfield label="序号" required="true"></s:textfield>-->
				<s:hidden name="rsid" value="%{#info.rsid}"></s:hidden>
				<s:textfield name="rid" label="案件总编号" required="true" value="%{#info.rid}"></s:textfield>
				<s:textfield name="unit" label="来函单位" required="true" value="%{#info.unit}"></s:textfield>
				<s:textfield id="date" name="date" label="来函时间" required="true" value="%{#info.date}"></s:textfield>
				<s:textfield name="sponsor" label="来函单位主办人" required="true" value="%{#info.sponsor}"></s:textfield>
				<s:textfield name="researchname" label="调查名称" required="true" value="%{#info.researchname}"></s:textfield>
				<s:textfield name="involvenum" label="涉及账户数" required="true" value="%{#info.involvenum}"></s:textfield>
				<s:textarea cols="30" rows="5" name="amountSituation" label="涉案金额（元）、立案情况" required="true" value="%{#info.amountSituation}"></s:textarea>
				<s:textfield name="isinvolved" label="是否涉案" required="true" value="%{#info.isinvolved}"></s:textfield>
				<s:textfield name="antisponsor" label="反洗钱处主办人" required="true" value="%{#info.antisponsor}"></s:textfield>
				<s:textfield name="paymentletterid" label="支付处查询书编号" required="true" value="%{#info.paymentletterid}"></s:textfield>
				<s:textfield name="investigation" label="反洗钱调查审批表编号" required="true" value="%{#info.investigation}"></s:textfield>
				<s:textfield name="finaname" label="涉及的金融机构名称" required="true" value="%{#info.finaname}"></s:textfield>
				<s:textfield name="finannum" label="涉及金融机构数" required="true" value="%{#info.finannum}"></s:textfield>
				<s:textfield name="sendresearch" label="向金融机构发出反洗钱调查通知书" required="true" value="%{#info.sendresearch}"></s:textfield>
				<s:textfield name="accountnum" label="调查通知书账户数" required="true" value="%{#info.accountnum}"></s:textfield>
				<s:textfield id="feedbackdate" name="feedbackdate" label="我行反馈时间" required="true" value="%{#info.feedbackdate}"></s:textfield>
				<s:textfield name="feedbackno" label="反馈资料文书号" required="true" value="%{#info.feedbackno}"></s:textfield>
				<s:textarea cols="30" rows="5" name="dealresult" label="处理结果" required="true" value="%{#info.dealresult}"></s:textarea>
				<s:textfield name="recordeno" label="存档案号" required="true" value="%{#info.recordeno}"></s:textfield>
				<s:textfield name="subjectname" label="主体名称" required="true" value="%{#info.subjectname}"></s:textfield>
				<s:textfield name="idnumber" label="证件号" required="true" value="%{#info.idnumber}"></s:textfield>
				<s:textarea cols="30" rows="5" name="note" label="备注" required="true" value="%{#info.note}"></s:textarea>
				<!--<s:file name="reportculeFile" label="可疑主体数据">
					<s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}]" />
				</s:file>-->
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
