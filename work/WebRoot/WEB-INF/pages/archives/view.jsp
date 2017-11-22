<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构明细</title>
	<script type="text/javascript">
	</script>
	<style type="text/css">
	#th td{
		background: RGB(234, 244, 253);
	}
	</style> 
</head>
<body><br>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构明细
			</legend>
			<br>
			<table width="100%" class="wwFormTable">
				<tr>
					<td class="slabel">
						金融机构基本信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
									金融机构类别
								</td>
								<td>
									<s:property value="#information.BOrgCatalog.catname" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									金融机构代码
								</td>
								<td>
									<s:property value="#information.boid" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									金融机构名称
								</td>
								<td>
									<s:property value="#information.bname" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								 联系地址
								</td>
								<td>
									<s:property value="#information.address" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								 机构负责人
								</td>
								<td>
									<s:property value="#information.responsiblePerson" />
								</td>
							</tr>
								<tr>
								<td class="tdLabel">
									员工人数
								</td>
								<td>
									<s:property value="#information.bworknum" />
								</td>
							</tr>
							
							<tr>
								<td class="tdLabel">
									评级类型
								</td>
								<td>
									<s:if test="#information.rateType.equals('00')">
										法人机构评级
									</s:if>
									<s:if test="#information.rateType.equals('01')">
										非法人机构评级
									</s:if>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						上年度资产
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
								上年末度总资产
								</td>
								<td>
									<s:property value="#information.blastamt" />（万）
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								上年度税后净利润
								</td>
								<td>
									<s:property value="#information.blastnet" />（万）
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						分管领导
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
								反洗钱工作分管领导
								</td>
								<td>
									<s:property value="#information.blead" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									分管领导电话
								</td>
								<td>
									<s:property value="#information.bleadtel" />
								</td>
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
							<tr>
								<td class="tdLabel">
									反洗钱部门负责人
								</td>
								<td>
									<s:property value="#information.bdeptlead" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								办公电话
								</td>
								<td>
									<s:property value="#information.bdeptleadtel" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								手机号码
								</td>
								<td>
									<s:property value="#information.bdeptleadphe" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
					反洗钱岗位人员信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
									反洗钱岗位人员
								</td>
								<td>
									<s:property value="#information.bwork" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									岗位人员办公电话
								</td>
								<td>
									<s:property value="#information.bworktel" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								岗位人员手机号码
								</td>
								<td>
									<s:property value="#information.bworkphe" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<s:if test="#information.corporationType.equals('00')">	
					<tr>
						<td class="slabel">
							法人机构信息
						</td>
						<td class="sinput">
							<table frame="void" class="inputform">
								<tr>
									<td class="tdLabel">
									成立时间
									</td>
									<td>
										<s:property value="#information.establishTime" />
									</td>
								</tr>
								<tr>
									<td class="tdLabel">
									注册资本
									</td>
									<td>
										<s:property value="#information.registeredCapital" />(万)
									</td>
								</tr>
								<tr>
									<td class="tdLabel">
									注册地
									</td>
									<td>
										<s:property value="#information.registeredArea" />
									</td>
								</tr>
								<tr>
									<td class="tdLabel">
									经营地
									</td>
									<td>
										<s:property value="#information.businessArea" />
									</td>
								</tr>
								<tr>
									<td class="tdLabel">
										分支机构数量
									</td>
									<td>
										<s:property value="#information.numberOfBranchOffice" />
									</td>
								</tr>
								<tr>
									<td class="tdLabel">
										境外分支机构所在国家或地区
									</td>
									<td>
										<s:property value="#information.overseasBranchOffice" />
									</td>
								</tr>
								<tr>  
							    <td class="tdLabel" colspan="1">
							    <label for="financial_save_bdeptleadphe" class="label">公司股东结构（列明前5名股东及其占比）<span class="required">(*)</span>:</label>
							    </td> 
							    <td colspan="1">
							    	<table id="shareholders" border="1">
							    	 <tr id="th">
							    		<td>股东名称</td>
							    		<td>占比</td>
							    	 </tr>
							    	<tr>
							    		<td>${information.rate2}</td>
							    		<td>${information.rate1}<label class="labelRate"> %</label></td>
							    	</tr>
							    	<tr>
							    		<td>${information.shareholder2}</td>
							    		<td>${information.rate2}<label class="labelRate"> %</label></td>
							    	</tr>
							    	<tr>
							    		<td>${information.shareholder3}</td>
							    		<td>${information.rate3}<label class="labelRate"> %</label></td>
							    	</tr>
							    	<tr>
							    		<td>${information.shareholder4}</td>
							    		<td>${information.rate4}<label class="labelRate"> %</label></td>
							    	</tr>
							    	<tr>
							    		<td>${information.shareholder5}</td>
							    		<td>${information.rate5}<label class="labelRate"> %</label></td>
							    	</tr>
									<s:property value="#information.shareholdingStructure" />
	 						    	</table>
								</td>  
							    </tr>
							</table>
						</td>
					</tr>
				</s:if>
				<s:if test="#information.corporationType.equals('01')">	
					<tr>
						<td class="slabel">
							分支机构
						</td>
						<td class="sinput">
							<table frame="void" class="inputform">
								<tr>
									<td class="tdLabel">
									总部所在地
									</td>
									<td>
										<s:property value="#information.headquarter" />
									</td>
								</tr>
								<tr>
								<td  class="tdLabel"><lable>本分公司对营业厅是否有管辖权</lable></td>
								<td>
									是
								</td>
								</tr>
								<tr>
								<td  class="tdLabel"><lable>在深的营业部家数</lable></td>
								<td>
									<s:property value="#information.numberOfHall" />家
								</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:if>
				<tr align="center">
				<td colspan="2">
					<s:submit theme="simple" align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				</td>
				</tr> 
			</table>
		</fieldset><br/>
	</div>
</body>
