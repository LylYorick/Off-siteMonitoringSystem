<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->内控制度上报</title>
</head>
<body>
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
    
     $.subscribe('add', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  		window.location.href="<%=request.getContextPath()%>/report/report_innercontrol.shtml?switchid="+<s:property value="switchid"/>;
  		}
  	});
  	 $.subscribe('zero', function(event,data) {
  	      if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  	 	if(window.confirm("确定零记录吗？")){
   			window.location.href="<%=request.getContextPath()%>/report/report_zero.shtml?switchid="+<s:property value="switchid"/>;
    	}
    	}
  	});
     $.subscribe('edit', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
		var s = $("#gridtable").jqGrid('getGridParam','selrow');
       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
   		var r = $("#gridtable").jqGrid('getRowData',s);     		 		
  		window.location.href="<%=request.getContextPath()%>/report/report_innercontrolmodify.shtml?id="+r.id+"&switchid="+<s:property value="switchid"/>;
  	}
  	});
     $.subscribe('del', function(event,data) {
          if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
		var s = $("#gridtable").jqGrid('getGridParam','selrow');
       	if(s==null){
   	        alert("请选择记录！");
   	        return;
   	    }
   		var r = $("#gridtable").jqGrid('getRowData',s);     		 		
  		window.location.href="<%=request.getContextPath()%>/report/report_innercontroldel.shtml?id="+r.id+"&switchid="+<s:property value="switchid"/>;
  	}
  	});
     $.subscribe('import', function(event,data) {
  		window.location.href="<%=request.getContextPath()%>/report/report_innercontrolimport.shtml?switchid="+<s:property value="switchid"/>;
  	});
     $.subscribe('updateuser', function(event,data) {
     	if($.trim($('#report_updateUser_name').val())=='' || $.trim($('#report_updateUser_tel').val())==''){
     		alert("制表人名字或电话不能为空");
     	}else{
	     	var params = {name:$('#report_updateUser_name').val(),tel:$('#report_updateUser_tel').val()};
	     	$.post("<%=request.getContextPath()%>/report/report_updateuser.shtml?switchid="+<s:property value="switchid"/>,params,function(data){
	     		alert(data);
	     		window.location.reload(true);
	     	}
	     	);
     	}
  	});
    </script> 
    <div class="grid">    
		<fieldset>
		<legend>
			内控制度上报
		</legend>
		<br>
		<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						数据类别：
					</td>
					<td>
						A
					</td>
					<td class="tdLabel">
						数据来源：
					</td>
					<td>
						<s:if test="#reportswitch.BOrgInformation.ishead == 0">
						F
					</s:if>
					<s:else>
						Z
					</s:else>
					</td>

				</tr>
				<tr>
					<td class="tdLabel">
						年度：
					</td>
					<td>
						<s:property value="#reportswitch.year"/>
					</td>
					<td class="tdLabel">
						金融机构类别代码：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.bcatid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						填报单位名称：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.bname" />
					</td>
					<td class="tdLabel">
						填报单位机构代码：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.boid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						制表人：
					</td>
					<td>
						<input type="text" name="name" value="<s:property value="#reportswitch.name" />" id="report_updateUser_name"/>
					</td>
					<td class="tdLabel">
						 联系电话：
					</td>
					<td>
						<input type="text" name="tel" value="<s:property value="#reportswitch.tel" />" id="report_updateUser_tel"/>
					</td>
				</tr>
				<tr><td colspan="4" align="center">
					<s:if test="#reportswitch.status == 1">
					<sj:submit id="grid_updateuser_colsbutton" value="保存" onClickTopics="updateuser" button="true" />
					</s:if>
				</td></tr>
			</table>
		
	</fieldset><br/>
	<s:if test="#session.userinfo.information.bname != ''">
		<sj:submit id="grid_add_colsbutton" value="数据新增" onClickTopics="add" button="true" />
		<sj:submit id="grid_edit_colsbutton" value="数据修改" onClickTopics="edit" button="true" />
		<sj:submit id="grid_del_colsbutton" value="数据删除" onClickTopics="del" button="true" />
		<sj:submit id="grid_zero_colsbutton" value="零报告提交" onClickTopics="zero" button="true" />
		<sj:submit id="grid_import_colsbutton" value="数据导入" onClickTopics="import" button="true" />
		</s:if>
		<s:url id="remoteurl" action="report_innerlist.shtml" escapeAmp="false"></s:url>
		<sj:grid id="gridtable" caption="内控制度列表" dataType="json"
			href="%{remoteurl}" pager="true" gridModel="gridModel"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">
			<sj:gridColumn name="id" index="id" title="序号" sortable="true" width="100" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}" />
			<sj:gridColumn name="name" index="name" title="制度名称" sortable="false" width="150" />
			<sj:gridColumn name="content" index="content" title="主要内容" sortable="false" width="330" />
			<sj:gridColumn name="dept" index="dept" title="制定部门" sortable="false" width="100" />
			<sj:gridColumn name="time" index="time" title="制定时间" sortable="false" width="100" />
			<sj:gridColumn name="filenb" index="filenb" title="相关文号" sortable="false" width="150" />
		</sj:grid>
	</div>
</body>
