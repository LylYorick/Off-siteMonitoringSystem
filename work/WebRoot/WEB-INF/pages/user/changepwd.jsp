<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>密码修改</title>
		
</head>
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			密码修改
		</legend>
		<br>
		<s:form namespace="/user" action="user_pwdupdate" method="post" onsubmit="return checkpwd()">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:textfield label="原始密码" required="true" name="oldpswd">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:password label="新密码" required="true" name="newpswd" id="newpswd">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:password>
			<s:password label="密码确认" required="true" name="newpswdconfirm" id="newpswdconfirm" onblur="checkpwd()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:password>
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center" id="modi" value="用户修改" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
	<script type="text/javascript">
		function checkpwd(){
			if($("#newpswd").val()!=$("#newpswdconfirm").val()){
				$("#newpswdconfirm").next().html("&nbsp;&nbsp;两次输入密码不符");
				$("#newpswdconfirm").next().css("font-weight", "bold");
				$("#newpswdconfirm").next().css("color", "red");
				return false;
			}else{
				$("#newpswdconfirm").next().empty();
			}
		}
	</script>
</body>
