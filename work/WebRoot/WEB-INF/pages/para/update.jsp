<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>修改上报截止日期</title>
	<script type="text/javascript">
	  	var isExtendsValidate = true;	//如果要试用扩展表单验证的话，该属性一定要申明
	function extendsValidate(){	//函数名称，固定写法
		if($("#yearendday").val()>31){
			alert("请输入小于31的数字");
			return false;
		}
		if($("#quaterendday").val()>31){
			alert("请输入小于31的数字");
			return false;
		}
	}
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
			<legend>
				修改上报截止日期
			</legend>
			<br>
			<s:form namespace="/jsonlist" action="para_updateEndday" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:textfield label="年报截止日期" id="yearendday" name="yearendday" value="%{#year}" reg="^\d{1,2}$" tip="只允许输入小于31的数字"></s:textfield>
				<s:textfield label="季报截止日期" id="quaterendday" name="quaterendday" value="%{#quater}" reg="^\d{1,2}$" tip="只允许输入小于31的数字"></s:textfield>
				<tr><td colspan="2" align="center">
				<s:submit align="center" value="提    交" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				</td></tr>
			</s:form>
		</fieldset><br/>
	</div>
</body>
