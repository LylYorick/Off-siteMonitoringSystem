<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>台账管理</title>
		<script type="text/javascript">
  	$.subscribe('add', function(event,data) { 
	  		window.location.href="<%=request.getContextPath()%>/financial/financial_taiadd.shtml?oid="+<s:property value="oid"/>;
	    });
	      	$.subscribe('modify', function(event,data) { 
	       	var s = $("#gridtable").jqGrid('getGridParam','selrow');
	       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
    		var r = $("#gridtable").jqGrid('getRowData',s);    		
	  		window.location.href="<%=request.getContextPath()%>/financial/financial_taimodify.shtml?taidi="+r.taidi;
	    });
	</script>
</head>
<body>
	<div class="grid">
			<sj:submit id="grid_selectbase_colsbutton" value="台账新增"
			onClickTopics="add" button="true" />
			<sj:submit id="grid_select_colsbutton" value="台账修改"
			onClickTopics="modify" button="true" />
			<s:url id="remoteurl" action="../financial/financial_tailist.shtml"/> 
<sj:grid id="gridtable" caption="台账列表" dataType="json"
			href="%{remoteurl}" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
			<sj:gridColumn name="taidi" index="taidi" title="ID" sortable="false"  width="70"/>
			<sj:gridColumn name="taidate" index="taidate" title="日期" sortable="false" width="100" />
			<sj:gridColumn name="taiauthor" index="taiauthor" title="修改人" sortable="false" width="100" />
			<sj:gridColumn name="taireason" index="taireason" title="事由" sortable="false" width="600" />
		</sj:grid>
	</div>
</body>
