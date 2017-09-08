<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>二级指标评分异议处理</title>
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
textarea[readonly] {
	background: #DDDDDD;
}
</style>
<script type="text/javascript">
$(function(){

  $("#addApply").click(function() {
    	window.location.href="<%=request.getContextPath()%>/assess/assess_selfAssessmentUpload.shtml";
  	});  
});
   
</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			提出异议申请
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
								for="assess_indexsave_ascdesc" class="label">机构类型:</label>
							</td>
							<td colspan="1">
							<label for="assess_indexsave_ascproject" class="label">法人机构</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascdesc" class="label">机构名称:</label>
							</td>
							<td colspan="1">
							<label for="assess_indexsave_ascproject" class="label">中国银行股份有限公司深圳市分行</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascdesc" class="label">一级指标名称:</label>
							</td>
							<td colspan="1">
								<label for="assess_indexsave_ascproject" class="label">制度完善程度</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">二级指标名称:</label>
							</td>
							<td colspan="1">
								<label for="assess_indexsave_ascproject" class="label">总部内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">原结果:</label>
							</td>
							<td colspan="1">
								<label for="assess_indexsave_ascproject" class="label">2分</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">期望结果:</label>
							</td>
							<td colspan="1">
								<label for="assess_indexsave_ascproject" class="label">3分</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">理由:</label>
							</td>
							<td colspan="1">
								<textarea name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc" readonly="readonly" >本机构认为完全达到此项标准的要求，申请材料详见附件</textarea>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascproject" class="label">附件:</label>
							</td>
							<td colspan="1">
								<input type="button" id="addApply" value="查看附件" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">处理结果<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
								<input type="text"  />
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">处理理由<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
									<textarea name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="button"
								id="assess_indexsave_0" value="提    交"
								class="ui-button ui-state-default ui-corner-all"></td>
						</tr>
					</tbody>
				</table>
			</s:form>
	</fieldset><br/>
	</div>
	
</body>

