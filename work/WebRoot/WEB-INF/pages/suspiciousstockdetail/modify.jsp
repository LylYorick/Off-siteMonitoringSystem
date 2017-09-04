<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易报告管理>>银行业可疑交易明细信息修改</title>
</head>
<body>
    <script type="text/javascript"> 
   
    </script>     
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			证券业可疑交易明细信息修改<input id="sj" type="hidden" />
		</legend>
		<br>
		<s:form namespace="/suspiciousstockdetail" action="suspiciousstockdetail_update" method="post"  enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			
			<s:hidden name="dsid" value="%{#info.dsid}"></s:hidden>
			<s:hidden name="BStockBase.sid" value="%{#info.BStockBase.sid}"></s:hidden>			
            <s:textfield label="金融机构名称" required="true" name="organname" value="%{#organname}" readonly="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="资金/结算账户开户行名称" required="true" name="bname" value="%{#info.bname}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>			
			<s:textfield label="证券/基金/期货账号" name="stockaccount" value="%{#info.stockaccount}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>	
			<s:textfield label="资金账号" required="true" name="moneyaccount" value="%{#info.moneyaccount}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>			
			<s:textfield label="结算账号" name="payaccount" value="%{#info.payaccount}" required="true">
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
			<s:textfield label="交易品种代码" name="ttype" value="%{#info.ttype}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="业务标示号" name="tid" value="%{#info.tid}" required="true">
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
			<s:textfield label="资金进出方向" name="rorp" value="%{#info.rorp}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="资金进出方式" name="rorpmtd" value="%{#info.rorpmtd}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="经办人/交易指示人姓名或名称" name="agname" value="%{#info.agname}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="经办人/交易指示人身份证号码" name="agid" value="%{#info.agid}" required="true">
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
