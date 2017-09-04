<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易报告管理>>证券业重点可疑交易信息录入</title>
</head>
<body>
<script type="text/javascript"> 
    
    </script>     
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			证券业重点可疑交易信息录入<input id="sj" type="hidden" />
		</legend>
		<br>
		<s:form namespace="/suspiciousstock" action="suspiciousstock_save" method="post"  enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			
            <s:textfield label="金融机构名称" required="true" size="18" name="orgname" value="%{#info.bname}" readonly="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="金融机构代码" required="true" size="18" name="boid" value="%{#info.boid}" readonly="true">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>			
			<s:textfield label="客户名称/姓名" name="cname" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户号" name="cid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户类型" name="ctype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />				
			</s:textfield>
			<s:textfield label="对私客户职业和对公客户行业" name="professional" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户身份证件/证明文件类型" name="cctype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户身份证件/证明文件号码" name="ccid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="对公客户法定代表人姓名" name="clegal" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="对公客户法定代表人身份证件类型" name="clegaltype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="对公客户法定代表人身份证件号码" name="clegalid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="交易期间" name="cperiod" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="本币累计交易笔数" name="clnum" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="本币累计交易金额" name="clamt" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />	
			</s:textfield>
			<s:textfield label="外币累计交易笔数" name="cfnum" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="外币累计交易金额" name="cfamt" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />	
			</s:textfield>
			
			<s:textfield label="可疑交易特征" name="cfeature" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textarea label="可疑行为描述" name="cdes" required="true" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
			</s:textarea>
			<s:textarea label="采取措施" name="cmethod" required="true" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
			</s:textarea>
			<s:textarea label="其他需要说明的情况" name="cother" required="true" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />				
			</s:textarea>
			<s:file name="suspiciousdataFile" label="交易明细文件" required="true" >
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />	
				<s:param name="remark" value="%{getText('Suspicious.bank')}" />			
			</s:file>
			<tr><td align="right">交易明细模板下载:</td><td colspan="5"><a href="<%=request.getContextPath()%>/templete/stock.xls">模板</a></td></tr>
			<s:file name="suspiciousFile" label="补充文件" required="true" >
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />				
			</s:file>
			<tr><td colspan="6" align="center">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
