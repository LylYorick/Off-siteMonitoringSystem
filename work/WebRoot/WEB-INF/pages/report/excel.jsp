<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>Excel导入</title>
	<script type="text/javascript">
	  function lock()
	  {
	 //锁
	  $.blockUI({message:'正在导入中,请稍候\n<img src="<%=request.getContextPath()%>/images/029.gif"/>'});
	  }
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
			<legend>
				Excel导入[共有文件:<s:property value="#list.size()"/>个]
			</legend>
			<br>
			<s:form namespace="/report" action="report_excelInsert" method="post" theme="simple">
				<div align="center">
				<s:if test="#list.size!=0">
				<table class="list-table">
					<thead>
								<tr>
									<th>
										文件
									</th>
				<s:iterator value="list" status="index">
					<tr><td><s:property/></td></tr>
				</s:iterator>
				<tr>
				<td colspan="2" align="center">
				<s:submit align="center" value="导 入" theme="simple" onclick="lock()" 
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				</td>
				</tr>
			</table>
			</s:if>
			<s:else>
						<font color="red">没有要导入的文件！</font>
					</s:else>
				</div>
			</s:form>
		</fieldset><br/>
	</div>
</body>
