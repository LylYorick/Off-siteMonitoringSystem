<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>二级指标管理</title>
	<script type="text/javascript">
     $.subscribe('indexadd', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_addQuota.shtml";
  	 });
     $.subscribe('alterIndex', function(event,data) {
     	if(confirm("是否保存选中修改?")){
     	 $(".alterTextarea").css("color","black");
     	}
  	});
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
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
			    		<label for="bpid" class="label">机构类别:</label>
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
	<div  class="ui-banner  ui-noBottomboder">
		<sj:submit id="grid_alter_colsbutton" value="保存修改" onClickTopics="alterIndex" button="true" />
		<input type="submit"  value="删除" class="ui-button ui-widget ui-state-default ui-corner-all" >
		<sj:submit id="grid_add_colsbutton" value="新增指标"
			onClickTopics="indexadd" button="true" />
   		<span  class="span_left">总分:80分</span>
   		<span  class="span_left">机构类型:银行业</span>
   		<span class="span_left">年度:2017</span>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%" id="tabel_detail">
				<tr style="font-weight: bold;">
					<th width="3%">序号</th>
					<th width="3%">
						操作
					</th>
					<th width="20%">
						指标名称
					</th>
					<th width="20%">
						指标描述
					</th>
					<th  width="20%">
					    评分标准
					</th>
					<th  width="5%">
					    是否允许自评
					</th>
					<th  width="15%">
						自评理由要求
					</th>
					<th  width="5%" align="center">
						分值
					</th>
				</tr>
					<tr>
					<td>
						1
					</td>
					<td>
					<input type="checkbox" >
					</td>
					<td >
						<textarea  class="textarea alterTextarea" >1制度完善程度</textarea>
					</td>
					<td >
						<textarea class="textarea alterTextarea" >结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。</textarea>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
					<input type="checkbox" >
					</td>
					<td  class="ssr" >
					<textarea   class="textarea alterTextarea">1.1总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</textarea></td>
					<td></td>
					<td>
						<textarea class="textarea alterTextarea">1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>
					</td>
					<td>
					<input type="checkbox" name="allow" class="alterCheckbox" checked="checked"><label id="allowLabel">是</label>
					</td>
					<td>
						<textarea class="textarea alterTextarea" id="allowTextarea">请重点说明xx年度制度新建、修订和废止情况。</textarea>
					</td>
					<td>
						<input class="alterTextarea gradeInput"  value="20">
					</td>
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
						<input type="checkbox" >
					</td>
				
					<td>
						<textarea  class="textarea alterTextarea" >1.2未按法律法规和监管要求及时修订内控制度；2.评级期内推出新业务（产品、服务），未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新；3.评级期内反洗钱工作组织形式或反洗钱工作流程、内容等发生变更，未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新。存在1项扣1分，最多扣3分。</textarea>
					</td>
					<td>
					</td>
					<td>
						<textarea  class="textarea alterTextarea">1.2总部根据法律法规和监管要求以及本机构业务发展和反洗钱工作实际及时修订或更新内控制度</textarea>
					</td>
					<td>
					<input type="checkbox" name="allow" checked="checked"><label id="allowLabel">是</label>
					</td>
					<td>
						<textarea class="textarea alterTextarea">请详细说明以下情况：1.评级期内本机构产品、业务是否有变化及具体变化情况；2.评级期内本机构反洗钱工作组织形式或反洗钱工作流程、内容是否有变更及具体变更情况；</textarea>
					</td>
					<td>
						<input class="alterTextarea gradeInput"  value="20">
					</td>
				</tr>
			</table>
	
	</div>
	
	
</body>
