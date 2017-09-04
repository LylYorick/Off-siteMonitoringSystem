<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->报表查询</title>
</head>
<body>
<script type="text/javascript"> 

    $.subscribe('before', function(event,data) { 
    }); 
    $.subscribe('complete', function(event,data) { 
    	var myjsongrid = eval("("+event.originalEvent.request.responseText+")");
    	$("#gridtable").trigger("clearGrid"); 
    	$("#gridtable")[0].addJSONData(myjsongrid);
    }); 
    $.subscribe('errorState', function(event,data) { 
    });
    
    $.subscribe('export', function(event,data) { 
       	window.open("<%=request.getContextPath()%>/report/report_export.shtml");
    });    
    $.subscribe('excel', function(event,data) { 
       	window.open("<%=request.getContextPath()%>/report/report_excel.shtml");
    });
     $.subscribe('manage', function(event,data) {
       	var s = $("#gridtable").jqGrid('getGridParam','selrow');
       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
   		var r = $("#gridtable").jqGrid('getRowData',s);     		 		
  		window.open("<%=request.getContextPath()%>/report/report_fill.shtml?reportid="+r.reportid+"&switchid="+r.id);
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
   option.value="";   
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
	function toggle(){
		var options = {};
		$("#toggle").toggle("blind",options,500);
	}
    </script>     
	<div class="grid">
		<fieldset>
		<legend onclick="toggle()">
			报表查询
		</legend>
		<br>
  	  <div id="toggle">
		<s:form namespace="/report" action="report_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			<s:select list="#reportList" label="报表名称" name="reportid" headerKey="" headerValue="所有报表" listValue="rptname" listKey="reportid">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
			</s:select>
			<s:select list="#list" label="金融机构类别" id="bpid" name="bid"  headerKey="9999" headerValue="所有"
				listKey="bid" listValue="catname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:select>
			<s:select list="{'--请选择--'}" label="金融机构名称" id="bannerid" name="oid"
				cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:select>
			<s:select label="上报状态" name="reportstatus" list="@org.work.web.constants.Constants@REPORT_STATUS" headerKey="9999" headerValue="全部" listKey="key" listValue="value">
			</s:select>
			<s:textfield label="年份" name="reportyear" size="4"></s:textfield>
			<s:textfield label="季度" name="reportquater" size="4"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="report_list" id="searchbutton" value="查  询"
				timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..." style="display: none" />
		</div>

	</div>
	</fieldset><br/>
			<sj:submit id="grid_manage_colsbutton" value="报表明细" button="true" onClickTopics="manage"/>
			<sj:submit id="grid_export_colsbutton" value="导出上报报文" button="true" onClickTopics="export" indicator="indicator1"/>
			<sj:submit id="grid_excel_colsbutton" value="导入Excel报表" button="true" onClickTopics="excel"/>
			<img id="indicator1" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..." style="display: none" />
		<s:url id="remoteurl" action="report_list.shtml" escapeAmp="false">
			<s:param name="reportid" value="%{reportid}"></s:param>
		</s:url>
		<sj:grid id="gridtable" caption="报表列表" dataType="json"
			href="%{remoteurl}" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect" >
			<sj:gridColumn name="id" index="switchid" title="序号" sortable="true" width="100" hidden="true" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="bname" index="bname" title="金融机构" sortable="false" width="300"/>
			<sj:gridColumn name="reportid" index="reportid" title="报表开关ID" sortable="false" hidden="true" />
			<sj:gridColumn name="rname" index="rname" title="报表名称" sortable="false" width="330" />
			<sj:gridColumn name="type" index="type" title="报表类型" sortable="false" width="80" />
			<sj:gridColumn name="year" index="year" title="年份" sortable="false" width="70" />
			<sj:gridColumn name="quater" index="quater" title="季度" sortable="false" width="50" />
			<sj:gridColumn name="isreport" index="isreport" title="是否有记录" sortable="false" width="100"  formatter="formatYN"/>
			<sj:gridColumn name="status" index="status" title="状态" sortable="false" width="50" formatter="formatLink"/>
		</sj:grid>
	</div>
	<script type="text/javascript">
		function formatLink(cellvalue, options, rowObject) { 
			if(cellvalue=="待上报"){
				return "<span style='color:green;'>"+cellvalue+"</span>";
				}else if(cellvalue=="未上报"){
					return "<span style='color:red'>"+cellvalue+"</span>";
				}else if(cellvalue=="已上报"){
					return "<span style='color:blue'>"+cellvalue+"</span>";
				}
        } 
        function formatYN(cellvalue, options, rowObject) { 
			if(cellvalue=="1"){
				return "<span style='color:green;'>"+'有'+"</span>";
				}else{
					return "<span style='color:red'>"+'无'+"</span>";
				}
        } 
	</script>
</body>
