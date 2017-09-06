<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>人民银行初评管理>>初评明细管理</title>
	<script type="text/javascript">
     $.subscribe('indexadd', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_addTwoClassIndex.shtml";
  	});
     $.subscribe('alterIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_alterTwoClassIndex.shtml";
  	});
     
    
</script>
<style type="text/css">
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}

td.ssr{font-size:28px;padding:0px;padding-top:0px;line-height:1 !important;} 

textarea.erji{width:90%; height:100%;}

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
		<table class="wwFormTable">
	   		 <tbody>
	   		 	<tr>  
	   		 		<!-- <td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">年度:</label>
					</td> 
		    		<td colspan="1">
		    			<input type="text" name="year" value="" id="assess_list_year">﻿
					</td>    -->
			    	<td class="tdLabel" colspan="1">
			    		<label for="bpid" class="label">金融机构类别:</label>
			    	</td> 
		    		<td colspan="1">
	    				<select name="bid" id="bpid" onchange="getsort()">
	    					<option value="1">法人金融机构</option>
	    					<option value="1">银行业</option>
	    					<option value="1">证券业</option>
	    					<option value="1">保险业</option>
						</select>
					</td>
					
	        	</tr>
	        	<tr>  
	   		 		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">一级指标名称:</label>
					</td> 
		    		<td colspan="1">
		    			<input type="text" >﻿
					</td>   
			    	<td class="tdLabel" colspan="1">
			    		<label for="bpid" class="label">二级指标:</label>
			    	</td> 
		    		<td colspan="1">
	    				<input type="text" >
					</td>
	        	</tr>        
			</tbody>
		</table>
		</s:form>
		<div align="center">
			<input type="submit" id="searchbutton" value="查  询"   style="margin-top:7px;" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<img id="indicator" src="/work/images/027.gif" alt="Loading..." style="display: none">
		</div>
	</fieldset>
	<div style="overflow:hidden;">
		<sj:submit id="grid_add_colsbutton" value="新增指标"
			onClickTopics="indexadd" button="true" />
   		<span class=" ui-state-default ui-corner-all span_left">年度:2017</span>
   		<span  class="ui-state-default ui-corner-all span_left">指标类型:法人机构</span>
   		<span  class="ui-state-default ui-corner-all span_left">总分:80分</span>
	</div>
<!-- 	<table id="gridtable" class="wwFormTable"></table>  -->
		<div id="gridtable_pager" style="width:1000px; height:225px; overflow:auto;" >
				<table class="wwFormTable" >
					<tr style="font-weight: bold;">
						<th width="50">序号</th>
						<th width="100">
							一级指标名称
						</th>
						<th width="200">
							一级指标描述
						</th>
						<th width="200" >
						二级指标
						</th>
						<th  width="250">
						评分标准
						</th>
						<th  width="200">
						自评理由要求
						</th>
						<th  width="50" align="center">
						最大分值
						</th>
						<th width="50">
							自评分数
						</th>
						<th width="150">
							自评理由
						</th>
						<th width="100">
							自评附件
						</th>
						<th width="150">
							操作
						</th>
					</tr>
					<tr>
						<td>
							1
						</td>
						<td rowspan="2">
							制度完善程度
						</td>
						<td rowspan="2">
							<textarea  style="width:85%; height:100px;"  readonly="readonly">结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。</textarea>
						</td>
						<td  class="ssr" >总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</td>
						<td>
							<textarea   class="erji"   readonly="readonly">1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>
						</td>
						<td>
							<textarea   class="erji"  readonly="readonly">请重点说明xx年度制度新建、修订和废止情况。</textarea>
						</td>
						<td align="center">
						20
						</td>
						<td align="center">
						18
						</td>
						<td>
						想想就能得90%
						</td>
						<td>
						附件暂无1
						</td>
						<td>
							<sj:submit id="grid_alter_colsbutton" value="修改" onClickTopics="alterIndex" button="true" />
							<input type="submit"  value="删除" class="ui-button ui-widget ui-state-default ui-corner-all" >
						</td>
					</tr>
					<tr>
						<td>
							2
						</td>
						<td class="ssr">
							1总部根据法律法规和监管要求以及本机构业务发展和反洗钱工作实际及时修订或更新内控制度
						</td>
						<td>
							<textarea   class="erji"  readonly="readonly">1.未按法律法规和监管要求及时修订内控制度；2.评级期内推出新业务（产品、服务），未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新；3.评级期内反洗钱工作组织形式或反洗钱工作流程、内容等发生变更，未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新。存在1项扣1分，最多扣3分。</textarea>
						</td>
						<td>
							<textarea   class="erji"  readonly="readonly">请详细说明以下情况：1.评级期内本机构产品、业务是否有变化及具体变化情况；2.评级期内本机构反洗钱工作组织形式或反洗钱工作流程、内容是否有变更及具体变更情况；</textarea>
						</td>
						<td align="center">
						20
						</td>
						<td align="center">
						16
						</td>
						<td>
						我觉得我能得90%
						</td>
						<td>
						附件暂无2
						</td>
						<td>
							<input type="submit"  value="修改" class="ui-button ui-widget ui-state-default ui-corner-all" >
							<input type="submit"  value="删除" class="ui-button ui-widget ui-state-default ui-corner-all" >
						</td>
					</tr>
				</table>
		</div> 
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