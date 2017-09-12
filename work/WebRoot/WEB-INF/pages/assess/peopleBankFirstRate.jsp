<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
	<title>监管评分>>人民银行初评管理</title>

	<script type="text/javascript">
		 $.subscribe('rate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateList.shtml";
	  	});
	  	<%--  $.subscribe('directRate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_directRate.shtml";
	  	}); --%>
	  	 $.subscribe('view', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateView.shtml";
	  	});
	  	 $.subscribe('processOpposition', function(event,data) {
    		document.location.href="<%=request.getContextPath()%>/assess/assess_manageOppositionList.shtml";
    	});
	  	 $.subscribe('updateOpinion', function(event,data) {
	  		document.location.href="<%=request.getContextPath()%>/assess/assess_superviseOpinionAdd.shtml";
    	});
	  	
	  	
	  	 $(function(){
		        $(':checkbox[type="checkbox"]').each(function(){
		            $(this).click(function(){
		                if($(this).attr('checked')){
		                    $(':checkbox[type="checkbox"]').removeAttr('checked');
		                    $(this).attr('checked','checked');
		                  //  alert(this.id);
		                }
		            });
		        });
		    }); 
		</script>

<style type="text/css">
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}


</style>
</head>
<body>
	<div class="grid">
	<fieldset>
		<legend>
			查询条件
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_list" method="post">
		<table class="wwFormTable" >
	   		 <tbody>
	   		 	<tr>  
	   		 		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">年度:</label>
					</td> 
					<td class="ldLabel" colspan="1" >
		    			<input type="text" name="year" value="2017" id="assess_list_year" >﻿
					</td>   
		    		<td class="tdLabel" colspan="1">
		    			<label class="label" >金融机构名称:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;">
							<option value="1">--请选择--</option>
	    					<option value="1">招商银行</option>
	    					<option value="1">上海商业银行有限公司深圳分行</option>
	    					<option value="1">华商银行</option>
	    					<option value="1">方正证券深圳分公司</option>
	    					<option value="1">浙商证券有限责任公司深圳辖区</option>
	    					<option value="1">太平人寿保险有限公司深圳分公司</option>
						</select>
					</td> 
	        	</tr>
			</tbody>
		</table>
		</s:form>
		<div align="center">
			<input type="submit" id="searchbutton" value="查  询" style="margin-top:7px;" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<img id="indicator" src="/work/images/027.gif" alt="Loading..." style="display: none">
		</div>
	</fieldset>
	<div  class="ui-banner  ui-noBottomboder">
		<sj:submit id="view" value="查看"
			onClickTopics="view" button="true" />
		<sj:submit id="rate" value="评级"
			onClickTopics="rate" button="true" />
		<sj:submit id="directRate" value="直接定级提交"
			onClickTopics="directRate" button="true" />
		<sj:submit id="processOpposition" value="查看/处理异议"
			onClickTopics="processOpposition" button="true" />
		<sj:submit id="updateOpinion" value="上传监管意见书"
			onClickTopics="updateOpinion" button="true" />
		<span  class=" span_left ">当前机构类型:法人机构</span>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%;" id="tabel_detail" >
				<tr style="font-weight: bold;">
					<th width="3%">
						
					</th>
					<th width="3%">
						<input type="checkbox" name="checkbox1" value="checkbox" disabled="disabled">
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
					<th width="5%" >
						自评得分
					</th>
					<th  width="5%">
					 	评级得分
					</th>
					<th  width="5%">
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
						<input type="checkbox" name="checkbox1" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						法人机构
					</td>
					<td>
						上海商业银行有限公司深圳分行
					</td>
					<td>
						机构自评
					</td>
					<td>
						80
					</td>
				
					<td>
					</td>
					<td>
						<input class="alterTextarea" type="text" style="width: 20px;" value="E">
					</td>
					<td>
						<textarea   class="textarea alterTextarea" >违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="监管意见书">监管意见书</a>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="整改报告">整改报告</a>
					</td>
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
						<input type="checkbox" name="checkbox1" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						法人机构
					</td>
					<td>
						浙商证券有限责任公司深圳辖区
					</td>
					<td>
						机构自评
					</td>
					<td>
						90
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
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