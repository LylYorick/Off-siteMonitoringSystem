<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>协查信息查询</title>
</head>
<body>
<script type="text/javascript">
  	$(document).ready(function() {
  	 	$("#starttime").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
  	 	$("#endtime").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
  	 	 // Customize two date pickers to work as a date range
        function customRange(input) {
            return {minDate: (input.id == 'endtime' ? $('#starttime').datepicker('getDate') : null),
                maxDate: (input.id == 'starttime' ? $('#endtime').datepicker('getDate') : null)};
        }
	});
    $.subscribe('before', function(event,data) { 
      var fData = event.originalEvent.formData; 
         /**alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout ); 
			*/
    }); 
    $.subscribe('complete', function(event,data) { 
    	var myjsongrid = eval("("+event.originalEvent.request.responseText+")");
    	$("#gridtable").trigger("clearGrid"); 
    	$("#gridtable")[0].addJSONData(myjsongrid);
    	 /** alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText +  
     '\n\nThe output div should have already been updated with the responseText.'); */
    }); 
    $.subscribe('errorState', function(event,data) { 
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status); 
    });
    
     $.subscribe('getselectedhistory', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	alert('Selected Rows : '+s); 
  	});
 	$.subscribe('add', function(event,data) {
   	var s; 
   	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	document.location.href="<%=request.getContextPath()%>/investigation/investigation_add.shtml";
   	}); 
   	
   	$.subscribe('modify', function(event,data) {
   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	var r = $("#gridtable").jqGrid('getRowData',s);
   	document.location.href="<%=request.getContextPath()%>/investigation/investigation_modify.shtml?crid="+r.crid;
   	});
   	
   	$.subscribe('delete', function(event,data) {
   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	var r = $("#gridtable").jqGrid('getRowData',s);
   	document.location.href="<%=request.getContextPath()%>/investigation/investigation_delete.shtml?crid="+r.crid;
   	});
    </script>    
	<div class="grid">
		<fieldset>
		<legend>
			协查查询
		</legend>
		<br>
		<s:form namespace="/investigation" action="investigation_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:textfield label="协查函号" name="checkid" id="checkid"></s:textfield>
			<s:textfield label="协查单位" name="unit" id="unit"></s:textfield>
			<s:textfield label="开始时间" name="starttime" id="starttime"></s:textfield>
			<s:textfield label="截止时间" name="endtime" id="endtime"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="investigation_list" id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effect="highlight" effectOptions="{ color : '#222222' }"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>

		</fieldset><br/>
			<sj:submit id="grid_edit_colsbutton" value="添加信息"
			onClickTopics="add" button="true" />
		<sj:submit id="grid_select_colsbutton" value="修改信息"
			onClickTopics="modify" button="true" />
		<sj:submit id="grid_export_colsbutton" value="删除信息"
			onClickTopics="delete" button="true" loadingText="正在删除..."/>
	
		<sj:grid id="gridtable" caption="协查信息列表" dataType="json"
			href="../investigation/investigation_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="crid" index="crid" title="序号" sortable="true"
				width="50" search="true"
				searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="subjectname" index="subjectname" title="主体名称" sortable="false"
				width="110" />
			<sj:gridColumn name="idnumber" index="idnumber" title="证件号" sortable="false"
				width="110" />
			<sj:gridColumn name="checkid" index="checkid" title="协查函号" sortable="false"
				width="150" />
			<%-- 
			<sj:gridColumn name="description" index="description" title="可疑交易描述" sortable="false"
				width="200" />
			<sj:gridColumn name="content" index="content" title="协查内容"
				sortable="false" width="200" />--%>
			<sj:gridColumn name="senddate" index="senddate" title="发函时间"
				sortable="false" width="150" />
			<sj:gridColumn name="unit" index="unit" title="协查单位" sortable="false"
				width="110" />
			<sj:gridColumn name="handledby" index="handledby" title="经手人" sortable="false"
				width="110" />
			<sj:gridColumn name="backdate" index="backdate" title="实际回函时间" sortable="false"
				width="110" />
			<sj:gridColumn name="note" index="note" title="备注" sortable="false"
				width="110" />
		</sj:grid>

	</div>
</body>
