<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索移交录入</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function() {
  	 	$("#transferdate").datepicker({changeMonth: true,changeYear: true});
	});
    $.subscribe('before', function(event,data) { 
      var fData = event.originalEvent.formData; 
    }); 
    $.subscribe('complete', function(event,data) { 
    	alert("添加成功");
    }); 
    $.subscribe('errorState', function(event,data) { 
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status); 
    });
    </script>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				线索移交录入
			</legend>
			<br>
			<s:form namespace="/transfercule" action="transfercule_save" method="post" enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
				<s:textfield name="transfersymbol" label="移送文号" required="true"></s:textfield>
				<s:textfield name="sourcecase" label="案件来源" required="true"></s:textfield>
				<s:textfield name="transferamout" label="移送金额" required="true"></s:textfield>
				<s:textfield id="transferdate" name="transferdate" label="移送时间" required="true"></s:textfield>
				<s:textfield name="handledby" label="经手人" required="true"></s:textfield>
				<s:textfield name="receivingunit" label="接受单位" required="true"></s:textfield>
				<s:textfield name="handledperson" label="接受单位经手人" required="true"></s:textfield>
				<s:textfield name="isplacedonfile" label="是否立案" required="true"></s:textfield>
				<s:textarea rows="5" cols="30" name="dealresult" label="处理结果" required="true"></s:textarea>
				<s:textarea rows="5" cols="30" name="notes" label="备注" required="true"></s:textarea>
				<s:file name="transfersourceFile" label="可疑主体数据">
					<s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}]" />
				</s:file>
				<s:submit align="center" value="提    交"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</s:form>

		</fieldset><br/>
	</div>
</body>
