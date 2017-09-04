<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
<DIV id=header>
<div id="logo"></div>
<div id="logo1"></div>
</DIV>
<ul id="mainNav">
	<li><div id="sj">今天是:&nbsp;<SCRIPT type=text/javascript>document.write(getLunarInfo());</SCRIPT></div></li>
		<li id="last_menu">
			<div>用户:<s:property value="#session.userinfo.brname"/>&nbsp;&nbsp;|&nbsp;&nbsp;登录时间:<s:property value="#session.userinfo.loadtime"/> |&nbsp;&nbsp;<a class="lightBlue" href="<%=request.getContextPath()%>/user/user_changepwd.shtml">修改个人资料</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a class="lightBlue" href="<%=request.getContextPath()%>/system/logout.shtml">退出系统</a></div>
		</li>
</ul>
</body>