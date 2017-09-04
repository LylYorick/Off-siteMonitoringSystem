<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易报告管理>>重点可疑交易信息录入</title>
		<script type="text/javascript">
			$(document).ready(function() {
  	 		$('#suspicious_save_cmethod').maxlength();
  	 		$('#suspicious_save_cdes').maxlength();
  	 		$('#suspicious_save_cother').maxlength();
		}); 
    </script>
</head>
<body>
<script type="text/javascript"> 
    
    </script>     
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			重点可疑交易信息录入
		</legend>
		<br>
		<s:form namespace="/suspicious" action="suspicious_save" method="post"  enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{6}" />
			</s:bean>
			
            <s:textfield label="金融机构名称" required="true" size="30" name="orgname" value="%{#info.bname}" readonly="true" cssStyle="background-color:#eeeeee">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:textfield label="金融机构代码" required="true" size="18" name="boid" value="%{#info.boid}" readonly="true" cssStyle="background-color:#eeeeee">
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
			<s:textfield label="客户类型" name="ctype" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				
			</s:textfield>
			<s:textfield label="客户国籍" name="cnation" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户身份证件/证明文件类型" name="cctype" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="客户身份证件/证明文件号码" name="ccid" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="对公客户法定代表人姓名" name="clegal" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="对公客户法定代表人身份证件类型" name="clegaltype" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="对公客户法定代表人身份证件号码" name="clegalid" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="交易期间" name="cperiod" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="本币累计交易笔数" name="clnum" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('documentField.integer')}" />
			</s:textfield>
			<s:textfield label="本币累计交易金额" name="clamt" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />
			</s:textfield>
			<s:textfield label="外币累计交易笔数" name="cfnum" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('documentField.integer')}" />
			</s:textfield>
			<s:textfield label="外币累计交易金额" name="cfamt" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
				<s:param name="remark" value="%{getText('Suspicious.unit')}" />
			</s:textfield>
			<s:textfield label="可疑交易特征" name="cfeature" size="18">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textarea label="可疑行为描述" name="cdes" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
			</s:textarea>
			<s:textarea label="采取措施" name="cmethod" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
			</s:textarea>
			<s:textarea label="其他需要说明的情况" name="cother" cols="60" rows="10">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />				
			</s:textarea>
			<s:file name="suspiciousdataFile" label="交易明细文件" required="true" >
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{5}" />
				<s:param name="remark" value="%{getText('Suspicious.bank')}" />
			</s:file>
			<tr><td align="right">交易明细模板下载:</td><td colspan="5"><a href="<%=request.getContextPath()%>/templete/bank.xls">模板</a></td></tr>
			<s:file name="suspiciousFile" label="补充文件" >
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
