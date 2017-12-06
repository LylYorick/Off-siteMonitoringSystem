<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>
	<head>
		<title>::反洗钱非现场监管系统::<decorator:title /></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="AML,反洗钱,人行,深圳中心支行,fred">
		<meta http-equiv="description" content="AML,反洗钱,人行,深圳中心支行,fred">
		
		<sj:head useJqGridPlugin="true" jqueryui="true" jquerytheme="redmond"/>
		<%--<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/layout-default-latest.css" /> --%>
		 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/layout.css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.layout.js"></script>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/custom.css" />
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/validate.css" />
		
			<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.layout-latest.js"></script> --%>
	<%-- 	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script> --%>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/layout.js"></script>
	 	<script type="text/javascript" src="<%=request.getContextPath()%>/js/custom.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/lunar.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.pngFix.pack.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/easy_validator.pack.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maxlength-min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/paginater.js"></script>
		 <decorator:head />
	</head>
	<body>
	<!-- banner开始 -->
		<DIV class="ui-layout-north">
			<page:applyDecorator page="/WEB-INF/layout/top.jsp" name="layout"></page:applyDecorator>
		</DIV>
	<!-- banner结束 -->
	<!-- menu开始 -->
		<DIV class="ui-layout-west">
			<page:applyDecorator page="/WEB-INF/layout/menu.jsp" name="layout"></page:applyDecorator>
		</DIV>
	<!-- menu结束 -->
	<!-- core开始 -->
		<DIV class="ui-layout-center" id="core">
			<decorator:body />
		</DIV>
	<!-- core结束 -->
	<!-- footer开始 -->
		<DIV class="ui-layout-south">
			<page:applyDecorator page="/WEB-INF/layout/footer.jsp" name="layout"></page:applyDecorator>
		</DIV>
	<!-- footer结束 -->
	</body>
</html>
