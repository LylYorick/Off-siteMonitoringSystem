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
	          var newfile = '<tr id='+(len+1)+'><td class="tdLabel" colspan="1"><label for="document_save_documentFile" class="label">待上传的附件<span class="required">(*)</span>:</label><label><a onclick="deltr('+(len+1)+')">删除</a></label></td><td colspan="1"><input type="file" size="40" name="documentFile" value="" id="document_save_documentFile" reg=".*doc|txt|.xls$" tip="允许word,excel,txt文件"/><span >&nbsp;&nbsp;<s:property value="%{getText('documentFile.remark')}" /></span></td></tr>';
			  $('.wwFormTable tr:first').after(newfile);
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
				$("tr[id=\'"+temp+"\']").replaceWith('<tr id='+(temp-1)+'><td class="tdLabel" colspan="1"><label for="document_save_documentFile" class="label">待上传的附件<span class="required">(*)</span>:</label><label><a onclick="deltr('+(temp-1)+')">删除</a></label></td><td colspan="1"><input type="file" size="40" name="documentFile" value="" id="document_save_documentFile"   reg=".*doc|txt|.xls$" tip="允许word,excel,txt文件"/><span >&nbsp;&nbsp;<s:property value="%{getText('documentFile.remark')}" /></span></td></tr>');
			}
		}
	}
	  $(function(){
		 $("#return").click(function(){
			 window.history.back();
		 });
	});
	</script>
</head>
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			金融机构上传附件
		</legend>
		<br>
		<s:form namespace="/document"  method="post" enctype="multipart/form-data">
			
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="" />
			</s:bean>
			
			<s:file name="documentFile" label="待上传的附件" required="true" size="40" >
				<s:param name="remark" value="%{getText('documentFile.remark')}" />
			</s:file>
			<tr id="alreadyUpload">  
			    <td class="tdLabel" colspan="1"><label for="assess_selfAssessmentUpload_documentFile" class="label" >已上传的附件:</label><label><a onclick="deltr('alreadyUpload')">删除</a></label></td> 
			    <td colspan="1" >
			    	<a href="/work/images/123.docx" download="制度体系.docx">制度体系.docx</a>
				</td>  
			</tr>
			<tr id="alreadyUpload2">  
			    <td class="tdLabel" colspan="1"><label for="assess_selfAssessmentUpload_documentFile" class="label" >已上传的附件:</label><label><a onclick="deltr('alreadyUpload2')">删除</a></label></td> 
			    <td colspan="1" >
			    	<a href="<%=request.getContextPath()%>/images/123.docx" download="内控措施.docx">内控措施.docx</a>
				</td>  
			</tr>
			<tr><td colspan="2" align="center">
			<input type="button" value="新增附件" id="addDoc" class="ui-button ui-state-default ui-corner-all">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			
			<input type="button" id="return" value="返回" class="ui-button ui-state-default ui-corner-all">
			</td>
			</tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
