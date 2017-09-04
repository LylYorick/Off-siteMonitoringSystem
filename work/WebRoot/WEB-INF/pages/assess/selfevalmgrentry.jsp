<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>评分列表</title>
	<script type="text/javascript">
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
	  	<%-- $.subscribe('add', function(event,data) { 
	  	    var s = $("#gridtable").jqGrid('getGridParam','selrow');
	  	    if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
    		var r = $("#gridtable").jqGrid('getRowData',s);
	  		window.location.href="<%=request.getContextPath()%>/assess/assess_add.shtml?oid="+r.oid+"&year="+r.xxyear;
	    }); --%>
	  	$.subscribe('view', function(event,data) { 
	       	var s = $("#gridtable").jqGrid('getGridParam','selrow');
	       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
    		var r = $("#gridtable").jqGrid('getRowData',s);
	  		window.location.href="<%=request.getContextPath()%>/assess/assess_view.shtml?oid="+r.oid+"&year="+r.xxyear+"&selfevalflag=b";
	    });
	     	$(getsort);   
function getsort(){   
    var cid=$("#bpid").val();   
    var time=new Date();   
    $.ajax({   
        cache:false,   
        url:'<%=request.getContextPath()%>/financial/financial_findInformation.shtml',   
        type:'post',   
        dataType:'json',   
        data:{cid:cid,t:time},   
        success:update_c   
    });   
}
function update_c(json){
   var sort=json.informationSet;   
   var cbanner=json.bname;   
   var s_root=document.getElementById('bannerid');   
   s_root.options.length=0;   
      var option = document.createElement("option");    
   option.text="---请选择---";   
   option.value="9999";   
   s_root.options[s_root.options.length] =option;  
   for(var i in sort){   
       var option = document.createElement("option");   
       var value=sort[i].oid;      
       var text=sort[i].bname;   
           option.text=text;   
           option.value=value;   
           s_root.options[s_root.options.length] =option;   
   }   
}
	</script>
</head>
<body>
	<div class="grid">
	<fieldset>
		<legend>
			查询条件
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_list" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<s:select list="#list" label="金融机构类别" id="bpid" name="bid"
				listKey="bid" listValue="catname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'--请选择--'}" label="金融机构名称" id="bannerid" name="oid"
				cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield name="year" label="年度">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:select name="level" label="等级" list="#{'':'--请选择--','A':'A','B':'B','C':'C','D':'D'}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:hidden name="selfevalflag" value="b"></s:hidden><!-- 用来告诉后台是：自评指标 -->
			<!--<s:select list="#alist" label="指标项" name="acsid" listKey="acsid"
				listValue="ascproject" headerKey="0" headerValue="所有指标">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{3}" />
			</s:select>
		--></s:form>
		<div align="center">
			<sj:submit formIds="assess_list" id="searchbutton" value="查  询"
				timeout="2500" button="true" indicator="indicator"
				onBeforeTopics="before" onCompleteTopics="complete"
				onErrorTopics="errorState" effect="highlight"
				effectOptions="{ color : '#222222' }" effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>
	</fieldset><br/>
		<%-- <sj:submit id="grid_add_colsbutton" value="进 入 评 分"
			onClickTopics="add" button="true" /> --%>
		<sj:submit id="grid_view_colsbutton" value="评 分 明 细"
			onClickTopics="view" button="true" />
		<sj:grid id="gridtable" caption="金融机构自评列表" dataType="json"
			href="../assess/assess_list.shtml?selfevalflag=b" pager="true"
			gridModel="gridModelassess" rowList="10,15,20" rowNum="20"
			rownumbers="true" viewrecords="true" multiselect="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
			<sj:gridColumn name="oid" index="oid" title="机构序号" sortable="false"
				width="70" />
			<sj:gridColumn name="bname" index="bname" title="银行名称"
				sortable="false" width="450" />
			<sj:gridColumn name="xxyear" index="xxyear" title="年度" sortable="false"
				width="150" />
			<sj:gridColumn name="score" index="score" title="分数"
				formatter="checkNum" sortable="false" width="150" />
			<sj:gridColumn name="level" index="level" title="等级"
				 sortable="false" width="150" />
		</sj:grid>
	</div>
	<script type="text/javascript">
		function checkNum(cellvalue, options, rowObject) { 
			if(cellvalue>=80){
				return "<span style='color:green;'>"+cellvalue+"</span>";
				}else if(cellvalue>50){
					return "<span style='color:red'>"+cellvalue+"</span>";
				}else{
					return "<span style='color:blue;font-weight:bold'>"+cellvalue+"</span>";
				}
        } 
	</script>
</body>
