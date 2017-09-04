<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>机构和岗位设立情况录入</title>
		<script type="text/javascript"> 
			
    </script>
</head>
<body>
<script type="text/javascript"> 
   
    </script>     
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			机构和岗位设立情况录入
		</legend>
		<br>
		<s:form namespace="/report" action="report_organizationsave" method="post">
			<tr>
					<td class="slabel">
						反洗钱机构
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
						<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="名称" required="true" name="organdpost.orgname" size="60"></s:textfield>
						</table>
					</td>
				</tr>
			<tr>
					<td class="slabel">
						单位负责人
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
						<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="姓名" required="true" name="organdpost.leadname" size="60"></s:textfield>
							<s:textfield label="职务" required="true" name="organdpost.leadpos" size="60"></s:textfield>
							<s:textfield label="联系电话" required="true" name="organdpost.leadtel" size="60"  reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"></s:textfield>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						反洗钱部门负责人
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="姓名" required="true" name="organdpost.deptlead" size="60"></s:textfield>
							<s:textfield label="联系电话" required="true" name="organdpost.deptleadtel" size="60"  reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"></s:textfield>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						反洗钱人员
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="专职（人数）" required="true" name="organdpost.ftnum" size="60" reg="^\d{1,3}$" tip="只允许输入数字"></s:textfield>
							<s:textfield label="兼职（人数）" required="true" name="organdpost.ptnum" size="60" reg="^\d{1,3}$" tip="只允许输入数字"></s:textfield>
						</table>
					</td>
				</tr>
				  <tr><td colspan="2" align="center">
  <s:hidden name="organdpost.reportswitch.switchid" value="%{switchid}"></s:hidden>
				<s:hidden name="switchid" value="%{switchid}"></s:hidden>
		<s:submit theme="simple" align="center"  value="提 交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
