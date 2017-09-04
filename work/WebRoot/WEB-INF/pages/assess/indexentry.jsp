<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>指标管理</title>
</head>
<body>
<script type="text/javascript">
     $.subscribe('indexadd', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_indexadd.shtml";
  	});
     
     $.subscribe('indexmodify', function(event,data) {
    	var s = $("#gridtable").jqGrid('getGridParam','selrow');
 	    if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	window.location.href="<%=request.getContextPath()%>/assess/assess_indexmodify.shtml?acsid="+r.acsid;
  	});
</script><br>
<div class="grid">

	<sj:submit id="grid_add_colsbutton" value="新增指标"
			onClickTopics="indexadd" button="true" />
	<sj:submit id="grid_edit_colsbutton" value="修改指标"
			onClickTopics="indexmodify" button="true" />

		<sj:grid id="gridtable" caption="评分指标列表" dataType="json"
			href="../assess/assess_indexlist.shtml" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">	
			<sj:gridColumn name="acsid" index="acsid" title="序号"
				sortable="true" width="40" search="true"
				searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="ascproject" index="ascproject" title="考核项目"
				sortable="false" width="250" />
			<sj:gridColumn name="ascdesc" index="ascdesc" title="考核细项" sortable="false"
				width="500" />
			<sj:gridColumn name="ascadd" index="ascadd" title="加分极值"
				sortable="false" width="60" />
			<sj:gridColumn name="asccut" index="asccut" title="减分极值"
				sortable="false" width="60" />
			<sj:gridColumn name="ascfiled" index="ascfiled" title="字段名"
				sortable="false" width="45" />
		</sj:grid>

	</div>
</body>
