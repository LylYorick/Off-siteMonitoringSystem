<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索来自司法机关修改</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function() {
  	 	$("#date").datepicker({changeMonth: true,changeYear: true});
  	 	$("#feedbackdate").datepicker({changeMonth: true,changeYear: true});
	});
    $.subscribe('before', function(event,data) { 
      var fData = event.originalEvent.formData; 
         /**alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout ); 
			*/
    }); 
    $.subscribe('complete', function(event,data) { 
    	alert("添加成功");
    	 /** alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText +  
     '\n\nThe output div should have already been updated with the responseText.'); */
    }); 
    $.subscribe('errorState', function(event,data) { 
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status); 
    });
    </script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				线索来自司法机关录入
			</legend>
			<br>
			<s:form namespace="/judicialcule" action="judicialcule_update" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<!--<s:textfield label="序号" required="true"></s:textfield>-->
				<s:hidden name="jsid" value="%{#info.jsid}"></s:hidden>
				<s:textfield name="jid" label="案件总编号" required="true" value="%{#info.jid}"></s:textfield>
				<s:textfield name="surveyname" value="%{#info.surveyname}" label="调查名称" required="true"></s:textfield>
				<s:textfield name="involvenum" value="%{#info.involvenum}" label="涉及账户数" required="true"></s:textfield>
				<s:textfield name="unit" value="%{#info.unit}" label="来函单位" required="true"></s:textfield>
				<s:textfield id="date" name="date" value="%{#info.date}" label="来函时间" required="true"></s:textfield>
				<s:textfield name="sponsor" value="%{#info.sponsor}" label="来函单位主办人" required="true"></s:textfield>
				<s:textarea cols="30" rows="5" name="amountSituation" value="%{#info.amountSituation}" label="涉案金额（元）、立案情况" required="true"></s:textarea>
				<s:textfield name="isinvolved" value="%{#info.isinvolved}" label="是否涉案" required="true"></s:textfield>
				<s:textfield name="letterid" value="%{#info.letterid}" label="立案决定书编号" required="true"></s:textfield>
				<s:textfield name="casename" value="%{#info.casename}" label="案件名称" required="true"></s:textfield>
				<s:textfield name="typeofcrime" value="%{#info.typeofcrime}" label="涉嫌犯罪类型" required="true"></s:textfield>
				<s:textfield name="cluessource" value="%{#info.cluessource}" label="侦查机关线索来源" required="true"></s:textfield>
				<s:textfield name="antisponsor" value="%{#info.antisponsor}" label="反洗钱处主办人" required="true"></s:textfield>
				<s:textfield name="paymentletterid" value="%{#info.paymentletterid}" label="支付处查询书编号" required="true"></s:textfield>
				<s:textfield name="approvalno" value="%{#info.approvalno}" label="反洗钱调查审批表编号" required="true"></s:textfield>
				<s:textfield name="finaname" value="%{#info.finaname}" label="涉及的金融机构名称" required="true"></s:textfield>
				<s:textfield name="finannum" value="%{#info.finannum}" label="涉及金融机构数" required="true"></s:textfield>
				<s:textfield name="sendresearch" value="%{#info.sendresearch}" label="向金融机构发出反洗钱调查通知书" required="true"></s:textfield>
				<s:textfield name="accountnum" value="%{#info.accountnum}" label="调查通知书账户数" required="true"></s:textfield>
				<s:textfield id="feedbackdate" name="feedbackdate" value="%{#info.feedbackdate}" label="我行反馈时间" required="true"></s:textfield>
				<s:textfield name="feedbackno" value="%{#info.feedbackno}" label="反馈资料文书号" required="true"></s:textfield>
				<s:textarea cols="30" rows="5" name="dealresult" value="%{#info.dealresult}" label="处理结果" required="true"></s:textarea>
				<s:textfield name="recordeno" value="%{#info.recordeno}" label="存档案号" required="true"></s:textfield>
				<s:textfield name="subjectname" value="%{#info.subjectname}" label="主体名称" required="true"></s:textfield>
				<s:textfield name="idnumber" value="%{#info.idnumber}" label="证件号" required="true"></s:textfield>
				<s:textarea cols="30" rows="5" name="notes" value="%{#info.notes}" label="备注" required="true"></s:textarea>
				<!--<s:file name="judicialculeFile" label="可疑主体数据">
					<s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}" />
				</s:file>-->
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
