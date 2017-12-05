<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>用户管理>>用户显示列表</title>
</head>
<body>
<script type="text/javascript"> 
    $.subscribe('before', function(event,data) { 
      var fData = event.originalEvent.formData;         
    }); 
    $.subscribe('complete', function(event,data) { 
    	var myjsongrid = eval("("+event.originalEvent.request.responseText+")");
    	$("#gridtable").trigger("clearGrid"); 
    	$("#gridtable")[0].addJSONData(myjsongrid);
    }); 
    $.subscribe('errorState', function(event,data) { 
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status); 
    });
    
     $.subscribe('add', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	document.location.href="<%=request.getContextPath()%>/user/user_add.shtml";
    	});
     $.subscribe('view', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	var r = $("#gridtable").jqGrid('getRowData',s);    	   	
    	document.location.href="<%=request.getContextPath()%>/user/user_download.shtml?buid="+r.buid;
    	}); 
     $.subscribe('modify', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	if(s==''){
    	    alert("请选择修改的用户！");
    	    return;
    	} 
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	document.location.href="<%=request.getContextPath()%>/user/user_modify.shtml?buid="+r.buid;
    	});
     $.subscribe('grant', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	 if(s==''){
    	    alert("请选择添加角色的用户！");
    	    return;
    	} 
    	var r = $("#gridtable").jqGrid('getRowData',s);    	   	
    	document.location.href="<%=request.getContextPath()%>/user/user_grant.shtml?buid="+r.buid;
    	});
     $.subscribe('reset', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	 if(s==''){
    	    alert("请选择用户！");
    	    return;
    	} 
    	var params = {buid:$("#gridtable").jqGrid('getRowData',s).buid};
     	$.post("<%=request.getContextPath()%>/user/user_reset.shtml",params,function(data){
     		alert(data);
     		window.location.reload(true);
     	}
     	);  	
    	document.location.href="<%=request.getContextPath()%>/user/user_reset.shtml?buid="+r.buid;
    	});  
	  	$(getsort);   
		function getsort(){   
		    var bfirstid=$("#bfirstid").val();   
		    var time=new Date();   
		    $.ajax({   
		        cache:false,   
		        url:'<%=request.getContextPath()%>/archives/archives_findArchivesByBfirstid.shtml',    
		        type:'post',   
		        dataType:'json',   
		        data:{bfirstid:bfirstid,t:time},   
		        success:update_c   
		    });   
		}
		function update_c(json){
			
		   var sort=json.archivesList;   
		   console.table(sort);
		   var cbanner=json.bname;   
		   var s_root=document.getElementById('bannerid');   
		   s_root.options.length=0; 
		   
		   var option = document.createElement("option");    
		   option.text="---请选择---";   
		   option.value="9999";   
		   s_root.options[s_root.options.length] =option;  
		           
		   for(var i in sort){   
		       var option = document.createElement("option");   
		       var value=sort[i].oid;
		       console.table(sort[i].catalogNew);      
		       var text=sort[i].bname;   
		          option.text=text;   
		          option.value=value;   
		          s_root.options[s_root.options.length] =option;   
		   }   
		}
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			用户显示列表
		</legend>
		<br>
		<s:form namespace="/user" action="user_list" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:select list="#list" label="金融机构类别" id="bfirstid" name="bfirstid" listKey="id.bfirstid" listValue="firstCatname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="#{'9999':'--请选择--'}" label="金融机构名称" id="bannerid" name="oid" cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield label="用户名" name="buname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="备注" name="bumark">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="user_list" id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effect="highlight" effectOptions="{ color : '#222222' }"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>
	</fieldset><br/>
		<sj:submit id="grid_add_colsbutton" value="用户新增"
			onClickTopics="add" button="true"/>
		<sj:submit id="grid_modify_colsbutton" value="用户修改" timeout="2500"
			onClickTopics="modify" button="true" indicator="loading"/>
		<sj:submit id="grid_grant_colsbutton" value="分配角色" timeout="2500"
			onClickTopics="grant" button="true" indicator="loading"/>		
		<sj:submit id="grid_reset_colsbutton" value="密码重置" timeout="2500"
			onClickTopics="reset" button="true" indicator="loading"/>		
				
		<sj:grid id="gridtable" caption="用户列表" dataType="json"
			href="../user/user_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
			<sj:gridColumn name="buid" index="buid" title="用户ID" sortable="false" width="120" hidden="true" />
			<sj:gridColumn name="brname" index="brname" title="用户名" sortable="false" width="120" />
			<sj:gridColumn name="buname" index="buname" title="登录名" sortable="false" width="100" />
			<sj:gridColumn name="rname" index="rname" title="所属角色" sortable="false" width="100" />
			<sj:gridColumn name="bname" index="bname" title="所属金融机构" sortable="true" width="250"/>
			<sj:gridColumn name="btel" index="btel" title="联系电话" sortable="false" width="80" />
			<sj:gridColumn name="loadtime" index="loadtime" title="登录时间" sortable="false" width="120" />
			<sj:gridColumn name="bumark" index="bumark" title="备注" sortable="false" width="200" />
		</sj:grid>

	</div>
	
</body>
