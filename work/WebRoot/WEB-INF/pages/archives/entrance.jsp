<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构查询</title>
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
    
     $.subscribe('getselectedhistory', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	if(typeof(r.oid) == "undefined"){
    		alert("请选择金融机构")
    		return;
    	}
	  	window.location.href="<%=request.getContextPath()%>/archives/archives_historyentry.shtml?oid="+r.oid;
  	});
  	
     $.subscribe('getselectedtai', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	if(typeof(r.oid) == "undefined"){
    		alert("请选择金融机构")
    		return;
    	}
	  	window.location.href="<%=request.getContextPath()%>/financial/financial_taientry.shtml?oid="+r.oid;
  	});
  	$.subscribe('view', function(event,data) { 
	       	var s = $("#gridtable").jqGrid('getGridParam','selrow');
	       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    } 
    		var r = $("#gridtable").jqGrid('getRowData',s);    		
	  		window.location.href="<%=request.getContextPath()%>/archives/archives_view.shtml?oid="+r.oid;
	    });
	    
	$.subscribe('createxls', function(event,data) {
	  	window.location.href="<%=request.getContextPath()%>/financial/financial_download.shtml?oid="+$("#bannerid").val()+"&bid="+$("#bpid").val();
  	});
  	
  	$(getsort);   
function getsort(){   
    var bfirstid=$("#bpid").val();   
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
				金融机构查询<s:property value="bid"/>
			</legend>
			<br>
			<s:form namespace="/archives" action="archives_list" method="post">
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
			</s:form>
			<div align="center">
				<sj:submit formIds="archives_list" id="searchbutton" value="查  询"
					timeout="2500" button="true" indicator="indicator"
					onBeforeTopics="before" onCompleteTopics="complete"
					onErrorTopics="errorState" />
				<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
					style="display: none" />
			</div>
        
		</fieldset><br/>
		<sj:submit id="grid_selectbase_colsbutton" value="查看详细信息"
			onClickTopics="view" button="true" />
		<sj:submit id="grid_select_colsbutton" value="显示变更记录"
			onClickTopics="getselectedhistory" button="true" />
		<%-- <sj:submit id="grid_tai_colsbutton" value="台账记录"
			onClickTopics="getselectedtai" button="true" /> --%>
		<sj:submit id="grid_export_colsbutton" value="导出到Excel"
			onClickTopics="createxls" button="true" loadingText="正在导出..." />

		<sj:grid id="gridtable" caption="金融机构列表" dataType="json"
			href="../archives/archives_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
			<sj:gridColumn name="oid" index="oid" title="机构ID" sortable="false" hidden="true" width="70"/>
			<sj:gridColumn name="boid" index="boid" title="机构代码" sortable="false" width="100" />
			<sj:gridColumn name="bname" index="bname" title="机构名称" sortable="false" width="170" />
			<sj:gridColumn name="address" index="address" title="办公地址" sortable="false" width="240" />
			<sj:gridColumn name="blead" index="blead" title="分管领导" sortable="false" width="150" />
			<sj:gridColumn name="bdeptlead" index=" bdeptlead" title="反洗钱部门负责人" sortable="false" width="150" />
			<sj:gridColumn name="bwork" index="bwork" title="反洗钱联系人" sortable="false" width="150" />
		</sj:grid>
        </div>
	
</body>
