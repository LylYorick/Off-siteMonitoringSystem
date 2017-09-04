<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>请求总行或者兄弟行协查名单录入</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#senddate").datepicker({beforeShow: customRange});
		$("#backdate").datepicker({beforeShow: customRange});
		function customRange(input) {
            return {minDate: (input.id == 'backdate' ? $('#senddate').datepicker('getDate') : null),
                maxDate: (input.id == 'senddate' ? $('#backdate').datepicker('getDate') : null)};
        }
	})
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
				请求总行或者兄弟行协查名单录入
			</legend>
			<br>
			<s:form namespace="/investigation" action="investigation_save" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<!--<s:textfield name="sid" label="序号" required="true"></s:textfield>-->
				<s:textfield name="checkid" label="协查函号" required="true"></s:textfield>
				<s:textarea rows="10" cols="80" name="description" label="可疑交易描述" required="true"></s:textarea>
				<s:textarea rows="10" cols="80" name="content" label="协查内容" required="true"></s:textarea>
				<s:textfield id="senddate" name="senddate" label="发函时间" required="true"></s:textfield>
				<s:textfield name="unit" label="协查单位" required="true"></s:textfield>
				<s:textfield name="handledby" label="经手人" required="true"></s:textfield>
				<s:textfield id="backdate" name="backdate" label="实际回函时间" required="true"></s:textfield>
				<s:textarea rows="10" cols="80" name="note" label="备注" required="true">
				</s:textarea>
				<s:file name="checkFile" label="可疑主体数据">
					<s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}" />
				</s:file>
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
