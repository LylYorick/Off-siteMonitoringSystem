<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>二级指标管理>>修改二级指标</title>

<style type="text/css">
	
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}
select{
	width:150px;
	height: 25px;	
}
textarea {
	text-align:left;
}
</style>
<script type="text/javascript">

$(function(){
 $("#noSelf").click(function(){
 	if($(this).attr("checked") == true){
 		$("#request").hide();
 	}
 });
 $("#needSelf").click(function(){
 	if($(this).attr("checked") == true){
 		$("#request").show();
 	}
 });
  $("#return").click(function(){
		 window.history.back();
	 });
});

</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			修改二级指标
		</legend>
		<br>
		<s:form namespace="/assess" method="post">
				<table class="wwFormTable">
					<tbody>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascproject" class="label">年度:</label>
							</td>
							<td colspan="1"><label
								for="assess_indexsave_ascproject" class="label">2017年</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascdesc" class="label">指标类型<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<label for="assess_indexsave_ascproject" class="label">法人机构</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascdesc" class="label">一级指标名称<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<select>
		    					<option value="1">制度完善程度</option>
		    					<option value="1">机制合理性</option>
		    					<option value="1">技术保障能力</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">一级指标描述<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1"><label class="label" style="width:300px;">结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。
									</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">二级指标名称<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc" >总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</textarea>﻿
							</td>
							
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">评分标准<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc" >1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">是否允许自评<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
								<input id="needSelf" type="radio" name="identity" value="0" checked="checked" />需要自评
								<input id="noSelf" type="radio" name="identity" value="1" />无需自评﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">自评理由要求<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea id="request" name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc" ></textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascproject" class="label">分值:</label>
							</td>
							<td colspan="1"><input type="text" name="ascadd" value="20"
								id="assess_indexsave_ascadd">分
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="button"
								id="assess_indexsave_0" value="提    交"
								class="ui-button ui-state-default ui-corner-all">
							<input type="button" id="return" value="返  回" 
									class="ui-button ui-state-default ui-corner-all">
							</td>
						</tr>
					</tbody>
				</table>
			</s:form>
	</fieldset><br/>
	</div>
	
</body>

