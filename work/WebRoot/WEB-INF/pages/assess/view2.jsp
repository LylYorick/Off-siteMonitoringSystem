<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分管理>>评分查看</title>
	<script type="text/javascript">
		
	</script>
</head>
<body>
		<fieldset>
		<legend>
			评分查看
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_print" method="post"
			cssClass="inputform" theme="simple">
			<table class="wwFormTable">
			<tr>
			<td class="tdLabel">金融机构:</td><td width="35%"><s:property value="#information.bname"/></td>
			<td class="tdLabel">考核年度:</td><td width="35%"><s:property value="year"/></td>
			</tr>
			</table>
			<br>
			<table class="wwFormTable">
				<tr style="font-weight: bold;">
					<th width="5%">序号</th>
					<th width="20%" >
						考核项目
					</th>
					<th width="30%">
						考核细项
					</th>
					<th width="17%">
						备注说明
					</th>
					<th width="8%">
						自评得分
					</th>
					<th width="20%">
						得分说明
					</th>
				</tr>
				<s:iterator value="list" status="index" var="l">
					<s:if test="%{#l[7]==0}">
								<tr style="font-weight: bold;font-style: italic"><td><s:property value='#l[0]' /></td><td colspan="6"><s:property value='#l[1]' /></td></tr>
					</s:if>
					<s:else>
					<tr>
					<td>
							<s:property value="#l[0]"/>
						</td>
						<td>
							<s:property value="#l[1]"/>
						</td>
						<td>
							<s:property value="#l[2]"/>
						</td>
						<td>
							<s:property value="#l[3]"/>
						</td>
						<td>
							<s:property value="#l[4]"/>
						</td>
						<td>
							<s:property value="#l[8]"/>
						</td>
					</tr>
					</s:else>
				</s:iterator>
				<tr><td colspan="6" align="center">
				<!--<s:submit theme="simple" align="center"  value="打印" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			--></td></tr>
			</table>
		</s:form>
	</fieldset><br/>
</body>
