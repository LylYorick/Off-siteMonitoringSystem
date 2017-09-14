<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
	<title>监管评分>>人民银行初评管理>>初评明细管理</title>
	<script type="text/javascript">
     $.subscribe('updateFile', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentUpload.shtml";
  	});
     $(function(){
		 $("#return").click(function(){
			 window.history.back();
		 });
	});
</script>
<style type="text/css">


</style> 

</head>
<body>
	<div class="tableDiv">
	<div class="ui-banner  ui-noBottomboder">
		<sj:submit id="updateFile" value="上传异议附件"
			onClickTopics="updateFile" button="true" />
   		<span class="span_left">年度:2017</span>
   		<span  class="span_left">机构类型:银行业</span>
	</div>
		<div id="gridtable_pager" style=" height:90%; overflow:auto;" >
				<table class="wwFormTable" id="tabel_detail" >
					<tr style="font-weight: bold;">
						<th width="50">序号</th>
						<th width="50">操作</th>
						<th width="100">
							异议附件
						</th>
						<th width="50">
							期望值
						</th>
						<th width="150">
							异议理由
						</th>
						<th width="80">
							异议类型
						</th>
						<th width="80">
							异议值
						</th>
						<th width="80">
							自评得分
						</th>
						<th  width="50" align="center">
							分值
						</th>
						<th width="200" >
						 	二级指标
						</th>
						<th  width="250">
							评分标准
						</th>
						<th width="100">
							一级指标名称
						</th>
						<th width="200">
							一级指标描述
						</th>
					</tr>
					<tr>
						<td>
							0
						</td>
						<td>
							<input type="checkbox">
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/images/123.docx" download="异议附件0">异议附件0</a>
						</td>
						<td align="center">
							<input type="text" style="width:35px"  name="asd" value="A" id="asd" >
						</td>
						<td>
							<textarea   class="erji"  ></textarea>
						</td>
						<td>
							等级异议
						</td>
						<td align="center">
							E﻿
						</td>
						<td align="center">
							80
						</td>
						<td align="center">
							100
						</td>
						<td ></td>
						<td>
						</td>
						<td >
						</td>
						<td >
						</td>
					</tr>
					<tr>
						<td>
							1
						</td>
						<td>
							<input type="checkbox">
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/images/123.docx" download="异议附件1">异议附件1</a>
						</td>
						<td align="center">
							<input type="text" style="width:35px"  name="asd" value="18" id="asd" >
						</td>
						<td>
							<textarea   class="erji"  ></textarea>
						</td>
						<td>
							评分异议
						</td>
						<td align="center">
							15﻿
						</td>
						<td align="center">
							15﻿
						</td>
						<td align="center">
							20
						</td>
						
						<td  class="ssr" >总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</td>
						<td>
							<textarea   class="erji"   readonly="readonly">1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>
						</td>
						<td rowspan="2">
							制度完善程度
						</td>
						<td rowspan="2">
							<textarea  style="width:85%; height:100px;"  readonly="readonly">结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。</textarea>
						</td>
					</tr>
					<tr>
						<td>
							2
						</td>
						<td>
							<input type="checkbox">
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/images/123.docx" download="异议附件2">异议附件2</a>
						</td>
						<td align="center">
							<input type="text" style="width:35px"  name="asdf" value="16" id="asdf" >
						</td>
						<td>
						<textarea   class="erji"  ></textarea>
						</td>
						<td>
							评分异议
						</td>
						<td align="center">
							15
						</td>
						<td align="center">
						</td>
						<td align="center">
							20
						</td>
						<td class="ssr">
							1总部根据法律法规和监管要求以及本机构业务发展和反洗钱工作实际及时修订或更新内控制度
						</td>
						<td>
							<textarea   class="erji"  readonly="readonly">1.未按法律法规和监管要求及时修订内控制度；2.评级期内推出新业务（产品、服务），未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新；3.评级期内反洗钱工作组织形式或反洗钱工作流程、内容等发生变更，未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新。存在1项扣1分，最多扣3分。</textarea>
						</td>
					</tr>
				</table>
				<table  align="center">
					<tr align="center">
						<td colspan="2" align="center">	
						<input type="button" id="searchbutton" value="保存" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
						<input type="button" id="searchbutton" value="提交" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
						<input type="button" id="return" value="返回" class="ui-button ui-state-default ui-corner-all">
						</td>
					</tr>
				</table>
		</div> 
	</div>
</body>

	