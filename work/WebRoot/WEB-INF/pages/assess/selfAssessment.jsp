<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>金融机构自评管理</title>

<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
     $.subscribe('view', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_listSelfAssessment.shtml";
  	});
     $.subscribe('rate', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentDo.shtml";
  	});
     $.subscribe('checkRate', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentCheck.shtml";
  	});
  	 $.subscribe('applyOpposition', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_manageOppositionApply.shtml";
  	});
     $.subscribe('viewOpposition', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_manageOppositionBankList.shtml";
  	});
     $.subscribe('uploadReport', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_rectificationReportAdd.shtml";
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
	
	<div  class="ui-banner  ui-noBottomboder">
		<sj:submit id="view" value="查看"
			onClickTopics="view" button="true" />
		<sj:submit id="rate" value="自评"
			onClickTopics="rate" button="true" />
		<sj:submit id="checkRate" value="复核"
			onClickTopics="checkRate" button="true" />
		<sj:submit id="applyOpposition" value="提出异议"
			onClickTopics="applyOpposition" button="true" />
		<sj:submit id="viewOpposition" value="异议处理情况"
			onClickTopics="viewOpposition" button="true" />
		<sj:submit id="uploadReport" value="上传整改报告"
			onClickTopics="uploadReport" button="true" />
	</div>
	
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable"  id="tabel_detail" style="width: 100%;">
				<tr style="font-weight: bold;">
					<th width="5%">
						序号
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
					<th  width="10%">
						监管意见书
					</th>
					<th  width="10%">
						整改报告
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
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="监管意见书">监管意见书</a>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="整改报告">整改报告</a>
					</td>
				</tr>
			</table>
	
	</div>
	
	
</body>
