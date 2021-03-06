<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>金融机构自评</title>
	<script type="text/javascript">
	 $(function(){
		 $("#return").click(function(){
			 window.history.back();
		 });
	});
     $.subscribe('indexadd', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_addTwoClassIndex.shtml";
  	});
     $.subscribe('alterIndex', function(event,data) {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_alterTwoClassIndex.shtml";
  	});
</script>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="tableDiv">
	<div style="padding: 5px;" class="ui-banner  ui-noBottomboder" >
   		<span class="left_span">年度:2017</span>
   		<span  class="left_span">自评得分:80分</span>
   		<span  class="left_span">评级得分:80分</span>
   		<span  class="left_span">评级等级:B</span>
	</div>
	<div style="overflow: auto; height: 90%">
			<table class="wwFormTable tablesDiv"  id="tabel_detail"  >
				<tr style="font-weight: bold;">
					<th width="50">序号</th>
					<th  width="200">
						自评附件
					</th>
					<th   width="200">
						自评理由
					</th>
					<th   width="50">
						自评得分
					</th>
					<th  width="150">
							评级理由
					</th>
					<th  width="50">
						评级得分
					</th>
					<th    width="50">
						分值
					</th>
					<th   width="200">
					二级指标
					</th>
					<th   width="200">
					评分标准
					</th>
					<th   width="150">
					自评理由要求
					</th>
					<th   width="100">
						一级指标名称
					</th>
						<th  width="150">
						一级指标描述
					</th>
				</tr>
				<tr>
					<td>
						1
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="内控措施.docx">内控措施.docx</a></br>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="各项举措.docx">各项举措.docx</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
					</td>
					<td>
						<textarea readonly="readonly">本机构认为并没有存在下列任一情形，可以直接评定为E类机构：（1）不配合反洗钱调查工作，拒绝提供信息资料；
						（2）提供信息资料存在重大事项隐瞒、重大信息遗漏、虚假陈述或误导性陈述，情节严重的；（3）存在其他重大问题，严重影响反洗钱调查工作的。希望重新评定为B级。申请材料详见附件</textarea>
						</textarea>
					</td>
					<td>
					15
					</td>
					<td>
							<textarea readonly="readonly" >违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
					<td>
					15
					</td>
					<td>
					20 
					</td>
					
					<td  class="ssr" >总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</td>
					<td>
						<textarea  readonly="readonly">1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>
					</td>
					<td>
						<textarea  readonly="readonly">请重点说明xx年度制度新建、修订和废止情况。</textarea>
					</td>
					<td rowspan="2">
						制度完善程度
					</td>
					<td rowspan="2">
						<textarea  readonly="readonly">结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。</textarea>
					</td>
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="人员分配.docx">人员分配.docx</a></br>
					</td>
					<td>
						<textarea readonly="readonly">本机构认为并没有存在下列任一情形，可以直接评定为E类机构：（1）不配合反洗钱调查工作，拒绝提供信息资料；
						（2）提供信息资料存在重大事项隐瞒、重大信息遗漏、虚假陈述或误导性陈述，情节严重的；（3）存在其他重大问题，严重影响反洗钱调查工作的。希望重新评定为B级。申请材料详见附件</textarea>
						</textarea>
					</td>
					<td>
					20
					</td>
					<td>
							<textarea  readonly="readonly">违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
					<td>
						20
					</td>
					<td>
					20
					</td>
					<td class="ssr">
						1总部根据法律法规和监管要求以及本机构业务发展和反洗钱工作实际及时修订或更新内控制度
					</td>
					<td>
						<textarea   readonly="readonly">1.未按法律法规和监管要求及时修订内控制度；2.评级期内推出新业务（产品、服务），未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新；3.评级期内反洗钱工作组织形式或反洗钱工作流程、内容等发生变更，未及时制定或对已有的反洗钱内控制度或相关业务操作规程进行更新。存在1项扣1分，最多扣3分。</textarea>
					</td>
					<td>
						<textarea readonly="readonly">请详细说明以下情况：1.评级期内本机构产品、业务是否有变化及具体变化情况；2.评级期内本机构反洗钱工作组织形式或反洗钱工作流程、内容是否有变更及具体变更情况；</textarea>
					</td>
					
				</tr>
					
			</table>
			<div align="center" style="margin-top:10px;">
				<input type="button" id="return" value="返  回" 
									class="ui-button ui-state-default ui-corner-all">
					<input type="button" id="exportExcel" value="导出excel" 
									class="ui-button ui-state-default ui-corner-all">
			</div>
		</div>
	</div>
	
	
</body>

