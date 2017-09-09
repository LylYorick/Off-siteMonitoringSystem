<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
	<title>监管评分>>人民银行初评管理</title>

	<script type="text/javascript">
		 $.subscribe('firstRate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateList.shtml";
	  	});
	  	 $.subscribe('directRate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_directRate.shtml";
	  	});
	  	 $.subscribe('viewRate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateView.shtml";
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
		    			<input type="text" name="year" value="2017" id="assess_list_year" readonly>﻿
					</td>   
		    		<td class="tdLabel" colspan="1">
		    			<label class="label" >金融机构名称:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;">
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
		<span  class=" span_left ">当前机构类型:法人机构</span>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%;" id="tabel_detail" >
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
					<th width="5%" >
						自评得分
					</th>
					<th  width="10%">
					 	评级得分
					</th>
					<th  width="5%">
						评级等级
					</th>
					<th  width="20%">
						定级理由
					</th>
				</tr>
				<tr>
					<td>
						<sj:submit id="grid_alter_colsbutton1" value="查看" onClickTopics="viewRate" button="true" />
						<sj:submit id="grid_alter_colsbutton" value="评级" onClickTopics="firstRate" button="true" />
						<sj:submit id="direct_colsbutton" value="直接定级" onClickTopics="directRate" button="true" />
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
						E
					</td>
					<td>
						<textarea   class="erji"   readonly="readonly">违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
					
				</tr>
				<tr>
					<td>
						<sj:submit id="grid_alter_colsbutton3" value="查看" onClickTopics="viewRate" button="true" />
						<sj:submit id="grid_alter_colsbutton2" value="评级" onClickTopics="firstRate" button="true" />
						<sj:submit id="direct_colsbutton2" value="直接定级" onClickTopics="directRate" button="true" />
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