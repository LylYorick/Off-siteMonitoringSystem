<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>一级评分列表</title>
	<script type="text/javascript">
	 $.subscribe('indexadd', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_addOneClassIndex.shtml";
  	});
	 $.subscribe('alterIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_alterOneClassIndex.shtml";
  	});
	</script>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
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
	    				<select style="height:25px;">
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
	<div  class="ui-banner  ui-noBottomboder">
		<sj:submit id="grid_add_colsbutton" value="新增指标"
			onClickTopics="indexadd" button="true" />
		<span  class=" span_left ">年度:2017</span>
   		<span  class=" span_left ">指标类型:法人机构</span>
   		<span  class="span_left ">总分:80分</span>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" id="tabel_detail"  style="width: 100%">
			<tr style="font-weight: bold;">
					<th width="20%">
						操作
					</th>
					<th width="5%">序号</th>
					<th width="10%">
						年度
					</th>
					<th width="15%">
						一级指标名称
					</th>
					<th width="40%">
						指标描述
					</th>
					
					<th width="10%">
						分值
					</th>
				
				</tr>
				<tr>
					<td>
						<sj:submit id="grid_alter_colsbutton" value="修改"
						onClickTopics="alterIndex" button="true" />
						<input type="submit"  value="删除" class="ui-button ui-widget ui-state-default ui-corner-all" >
					</td>
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
						结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。
					</td>
					<td>
					20
					</td>
					
				</tr>
					<tr>
					<td>
						<input type="submit"  value="修改" class="ui-button ui-widget ui-state-default ui-corner-all" >
						<input type="submit"  value="删除" class="ui-button ui-widget ui-state-default ui-corner-all" >
					</td>
					<td>
						2
					</td>
					<td>
						2017
					</td>
					<td>
						机制合理性
					</td>
					<td>
					建立有效的反洗钱内部工作机制，运作规范顺畅。重点评价反洗钱机构和岗位设置情况，反洗钱工作体系的运作效率及其规范、合理程度，对可疑交易分析甄别的模式和可行性，建立对新兴业务的风险研判机制等。
					</td>
					<td>
					20
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