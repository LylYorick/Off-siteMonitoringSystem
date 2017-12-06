<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ERROR</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <s:debug></s:debug>
  		异常:<s:property value="exceptionStack"/>
   <div align="center" style="width: 300px;margin: 10px auto">
   	<div id="effect" class="ui-widget-content ui-corner-all">
		<h3 class="ui-widget-header ui-corner-all">操作提示</h3>
		<p style="height: 100px;vertical-align: center;margin-top: 50px">
			异常:<s:property value="exception.message"/>
	
			</p>
	</div>

    </div>
    
  </body>
</html>
