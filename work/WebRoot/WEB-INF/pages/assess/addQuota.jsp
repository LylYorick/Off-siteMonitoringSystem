<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>指标管理>>新增指标</title>
	<style type="text/css">

	select{
		width:150px;
		height: 25px;	
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
	 parentCheckboxChange();
	});
	function parentCheckboxChange(){
		var obj =$("#parentCheckbox");
		if(obj.val() == "0"){
			$(".twoClassIndex").hide();
		}
		$("#parentCheckbox").change(function(){
			if($(this).val()=="0"){
				//如果是一级指标s
				$(".twoClassIndex").hide();
				$("#quotaDescription").removeAttr("readonly");
				$("#quotaDescription").css("back-ground","#FFF");
				$("#quotaDescription").text("");
			}else{
			//如果是二级指标
				$("#quotaDescription").attr("readonly","readonly");
				$("#quotaDescription").css("back-ground","#DDD");
				$("#quotaDescription").text("结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性");
				$(".twoClassIndex").show();
			}
		});
	}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			新增指标
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
								<label for="assess_indexsave_ascproject" class="label">银行业</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascdesc" class="label">父级指标名称<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<select id="parentCheckbox">
								<option value="0">根项目</option>
		    					<option value="1">制度完善程度</option>
		    					<option value="1">机制合理性</option>
		    					<option value="1">技术保障能力</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">指标名称<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
								<textarea class="textarea"></textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">指标描述<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea id="quotaDescription" class="textarea">
							</textarea>
									
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">评分标准<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea  class="textarea twoClassIndex"></textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">是否允许自评<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
								<div class="twoClassIndex">
									<input id="needSelf" type="radio" name="identity" value="0" checked="checked" />需要自评
									<input id="noSelf" type="radio" name="identity" value="1" />无需自评﻿
								</div>
							</td>
						</tr>
						<tr>
							<td class="tdLabel " colspan="1"><label
								for="assess_indexsave_ascadd" class="label">自评理由要求<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1">
							<textarea id="request" class="textarea twoClassIndex"></textarea>﻿
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascproject" class="label">分值:</label>
							</td>
							<td colspan="1"><input type="text" class="twoClassIndex">
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

