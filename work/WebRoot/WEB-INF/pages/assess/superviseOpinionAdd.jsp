
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>资料报备管理>>金融机构上报资料</title>
	<script type="text/javascript">
		$(function(){
			$('#addDoc').click(function(){
			  var $table=$(".wwFormTable tr");
			  var len=$table.length;
	          var newfile = '<tr id='+(len+1)+'><td class="tdLabel" colspan="1"><label for="document_save_documentFile" class="label">待上报的文件<span class="required">(*)</span>:</label><label><a onclick="deltr('+(len+1)+')">删除</a></label></td><td colspan="1"><input type="file" size="40" name="documentFile" value="" id="document_save_documentFile" reg=".*doc|txt|.xls$" tip="允许word,excel,txt文件"/><span >&nbsp;&nbsp;<s:property value="%{getText('documentFile.remark')}" /></span></td></tr>';
			  $('.wwFormTable tr:first').after(newfile);
	        });
      });
     $(function(){
		 $("#return").click(function(){
			 window.history.back();
		 });
	});
      
      	function deltr(index)
	{
		 var $table=$(".wwFormTable tr");
		if(index>$table.length)
			return;
		else
		{
			$("tr[id=\'"+index+"\']").remove();			
			for(var temp=index+1;temp<=$table.length;temp++)
			{
				$("tr[id=\'"+temp+"\']").replaceWith('<tr id='+(temp-1)+'><td class="tdLabel" colspan="1"><label for="document_save_documentFile" class="label">待上报的文件<span class="required">(*)</span>:</label><label><a onclick="deltr('+(temp-1)+')">删除</a></label></td><td colspan="1"><input type="file" size="40" name="documentFile" value="" id="document_save_documentFile"   reg=".*doc|txt|.xls$" tip="允许word,excel,txt文件"/><span >&nbsp;&nbsp;<s:property value="%{getText('documentFile.remark')}" /></span></td></tr>');
			}
		}
	}
	</script>
</head>
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			上传监管意见书
		</legend>
		<br>
		<s:form namespace="/document" action="document_save" method="post" enctype="multipart/form-data">

				<table class="wwFormTable">
					
					<tr>
						<td class="tdLabel" colspan="1"><label class="label">年份:</label>﻿
						</td>
						<td  colspan="1">
							  <input type="text"  style=" background: #EEEEEE;"   readonly="readonly" name="asd" value="2017" id="asd">  
						</td>
					</tr>
					<tr>
						<td class="tdLabel" colspan="1"><label class="label">金融机构名称:</label></td>
						<td colspan="1"><select  style="height:25px; width: 200px; background: #EEEEEE;" disabled="disabled">
								<option value="1">招商银行</option>
								<option value="1">上海商业银行有限公司深圳分行</option>
								<option value="1">华商银行</option>
								<option value="1">方正证券深圳分公司</option>
								<option value="1">浙商证券有限责任公司深圳辖区</option>
								<option value="1">太平人寿保险有限公司深圳分公司</option>
						</select></td>
					</tr>
					<tr>
						<td class="tdLabel" colspan="1"><label
							for="document_save_documentFile" class="label">监管意见书<span
								class="required">(*)</span>:</label>
						</td>
						<td colspan="1"><input type="file" name="documentFile"
							size="40" value="" id="document_save_documentFile" />﻿<span>[说明:上传文件格式为doc,txt,xls,jpg等格式文件]
						</span>
						</td>

					</tr>
				 	<tr>
						<td colspan="2" align="left"  style="color:red;">再次上传同年份同机构的监管意见书将会被替换</td>
					</tr> 
					<tr>
						<td colspan="2" align="center" >
							<input type="submit" id="document_save_0" value="&#25552;    &#20132;" class="ui-button ui-state-default ui-corner-all" />
							<input type="button" id="return" value="返回" class="ui-button ui-state-default ui-corner-all">
							</td>
					</tr>

				</table>
			</s:form>

	</fieldset><br/>
	</div>
</body>
