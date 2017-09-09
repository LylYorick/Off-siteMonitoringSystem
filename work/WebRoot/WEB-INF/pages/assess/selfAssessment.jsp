<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>金融机构自评管理</title>

<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
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
		<div align="center" style="margin-top:7px;">
			<input type="submit" id="searchbutton" value="查  询" class="ui-button ui-widget ui-state-default ui-corner-all gap" role="button" aria-disabled="false">
		</div>
	</fieldset>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable"  id="tabel_detail" style="width: 100%;">
				<tr style="font-weight: bold;">
					<th width="15%">
						操作
					</th>
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
					 	评级得分
					</th>
					<th  width="10%">
						评级等级
					</th>
					<th  width="20%">
						定级理由
					</th>
					
				</tr>
				<tr>
					<td>
						<sj:submit id="grid_list_colsbutton" value="查看"
						onClickTopics="listIndex" button="true" />
						<sj:submit id="grid_do_colsbutton" value="自评"
						onClickTopics="doIndex" button="true" />
						<sj:submit id="grid_check_colsbutton" value="复核"
						onClickTopics="checkIndex" button="true" />
					</td>
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
						<textarea class="erji" readonly="readonly">违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
				</tr>
			</table>
	
	</div>
	
	
</body>
