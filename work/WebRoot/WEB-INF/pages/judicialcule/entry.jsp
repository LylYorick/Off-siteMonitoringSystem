<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>线索来源(司法机关)查询</title>
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
   	document.location.href="<%=request.getContextPath()%>/judicialcule/judicialcule_add.shtml";
   	}); 
   	$.subscribe('modify', function(event,data) {
   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	var r = $("#gridtable").jqGrid('getRowData',s);
   	document.location.href="<%=request.getContextPath()%>/judicialcule/judicialcule_modify.shtml?jsid="+r.jsid;
   	});
   	
   	$.subscribe('delete', function(event,data) {
   	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
   	var r = $("#gridtable").jqGrid('getRowData',s);
   	document.location.href="<%=request.getContextPath()%>/judicialcule/judicialcule_delete.shtml?jsid="+r.jsid;
   	});
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			线索来源司法机关查询
		</legend>
		<br>
		<s:form namespace="/judicialcule" action="judicialcule_list" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:textfield label="案件总编号" name="jid" id="jid"></s:textfield>
			<s:textfield label="调查名称" name="surveyname" id="surveyname"></s:textfield>
			<s:textfield label="开始时间" name="starttime" id="starttime"></s:textfield>
			<s:textfield label="截止时间" name="endtime" id="endtime"></s:textfield>
			<s:textfield label="来函单位" name="unit" id="unit"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="judicialcule_list" id="searchbutton" value="查  询"
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
	
		<sj:grid id="gridtable" caption="线索来源司法机关信息列表" dataType="json"
			href="../judicialcule/judicialcule_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="jsid" index="jsid" title="序号" sortable="true"
				width="100" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}" />
				<sj:gridColumn name="subjectname" index="subjectname" title="主体名称" sortable="false"
				width="110" />
			<sj:gridColumn name="idnumber" index="idnumber" title="证件号" sortable="false"
				width="110" />
			<sj:gridColumn name="jid" index="jid" title="案件总编号" sortable="false"
				width="150" />
			<sj:gridColumn name="surveyname" index="researchname" title="调查名称" sortable="false"
				width="100" />
			<sj:gridColumn name="involvenum" index="involvenum" title="涉及账户数"
				sortable="false" width="150" />
			<sj:gridColumn name="unit" index="unit" title="来函单位"
				sortable="false" width="150" />
			<sj:gridColumn name="date" index="date" title="来函时间" sortable="false"
				width="110" />
			<sj:gridColumn name="sponsor" index="sponsor" title="来函单位主办人" sortable="false"
				width="160" />
			<%-- 
			<sj:gridColumn name="amountSituation" index="amountSituation" title="涉案金额（元）、立案情况" sortable="false"
				width="110" />
			<sj:gridColumn name="isinvolved" index="isinvolved" title="是否涉案" sortable="false"
				width="110" />
			<sj:gridColumn name="letterid" index="letterid" title="立案决定书编号" sortable="false"
				width="110" />
			<sj:gridColumn name="antisponsor" index="antisponsor" title="反洗钱处主办人" sortable="false"
				width="110" />
			<sj:gridColumn name="paymentletterid" index="paymentletterid" title="支付处查询书编号" sortable="false"
				width="110" />
			<sj:gridColumn name="investigation" index="investigation" title="向异地人民银行协查" sortable="false"
				width="110" />
			<sj:gridColumn name="approvalno" index="approvalno" title="反洗钱调查审批表编号" sortable="false"
				width="110" />
			<sj:gridColumn name="finaname" index="finaname" title="涉及的金融机构名称" sortable="false"
				width="110" />
			<sj:gridColumn name="finannum" index="finannum" title="涉及金融机构数" sortable="false"
				width="110" />
			<sj:gridColumn name="sendresearch" index="sendresearch" title="向金融机构发出反洗钱调查通知书" sortable="false"
				width="110" />
			<sj:gridColumn name="accountnum" index="accountnum" title="调查通知书账户数" sortable="false"
				width="110" />
			<sj:gridColumn name="feedbackdata" index="feedbackdata" title="我行反馈时间" sortable="false"
				width="110" />
			<sj:gridColumn name="feedbackno" index="feedbackno" title="反馈资料文书号" sortable="false"
				width="110" />
			<sj:gridColumn name="dealresult" index="dealresult" title="处理结果" sortable="false"
				width="110" />
			<sj:gridColumn name="recordeno" index="recordeno" title="存档案号" sortable="false"
				width="110" />
			<sj:gridColumn name="notes" index="notes" title="备注" sortable="false"
				width="110" />--%>
				</sj:grid>
	</div>
</body>
