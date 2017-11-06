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
/* 	#shareholders td{
		border-left:5px solid;
		border-top: 5px solid;
		border-right: 5px solid;
		border-bottom:5px solid;
	} */
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
									员工人数
								</td>
								<td>
								1000人
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									深圳分支机构数量
								</td>
								<td>
									20家
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									反洗钱岗位人员
								</td>
								<td>
									袁鹏程
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									岗位人员办公电话
								</td>
								<td>
									84449533
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								岗位人员手机号码
								</td>
								<td>
									13547874524
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
								500,000.45（万）
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								上年度税后净利润
								</td>
								<td>
								54,545(万)
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
									张三	
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
									分管领导电话
								</td>
								<td>
									84465000
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td class="slabel">
						反洗钱部门负责人信息
					</td>
					<td class="sinput">
						<table frame="void" class="inputform">
							<tr>
								<td class="tdLabel">
									反洗钱部门负责人
								</td>
								<td>
								李四
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								办公电话
								</td>
								<td>
								84465000
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								手机号码
								</td>
								<td>
								18645642135
								</td>
							</tr>
						</table>
					</td>
				</tr>
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
								2005年6月
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								注册资本
								</td>
								<td>
								1000(万)
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								注册地
								</td>
								<td>
								中国上海
								</td>
							</tr>
							<tr>
								<td class="tdLabel">
								经营地
								</td>
								<td>
								中国深圳
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
						    		<td>深圳市人民政府</td>
						    		<td> 52<label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td>阿里巴巴集团</td>
						    		<td>20<label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td>荀大新</td>
						    		<td>10<label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td>刘晓东</td>
						    		<td>5<label class="labelRate"> %</label></td>
						    	</tr>
						    	<tr>
						    		<td>深圳地铁</td>
						    		<td>3<label class="labelRate"> %</label></td>
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
							<tr>
								<td class="tdLabel">
								总部所在地
								</td>
								<td>
								深圳市罗湖区
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
								20家
							</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr align="center">
				<td colspan="2">
					<s:submit theme="simple" align="center" value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
				</td>
				</tr> 
			</table>
		</fieldset><br/>
	</div>
</body>
