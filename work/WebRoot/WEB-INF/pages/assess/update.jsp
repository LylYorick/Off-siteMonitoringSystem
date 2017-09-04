<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分管理>>监管评分</title>
</head>
<body>
	<fieldset>
		<legend>
			评分录入
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_save" method="post"
			cssClass="inputform" theme="simple">
			<table class="wwFormTable">
			<tr>
			<td class="tdLabel">金融机构:</td><td width="35%"><s:property value="#information.bname"/></td>
			<td class="tdLabel">考核年度:</td><td width="35%"><s:textfield name="year" value="2010"/></td>
			</tr>
			</table>
			<br>
			<table class="wwFormTable">
				<tr style="font-weight: bold;">
					<td width="5%">序号</td>
					<td width="15%">
						考核项目
					</td>
					<td width="27%">
						考核细项
					</td>
					<td width="17%">
						备注说明
					</td>
					<td width="6%">
						+极值
					</td>
					<td width="6%">
						-极值
					</td>
					<td width="6%">
						得分
					</td>
					<td width="18%">
						得分说明
					</td>
				</tr>
				<s:iterator value="list" status="index">
					<s:if test="%{ascpid==0}">
								<tr style="font-weight: bold;font-style: italic"><td><s:property value='acsid' /></td><td colspan="7"><s:property value='ascproject' /></td></tr>
					</s:if>
					<s:else>
					<tr>
					<td>
							<s:property value='acsid' />
						</td>
						<td>
							<s:property value='ascproject' />
						</td>
						<td>
							<s:property value='ascdesc' />
						</td>
						<td>
							<s:property value='ascremark' />
						</td>
						<td>
							<s:property value='ascadd' />
						</td>
						<td>
							<s:property value='asccut' />
						</td>
						<td>
							<s:textfield name="%{ascfiled}" size="3" cssClass="num" value="0"></s:textfield>
						</td>
						<td>
							<s:textarea name="input%{ascfiled}" cssStyle="width:90%;height:100%;overflow:hidden" ></s:textarea>
						</td>
					</tr>
					</s:else>
				</s:iterator>
				<tr><td colspan="8" align="center">
				<s:hidden name="oid" value="%{oid}"></s:hidden>
				<s:submit theme="simple" align="center"  value="评分录入" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
			</table>
		</s:form>
	</fieldset><br/>

</body>
