<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>一级指标管理>>新增一级指标</title>

<script type="text/javascript">
	$(function(){
	
	 $("#return").click(function(){
		 window.history.back();
	 });
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
			新增二级指标
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_indexsave" method="post">
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
								for="assess_indexsave_ascproject" class="label">金融机构类别:</label>
							</td>
							<td colspan="1"><label
								for="assess_indexsave_ascproject" class="label">法人机构</label>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascdesc" class="label">一级指标名称<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1"><input type="text" name="ascadd" value=""
								id="assess_indexsave_ascadd">﻿<span> </span>
							</td>
						</tr>
						<tr>
							<td class="tdLabel" colspan="1"><label
								for="assess_indexsave_ascadd" class="label">一级指标描述<span
									class="required">(*)</span>:</label>
							</td>
							<td colspan="1"><textarea name="ascdesc" cols="40" rows="8"
									id="assess_indexsave_ascdesc"></textarea>﻿<span> </span>
							</td>
							
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								id="assess_indexsave_0" value="提 交"
								class="ui-button ui-state-default ui-corner-all">
								<input type="button" id="return" value="返 回" 
									class="ui-button ui-state-default ui-corner-all">
							</td>
						</tr>
					</tbody>
				</table>
			</s:form>

	</fieldset><br/>
	</div>
	
</body>

