<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>一级指标管理>>新增一级指标</title>

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
			新增二级指标
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
								for="assess_indexsave_ascdesc" class="label">机构类型<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<label for="assess_indexsave_ascproject" class="label">法人金融机构</label>
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
										id="assess_indexsave_ascdesc" ></textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">评分标准<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc" ></textarea>﻿
							</td>
						</tr>
							<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">自评理由要求<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea name="ascdesc" cols="50" rows="5"
									id="assess_indexsave_ascdesc" ></textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascproject" class="label">分值:</label>
							</td>
							<td colspan="1"><input type="text" name="ascadd" value=""
								id="assess_indexsave_ascadd">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
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

