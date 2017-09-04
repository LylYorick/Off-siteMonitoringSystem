<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构监管报表管理>>上报情况列表</title>
</head>
<body>
<script type="text/javascript"> 
        $.subscribe('getselectedhistory', function(event,data) {
    	var s; 
    	s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	alert('Selected Rows : '+s); 
  	});
  	$.subscribe('gotoPage', function(event,data) {
    	var s = $("#gridtable").jqGrid('getGridParam','selrow');
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	window.open("<%=request.getContextPath()%>/report/report_fill.shtml?reportid="+encodeURI(r.name));
    	/**alert('Selected Rows : '+r.name); */
  	});
    </script>     
	<br>
	<div class="grid">
	<fieldset>
		<legend>
			调查信息查询
		</legend>
		<br>
		<s:form namespace="/information" action="information_entry" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:select list="{'调查档案','总行或者兄弟行协查名单','线索来源(主动调查)','线索来源(举报或者专报)','线索来源(司法机关)','线索来源(总行或者兄弟行)','线索移交'}" label="报表名称">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'已提交','未提交','已上报'}" label="报表状态">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'2010','2011','2012'}" label="年份">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select><s:select list="{'第一季度','第二季度','第三季度','第四季度'}" label="季度">
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
	<div  class="ui-state-highlight ui-corner-all">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span> 
				点击相应报表将直接进入该报表的录入界面</p>
	</div>
	<sj:submit id="grid_upload_colsbutton" value="上报选中报表"
			onClickTopics="getselectedhistory" button="true" />
	<sj:submit id="grid_select_colsbutton" value="显示变更记录"
			onClickTopics="getselectedhistory" button="true" />
	<sj:grid id="gridtable" caption="上报情况列表" dataType="json"
			href="../jsontest/test_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="name" index="name" title="报表名称" sortable="true"
				width="500" search="true"
				searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="title" index="title" title="时间" sortable="false"
				width="250" />
			<sj:gridColumn name="age" index="age" title="报表状态" sortable="false"
				width="200" />
			
		</sj:grid>

	</div>
</body>
