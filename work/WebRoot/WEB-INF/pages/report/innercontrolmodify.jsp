<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>内控制度建设情况修改</title>
</head>
<body>
	<script type="text/javascript"> 
   $(document).ready(function() {
  	 		$("#starttime").datepicker({changeMonth: true,changeYear: true});
		}); 
    </script>
	<div class="grid">
		<fieldset>
			<legend>
				内控制度建设情况修改
			</legend>
			<br>
			<s:form namespace="/report" action="report_innercontrolupdate" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:textfield label="制度名称" required="true" name="innercontrol.iname" size="40">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:textfield>
				<s:textarea label="主要内容" required="true" name="innercontrol.icontent" rows="8" cols="80">
				</s:textarea>
				<s:textfield label="制定部门" required="true" name="innercontrol.idept">
				</s:textfield>
				<s:textfield label="制定时间" required="true" name="innercontrol.itime"  id="starttime">
				</s:textfield>
				<s:textfield label="相关文号" required="true" name="innercontrol.filenb">
				</s:textfield>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				<s:hidden name="innercontrol.innerid" value="%{id}"></s:hidden>
				<s:hidden name="innercontrol.reportswitch.switchid" value="%{innercontrol.reportswitch.switchid}"></s:hidden>
				<s:hidden name="id" value="%{id}"></s:hidden>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
				</td></tr>
			</s:form>

		</fieldset><br/>
	</div>
</body>
