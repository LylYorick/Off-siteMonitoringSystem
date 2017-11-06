<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构明细</title>
	<script type="text/javascript">
		
	</script>
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
					<td  class="slabel">
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
									办公地址
								</td>
								<td>
									<s:property value="#information.baddr" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									深圳分支机构数量
								</td>
								<td>
									<s:property value="#information.bbrchnum" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									反洗钱工作联系人
								</td>
								<td>
									<s:property value="#information.bwork" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									联系人办公电话
								</td>
								<td>
									<s:property value="#information.bworktel" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									联系人手机号码
								</td>
								<td>
									<s:property value="#information.bworkphe" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									传真
								</td>
								<td>
									<s:property value="#information.bfax" />
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
						</table>
					</td>
				</tr>
				<tr>
					<td class="slabel">
						反洗钱部门信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
									反洗钱部门
								</td>
								<td>
									<s:property value="#information.bdept" />
								</td>
							</tr>
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
					<td  class="slabel">
						分管领导信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
									反洗钱分管领导
								</td>
								<td>
									<s:property value="#information.blead" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									分管领导职务
								</td>
								<td>
									<s:property value="#information.bleadpst" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									分管领导联系电话
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
						上年度资产
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
									上年度总资产<font color="red">(万元)</font>
								</td>
								<td>
									<s:property value="@org.work.web.util.AmtDisplay@convertT(#information.blastamt,true)" />
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									上年度税后净利润<font color="red">(万元)</font>
								</td>
								<td>
									<s:property value="@org.work.web.util.AmtDisplay@convertT(#information.blastnet,true)" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</fieldset><br/>
	</div>
</body>
