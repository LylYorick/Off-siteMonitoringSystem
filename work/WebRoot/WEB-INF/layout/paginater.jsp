<%@ page contentType="text/html; charset=utf-8" language="java" %>
<jsp:directive.page import="com.opensymphony.xwork2.ActionContext"/>
<%@page import="org.work.web.util.Paginater;"%>
<%@ taglib uri="/WEB-INF/dwt.tld" prefix="d"%>
<%
	request.setAttribute(Paginater.PAGINATER, ActionContext.getContext().getContextMap().get("com.flink.util.Paginater"));
%>
<d:paginate navigateStyle="classical"/>
