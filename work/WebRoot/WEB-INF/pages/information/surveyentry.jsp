<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>调查信息查询</title>
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
         /**alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout ); 
			*/
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
    	alert('Selected Rows : '+s); 
  	});
 	$.subscribe('add', function(event,data) {
   	var s; 
   	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	document.location.href="<%=request.getContextPath()%>/information/information_surveyadd.shtml";
   	}); 
   	
   	$.subscribe('modify', function(event,data) {
   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	var r = $("#gridtable").jqGrid('getRowData',s);
   	document.location.href="<%=request.getContextPath()%>/information/information_surveymodify.shtml?iaid="+r.iaid;
   	
   	});
   	
   	$.subscribe('delete', function(event,data) {
   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	var r = $("#gridtable").jqGrid('getRowData',s);
   	
   	document.location.href="<%=request.getContextPath()%>/information/information_surveydelete.shtml?iaid="+r.iaid;
   	
   	});
    </script>  
    <div class="grid">   
		<fieldset>
		<legend>
			调查信息查询
		</legend>
		<br>
		<s:form namespace="/information" action="information_surveylist" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<!-- 
			<s:select list="{'调查档案','总行或者兄弟行协查名单','线索来源(主动调查)','线索来源(举报或者专报)','线索来源(司法机关)','线索来源(总行或者兄弟行)','线索移交'}" label="调查信息表单">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{3}" />
			</s:select>
			 -->
			<s:textfield label="审批表编号" name="approvalid" id="approvalid"></s:textfield>
			<s:textfield label="可疑主体名称" name="subjectname" id="subjectname"></s:textfield>
			<s:textfield label="开始时间" name="starttime" id="starttime"></s:textfield>
			<s:textfield label="截止时间" name="endtime" id="endtime"></s:textfield>
			<s:textfield label="函号" name="letterid" id="letterid"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="information_surveylist" id="searchbutton" value="查  询"
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
			onClickTopics="delete" button="true" />
	
		<sj:grid id="gridtable" caption="调查信息列表" dataType="json"
			href="../information/information_surveylist.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="iaid" index="iaid" title="序号" sortable="true"
				width="100" hidden="false" searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="subjectname" index="subjectname" title="主体名称" sortable="false"
				width="160" />
			<sj:gridColumn name="idnumber" index="idnumber" title="证件号" sortable="false"
				width="160" />
			<sj:gridColumn name="orgname" index="orgname" title="金融机构名称" sortable="true"
				width="150" search="true" />
			<sj:gridColumn name="date" index="date" title="日期" sortable="true"
				width="150" />
			<sj:gridColumn name="approvalid" index="approvalid" title="审批编号" sortable="true"
				width="100" />
			<sj:gridColumn name="letterid" index="letterid" title="函号"
				sortable="true" width="150" />
			<sj:gridColumn name="lettertime" index="lettertime" title="发函时间"
				sortable="false" width="150" />
			<sj:gridColumn name="feedbacktime" index="feedbacktime" title="要求反馈时间" sortable="false"
				width="100" />
			<sj:gridColumn name="realtime" index="realtime" title="实际反馈时间" sortable="false"
				width="160" />
		</sj:grid>

	</div>
</body>
