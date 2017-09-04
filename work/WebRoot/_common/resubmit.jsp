<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="/pages/common/ERROR.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% response.setHeader("Cache-Control", "no-cache"); %>

<html>
	<head>
		<title>操作失败</title>
		<base target="_self">
	</head>
	
	<body>
		<div align="center" style="width: 300px;margin: 10px auto">
   	<div id="effect" class="ui-widget-content ui-corner-all">
		<h3 class="ui-widget-header ui-corner-all">操作提示</h3>
		<p style="height: 100px;vertical-align: center;margin-top: 50px">
			 请不要重复操作!
			</p>
	</div>
    </div>
	</body>
</html>