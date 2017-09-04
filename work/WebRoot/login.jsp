<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<%
String errors = (String)session.getAttribute("errors");
session.removeAttribute("errors");
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>反洗钱非现场监管系统</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/struts/js/base/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
		<style type="text/css">
			body{
				text-align:center;
				margin:0;
				padding:0;
				background:RGB(242,242,242);
				font-size:9pt;
			}
			#main{
				background:url(images/index.jpg) transparent top left no-repeat;
				width:1000px;
				height:600px;
				display:block;
				margin:10px auto;
		
			}
			form{
				position:relative;
				top:340px;
				left:200px;
			}
			table{
			width:240px;
			border: 0px solid #ffffff;  
            padding:0;   
            margin:0 auto;  
            border-collapse: collapse;  
			}
			td{
			height:20px;
			font-family: 宋体, Times New Roman;
			border: 0px solid #ffffff;  
            font-size:12px;  
            padding: 3px 3px 3px 8px;  
            color: #444444;  
			}
			input{
				background:#ffffff;
				border:1px solid #999999;
				margin:0 3px;
			}
		</style>

		<script type="text/javascript">
			window.onload = function() {
				document.getElementById("usernm").focus();
			}
			
			function changeFocus(target) {
				if (event.keyCode == 13) {
					var o = document.getElementById(target);
					o.focus();
					
					if (o.type.toUpperCase() == "BUTTON") {
						event.keyCode = 0;
					}
				}
			}
			
			function login() {
				if($.trim($("#usernm").val())=="" || $.trim($("#passwd").val())==""){
					alert("用户名或者密码不得为空");
					return false;
				}
				document.forms[0].submit();
				document.getElementById("btnSubmit").disabled = true;
			}
		</script>
	</head>
	
	<body>

		<div id="main">
			<form action="<%=request.getContextPath()%>/system/login.shtml" method="post"
				onsubmit="btnSubmit.disabled=true">
				<table>
					<tr><td colspan="2" align="center"><span style="color:#ff0000"><% if(errors!=null){out.println(errors);}%></span></td></tr>
					<tr>
						<td>
							用户名:
						</td>
						<td>
							<input type="text" size="20" id="usernm" name="usernm" value="operator" onkeydown="changeFocus('passwd')" />
						</td>
					</tr>
					<tr>
						<td>
							密&nbsp;&nbsp;码:
						</td>
						<td>
							<input type="password" size="20" id="passwd" name="passwd" value="1" onkeydown="changeFocus('btnSubmit')" />
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<button  id="btnSubmit"  onclick="login()"> 登 录 </button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
