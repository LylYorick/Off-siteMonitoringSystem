<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>角色管理>>角色显示列表</title>
</head>
<body>
<script type="text/javascript"> 

     $.subscribe('add', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	document.location.href="<%=request.getContextPath()%>/role/role_add.shtml";
    	});
     $.subscribe('modify', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	if(s==''){
    	    alert("请选择修改的角色！");
    	    return;
    	} 
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	document.location.href="<%=request.getContextPath()%>/role/role_modify.shtml?rid="+r.rid;
    	});
     $.subscribe('grant', function(event,data) {
		var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	if(s==''){
    	    alert("请选择修改权限的角色！");
    	    return;
    	} 
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	document.location.href="<%=request.getContextPath()%>/role/role_grant.shtml?rid="+r.rid;
    	});  
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			角色显示列表
		</legend>
		<br>
		

		<sj:submit id="grid_add_colsbutton" value="角色新增"
			onClickTopics="add" button="true"/>
		<sj:submit id="grid_modify_colsbutton" value="角色修改" timeout="2500"
			onClickTopics="modify" button="true" indicator="loading"/>
		<sj:submit id="grid_grant_colsbutton" value="权限修改" timeout="2500"
			onClickTopics="grant" button="true" indicator="loading"/>		
				
		<sj:grid id="gridtable" caption="角色列表" dataType="json"
			href="../role/role_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="rid" index="rid" title="序号" sortable="true" width="200"/>
			<sj:gridColumn name="rname" index="rname" title="角色名" sortable="false" width="150" />
			<sj:gridColumn name="rmark" index="rmark" title="角色备注" sortable="false" width="500" />
		</sj:grid>
	
	</fieldset><br/>

	</div>
</body>
