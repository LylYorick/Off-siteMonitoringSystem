<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>异议申请处理</title>

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
td.ssr{font-size:28px;padding:0px;padding-top:0px;line-height:110% !important;} 
textarea[readonly] {
	background: #DDDDDD;
}
</style>
<script type="text/javascript">
     $.subscribe('addApply', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_applyOppositionAdd.shtml";
  	});
     $.subscribe('addAssess', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_applyOppositionForAssess.shtml";
  	});
  
     $(function(){
	  $("#deal").click(function() {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_manageOppositionDeal.shtml";
	  	});  
	  $("#dealAssess").click(function() {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_manageOppositionDealAssess.shtml";
	  	});  
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
		    			<label for="assess_list_year" class="label">机构类型:</label>
					</td> 
					<td colspan="1">
						<select style="height:25px;">
	    					<option value="1">法人金融机构</option>
	    					<option value="1">银行业</option>
	    					<option value="1">证券业</option>
	    					<option value="1">保险业</option>
						</select>
					</td>   
	        	</tr>
	        		<td class="tdLabel" colspan="1">
		    			<label for="assess_list_year" class="label">机构名称:</label>
					</td> 
					<td colspan="1">
						<select style="height:25px;">
	    					<option value="1">上海浦东发展银行股份有限公司</option>
	    					<option value="1">交通银行股份有限公司深圳分行</option>
	    					<option value="1">江苏银行股份有限公司深圳分行</option>
	    					<option value="1">浙商银行深圳分行</option>
						</select>
					</td>  
					<td class="tdLabel" colspan="1">
		    			<label class="label" >状态:</label>﻿
					</td>   
			    	<td  colspan="1">
						<select style="height:25px;">
	    					<option value="1">待处理</option>
	    					<option value="1">已处理</option>
						</select>
					</td> 
	        	<tr>
	        	</tr>
	        	<tr>  
	   		 		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">异议类型:</label>
					</td> 
					<td colspan="1">
						<select style="height:25px;">
	    					<option value="1">二级指标评分异议</option>
	    					<option value="1">评级等级异议</option>
						</select>
					</td>   
					<td class="tdLabel" colspan="1">
					</td> 
					<td colspan="1">
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
	</div>
	<div id="gridtable_pager" style="width:100%; overflow:auto;">
			<table class="wwFormTable" style="width: 100%;min-width: 1450px;">
				<tr style="font-weight: bold;">
					<th style="min-width: 50px;width:5%;">编号</th>
					<th style="min-width: 200px;width:20%;">机构名称</th>
					<th style="min-width: 100px;width:10%;">
						异议类型
					</th>
					<th style="min-width: 200px;width:20%;">
						二级指标名称
					</th>
					<th style="min-width: 50px;width:5%;">
						异议值				
					</th>
					<th style="min-width: 50px;width:10%;">
						期望结果
					</th>
					<th style="min-width: 200px;width:20%;">
						理由
					</th>
					<th style="min-width: 100px;width:10%;" >
						状态
					</th>
					<th style="min-width: 100px;width:10%;" >
						附件
					</th>
					<th  style="min-width: 50px;width:5%;">
					 	处理结果
					</th>
					<th  style="min-width: 100px;width:20%;">
					 	处理理由
					</th>
					<th style="min-width: 100px;width:10%;">
						操作
					</th>
				</tr>
				<tr>
					<td>
						12
					</td>
					<td>
						中国银行股份有限公司深圳市分行
					</td>
					<td>
						评级等级异议
					</td>
					<td  class="ssr" ></td>
					<td>
						E
					</td>
					<td>
						B
					</td>
					<td>
						<textarea rows="3" cols="20" readonly="readonly">本机构认为并没有存在下列任一情形，可以直接评定为E类机构：（1）不配合反洗钱调查工作，拒绝提供信息资料；
						（2）提供信息资料存在重大事项隐瞒、重大信息遗漏、虚假陈述或误导性陈述，情节严重的；（3）存在其他重大问题，严重影响反洗钱调查工作的。希望重新评定为B级。申请材料详见附件</textarea>
					</td>
					<td>
						已处理
					</td>
					<td>
						<sj:submit id="grid_check_colsbutton" value="查看"
						onClickTopics="checkIndex" button="true" />
					</td>
					<td>
						E
					</td>
					<td>
						<textarea rows="3" cols="20" readonly="readonly">重新查看文件后认为依旧违反
						(2)提供信息资料存在重大事项隐瞒、重大信息遗漏、虚假陈述或误导性陈述，情节严重
						因此无法修改评级</textarea>
					</td>
					<td>
						<input type="button" id="dealAssess" value="处理" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
					</td>
				</tr>
				<tr>
				<td>
						13
					</td>
					<td>
						中国银行股份有限公司深圳市分行
					</td>
					<td>
						二级指标评分异议
					</td>
					<td  class="ssr" >总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</td>
					<td>
						18
					</td>
					<td>
						20
					</td>
					<td>
						<textarea rows="3" cols="20" readonly="readonly">本机构认为完全达到此项标准的要求，申请材料详见附件</textarea>
					</td>
					<td>
						待处理
					</td>
					<td>
						<input type="button" id="searchbutton" value="查看" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
						<input type="button" id="deal" value="处理" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
					</td>
				</tr>
			</table>
		</div> 
	</div>
</body>