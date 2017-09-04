<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->报表管理</title>
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
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status); 
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
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			报表管理
		</legend>
		<br>
		<s:form namespace="/report" action="report_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			<s:select list="#reportList" label="报表名称" name="reportid" headerKey="" headerValue="所有报表" listValue="rptname" listKey="reportid">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
			</s:select>
			<s:select label="上报状态" name="reportstatus" list="@org.work.web.constants.Constants@REPORT_STATUS" headerKey="" headerValue="全部" listKey="key" listValue="value">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
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

	</fieldset><br/><br/>
			<sj:submit id="grid_manage_colsbutton" value="报表管理" button="true" onClickTopics="manage"/><font color="#ff0000"><-选择报表后点击此按钮进行报备上报</font>
		<s:url id="remoteurl" action="report_list.shtml" escapeAmp="false">
			<s:param name="reportid" value="%{reportid}"></s:param>
		</s:url>
		<sj:grid id="gridtable" caption="报表列表" dataType="json"
			href="%{remoteurl}" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
			<sj:gridColumn name="id" index="switchid" title="序号" sortable="true" width="50" hidden="true" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}" />
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
