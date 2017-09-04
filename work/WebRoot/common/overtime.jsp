<!-- 
	@ submit element.
	@ fred.du
	@ 2006-12-23.
//-->
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>操作超时</title>
	</head>
	
	<body>
		<p align="center">
			您还没有登录或操作超时, 点<a href="<%=request.getContextPath()%>/login.jsp">这里</a>重新登录.
		</p>
	</body>
</html>
