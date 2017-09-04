<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>内控制度建设情况导入</title>
</head>
<body>
	<script type="text/javascript"> 
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
				内控制度建设情况导入
			</legend>
			<br>
			<s:form namespace="/report" action="report_innercontrolImportsave" method="post"  enctype="multipart/form-data">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:file label="数据文件" name="importFile" reg=".*xls$" tip="只允许excel文件">
					<s:param name="remark" value="%{getText('reportFile.innerControl')}" />
				</s:file>
				<tr><td>模板下载</td><td><a href="<%=request.getContextPath()%>/templete/4.xls">模板</a></td></tr>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
				</td></tr>
			</s:form>

		</fieldset><br/>
	</div>
</body>
