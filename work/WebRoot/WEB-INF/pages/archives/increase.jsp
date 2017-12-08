<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构信息录入</title>
		<script type="text/javascript">
		$(document).ready(function() {
		  	 	var dates = $("#archives_save_archives_establishTime").datepicker({
	  	 		changeMonth: true,
	  	 		changeYear: true,
				onSelect: function(selectedDate) {
					var option = this.id == "startdate" ? "mixDate" : "maxDate";
					var instance = $(this).data("datepicker");
					var date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
					dates.not(this).datepicker("option", option, date);
				}
			});
		});
		function toClassify(){
			window.location.href= "<%=request.getContextPath()%>/archives/archives_toClassify.shtml";
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
	TABLE.wwFormTable TD.tdLabel{
		padding:0px;
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
			<s:form namespace="/archives" action="archives_save" method="post" target="_self">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{2}" />
				</s:bean>
				<s:hidden name="archives.oid" value="%{#info.oid}"></s:hidden>
				<s:hidden name="archives.corporationType" value="%{#info.corporationType}"></s:hidden>
				<s:hidden name="archives.BOrgCatalog.bid" value="%{#info.BOrgCatalog.bid}"></s:hidden>
				<s:hidden name="archives.rateType" value="%{#info.rateType}"></s:hidden>
				<s:hidden id="bfirstid"name="archives.catalogNew.id.bfirstid" value="%{#info.catalogNew.id.bfirstid}"></s:hidden>
				<s:hidden id="bfirstid"name="archives.catalogNew.id.bsecondid" value="%{#info.catalogNew.id.bsecondid}"></s:hidden>
				<s:hidden id="bfirstid"name="archives.catalogNew.id.bthirdid" value="%{#info.catalogNew.id.bthirdid}"></s:hidden>
				<s:textfield label="金融机构名称" required="true" name="archives.bname"
					value="%{#info.bname}" size="60" reg="^[\s|\S]{1,40}$" tip="不能为空,且最多为40个字符">
				</s:textfield>
				<tr>
					<td class="tdLabel" colspan="1">
					  <label for="shareholdingStructure" class="label">金融机构类型</span>:</label>
					</td>
					<td>
						<s:property  value="#info.catalogNew.firstCatname"/>
						<s:if test="!#info.catalogNew.id.bsecondid.equals('00')">
							<s:property  value="#info.catalogNew.secondCatname"/>
						</s:if>
						<s:if test="!#info.catalogNew.id.bthirdid.equals('00')">
							<s:property  value="#info.catalogNew.thirdCatname"/>
						</s:if>
						<input type="button" value="修改机构行业" onclick="toClassify()" >
					</td>
				</tr>
  				<s:if test="#info.corporationType.equals('00')">	
					<s:textfield label="成立时间" required="true" name="archives.establishTime" 
						value="%{#info.establishTime}" reg="^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$" tip="日期格式不正确">
					</s:textfield>
					<s:textfield label="注册资本(万)" required="true" name="archives.registeredCapital"
						value="%{#info.registeredCapital}" reg="^(\-|\+)?\d+(\.\d+)?$" tip="只能输入数值">
					</s:textfield>
					<s:textfield label="注册地" required="true" name="archives.registeredArea" 
						value="%{#info.registeredArea}" reg="^[\s|\S]{1,150}$" tip="不能为空,且最多为150个字符">
					</s:textfield>
					<s:textfield label="经营地" required="true" name="archives.businessArea"
						value="%{#info.businessArea}" reg="^[\s|\S]{1,150}$" tip="不能为空,且最多为150个字符">
					</s:textfield>
				
					<tr>
					    <td class="tdLabel" colspan="1">
					    <label for="shareholdingStructure" class="label">公司股东结构（列明前5名股东及其占比）<span class="required">(*)</span>:</label>
					    </td>
					    <td colspan="1">
					   		<table id="shareholders">
					    	    <tr id="th">
						    		<td>股东名称</td>
						    	    <td>占比</td>
					    	    </tr>
						    	<tr>
						    		<td><input name="archives.shareholder1" class="shareholderName" value="${info.shareholder1}" reg="^[\s|\S]{1,30}$" tip="不能为空，且最多为30个字符"></td>
						    		<td><input  name="archives.rate1" class="rate" value="${info.rate1}"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="archives.shareholder2"class="shareholderName" value="${info.shareholder2}" reg="^[\s|\S]{1,30}$" tip="不能为空，且最多为30个字符"></td>
						    		<td><input name="archives.rate2" class="rate" value="${info.rate2}"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="archives.shareholder3" class="shareholderName" value="${info.shareholder3}" reg="^[\s|\S]{1,30}$" tip="不能为空，且最多为30个字符"></td>
						    		<td><input name="archives.rate3" class="rate" value="${info.rate3}"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="archives.shareholder4" class="shareholderName" value="${info.shareholder4}" reg="^[\s|\S]{1,30}$" tip="不能为空，且最多为30个字符" ></td>
						    		<td><input  name="archives.rate4" class="rate" value="${info.rate4}"><label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td><input name="archives.shareholder5" class="shareholderName" value="${info.shareholder5}" reg="^[\s|\S]{1,30}$" tip="不能为空，且最多为30个字符"></td>
						    		<td><input name="archives.rate5" class="rate" value="${info.rate5}"><label class="labelRate"> %</label></td>
						    	</tr>
							 	</table>
						</td>
					</tr>
				</s:if>
				<s:if test="#info.corporationType.equals('01')">	
					<s:textfield label="总部所在地" required="true" name="archives.headquarter"
						value="%{#info.headquarter}" reg="^[\s|\S]{1,320}$" tip="不能为空，且最多320个字符">
					</s:textfield>
				</s:if>
				<s:textfield label="员工人数:" required="true" name="archives.bworknum" 
					value="%{#info.bworknum}" reg="^\d{1,6}$" tip="只允许输入1-6位的数字">
				</s:textfield>
				<s:textfield label="上年末度总资产(万)" required="true" name="archives.blastamt"  
					value="%{#info.blastamt}" reg="^(\-|\+)?\d+(\.\d+)?$" tip="只能输入数值">
					<s:param name="remark" value="%{getText('documentField.number')}" />
				</s:textfield>
				<s:textfield label="上年度税后净利润(万)" required="true" name="archives.blastnet"  
					value="%{#info.blastnet}" reg="^(\-|\+)?\d+(\.\d+)?$" tip="只能输入数值">
					<s:param name="remark" value="%{getText('documentField.number')}" />
				</s:textfield>
				<s:if test="#info.corporationType.equals('00')">
					<s:textfield label="分支机构数量" required="true" name="archives.numberOfBranchOffice"
						value="%{#info.numberOfBranchOffice}"  reg="^\d{1,6}$" tip="只允许输入1-6位的数字">
					</s:textfield>
					<s:textarea label="境外分支机构所在国家或地区"  name="archives.overseasBranchOffice"
						value="%{#info.overseasBranchOffice}" cols="50" rows="3" reg="^[\s|\S]{1,320}$" tip="不能为空，且最多320个字符">
					</s:textarea>
				</s:if>
				<s:if test="#info.catalogNew.id.bthirdid.equals('01')">
					<s:textfield label="在深的营业部家数" id="numberOfHall" name="archives.numberOfHall" 
						value="%{#info.numberOfHall}"  reg="^\d{1,6}$" tip="只允许输入1-6位的数字">
					</s:textfield>
				</s:if>
				<s:textfield label="机构负责人" required="true" name="archives.responsiblePerson"
					value="%{#info.responsiblePerson}" size="20" reg="^[\s|\S]{1,13}$" tip="不能为空，且最多13个字符">
				</s:textfield>
			
				<tr>
					<td class="tdLabel">
						评级类型:
					</td>
					<td>
						<s:if test="#info.rateType.equals('00')">
							法人机构评级
						</s:if>
						<s:if test="#info.rateType.equals('01')">
							非法人机构评级
						</s:if>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						分管领导
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<s:textfield label="反洗钱工作分管领导" required="true" name="archives.blead" 
									value="%{#info.blead}" reg="^[\s|\S]{1,13}$" tip="不能为空，且最多13个字符" >
								</s:textfield>
							</tr>
							<tr>
								<s:textfield label="分管领导电话" required="true" name="archives.bleadtel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
									value="%{#info.bleadtel}">
								</s:textfield>	
							</tr>				
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
					反洗钱工作牵头部门负责人信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:bean name="java.util.HashMap" id="qTableLayout">
								<s:param name="tablecolspan" value="%{2}" />
							</s:bean>
							<s:textfield label="反洗钱部门负责人" required="true" name="archives.bdeptlead"
								value="%{#info.bdeptlead}" reg="^[\s|\S]{1,13}$" tip="不能为空，且最多13个字符">
							</s:textfield>
							<s:textfield label="办公电话" required="true" name="archives.bdeptleadtel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bdeptleadtel}">
							</s:textfield>
							<s:textfield label="手机号码" required="true" name="archives.bdeptleadphe" reg="\d{11}$" tip="只允许输入11位数字"
								value="%{#info.bdeptleadphe}">
							</s:textfield>				
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
					反洗钱岗位人员信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<s:textfield label="反洗钱岗位人员" required="true" name="archives.bwork" value="%{#info.bwork}" reg="^[\s|\S]{1,13}$" tip="不能为空，且最多13个字符">
							</s:textfield>
							<s:textfield label="岗位人员办公电话" required="true" name="archives.bworktel" reg="^\d{3}-\d{8}$|^\d{4}-\d{8}$" tip="国内电话号码，格式: 0755-22590240 或 021-88888888"
								value="%{#info.bworktel}">
							</s:textfield>
							<s:textfield label="岗位人员手机号码" required="true" name="archives.bworkphe" reg="\d{11}$" tip="只允许输入11位数字"
								value="%{#info.bworkphe}">
							</s:textfield>
							<s:textfield label="联系地址" required="true" name="archives.address"
								 value="%{#info.address}" size="60" reg="^[\s|\S]{1,300}$" tip="不能为空">
							</s:textfield>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<s:submit theme="simple" align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
					</td>
				</tr>
				</table>
			</s:form>

		</fieldset><br/>
	</div>
</body>
