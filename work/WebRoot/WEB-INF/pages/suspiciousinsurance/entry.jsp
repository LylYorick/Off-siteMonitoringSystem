<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易报告管理>>重点可疑交易管理</title>
</head>
<body>
<script type="text/javascript"> 
    /**页面加载时渲染日期空间*/
  	$(document).ready(function() {
  	 	var dates = $("#starttime, #endtime").datepicker({
  	 		changeMonth: true,changeYear: true,
			onSelect: function(selectedDate) {
				var option = this.id == "starttime" ? "minDate" : "maxDate";
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

    $.subscribe('add', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	document.location.href="<%=request.getContextPath()%>/suspiciousinsurance/suspiciousinsurance_add.shtml";
    	});  
    $.subscribe('insuranceview', function(event,data) { 
	       	var s = $("#gridtable").jqGrid('getGridParam','selrow');
	       	if(s==null){
    	        alert("请选择记录！");
    	        return;
    	    }
    		var r = $("#gridtable").jqGrid('getRowData',s);     
    		//alert(r.siid);		 		
	  		window.location.href="<%=request.getContextPath()%>/suspiciousinsurance/suspiciousinsurance_insuranceview.shtml?id="+r.siid;
	    });    	  
     $.subscribe('getselectedhistory', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	alert('Selected Rows : '+s); 
  	});
    $.subscribe('createxls', function(event,data) {
    	var cname = $("#cname").val();    	
    	var ccid = $("#ccid").val(); 
    	var starttime = $("#starttime").val(); 
    	var endtime = $("#endtime").val(); 
    	var lineid = $("#lineid").val();     	
    	//alert("cname="+cname+" lineid="+lineid+" starttime="+starttime+" endtime="+endtime+" ccid="+ccid);
	  	window.location.href="<%=request.getContextPath()%>/suspiciousinsurance/suspiciousinsurance_downloadinsurance.shtml?ccid="+ccid+"&cname="+cname+"&starttime="+starttime+"&endtime="+endtime+"&lineid="+lineid;
  	});	
    </script>     
	<div class="grid">
		<fieldset>
		<legend>
			重点可疑交易管理（保险业）
		</legend>
		<br>
		<s:form namespace="/suspiciousinsurance" action="suspiciousinsurance_insurancelist" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:textfield label="客户名称" name="cname" id="cname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" /></s:textfield>
			<s:textfield label="证件号码" name="ccid" id="ccid">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" /></s:textfield>
			<s:textfield label="开始时间" name="starttime" id="starttime">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" /></s:textfield>
			<s:textfield label="截止时间" name="endtime" id="endtime">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" /></s:textfield>
			<s:textfield label="线索编号" name="lineid" id="lineid">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" /></s:textfield>
			<s:select label="金融机构" name="oid" list="#informationSet" headerKey="" headerValue="请选择" listKey="oid" listValue="bname" cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
		</s:form>
		<div align="center">
			<sj:submit formIds="suspiciousinsurance_insurancelist" id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effect="highlight" effectOptions="{ color : '#222222' }"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>	
     </fieldset><br/>
		<s:if test="#session.userinfo.information.bname != ''">
		<sj:submit id="grid_add_colsbutton" value="添加可疑交易"
			onClickTopics="add" button="true"/>	
			</s:if>
		<sj:submit id="grid_insuranceview_colsbutton" value="线索信息查询"
			onClickTopics="insuranceview" button="true"/>
	
		<sj:grid id="gridtable" caption="重点可疑交易报告列表" dataType="json"
			href="../suspiciousinsurance/suspiciousinsurance_insurancelist.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="siid" index="siid" title="ID" sortable="false" width="50" hidden="true"/>
			<sj:gridColumn name="BOrgInformation.bname" index="BOrgInformation.bname" title="金融机构名称" sortable="false" width="200"/>
			<sj:gridColumn name="updatetime" index="updatetime" title="报送时间" sortable="false"	width="180" />
			<sj:gridColumn name="lineid" index="lineid" title="线索编号" sortable="false" width="150" />
			<sj:gridColumn name="cname" index="cname" title="客户姓名" sortable="false" width="150" />
			<sj:gridColumn name="clamt" index="clamt" title="本币累计金额" 	sortable="false" width="150" />
			<sj:gridColumn name="cfamt" index="cfamt" title="外币累计金额" sortable="false" width="150" />
		</sj:grid>
	</div>
	
</body>
