<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构信息录入</title>
		<script type="text/javascript">

	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构信息录入
			</legend>
			<br>
			<s:form namespace="/financial" action="financial_save" method="post" target="_self">
				<tr>
					<td class="slabel">
						金融机构基本信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:hidden name="oid" value="%{#info.oid}"></s:hidden>
							<s:hidden name="bcatid" value="%{#info.bcatid}"></s:hidden>
							<s:hidden name="boid" value="%{#info.boid}"></s:hidden>
							<s:hidden name="bmininame" value="%{#info.bmininame}"></s:hidden>
							<s:hidden name="ishead" value="%{#info.ishead}"></s:hidden>
							<s:hidden name="BOrgCatalog.bid" value="%{#info.BOrgCatalog.bid}"></s:hidden>

							<s:textfield label="金融机构名称" required="true" name="bname"
								value="%{#info.bname}" size="60" reg="^[\s|\S]{1,100}$" tip="不能为空">
								<s:param name="labelcolspan" value="%{1}" />
								<s:param name="inputcolspan" value="%{1}" />
							</s:textfield>
							<s:textfield label="办公地址" required="true" name="baddr"
								value="%{#info.baddr}" size="60">
							</s:textfield>
							<s:textfield label="深圳分支机构数量" required="true" name="bbrchnum"  reg="^\d{1,3}$" tip="只允许输入数字"
								value="%{#info.bbrchnum}">
								<s:param name="remark" value="%{getText('documentField.integer')}" />
							</s:textfield>
							<s:textfield label="反洗钱工作联系人" name="bwork" value="%{#info.bwork}">
							</s:textfield>
							<s:textfield label="联系人办公电话" required="true" name="bworktel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bworktel}">
							</s:textfield>
							<s:textfield label="联系人手机号码" required="true" name="bworkphe" reg="^\d{11}$" tip="只允许输入11位数字"
								value="%{#info.bworkphe}">
							</s:textfield>
							<s:textfield label="传真" required="true" name="bfax"
								value="%{#info.bfax}">
							</s:textfield>
							<s:textfield label="员工人数" required="true" name="bworknum" reg="^\d{1,6}$" tip="只允许输入数字"
								value="%{#info.bworknum}">
								<s:param name="remark" value="%{getText('documentField.integer')}" />
							</s:textfield>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						反洗钱部门信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>

							<s:textfield label="反洗钱部门" required="true" name="bdept"
								value="%{#info.bdept}">
							</s:textfield>
							<s:textfield label="反洗钱部门负责人" required="true" name="bdeptlead"
								value="%{#info.bdeptlead}">
							</s:textfield>
							<s:textfield label="办公电话" required="true" name="bdeptleadtel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bdeptleadtel}">
							</s:textfield>
							<s:textfield label="手机号码" required="true" name="bdeptleadphe" reg="\d{11}$" tip="只允许输入11位数字"
								value="%{#info.bdeptleadphe}">
							</s:textfield>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						分管领导信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="反洗钱分管领导" required="true" name="blead"
								value="%{#info.blead}">
							</s:textfield>
							<s:textfield label="分管领导职务" required="true" name="bleadpst"
								value="%{#info.bleadpst}">
							</s:textfield>
							<s:textfield label="分管领导联系电话" required="true" name="bleadtel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bleadtel}">
							</s:textfield>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						上年度资产
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="上年度总资产" required="true" name="blastamt"
								value="%{#info.blastamt}">
								<s:param name="remark" value="%{getText('documentField.number')}" />
							</s:textfield>
							<s:textfield label="上年度税后净利润" required="true" name="blastnet"  reg="^(\-|\+)?\d+(\.\d+)?$" tip="只能输入数值"
								value="%{#info.blastnet}">
								<s:param name="remark" value="%{getText('documentField.number')}" />
							</s:textfield>							

						</table>
					</td>
				</tr>
				<tr align="center">
				<td colspan="2">
					<s:submit theme="simple" align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				</td>
				</tr>
			</s:form>

		</fieldset><br/>
	</div>
</body>
