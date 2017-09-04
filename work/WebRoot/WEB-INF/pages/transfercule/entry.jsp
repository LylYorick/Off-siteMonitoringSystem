<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索移交查询</title>
</head>
<body>
<script type="text/javascript">
  	$(document).ready(function() {
  	 	$("#starttime").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
  	 	$("#endtime").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
  	 	function customRange(input) {
            return {minDate: (input.id == 'endtime' ? $('#starttime').datepicker('getDate') : null),
                maxDate: (input.id == 'starttime' ? $('#endtime').datepicker('getDate') : null)};
        }
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

 	$.subscribe('add', function(event,data) {
	   	var s; 
	   	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
	   	document.location.href="<%=request.getContextPath()%>/transfercule/transfercule_add.shtml";
   	}); 
   	
   	$.subscribe('modify', function(event,data) {
	   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
	   	var r = $("#gridtable").jqGrid('getRowData',s);
	   	document.location.href="<%=request.getContextPath()%>/transfercule/transfercule_modify.shtml?tsid="+r.tsid;
   	});
   	
   	$.subscribe('delete', function(event,data) {
	   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
	   	var r = $("#gridtable").jqGrid('getRowData',s);
   		document.location.href="<%=request.getContextPath()%>/transfercule/transfercule_delete.shtml?tsid="+r.tsid;
   	});
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			线索移交查询
		</legend>
		<br>
		<s:form namespace="/transfercule" action="transfercule_list" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:textfield label="移送文号" name="transfersymbol" id="transfersymbol"></s:textfield>
			<s:textfield label="主体名称" name="subjectname" id="subjectname"></s:textfield>
			<s:textfield label="开始时间" name="starttime" id="starttime"></s:textfield>
			<s:textfield label="截止时间" name="endtime" id="endtime"></s:textfield>
			<s:textfield label="接受单位" name="receivingunit" id="receivingunit"></s:textfield>
			<s:textfield label="是否立案" name="isplacedonfile" id="isplacedonfile"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="transfercule_list" id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>

	</fieldset><br/>
		<sj:submit id="grid_edit_colsbutton" value="添加信息"
			onClickTopics="add" button="true" />
		<sj:submit id="grid_select_colsbutton" value="修改信息"
			onClickTopics="modify" button="true" />
		<sj:submit id="grid_export_colsbutton" value="删除信息"
			onClickTopics="delete" button="true" />
	
		<sj:grid id="gridtable" caption="线索移交信息列表" dataType="json"
			href="../transfercule/transfercule_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="tsid" index="tsid" title="序号" sortable="true" width="100" searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="transfersymbol" index="transfersymbol" title="移送文号" sortable="true" width="150" />
			<sj:gridColumn name="sourcecase" index="sourcecase" title="案件来源" sortable="false" width="150" />
			<sj:gridColumn name="transferamout" index="transferamout" title="移送金额" sortable="false" width="100" />
			<sj:gridColumn name="transferdate" index="transferdate" title="移送时间" sortable="false" width="150" />
			<sj:gridColumn name="handledby" index="handledby" title="经手人" sortable="false" width="150" />
			<sj:gridColumn name="receivingunit" index="receivingunit" title="接受单位" sortable="false" width="110" />
			<sj:gridColumn name="handledperson" index="handledperson" title="接受单位经手人" sortable="false" width="160" />
			<sj:gridColumn name="isplacedonfile" index="isplacedonfile" title="是否立案" sortable="false" width="160" />
			<sj:gridColumn name="dealresult" index="dealresult" title="处理结果" sortable="false" width="160" />
			<sj:gridColumn name="notes" index="notes" title="备注" sortable="false" width="160" />
			<sj:gridColumn name="tsid" index="tsid" title="id" hidden="true" sortable="false" width="160" />
			</sj:grid>
	</div>
</body>
