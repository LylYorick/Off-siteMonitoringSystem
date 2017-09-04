<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>角色管理>分配权限</title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			String[] treestr = (String[])session.getAttribute("treeItems");
			String havePrivileges = (String)session.getAttribute("havePrivileges");
			session.removeAttribute("treeItems");
			session.removeAttribute("havePrivileges");
		%>
	<script type="text/javascript" src="<%=path%>/js/wtree.js"></script>
	<link rel="stylesheet" href="<%=path %>/style/dtree.css"  type="text/css"></link>
</head>
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			角色名:[<s:property value="rname"/>]分配权限
		</legend>
		<br>
		<s:form id="rolepriform" namespace="/role" action="role_privilegeInsert"  method="POST" target="_self">
						
						<s:hidden name="rid" />
						<s:hidden id="prlgArray" name="prlgArr" value=""></s:hidden>
						<table>
							<tr>
								<td width="30%" align="left">
								<div id="systree"></div>
									<script type="text/javascript">
										
										function submitData(){
											var selids=tree.getCheckedNodes();
											var str="";
											for(var n=0; n<selids.length; n++){
												str+=selids[n]+";";
											}
											document.getElementById("prlgArray").value=str;
											document.getElementById.submit();
											}
										tree = new dTree('tree','<%=path%>/images/prlgTreeImg/');//创建一个对象.
										tree.config.folderLinks=true;
										tree.config.useCookies=false;
										tree.config.check=true;
										<%
									    try
									 	{
									    	if(null!=treestr){
									    		String tmpStr = "";
									    		for(int i=0;i<treestr.length;i++){
									    			tmpStr = "tree.add("+treestr[i]+");";
									    			out.println(tmpStr);
									    		}
									    	}
									    	
										 }
										 catch(Exception e)
										 {
							                String msg = "出错了！";
									 		out.print("alert('"+msg+"'); return;");
									     }
									%>
									    document.write(tree);
									    var funcs = eval("("+"{funcs:["+"<%=havePrivileges%>"+"]}"+")");
										for(var n=0; n<funcs.funcs.length;n++){
											tree.co(funcs.funcs[n].menudm).checked=true;
										}	    
								    </script>   
								</td>
							</tr>
							<tr><td align="center"><s:submit name="submit" value="提    交"  cssClass="ui-button ui-state-default ui-corner-all" onclick="submitData();"></s:submit></td></tr>
							
						</table>
						

					</s:form>

	</fieldset><br/>
	</div>
</body>
