<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易报告管理>>保险业重点可疑交易信息录入</title>
</head>
<body>
<script type="text/javascript"> 
    
    </script>     
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			保险业重点可疑交易信息录入
		</legend>
		<br>
		<s:form namespace="/suspiciousinsurance" action="suspiciousinsurance_save" method="post"  enctype="multipart/form-data">
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
			<s:textfield label="投保人名称/姓名" name="cname" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="投保人类型" name="ctype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />				
			</s:textfield>			
			<s:textfield label="投保人身份证件类型" name="cctype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="投保人身份证件号码" name="ccid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户职业和客户行业" name="professional" required="true" size="18">
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
			<s:textfield label="被保险人总数" name="cpnum" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="被保险人名称" name="ciname" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="被保险人身份证件类型" name="citype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="被保险人身份证件号码" name="ciid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="投保人与被保险人的关系" name="crelation" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="受益人总数" name="ctotal" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="受益人名称" name="csname" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="受益人身份证件类型" name="cstype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="受益人身份证件号码" name="csid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="可疑交易特征" name="cfeature" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="保险合同总份数" name="cmnum" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="外币累计交易金额" name="cfamt" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />	
			</s:textfield>
			<s:textfield label="保险种类" name="cmtype" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="保险合同号" name="cmcid" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="保险名称" name="cmname" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="保险期间" name="cmperiod" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="保险标的" name="cmsubject" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="保险金额" name="cmamt" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />	
			</s:textfield>
			<s:textfield label="保险费" name="cmpay" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="缴费方式" name="cmmethod" required="true" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
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
			<tr><td align="right">交易明细模板下载:</td><td colspan="5"><a href="<%=request.getContextPath()%>/templete/insurance.xls">模板</a></td></tr>
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
