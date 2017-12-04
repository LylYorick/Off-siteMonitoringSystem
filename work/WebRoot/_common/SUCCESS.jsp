<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SUCCESS</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%
		String path = request.getContextPath();                     //拿到当前项目的路径
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<style type="text/css">
	.defaultMessage{
	    font-weight: bold;
	    color: #2e6e9e;
	}
	</style>
  </head>
  
  <body>
  <div align="center" style="width: 300px;margin: 10px auto">
   	<div id="effect" class="ui-widget-content ui-corner-all">
		<h3 class="ui-widget-header ui-corner-all">操作提示</h3>
		<p style="height: 100px;vertical-align: center;margin-top: 30px">
			<img src="../images/SUCC.png">
			</p>
		<p  class="defaultMessage">
			<s:property value="successMessage"/>
		</p>
		<p style="height: 50px;vertical-align: center;margin-top: 30px">
			<s:iterator value="btList">
				<input type="button" class="ui-button ui-state-default ui-corner-all" value="<s:property value="_btName"/>" onclick="javascript:location.href='<%=basePath%><s:property value="_btUrl"/>'"/>
			</s:iterator>
			
		</p>
	</div>

    </div>
  </body>
</html>
