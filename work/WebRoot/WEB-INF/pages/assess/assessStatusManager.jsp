<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>二级指标管理</title>
	<script type="text/javascript">
     $.subscribe('uploadFiles', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentUpload.shtml";
  	});
  	
    function confirmpass(){
     	$("#confirmButton").click(function(){
     		if($("#flagInput").val()=="backBeforeIndex"){
     			$("#quota").addClass("redTr");
     			$("#quotaLabel").hide();
     			$("#quotaInput").show();
     			$("#quotaCheckbox").show();
     			$("#assess").removeClass("redTr");
     			$("#assessLabel").show();
     			$("#assessInput").hide();
     			$("#assessCheckbox").hide();
     		}else if($("#flagInput").val()=="saveAlter" && $("#quotaCheckbox").is(":checked") ){
     			$("#assessBeginLabel").text("2017年1月5号");
     			$(".alterTextarea").css("color","black");
     		}
     		$("#confirmDiv").hide();
     	})
    }
    function backBeforIndex(){
    	$("#backBeforeIndex").click(function(){
    		$("#flagInput").val("backBeforeIndex");
    		$("#confirmDiv").show();
    	});
  	}
	 function saveAlter(){
	    	$("#saveAlter").click(function(){
	    		$("#flagInput").val("saveAlter");
	    		$("#confirmDiv").show();
	    	});
	  	}
    $(function(){
    	 confirmpass();
    	 backBeforIndex();
    	 saveAlter();
    });
</script>
<style type="text/css">
#confirmDiv {
	position: absolute;
	background:white;
	baz-index: 1000;
	width: 300px;
	height: 150px;
	top: 100px;
	left: calc(50% -   150px);
}
.layer_title{
	padding: 0 80px 0 20px;
    height: 42px;
    line-height: 42px;
    border-bottom: 1px solid #eee;
    font-size: 14px;
    overflow: hidden;
    border-radius: 2px 2px 0 0;
    background-color: #333;
    color: #fff;
}
.redTr td{
	font-weight: bolder;
}
</style> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
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
		<div  class="ui-banner  ui-noBottomboder">
				<input type="button" id="backBeforeIndex" value="退回上级状态" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
				<input type="button" id="saveAlter" value="保存修改" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
		   		<span class="span_left">年度:2017</span>
		</div>
			<table class="wwFormTable " style="width: 100%">
				<tr style="font-weight: bold;">
					<th  style="width:5%;">操作</th>
					<th  style="width:35%;">阶段名</th>
					<th  style="width:30%;">开始时间</th>
					<th  style="width:30%;">结束时间</th>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<label class="label">准备阶段</label>
					</td>
					<td>
						<label class="label">2016年10月1日</label>
					</td>
					<td>
						<label class="label">2016年11月1日</label>
					</td>
				</tr>
				<tr id="quota">
					<td>
						<input type="checkbox" id="quotaCheckbox" style="display: none;">
					</td>
					<td>
						<label class="label">评级标准制定</label>
					</td>
					<td>
						<label class="label">2016年11月2日</label>
					</td>
					<td>
						<label id="quotaLabel" class="label">2016年12月31日</label>
						<input id="quotaInput" type="text" style="display: none;"class="alterTextarea" value="2016年12月31日">
					</td>
				</tr>
				<tr id="assess" class="redTr">
					<td>
						<input type="checkbox" id="assessCheckbox">
					</td>
					<td>
						<label class="label">机构自评</label>
					</td>
					<td>
						<label class="label" id="assessBeginLabel">2017年1月1日</label>
					</td>
					<td>
						<label id="assessLabel" style="display:none;" class="label" >2017年1月10日</label>
						<input id="assessInput"  type="text" class="alterTextarea" value="2017年1月10日">
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<label class="label">初评</label>
					</td>
					<td>
						<label class="label">2017年1月11日</label>
					</td>
					<td>
						<label class="label">2017年2月10日</label>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<label class="label">复评即初评结果公示阶段</label>
					</td>
					<td>
						<label class="label">2017年2月11日</label>
					</td>
					<td>
						<label class="label">2017年2月20日</label>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<label class="label">结果公示</label>
					</td>
					<td>
						<label class="label">2017年2月21日</label>
					</td>
					<td>
						<label class="label"></label>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="confirmDiv" style="display: none;">
		<div>
		<table class="wwFormTable "   >
			<tr style="font-weight: bold;">
					<th  colspan="2">确认密码</th>
				</tr>
				<tr>
					<td style="width: 80px; text-align: right;"><lable class="label">当前账号:</lable></td>
					<td>operate</td>
				</tr>
				<tr>
					<td style="width: 80px; text-align: right;">密码:</td>
					<td><input type="password" style="width:100px;"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input id="confirmButton" type="button" value="确认" class="ui-button ui-widget ui-state-default ui-corner-all" >
						<input type="button" value="取消" class="ui-button ui-widget ui-state-default ui-corner-all" >
					</td>
				</tr>
			</table>
		</div>
	</div>
	<input id="flagInput" value="" style="display: none;">
</body>

