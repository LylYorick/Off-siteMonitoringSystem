<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索来自总行或兄弟行录入</title>
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
				线索来自总行或兄弟行录入
			</legend>
			<br>
			<s:form namespace="/headcule" action="headcule_save" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<%--<s:textfield name="" label="序号" required="true"></s:textfield>
				<s:textfield name="hid" label="案件总编号" required="true"></s:textfield>--%>
				<s:textfield name="surveyname" label="调查名称" required="true"></s:textfield>
				<s:textfield name="involvenum" label="涉及账户数" required="true"></s:textfield>
				<s:textfield name="source" label="来源" required="true"></s:textfield>
				<s:textfield id="date" name="date" label="时间" required="true"></s:textfield>
				<s:textfield name="sponsor" label="来函单位主办人" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="amountSituation" label="涉案金额（元）、立案情况" required="true"></s:textarea>
				<s:textfield name="isinvolved" label="是否涉案" required="true"></s:textfield>
				<s:textfield name="letterid" label="立案决定书编号" required="true"></s:textfield>
				<s:textfield name="antisponsor" label="反洗钱处主办人" required="true"></s:textfield>
				<s:textfield name="paymentletterid" label="支付处查询书编号" required="true"></s:textfield>
				<s:textfield name="investigation" label="向异地人民银行协查" required="true"></s:textfield>
				<s:textfield name="approvalno" label="反洗钱调查审批表编号" required="true"></s:textfield>
				<s:textfield name="finaname" label="涉及的金融机构名称" required="true"></s:textfield>
				<s:textfield name="finannum" label="涉及金融机构数" required="true"></s:textfield>
				<s:textfield name="sendresearch" label="向金融机构发出反洗钱调查通知书" required="true"></s:textfield>
				<s:textfield name="accountnum" label="调查通知书账户数" required="true"></s:textfield>
				<s:textfield id="feedbackdate" name="feedbackdate" label="我行反馈时间" required="true"></s:textfield>
				<s:textfield name="feedbackno" label="反馈资料文书号" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="dealresult" label="处理结果" required="true"></s:textarea>
				<s:textfield name="recordeno" label="存档案号" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="notes" label="备注" required="true"></s:textarea>
				<s:file name="headculeFile" label="可疑主体数据">
					<s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}]" />
				</s:file>
				<s:submit align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>
		</fieldset><br/>
	</div>
</body>
