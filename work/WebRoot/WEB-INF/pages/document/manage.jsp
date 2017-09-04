<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>资料报备管理>>资料管理</title>
</head>
<body>
<script type="text/javascript"> 
	/**页面加载时渲染日期空间*/
  	$(document).ready(function() {
  	var dates = $("#_startdate, #_enddate").datepicker({
  	 		changeMonth: true,
  	 		changeYear: true,
			onSelect: function(selectedDate) {
				var option = this.id == "_startdate" ? "minDate" : "maxDate";
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
    
     $.subscribe('upload', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	document.location.href="<%=request.getContextPath()%>/document/document_add.shtml";
    	});
      $.subscribe('downloadfile', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	var oid="";
     	var uid="";
     	if(s==''){
    	    alert("请选择要下载的资料！");
    	    return;
    	}  
    	if(s.length>0){
    		for (var i=0; i < s.length; i++) { 
    			var id = s[i]; 
    			var row = $("#gridtable").jqGrid('getRowData', id); 
    			oid+=row['BOrgInformation.oid']+",";
    			uid+=row.uid+",";
    		}
    	}
    	document.location.href="<%=request.getContextPath()%>/document/document_download.shtml?oids="+oid+"&uids="+uid;
    	}); 	
     $.subscribe('deletefile', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	if(s==''){
    	    alert("请选择删除的资料！");
    	    return;
    	} 
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	if(window.confirm("确定要删除吗？")){
    	    document.location.href="<%=request.getContextPath()%>/document/document_delete.shtml?uid="+r.uid;
    	}
    	});
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			资料管理
		</legend>
		<br>
		<s:form namespace="/document" action="document_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:textfield label="开始日期" id="_startdate"  name="starttime">
			</s:textfield>
			<s:textfield label="截止日期" id="_enddate"  name="endtime"></s:textfield>
			<s:textfield label="材料名称" name="filename">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{3}" /></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="document_list" id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effect="highlight" effectOptions="{ color : '#222222' }"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>
	</fieldset><br/>
	
		<sj:submit id="grid_upload_colsbutton" value="资料上报"
			onClickTopics="upload" button="true"/>
		<sj:submit id="grid_download_colsbutton" value="文件下载" timeout="2500"
			onClickTopics="downloadfile" button="true" indicator="loading" loadingText="正在下载..."/>
			<sj:submit id="grid_delete_colsbutton" value="文件删除" timeout="2500"
			onClickTopics="deletefile" button="true" indicator="loading" loadingText="正在删除..."/>
		<sj:grid id="gridtable" caption="上报资料列表" dataType="json"
			href="../document/document_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="uid" index="uid" title="序号" sortable="true" hidden="true" 
				width="50"/>
				<sj:gridColumn name="BOrgInformation.oid" index="BOrgInformation.oid" title="金融机构ID" sortable="false" hidden="true" width="100" />
			<sj:gridColumn name="BOrgInformation.bname" index="bname" title="上报金融机构名称" sortable="true"
				width="280"/>
			<sj:gridColumn name="filename" index="filename" title="文件名" sortable="false"
				width="350" />
			<sj:gridColumn name="updatetime" index="updatetime" title="上报时间" sortable="false"
				width="150" />
			<sj:gridColumn name="updateuser" index="updateuser" title="上报人" sortable="false"
				width="150" />
			
		</sj:grid>
	</div>
	
</body>
