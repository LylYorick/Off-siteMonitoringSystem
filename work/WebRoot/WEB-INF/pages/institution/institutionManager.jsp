<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
	<title>制度管理</title>

	<script type="text/javascript">
		$(document).ready(function() {
	  	 	var dates = $("#startdate, #enddate").datepicker({
  	 		changeMonth: true,
  	 		changeYear: true,
			onSelect: function(selectedDate) {
				var option = this.id == "startdate" ? "mixDate" : "maxDate";
				var instance = $(this).data("datepicker");
				var date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
				dates.not(this).datepicker("option", option, date);
			}
			}
  	 	);
		});
		
	
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
		
	$(getsort);   
    function getsort(){   
        var cid=$("#bpid").val();   
        var time=new Date();   
        $.ajax({   
            cache:false,   
            url:'<%=request.getContextPath()%>/financial/financial_findInformation.shtml',    
            type:'post',   
            dataType:'json',   
            data:{cid:cid,t:time},   
            success:update_c   
        });   
    }
    function update_c(json){
       var sort=json.informationSet;   
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
           var text=sort[i].bname;   
               option.text=text;   
               option.value=value;   
               s_root.options[s_root.options.length] =option;   
       }   
    }	
		
		
	$.subscribe('upload', function(event,data) {
	    	var s; 
	    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
	    	document.location.href="<%=request.getContextPath()%>/institution/institution_institutionAdd.shtml";
    	});
		
	$.subscribe('downloadfile', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	var oid="";
     	var ins_id="";
     	if(s==''){
    	    alert("请选择要下载的资料！");
    	    return;
    	}  
    	if(s.length>0){
    		for (var i=0; i < s.length; i++) { 
    			var id = s[i]; 
    			var row = $("#gridtable").jqGrid('getRowData', id); 
    			oid+=row['BOrgInformation.oid']+",";
    			ins_id+=row.ins_id+",";
    		}
    	}
    	document.location.href="<%=request.getContextPath()%>/institution/institution_download.shtml?oids="+oid+"&ins_ids="+ins_id; 
    	}); 
    		
     $.subscribe('deletefile', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	if(s==''){
    	    alert("请选择删除的资料！");
    	    return;
    	} 
    	var ins_id="";
    	if(s.length>0){
    		for (var i=0; i < s.length; i++) { 
    			var id = s[i]; 
    			var row = $("#gridtable").jqGrid('getRowData', id); 
    			ins_id+=row.ins_id+",";
    		}
    	}
	    	if(window.confirm("确定要删除吗？")){
	    <%-- 	document.location.href="<%=request.getContextPath()%>/institution/institution_delete.shtml?ins_ids="+ins_id; --%>
		    	$.ajax({
		            cache:false,   
		            url:'<%=request.getContextPath()%>/institution/institution_delete.shtml',    
                    data:{ins_ids:ins_id},
		            type:'post',   
		            dataType:'json',   
		            success:function(data){
		            	alert(data.errorMsg);
		            	if(data.errorMsg == "删除文件成功"){
		            		location.reload();
		            	}
		            }
		        });  
	    	}
    	});
		
		</script>

<style type="text/css">
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}


</style>
</head>
<body>
	<div class="grid">
		<fieldset>
			<legend>
				制度查询
			</legend>
			<br>
			<s:form namespace="/institution" action="institution_list" method="post">

				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{4}" />
				</s:bean>
				<s:select list="#list" label="金融机构类别" id="bpid" name="bid" listKey="bid" listValue="catname" onchange="getsort()">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:select>
				<s:select list="#{'9999':'--请选择--'}" label="金融机构名称" id="bannerid" name="oid" cssStyle="width:240px">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:select>
				<s:textfield label="开始日期" name="starttime" id="startdate"></s:textfield>
				<s:textfield label="截止日期" name="endtime" id="enddate"></s:textfield>

			</s:form>
			<div align="center">
				<sj:submit formIds="institution_list" id="searchbutton" value="查  询"
					timeout="2500" button="true" indicator="indicator"
					onBeforeTopics="before" onCompleteTopics="complete"
					onErrorTopics="errorState" />
				<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
					style="display: none" />
			</div>
        
		</fieldset><br/>
		<sj:submit id="grid_upload_colsbutton" value="制度上报"
			onClickTopics="upload" button="true"/>
		<sj:submit id="grid_download_colsbutton" value="文件下载" timeout="2500"
			onClickTopics="downloadfile" button="true" indicator="loading" loadingText="正在下载..."/>
		<sj:submit id="grid_delete_colsbutton" value="记录删除" timeout="2500"
			onClickTopics="deletefile" button="true" indicator="loading" loadingText="正在删除..."/>
			
		<sj:grid id="gridtable" caption="金融机构列表" dataType="json"
			href="../institution/institution_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect" 	height="200">
			<sj:gridColumn name="ins_id" index="ins_id" title="制度表ID" sortable="true" hidden="true" width="70"/>
			<sj:gridColumn name="archives.oid" index="archives.oid" hidden="true" title="金融机构ID" sortable="false" width="70" />
			<sj:gridColumn name="archives.bname" index="archives.bname" title="金融机构名称" sortable="false" width="270" />
			<sj:gridColumn name="up_time" index="up_time" title="上传时间" sortable="false" width="110" />
			<sj:gridColumn name="file_url" index="file_url" title="文件路径"  hidden="true" sortable="false" width="90" />
			<sj:gridColumn name="file_name" index="file_name" title="文件名称" sortable="false" width="350" />
			<sj:gridColumn name="file_type" index="file_type" title="文件类型" sortable="false"  hidden="true" width="90" />
			<sj:gridColumn name="up_user" index="up_user" title="上传人" sortable="false" width="90" />
			<sj:gridColumn name="cnt" index="cnt" title="下载次数" sortable="false" width="90" />
		</sj:grid>
        </div>
</body>
