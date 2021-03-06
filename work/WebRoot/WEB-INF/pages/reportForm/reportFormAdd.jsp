<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>制度管理>>金融机构上传制度</title>
	<script type="text/javascript">
		$(function(){
			$('#addDoc').click(function(){
			  var $table=$(".wwFormTable tr");
			  var len=$table.length;
	          var newfile = '<tr id='+(len+1)+'><td class="tdLabel" colspan="1"><label for="reportForm_save_reportFormFile" class="label">待上传的附件<span class="required">(*)</span>:</label><label><a onclick="deltr('+(len+1)+')">删除</a></label></td><td colspan="1"><input type="file" size="40" name="reportFormFile" value="" id="reportForm_save_reportFormFile" reg=".*doc|txt|.xls$" tip="允许word,excel,txt文件"/><span >&nbsp;&nbsp;<s:property value="%{getText('documentFile.remark')}" /></span></td></tr>';
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
				$("tr[id=\'"+temp+"\']").replaceWith('<tr id='+(temp-1)+'><td class="tdLabel" colspan="1"><label for="reportForm_save_reportFormFile" class="label">待上传的附件<span class="required">(*)</span>:</label><label><a onclick="deltr('+(temp-1)+')">删除</a></label></td><td colspan="1"><input type="file" size="40" name="reportFormFile" value="" id="reportForm_save_reportFormFile"   reg=".*doc|txt|.xls$" tip="允许word,excel,txt文件"/><span >&nbsp;&nbsp;<s:property value="%{getText('documentFile.remark')}" /></span></td></tr>');
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
		<s:form namespace="/reportForm"  action="reportForm_save" method="post" enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:label label="金融机构名称" required="true" name="#session.userinfo.archives.bname" cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:label>
			<s:file name="reportFormFile" label="待上传的附件" required="true" size="40" >
				<s:param name="remark" value="%{getText('documentFile.remark')}" />
			</s:file>
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
