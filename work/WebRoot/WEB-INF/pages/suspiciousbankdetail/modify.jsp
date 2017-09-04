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
			银行业可疑交易明细信息修改
		</legend>
		<br>
		<s:form namespace="/suspiciousbankdetail" action="suspiciousbankdetail_update" method="post"  enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			
			<s:hidden name="did" value="%{#info.did}"></s:hidden>
			<s:hidden name="BBankBase.id" value="%{#info.BBankBase.id}"></s:hidden>			
            <s:textfield label="金融机构名称" required="true" name="bname" value="%{#info.bname}" readonly="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="账号" required="true" name="account" value="%{#info.account}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>			
			<s:textfield label="交易日期" name="trandate" value="%{#info.trandate}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易方式" name="tranmethod" value="%{#info.tranmethod}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="涉外收支交易分类与代码" name="fid" value="%{#info.fid}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
				
			</s:textfield>
			<s:textfield label="资金收付标志" name="rorp" value="%{#info.rorp}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="资金来源和用途" name="use" value="%{#info.use}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="对方金融机构网点名称" name="ooname" value="%{#info.ooname}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="对方金融机构网点行政区域代码" name="ooid" value="%{#info.ooid}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易对手账号" name="otaccount" value="%{#info.otaccount}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易对方身份证件/证明文件类型" name="ottype" value="%{#info.ottype}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易对方身份证件/证明文件号码" name="otid" value="%{#info.otid}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易对手姓名或名称" name="otname" value="%{#info.otname}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="币种" name="currency" value="%{#info.currency}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="交易额（按原币计）" name="lamt" value="%{#info.lamt}" required="true">
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />				
			</s:textfield>
			<s:textfield label="交易额（折合美元）" name="fmat" value="%{#info.fmat}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />	
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />			
			</s:textfield>
			<s:textfield label="业务标示号" name="tid" value="%{#info.tid}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="代办人姓名" name="agname" value="%{#info.agname}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="代办人身份证件/证明文件号码" name="agid" value="%{#info.agid}" required="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
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
