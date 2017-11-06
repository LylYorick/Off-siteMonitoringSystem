<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构信息录入</title>
		<script type="text/javascript">
		$(function(){
			initial();
			controllInput_HallNum();
		});
		function initial(){
			$("#input_hallNum").hide();
		};
		function controllInput_HallNum(){
         	var juridiction = $("input[name='haveJurisdiction']");
         	var  hallNum = $("#input_hallNum");
			juridiction.click(function(){
				if(juridiction.is(":checked")){
						hallNum.show();
				}else{
					hallNum.val("");
					hallNum.hide();
				}
			});
		}
	</script>
	<style type="text/css">
	#shareholders td{
		border:none !important;
		
	}
	 #th{
		background: RGB(234, 244, 253);
	}
	.shareholderName{
		width:100px;
	}
	.rate{
		width:50px;
	}
	.labelRate{
	font-size:14px;
	}
	</style>
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
							</s:textfield>
							<s:select label="金融机构类型" list="#{'1':'银行业', '2':'证券业','3':'保险业','4':'基金业','5':'期货业','7':'第三方支付公司','8':'证券或基金子公司','6':'其他'}" >
							</s:select>
							<s:textfield label="员工人数" required="true" name="bworknum" reg="^\d{1,6}$" tip="只允许输入数字"
								value="%{#info.bworknum}">
							</s:textfield>
							<s:textfield label="机构负责人" required="true"   reg="^(\-|\+)?\d+(\.\d+)?$" tip="只能输入数值"
								value="">
							</s:textfield>
							<s:textfield label="反洗钱岗位人员" name="bwork" value="%{#info.bwork}" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="反洗钱岗位人员" >
							</s:textfield>
							<s:textfield label="岗位人员办公电话" required="true" name="bworktel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bworktel}">
							</s:textfield>
							<s:textfield label="岗位人员手机号码" required="true" name="bworkphe" reg="^\d{11}$" tip="只允许输入11位数字"
								value="%{#info.bworkphe}">
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
							<s:textfield label="上年末度总资产" required="true" name="blastamt"
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
				<tr>
					<td class="slabel">
						分管领导
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="反洗钱工作分管领导" required="true" name="bdeptlead" tip="只允许输入数字"
								value="%{#info.bdeptlead}">
							</s:textfield>
							<s:textfield label="分管领导电话" required="true" name="bdeptleadtel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bdeptleadtel}">
							</s:textfield>					
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						反洗钱部门负责人信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
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
						法人机构信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="成立时间" required="true" name="bdept"
								value="%{#info.bdept}">
							</s:textfield>
							<s:textfield label="注册资本" required="true" name="bdeptlead"
								value="%{#info.bdeptlead}">
							</s:textfield>
							<s:textfield label="注册地" required="true" name="bdeptleadtel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bdeptleadtel}">
							</s:textfield>
							<s:textfield label="经营地" required="true" name="bdeptleadphe" reg="\d{11}$" tip="只允许输入11位数字"
								value="%{#info.bdeptleadphe}">
							</s:textfield>
							<tr>  
						    <td class="tdLabel" colspan="1">
						    <label for="financial_save_bdeptleadphe" class="label">公司股东结构（列明前5名股东及其占比）<span class="required">(*)</span>:</label>
						    </td> 
						    <td colspan="1">
						    	<table id="shareholders">
						    	 <tr id="th">
						    		<td>股东名称</td>
						    		<td>占比</td>
						    	 </tr>
						    	<tr>
						    		<td><input name="BOrgCatalog1" class="BOrgCatalog"></td>
						    		<td><input  name="rate1" class="rate"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="shareholderName2"class="shareholderName"></td>
						    		<td><input class="rate2" class="rate" ><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="shareholderName3" class="shareholderName"></td>
						    		<td><input name="rate3" class="rate3"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="shareholderName4" class="shareholderName"></td>
						    		<td><input  name="rate" class="rate"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="shareholderName5" class="shareholderName"></td>
						    		<td><input name="rate5" class="rate5"><label class="labelRate"> %</label></td>
						    	</tr>
 						    	</table>
							</td>  
						    </tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						分支机构
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="总部所在地" required="true" name="blead"
								value="%{#info.blead}">
							</s:textfield>
							<tr>
							<td  class="tdLabel"><lable>本分公司对营业厅是否有管辖权</lable></td>
							<td>
								<input type="checkbox" name="haveJurisdiction" value="0" >是
							</td>
							</tr>
							<s:textfield label="在深的营业部家数" required="true" id="input_hallNum" name="hallNum" 
								value="">
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
