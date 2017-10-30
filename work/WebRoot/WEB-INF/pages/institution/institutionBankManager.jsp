<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
	<title>监管评分>>人民银行初评管理</title>

	<script type="text/javascript">
		$(document).ready(function() {
	  	 	$("#starttime").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
	  	 	$("#endtime").datepicker({changeMonth: true,changeYear: true,beforeShow: customRange});
	  	 	 // Customize two date pickers to work as a date range
	        function customRange(input) {
	            return {minDate: (input.id == 'endtime' ? $('#starttime').datepicker('getDate') : null),
	                maxDate: (input.id == 'starttime' ? $('#endtime').datepicker('getDate') : null)};
	        }
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
	    					<option value="1">渤海银行深圳分行</option>
	    					<option value="1">浙商证券有限责任公司深圳辖区</option>
	    					<option value="1">太平人寿保险有限公司深圳分公司</option>
						</select>
					</td> 
	        	</tr>
	        	<tr>
	        		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">上传开始时间:</label>
					</td> 
					<td class="ldLabel" colspan="1" >
						<input type="date" value="2016-10-24" id="start_time" />
					</td>   
					<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">上传结束时间:</label>
					</td> 
					<td class="ldLabel" colspan="1" >
						<input type="date" value="2017-10-24" id="end_time" />
					</td>   
	        	</tr>
	        	<tr>
	        		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">机构类型:</label>
					</td> 
					<td colspan="1">
	    				<select >
	    					<option value="1">法人机构-银行业</option>
	    					<option value="1">法人机构-证券业</option>
	    					<option value="1">法人机构-保险业</option>
	    					<option value="1">银行业</option>
	    					<option value="1">证券业</option>
	    					<option value="1">保险业</option>
						</select>
					</td>
					<td></td><td></td> 
	        	</tr>
	        	
			</tbody>
		</table>
		</s:form>
		<div align="center">
			<input type="submit" id="searchbutton" value="查  询" style="margin-top:7px;" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<img id="indicator" src="/work/images/027.gif" alt="Loading..." style="display: none">
		</div>
	</fieldset>
<%-- 	<div  class="ui-banner  ui-noBottomboder">
		<sj:submit id="view" value="查看"
			onClickTopics="view" button="true" />
		<sj:submit id="rate" value="评级"
			onClickTopics="rate" button="true" />
	</div> --%>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%;" id="tabel_detail" >
				<tr style="font-weight: bold;">
					<th width="3%">
						
					</th>
					<th width="3%">
						<input type="checkbox" id="checkbox" name="checkbox" value="checkbox" disabled="disabled">
					</th>
					<th width="5%">年度</th>
					<th width="10%">
						机构类型
					</th>
					<th width="20%">
						机构名称
					</th>
					<th width="10%">
						机构编号
					</th>
					<th width="10%" >
						最后上传时间
					</th>
					<th width="20%">
						附件
					</th>
				</tr>
				<tr>
					<td>
						1
					</td>
					<td>
						<input type="checkbox"  id="checkbox1"  name="checkbox1" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						上海商业银行有限公司深圳分行
					</td>
					<td>
						8429847243
					</td>
					<td>
						2017-08-01
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
					</td>
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
						<input type="checkbox"  id="checkbox2"  name="checkbox2" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						渤海银行深圳分行
					</td>
					<td>
						469275464-4
					</td>
					<td>
						2017-08-23
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
					</td>
				</tr>
				<tr>
					<td>
						3
					</td>
					<td>
						<input type="checkbox"  id="checkbox3"  name="checkbox3" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						平安银行总行
					</td>
					<td>
						4624582048
					</td>
					<td>
						2017-04-23
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
					</td>
				</tr>
				<tr>
					<td>
						4
					</td>
					<td>
						<input type="checkbox"  id="checkbox4"  name="checkbox4" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						华商银行
					</td>
					<td>
						6201983744
					</td>
					<td>
						2017-11-01
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
					</td>
				</tr>
				
				<tr>
					<td>
						5
					</td>
					<td>
						<input type="checkbox"  id="checkbox5"  name="checkbox5" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						广东发展银行深圳分行
					</td>
					<td>
						1038472847
					</td>
					<td>
						2017-03-11
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
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