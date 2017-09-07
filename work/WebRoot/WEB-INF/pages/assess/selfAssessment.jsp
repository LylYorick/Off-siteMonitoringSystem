<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>金融机构自评管理</title>

<style type="text/css">
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}
td{
	text-align:center;
}
</style>
<script type="text/javascript">
     $.subscribe('listIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_listSelfAssessment.shtml";
  	});
     $.subscribe('doIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentDo.shtml";
  	});
     $.subscribe('checkIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentCheck.shtml";
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
		    			<label class="label" >状态:</label>﻿
					</td>   
			    	<td  colspan="1">
						<select style="height:25px;">
	    					<option value="1">机构自评</option>
	    					<option value="1">自评待复核</option>
	    					<option value="1">待初评</option>
	    					<option value="1">初评中</option>
	    					<option value="1">复评中</option>
	    					<option value="1">结果发布</option>
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
   		<span class=" ui-state-default ui-corner-all span_left">年度:2017</span>
   		<span  class="ui-state-default ui-corner-all span_left">当前机构类型:法人机构</span>
   		<span  class="ui-state-default ui-corner-all span_left">总分:80分</span>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%;">
				<tr style="font-weight: bold;">
					<th width="5%">年度</th>
					<th width="10%">
						机构类型
					</th>
					<th width="20%">
						机构名称
					</th>
					<th width="10%">
						状态
					</th>
					<th width="10%" >
						自评总分
					</th>
					<th width="10%" >
						自评得分
					</th>
					<th  width="10%">
					 	人民银行评分总分
					</th>
					<th  width="10%">
					 	人民银行评分得分
					</th>
					<th  width="10%">
						人民银行评级
					</th>
					<th width="15%">
						操作
					</th>
				</tr>
				<tr>
					<td>
						2017
					</td>
					<td>
						法人机构
					</td>
					<td>
						中国银行股份有限公司深圳市分行
					</td>
					<td>
						机构自评
					</td>
					<td>
						90
					</td>
					<td>
						80
					</td>
					<td>
						100
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
						<sj:submit id="grid_list_colsbutton" value="查看"
						onClickTopics="listIndex" button="true" />
						<sj:submit id="grid_do_colsbutton" value="自评"
						onClickTopics="doIndex" button="true" />
						<sj:submit id="grid_check_colsbutton" value="复核"
						onClickTopics="checkIndex" button="true" />
					</td>
				</tr>
			</table>
	
	</div>
	
	
</body>
