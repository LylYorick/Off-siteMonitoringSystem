<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>日志查询>>日志列表</title>
</head>
<body>
	<script type="text/javascript"> 
	/**页面加载时渲染日期空间*/
  	$(document).ready(function() {
  	 	$("#_startdate").datepicker({changeMonth: true,changeYear: true});
  	 	$("#_enddate").datepicker({changeMonth: true,changeYear: true});
	});
	 $.subscribe('complete', function(event,data) { 
    	var myjsongrid = eval("("+event.originalEvent.request.responseText+")");
    	$("#gridtable").trigger("clearGrid"); 
    	$("#gridtable")[0].addJSONData(myjsongrid);
    }); 
    </script>
	<div class="grid">
	<fieldset>
		<legend>
			日志查询
		</legend>
		<br>
		<s:form namespace="/jsonlist" action="log_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:textfield label="操作人名称" name="operatorname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{3}" />
			</s:textfield>
			<s:textfield label="开始日期" name="starttime" id="_startdate"></s:textfield>
			<s:textfield label="截止日期" name="endtime" id="_enddate"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="log_list" id="searchbutton" value="查  询"
				timeout="2500" button="true" indicator="indicator"
				onBeforeTopics="before" onCompleteTopics="complete"
				onErrorTopics="errorState" effect="highlight"
				effectOptions="{ color : '#222222' }" effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>
	</fieldset><br/>

			<sj:grid id="gridtable" caption="上报资料列表" dataType="json"
				href="../jsonlist/log_list.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
				<sj:gridColumn name="logid" index="logid" title="序号" sortable="false" width="50" />
				<sj:gridColumn name="operatorid" index="operatorid" title="操作人ID" sortable="false" width="100" />
				<sj:gridColumn name="operatorname"	index="operatorname" title="操作人名称" sortable="false" width="100" />
				<sj:gridColumn name="operatetype" index="operatetype" title="操作类型" sortable="false" width="100" />
				<sj:gridColumn name="time" index="time" title="操作时间"	sortable="false" width="150" />
				<sj:gridColumn name="operatedetail" index="operatedetail" title="操作明细" sortable="false" width="480" />

			</sj:grid>

		</div>

</body>
