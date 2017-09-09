<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>二级指标管理</title>
	<script type="text/javascript">
     $.subscribe('uploadFiles', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentUpload.shtml";
  	});
     
    
</script>
<style type="text/css">
.span_left{
	padding:.4em 1em; 
	height:25px;
	margin:5px 5px 0px 0px;
}

td.ssr{font-size:28px;padding:0px;padding-top:0px;line-height:110% !important;} 
.tableDiv{
	width: 98%; 
	height:95%;
	overflow-x: auto; 
	margin: 10px;
}
.tablesDiv{
	margin:  auto !important;
	width: 100% !important;
	text-align: center;
}
textarea[readonly] {
	background: #DDDDDD;
}
</style> 

</head>
<body>
	<div class="tableDiv">
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
		    			<select style="height:25px;width:200px;">
	    					<option value="1">2017</option>
	    					<option value="1">2018</option>
						</select>﻿
					</td>   
			    	<td  colspan="3">
						<input type="submit" id="searchbutton" value="查  询" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
					</td> 
	        	</tr>
			</tbody>
		</table>
		</s:form>
	</fieldset>
	<div style="overflow: auto; ">
			<table class="wwFormTable tablesDiv" >
				<tr style="font-weight: bold;">
					<th  style="width:20%;">年度</th>
					<th  style="width:20%;">准备阶段</th>
					<th  style="width:20%;">
						评级标准制定阶段
					</th>
					<th  style="width:20%;">
						金融机构自评阶段
					</th>
					<th  style=width:20%;">
						初评阶段
					</th>
					<th  style="min-width: 200px;width:20%;">
						复评即初评结果公示阶段
					</th>
					<th  style="width:20%;">
						 结果公示
					</th>
				</tr>
				<tr>
					<td>
						<label class="label">2017</label>
					</td>
					<td>
						<input type="button"  value="开始年度评级" class="ui-button ui-widget ui-state-default ui-corner-all"  >
					</td>
					<td >
						<input type="button"  value="发布评级表" class="ui-button ui-widget ui-state-default ui-corner-all"  >
					</td>
					<td >
						<input type="button"  value="结束自评" class="ui-button ui-widget ui-state-default ui-corner-all"  >
					</td>
					<td >
						<input type="button"  value="结束初评" class="ui-button ui-widget ui-state-default ui-corner-all"  >
					</td>
					<td>
						<input type="button"  value="结束复评" class="ui-button ui-widget ui-state-default ui-corner-all"  >
					</td>
					<td>
					</td>
					
				</tr>
				
			</table>
		</div>
	</div>
	
	
</body>

