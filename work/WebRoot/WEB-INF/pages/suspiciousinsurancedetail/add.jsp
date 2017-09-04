<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易报告管理>>保险业可疑交易明细信息录入</title>
</head>
<body>
<script type="text/javascript"> 
    
    </script>     
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			保险业可疑交易明细信息录入
		</legend>
		<br>
		<s:form namespace="/suspiciousinsurancedetail" action="suspiciousinsurancedetail_save" method="post"  enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			
			<s:hidden name="BInsuranceBase.siid" value="%{#id}"></s:hidden>
            <s:textfield label="金融机构名称" required="true" name="organname" value="%{#info.bname}" readonly="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易日期" name="trandate" value="%{#info.trandate}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易种类" name="tranmethod" value="%{#info.tranmethod}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>	
			<s:textfield label="资金账户开户行" required="true" name="bname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>			
			<s:textfield label="银行转账资金账号" name="iaccount" value="%{#info.iaccount}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>	
			<s:textfield label="币种" name="currency" value="%{#info.currency}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易额（按原币计）" name="lamt" value="%{#info.lamt}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />	
			</s:textfield>
			<s:textfield label="交易额（折合美元）" name="fmat" value="%{#info.fmat}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />	
			</s:textfield>
			<s:textfield label="资金进出方式" name="rorpmethod" value="%{#info.rorpmethod}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="资金进出方向" name="rorp" value="%{#info.rorp}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="经办人名称" name="agname" value="%{#info.agname}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="经办人号码" name="agid" value="%{#info.agid}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textarea label="备注" name="remark" required="true" value="%{#info.remark}" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />				
			</s:textarea>
					
			<tr><td colspan="6" align="center">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
