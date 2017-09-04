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
	<div  class="grid">
		<fieldset>
			<legend>
				线索来自举报录入
			</legend>
			<br>
			<s:form namespace="/reportcule" action="reportcule_save"
				method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<%--<s:textfield label="序号" required="true"></s:textfield>
				<s:textfield name="rid" label="案件总编号" required="true"></s:textfield>--%>
				<s:textfield name="unit" label="来函单位" required="true"></s:textfield>
				<s:textfield id="date" name="date" label="来函时间" required="true"></s:textfield>
				<s:textfield name="sponsor" label="来函单位主办人" required="true"></s:textfield>
				<s:textfield name="researchname" label="调查名称" required="true"></s:textfield>
				<s:textfield name="involvenum" label="涉及账户数" required="true"></s:textfield>
				<s:textarea cols="30" rows="5" name="amountSituation" label="涉案金额（元）、立案情况" required="true"></s:textarea>
				<s:textfield name="isinvolved" label="是否涉案" required="true"></s:textfield>
				<s:textfield name="antisponsor" label="反洗钱处主办人" required="true"></s:textfield>
				<s:textfield name="paymentletterid" label="支付处查询书编号" required="true"></s:textfield>
				<s:textfield name="investigation" label="反洗钱调查审批表编号" required="true"></s:textfield>
				<s:textfield name="finaname" label="涉及的金融机构名称" required="true"></s:textfield>
				<s:textfield name="finannum" label="涉及金融机构数" required="true"></s:textfield>
				<s:textfield name="sendresearch" label="向金融机构发出反洗钱调查通知书" required="true"></s:textfield>
				<s:textfield name="accountnum" label="调查通知书账户数" required="true"></s:textfield>
				<s:textfield id="feedbackdate" name="feedbackdate" label="我行反馈时间" required="true"></s:textfield>
				<s:textfield name="feedbackno" label="反馈资料文书号" required="true"></s:textfield>
				<s:textarea cols="30" rows="5" name="dealresult" label="处理结果" required="true"></s:textarea>
				<s:textfield name="recordeno" label="存档案号" required="true"></s:textfield>
				<s:textarea cols="30" rows="5" name="note" label="备注" required="true"></s:textarea>
				<s:file name="reportculeFile" label="可疑主体数据">
					<s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}" />
				</s:file>
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
