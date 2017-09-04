<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>资料报备管理>>上报资料查询a</title>
</head>
<body>
	<script type="text/javascript"> 
	/**页面加载时渲染日期空间*/
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
    	
    $.subscribe('createxls', function(event,data) {
    	var oid = document.getElementById("oid").value; 
    	alert(oid);
    	var filename = document.getElementById("filename").value; 
    	alert(filename);   
    	var endtime =  	document.getElementById("endtime").value;
    	alert(endtime);
    	var starttime = document.getElementById("starttime").value;    
    	alert(starttime);	
    	alert("<%=request.getContextPath()%>/document/document_downloadxls.shtml?oid="+oid+"&filename="+filename+"&starttime="+starttime+"&endtime="+endtime);
	  	window.location.href="<%=request.getContextPath()%>/document/document_downloadxls.shtml?oid="+oid+"&filename="+filename+"&starttime="+starttime+"&endtime="+endtime;
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
    </script>
	<div class="grid">
	<fieldset>
		<legend>
			上报资料查询
		</legend>
		<br>
		<s:form namespace="/document" action="document_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:select list="#list" label="金融机构类别" id="bpid" name="bid"
				listKey="bid" listValue="catname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'--请选择--'}" label="金融机构名称" id="bannerid" name="oid"
				cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield label="开始日期" name="starttime" id="startdate"></s:textfield>
			<s:textfield label="截止日期" name="endtime" id="enddate"></s:textfield>
			<s:textfield label="材料名称" name="filename">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{3}" />
			</s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="document_list" id="searchbutton" value="查  询"
				timeout="2500" button="true" indicator="indicator"
				onBeforeTopics="before" onCompleteTopics="complete"
				onErrorTopics="errorState" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>
	</fieldset><br/><br/>
			<sj:submit id="grid_download_colsbutton" value="文件下载" timeout="2500"
				onClickTopics="downloadfile" button="true"/>
			<sj:grid id="gridtable" caption="上报资料列表" dataType="json"
				href="../document/document_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
				<sj:gridColumn name="uid" index="uid" title="序号" hidden="true" sortable="false" width="50" />
				<sj:gridColumn name="BOrgInformation.oid" index="BOrgInformation.oid" hidden="true" title="金融机构ID" sortable="false" width="100" />
				<sj:gridColumn name="BOrgInformation.bname"	index="BOrgInformation.bname" title="上报金融机构名称" sortable="false" width="280" />
				<sj:gridColumn name="filename" index="filename" title="文件名" sortable="false" width="350" />
				<sj:gridColumn name="updatetime" index="updatetime" title="上报时间"	sortable="false" width="150" />
				<sj:gridColumn name="updateuser" index="updateuser" title="上报人" sortable="false" width="100" />
				<sj:gridColumn name="cnt" index="cnt" title="下载次数" sortable="false" width="100" />

			</sj:grid>

		</div>
</body>
