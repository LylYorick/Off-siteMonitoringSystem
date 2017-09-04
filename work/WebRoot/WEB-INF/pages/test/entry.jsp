<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构查询</title>
</head>
<body>
<script type="text/javascript"> 
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
    </script>     
	<br>
	<div style="width: 1020px; margin: auto;" class="grid">
		<fieldset>
		<legend>
			金融机构查询
		</legend>
		<br>
		<s:form namespace="/jsontest" action="test_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:select list="{'银行业','保险业','证券业','信托','其他'}" label="金融机构类别">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'工商银行','农业银行','建设银行'}" label="金融机构名称">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			
		</s:form>
		<div align="center">
			<sj:submit formIds="test_list" id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effect="highlight" effectOptions="{ color : '#222222' }"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>

	</fieldset><br/>
			<sj:submit id="grid_edit_colsbutton" value="显示/隐藏列"
			onClickTopics="显示/隐藏列" button="true" />
		<sj:submit id="grid_select_colsbutton" value="显示变更记录"
			onClickTopics="getselectedhistory" button="true" />
		<sj:submit id="grid_export_colsbutton" value="导出到Excel"
			onClickTopics="导出到Excel" button="true" href="<%=request.getContextPath()%>/bulletin_list.shtml" loadingText="正在导出..."/>
	
		<sj:grid id="gridtable" caption="金融机构列表" dataType="json"
			href="../jsontest/test_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="15" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="name" index="name" title="名称" sortable="true"
				width="150" search="true"
				searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="title" index="title" title="头衔" sortable="false"
				width="150" />
			<sj:gridColumn name="age" index="age" title="年龄" sortable="false"
				width="100" />
			<sj:gridColumn name="company" index="company" title="国家"
				sortable="false" width="150" />
			<sj:gridColumn name="address" index="address" title="地址"
				sortable="false" width="150" />
			<sj:gridColumn name="tel" index="tel" title="电话" sortable="false"
				width="110" />
			<sj:gridColumn name="email" index="email" title="邮件" sortable="false"
				width="160" />
		</sj:grid>

	</div>
</body>
