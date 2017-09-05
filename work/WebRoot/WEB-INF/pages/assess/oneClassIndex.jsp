<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>一级评分列表</title>
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
		<table class="wwFormTable">
	   		 <tbody>
	   		 	<tr>  
	   		 		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">年度:</label>
					</td> 
		    		<td colspan="1">
		    			<input type="text" name="year" value="" id="assess_list_year">﻿
					</td>   
			    	<td class="tdLabel" colspan="1">
			    		<label for="bpid" class="label">金融机构类别:</label>
			    	</td> 
		    		<td colspan="1">
	    				<select name="bid" id="bpid" onchange="getsort()">
	    					<option value="1">法人金融机构</option>
	    					<option value="1">银行业</option>
	    					<option value="1">证券业</option>
	    					<option value="1">保险业</option>
						</select>
					</td>  
	        	</tr>      
			</tbody>
		</table>
		</s:form>
		<div align="center">
			<input type="submit" id="searchbutton" value="查  询" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<img id="indicator" src="/work/images/027.gif" alt="Loading..." style="display: none">
		</div>
	</fieldset>
	<div style="overflow:hidden;">
		<input type="submit"  value="新增指标" class="ui-button ui-widget ui-state-default ui-corner-all" >
   		<span style="float:right; padding:.4em 1em; " class=" ui-state-default ui-corner-all">年度:2017</span>
   		<span style="float:right; padding:.4em 1em; " class=" ui-state-default ui-corner-all">指标类型:法人机构</span>
   		<span style="float:right; padding:.4em 1em; " class=" ui-state-default ui-corner-all">总分:80分</span>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%">
				<tr style="font-weight: bold;">
					<th width="5%">序号</th>
					<th width="10%">
						一级指标名称
					</th>
					<th width="15%">
						一级指标描述
					</th>
					<th width="20%" >
					二级指标
					</th>
					<th  width="25%">
					评分标准
					</th>
					<th  width="10%">
					分值
					</th>
					<th width="15%">
						操作
					</th>
				</tr>
				<tr>
					<td>
						1
					</td>
					<td>
						2017
					</td>
					<td>
						制度完善程度
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					20
					</td>
					<td>
						<input type="submit"  value="修改" class="ui-button ui-widget ui-state-default ui-corner-all" >
						<input type="submit"  value="删除" class="ui-button ui-widget ui-state-default ui-corner-all" >
					</td>
				</tr>
					
			</table>
	
	</div>
	
	
</body>

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