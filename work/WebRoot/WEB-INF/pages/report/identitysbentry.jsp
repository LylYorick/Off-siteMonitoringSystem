<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->金融机构客户身份识别情况（识别客户）</title>
	<script type="text/javascript">
	 $.subscribe('zero', function(event,data) {if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  	 	if(window.confirm("确定零记录吗？提交后将自动清除已填写信息")){
   			window.location.href="<%=request.getContextPath()%>/report/report_zerosb.shtml?switchid="+<s:property value="switchid"/>;
    	}
    	}
  	});
  	  	var isExtendsValidate = true;	//如果要试用扩展表单验证的话，该属性一定要申明
	function extendsValidate(){	//函数名称，固定写法
		if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}
	}
     $.subscribe('updateuser', function(event,data) {
     	if($.trim($('#report_updateUser_name').val())=='' || $.trim($('#report_updateUser_tel').val())==''){
     		alert("制表人名字或电话不能为空");
     	}else{
	     	var params = {name:$('#report_updateUser_name').val(),tel:$('#report_updateUser_tel').val()};
	     	$.post("<%=request.getContextPath()%>/report/report_updateuser.shtml?switchid="+<s:property value="switchid"/>,params,function(data){
	     		alert(data);
	     		window.location.reload(true);
	     	}
	     	);
     	}
  	});
  	     $.subscribe('import', function(event,data) {
  		window.location.href="<%=request.getContextPath()%>/report/report_identitysbImport.shtml?switchid="+<s:property value="switchid"/>;
  	});
  	function acc(para){
  		var t=$("#report_identitysbsave_indentitysb_n"+parseInt(24+para)).val();
  		var t1=$("#report_identitysbsave_indentitysb_n"+parseInt(28+para)).val();
  		var t2=$("#report_identitysbsave_indentitysb_n"+parseInt(32+para)).val();
  		var t3=$("#report_identitysbsave_indentitysb_n"+parseInt(36+para)).val();
  		var t4=$("#report_identitysbsave_indentitysb_n"+parseInt(40+para)).val();
  		var t5=$("#report_identitysbsave_indentitysb_n"+parseInt(44+para)).val();
  		$("#report_identitysbsave_indentitysb_n"+parseInt(20+para)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4)+parseInt(t5));
  	}
  	function accs(para){
  		var t=$("#report_identitysbsave_indentitysb_n"+parseInt(80+para)).val();
  		var t1=$("#report_identitysbsave_indentitysb_n"+parseInt(84+para)).val();
  		var t2=$("#report_identitysbsave_indentitysb_n"+parseInt(88+para)).val();
  		var t3=$("#report_identitysbsave_indentitysb_n"+parseInt(92+para)).val();
  		var t4=$("#report_identitysbsave_indentitysb_n"+parseInt(96+para)).val();
  		var t5=$("#report_identitysbsave_indentitysb_n"+parseInt(100+para)).val();
  		$("#report_identitysbsave_indentitysb_n"+parseInt(76+para)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4)+parseInt(t5));
  	}
  	function accz(para){
  		var t=$("#report_identitysbsave_indentitysb_n"+parseInt(para)).val();
  		var t1=$("#report_identitysbsave_indentitysb_n"+parseInt(48+para)).val();
  		$("#report_identitysbsave_indentitysb_n"+parseInt(104+para)).val(parseInt(t)+parseInt(t1));
  	}
	function check(para){
  		var t=$("#report_identitysbsave_indentitysb_n"+parseInt(64+para)).val();
  		var t1=$("#report_identitysbsave_indentitysb_n"+parseInt(60+para)).val();
  		if(parseInt(t)>parseInt(t1)){
  			alert("应该小于总数!");
  			$("#report_identitysbsave_indentitysb_n"+parseInt(64+para)).focus();
  			$("#report_identitysbsave_indentitysb_n"+parseInt(64+para)).val(0);
  		}
  	}
	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			金融机构客户身份识别情况（识别客户）
		</legend>
		<br>
		<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						数据类别：
					</td>
					<td>
						F
					</td>
					<td class="tdLabel">
						数据来源：
					</td>
					<td>
						<s:if test="#reportswitch.BOrgInformation.ishead == 0">
						F
					</s:if>
					<s:else>
						Z
					</s:else>
					</td>

				</tr>
				<tr>
					<td class="tdLabel">
						年度/季度
					</td>
					<td>
						<s:property value="#reportswitch.year"/>/<s:property value="#reportswitch.quater"/>
					</td>
					<td class="tdLabel">
						金融机构类别代码：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.bcatid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						填报单位名称：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.bname" />
					</td>
					<td class="tdLabel">
						填报单位机构代码：
					</td>
					<td>
						<s:property value="#reportswitch.BOrgInformation.boid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						制表人：
					</td>
					<td>
						<input type="text" name="name" value="<s:property value="#reportswitch.name" />" id="report_updateUser_name"/>
					</td>
					<td class="tdLabel">
						 联系电话：
					</td>
					<td>
						<input type="text" name="tel" value="<s:property value="#reportswitch.tel" />" id="report_updateUser_tel"/>
					</td>
				</tr>
				<tr><td colspan="4" align="center">
					
					<s:if test="#reportswitch.status == 1">
					<sj:submit id="grid_updateuser_colsbutton" value="保存" onClickTopics="updateuser" button="true" />[上报数据前请先输入制表人信息]
					</s:if>
				</td></tr>
			</table>
		<br/>
		<s:if test="#session.userinfo.information.bname != ''">
		<sj:submit id="grid_import_colsbutton" value="数据导入" onClickTopics="import" button="true" />
		<sj:submit id="grid_zero_colsbutton" value="零报告提交" onClickTopics="zero" button="true" cssStyle="margin-left:10px" /><span style="color:#ff0000"><s:property value="%{getText('zero.remark')}"/></span>
</s:if><s:form namespace="/report" action="report_identitysbsave" method="post" theme="simple">
<table width="100%" frame="void" class="wwFormTable">
<tr style="font-weight: bold;">
					
    <th colspan="3" width="40%">项目</th>
    <th >新客户</th>
    <th >一次性交易</th>
    <th >跨境汇兑</th>
    <th >其他情形</th>
  </tr>
  <tr>
    <td rowspan="12" height="288" class="tdLabel">对公客户</td>
    <td colspan="2" class="tdLabel">总数</td>
    <td><s:textfield name="indentitysb.n1" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n2" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n3" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n4" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(4)"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="2" class="tdLabel">通过代理行识别数</td>
    <td><s:textfield name="indentitysb.n5" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n6" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n7" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n8" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="2" class="tdLabel">通过第三方识别数</td>
    <td><s:textfield name="indentitysb.n9" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n10" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n11" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n12" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="2" class="tdLabel">与离岸中心有关的</td>
    <td><s:textfield name="indentitysb.n13" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n14" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n15" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n16" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="2" class="tdLabel">受益人数</td>
    <td><s:textfield name="indentitysb.n17" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n18" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n19" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n20" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td rowspan="7" height="168" class="tdLabel">发现问题</td>
    <td  class="tdLabel">合计</td>
    <td><s:textfield name="indentitysb.n21" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n22" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n23" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n24" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">匿名、假名</td>
    <td><s:textfield name="indentitysb.n25" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n26" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n27" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n28" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">证件造假</td>
    <td><s:textfield name="indentitysb.n29" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n30" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n31" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n32" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">证件失效</td>
    <td><s:textfield name="indentitysb.n33" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n34" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n35" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n36" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">利用他人证件</td>
    <td><s:textfield name="indentitysb.n37" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n38" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n39" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n40" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">犯罪嫌疑人</td>
    <td><s:textfield name="indentitysb.n41" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n42" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n43" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n44" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">其他情形</td>
    <td><s:textfield name="indentitysb.n45" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n46" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n47" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n48" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(4)"></s:textfield></td>
  </tr>
  <tr>
    <td rowspan="14" height="336" class="tdLabel">对私客户<br />
    </td>
    <td colspan="2" class="tdLabel">总数</td>
    <td><s:textfield name="indentitysb.n49" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n50" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n51" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n52" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accz(4)"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="2" class="tdLabel">通过代理行识别数</td>
    <td><s:textfield name="indentitysb.n53" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n54" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n55" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n56" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="2" class="tdLabel">通过第三方识别数</td>
    <td><s:textfield name="indentitysb.n57" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n58" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n59" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n60" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td rowspan="2" height="48" class="tdLabel">居民</td>
    <td  class="tdLabel">合计</td>
    <td><s:textfield name="indentitysb.n61" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n62" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n63" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n64" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">其中他人代理</td>
    <td><s:textfield name="indentitysb.n65" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n66" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n67" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n68" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(4)"></s:textfield></td>
  </tr>
  <tr>
    <td rowspan="2" height="48" class="tdLabel">非居民</td>
    <td  class="tdLabel">合计</td>
    <td><s:textfield name="indentitysb.n69" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onkeyup="acc()"></s:textfield></td>
    <td><s:textfield name="indentitysb.n70" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n71" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="indentitysb.n72" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">其中他人代理</td>
    <td><s:textfield name="indentitysb.n73" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(9)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n74" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(10)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n75" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(11)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n76" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="check(12)"></s:textfield></td>
  </tr>
  <tr>
    <td rowspan="7" height="168" class="tdLabel">发现问题</td>
    <td  class="tdLabel">合计</td>
    <td><s:textfield name="indentitysb.n77" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n78" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n79" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n80" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">匿名、假名</td>
    <td><s:textfield name="indentitysb.n81" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n82" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n83" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n84" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">证件造假</td>
    <td><s:textfield name="indentitysb.n85" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n86" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n87" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n88" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">证件失效</td>
    <td><s:textfield name="indentitysb.n89" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n90" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n91" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n92" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">利用他人证件</td>
    <td><s:textfield name="indentitysb.n93" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n94" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n95" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n96" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">犯罪嫌疑人</td>
    <td><s:textfield name="indentitysb.n97" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n98" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n99" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n100" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(4)"></s:textfield></td>
  </tr>
  <tr>
    <td  class="tdLabel">其他情形</td>
    <td><s:textfield name="indentitysb.n101" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(1)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n102" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(2)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n103" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(3)"></s:textfield></td>
    <td><s:textfield name="indentitysb.n104" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="accs(4)"></s:textfield></td>
  </tr>
  <tr>
    <td colspan="3" class="tdLabel">合计</td>
    <td><s:textfield name="indentitysb.n105" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n106" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n107" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="indentitysb.n108" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
  </tr>
  <tr><td colspan="7" align="center">
  <s:hidden name="indentitysb.kid"></s:hidden>
  <s:hidden name="indentitysb.reportswitch.switchid" value="%{switchid}"></s:hidden>
  <s:hidden name="switchid" value="%{switchid}"></s:hidden>
		<s:submit theme="simple" align="center"  value="保存" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
</td></tr>
</table>
</s:form>
	</fieldset><br/>
	</div>
</body>
