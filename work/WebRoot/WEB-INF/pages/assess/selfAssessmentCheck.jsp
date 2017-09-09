<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>二级指标管理</title>
	<script type="text/javascript">
     $.subscribe('indexadd', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_addTwoClassIndex.shtml";
  	});
     $.subscribe('alterIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_alterTwoClassIndex.shtml";
  	});
     
     $(function(){
		 $("#return").click(function(){
			 window.history.back();
		 });
	});
</script>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="tableDiv">
	<div style="padding: 5px;" class="ui-banner  ui-noBottomboder">
   		<span  class="left_span">年度:2017</span>
   		<span  class="left_span">机构类型:法人机构</span>
   		<span  class="left_span">机构名称:中国银行股份有限公司深圳市分行</span>
   		<span  class="left_span">状态:退回修改</span>
   		<span  class="left_span">自评总分:90分</span>
   		<span  class="left_span">自评得分:80分</span>
	</div>
	<div style="overflow: auto; height: 90%">
			<table class="wwFormTable tablesDiv" id="tabel_detail">
				<tr style="font-weight: bold;">
					<th  style="min-width: 40px;width:5%;">序号</th>
					<th   align="center" style="min-width:100px; width:10%;">
						附件
					</th>
					<th   align="center" style="min-width:100px; width:10%;">
					 	 复核拒绝理由
					</th>
					<th   align="center" style="min-width: 80px;width:10%;">
						自评得分
					</th>
					<th   align="center" style="min-width:150px;width:15%;">
						自评理由
					</th>
					<th   align="center" style="min-width: 40px;width:5%;">
						分值
					</th>
					<th  style="min-width: 160px;width:20%;">
					二级指标
					</th>
					<th  style="min-width: 200px;width:25%;">
					评分标准
					</th>
					<th  style="min-width: 100px;width:10%;">
						自评理由要求
					</th>
					<th  style="min-width: 80px;width:10%;">
						一级指标名称
					</th>
					<th  style="min-width: 80px;width:10%;">
						一级指标描述
					</th>
				</tr>
				<tr>
					<td>
						1
					</td>
						<td>
						<sj:submit id="grid_alter_colsbutton" value="查看附件" onClickTopics="uploadFiles" button="true" />
					</td>
					<td>
						<textarea rows="3" cols="10" ></textarea>
					</td>
					<td align="center">
						<label class="label">20</label>
					</td>
					<td>
						<textarea rows="3" cols="20" readonly="readonly">1. 2017完成建立客户身份的识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料等制度
						2.保存了交易记录、、绩效考核、责任追究以及协助反洗钱调查</textarea>
					</td>
					<td>
					20
					</td>
				
					<td  class="ssr" >总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</td>
					<td>
						<textarea rows="3" cols="30" readonly="readonly">1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>
					</td>
					<td>
						<textarea rows="3" cols="10" readonly="readonly">请重点说明xx年度制度新建、修订和废止情况。</textarea>
					</td>
					<td rowspan="2">
						制度完善程度
					</td>
					<td rowspan="2">
						<textarea rows="7" cols="10"  readonly="readonly">结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。</textarea>
					</td>
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
					<input type="button" value="查看附件" class="ui-button ui-widget ui-state-default ui-corner-all" > 
					</td>
					<td>
						<textarea rows="3" cols="10" ></textarea>
					</td>
					<td>
					</td>
					<td>
					<label class="lable"></label>
					</td>
					<td>
					20
					</td>
					
					<td class="ssr">
						1总部根据法律法规和监管要求以及本机构业务发展和反洗钱工作实际及时修订或更新内控制度
					</td>
					<td>
						<textarea rows="3" cols="30"   readonly="readonly">1.未按法律法规和监管要求及时修订内控制度；2.评级期内推出新业务（产品、服务），未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新；3.评级期内反洗钱工作组织形式或反洗钱工作流程、内容等发生变更，未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新。存在1项扣1分，最多扣3分。</textarea>
					</td>
					<td>
						<textarea rows="3" cols="10"   readonly="readonly">此项无需自评</textarea>
					</td>
				</tr>
			</table>
			<div align="center" style="margin-top:10px;">
				<input type="button" id="searchbutton" value="保存" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" >
				<input type="submit" id="searchbutton" value="复核通过" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
				<input type="submit" id="searchbutton" value="复核拒绝" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
				<input type="button" id="return" value="返回" 
									class="ui-button ui-state-default ui-corner-all">
			</div>
		</div>
	</div>
	
	
</body>

