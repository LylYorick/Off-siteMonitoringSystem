<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>系统公告>>添加</title>
</head>
<body>
	<s:form namespace="/dynamic" action="test!add" method="post" cssStyle="width:98%">
		<s:bean name="java.util.HashMap" id="qTableLayout">
			<s:param name="tablecolspan" value="%{4}" />
		</s:bean>
		<s:textfield name="name" label="标题" required="true">
			<s:param name="labelcolspan" value="%{1}" />
			<s:param name="inputcolspan" value="%{1}" />
		</s:textfield>
		<s:textfield name="address" label="内容">
			<s:param name="labelcolspan" value="%{1}" />
			<s:param name="inputcolspan" value="%{1}" />
		</s:textfield>
		<s:textfield name="title" label="作者">
			<s:param name="labelcolspan" value="%{1}" />
			<s:param name="inputcolspan" value="%{1}" />
		</s:textfield>
		<s:textfield name="email" label="日期" id="sj">
			<s:param name="labelcolspan" value="%{1}" />
			<s:param name="inputcolspan" value="%{1}" />
		</s:textfield>
		<tr><td colspan="4" align="center">
		<s:submit value="提交" theme="simple"></s:submit>
		</td></tr>
	</s:form>
</body>
