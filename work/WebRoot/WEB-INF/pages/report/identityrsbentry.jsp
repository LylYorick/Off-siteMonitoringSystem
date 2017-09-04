<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>报表上报->金融机构客户身份识别情况(重新识别客户)</title>
		<script type="text/javascript">
	 $.subscribe('zero', function(event,data) {
	if('<s:property value="#reportswitch.name" />'=='' || '<s:property value="#reportswitch.tel" />'==''){
     		alert("制表人名字或电话不能为空");
     		return false;
     	}else{
  	 	if(window.confirm("确定零记录吗？")){
   			window.location.href="<%=request.getContextPath()%>/report/report_zerorsb.shtml?switchid="+<s:property value="switchid"/>;
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
  		window.location.href="<%=request.getContextPath()%>/report/report_identityrsbImport.shtml?switchid="+<s:property value="switchid"/>;
  	});
  	function acc(para,para2){
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt(para)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt(10+para)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt(20+para)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt(30+para)).val();
  		var t4=$("#report_identityrsbsave_identityrsb_r"+parseInt(40+para)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(50+para)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4));
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+2)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+1)).val();
  		if(parseInt(t)>parseInt(t1)){
  			alert("应该小于总数!");
  			$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+2)).focus();
  			$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+2)).val(0);
  		}
  	}
  	function acc1(para,para2){
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt(5+para)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt(15+para)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt(25+para)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt(35+para)).val();
  		var t4=$("#report_identityrsbsave_identityrsb_r"+parseInt(45+para)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(55+para)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4));
  		
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+7)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+6)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+para)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+5+para)).val();
  		if(parseInt(t)>parseInt(t1)){
  			alert("应该小于总数!");
  			$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+7)).focus();
  			$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+7)).val(0);
  		}
  		if(parseInt(t3)>parseInt(t2)){
  			alert("输入不合规范!");
  			$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+5+para)).focus();
  			$("#report_identityrsbsave_identityrsb_r"+parseInt((para2-1)*10+5+para)).val(0);
  		}
  		
  	}
  	function acck(para,para1){
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt(3+para1)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt(13+para1)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt(23+para1)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt(33+para1)).val();
  		var t4=$("#report_identityrsbsave_identityrsb_r"+parseInt(43+para1)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(53+para1)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4));
  		var tt=$("#report_identityrsbsave_identityrsb_r"+parseInt(4+(para-1)*10)).val();
  		var tt1=$("#report_identityrsbsave_identityrsb_r"+parseInt(4+(para-1)*10+1)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(3+(para-1)*10)).val(parseInt(tt)+parseInt(tt1));
  		
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt(3)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt(13)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt(23)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt(33)).val();
  		var t4=$("#report_identityrsbsave_identityrsb_r"+parseInt(43)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(53)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4));
  	}
  	function acck2(para,para1){
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt(8+para1)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt(18+para1)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt(28+para1)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt(38+para1)).val();
  		var t4=$("#report_identityrsbsave_identityrsb_r"+parseInt(48+para1)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(58+para1)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4));
  		var tt=$("#report_identityrsbsave_identityrsb_r"+parseInt(9+(para-1)*10)).val();
  		var tt1=$("#report_identityrsbsave_identityrsb_r"+parseInt(9+(para-1)*10+1)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(8+(para-1)*10)).val(parseInt(tt)+parseInt(tt1));
  		
  		var t=$("#report_identityrsbsave_identityrsb_r"+parseInt(8)).val();
  		var t1=$("#report_identityrsbsave_identityrsb_r"+parseInt(18)).val();
  		var t2=$("#report_identityrsbsave_identityrsb_r"+parseInt(28)).val();
  		var t3=$("#report_identityrsbsave_identityrsb_r"+parseInt(38)).val();
  		var t4=$("#report_identityrsbsave_identityrsb_r"+parseInt(48)).val();
  		$("#report_identityrsbsave_identityrsb_r"+parseInt(58)).val(parseInt(t)+parseInt(t1)+parseInt(t2)+parseInt(t3)+parseInt(t4));
  	}

	</script>
</head>
<body>
	<div class="grid">
		<fieldset>
		<legend>
			金融机构客户身份识别情况(重新识别客户)
		</legend>
		<br>
		<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						数据类别：
					</td>
					<td>
						G
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
		<sj:submit id="grid_import_colsbutton" value="数据导入" onClickTopics="import" button="true" />
		<sj:submit id="grid_zero_colsbutton" value="零报告提交" onClickTopics="zero" button="true" cssStyle="margin-left:10px" /><span style="color:#ff0000"><s:property value="%{getText('zero.remark')}"/></span>
<s:form namespace="/report" action="report_identityrsbsave" method="post" theme="simple" >
<table width="100%" frame="void" class="wwFormTable">
<tr style="font-weight: bold;">
    <th rowspan="2">重新识别原因</th>
    <th colspan="2">对公客户</th>
    <th colspan="3">对私客户</th>
  </tr>
  <tr>
    <th>总数</th>
    <th>涉及受益人的</th>
    <th>总数</th>
    <th>居民</th>
    <th>非居民</th>
  </tr>  
  <tr>
    <td class="tdLabel">变更重要信息</td>
    <td><s:textfield name="identityrsb.r1" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r2" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r3" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r4" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(1,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r5" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(1,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">其中查实的</td>
    <td><s:textfield name="identityrsb.r6" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(1,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r7" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(2,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r8" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r9" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(1,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r10" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(1,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">行为异常</td>
    <td><s:textfield name="identityrsb.r11" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1,2)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r12" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2,2)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r13" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r14" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(2,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r15" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(2,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">其中查实的</td>
    <td><s:textfield name="identityrsb.r16" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(1,2)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r17" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(2,2)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r18" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r19" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(2,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r20" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(2,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">犯罪嫌疑人</td>
    <td><s:textfield name="identityrsb.r21" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1,3)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r22" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2,3)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r23" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r24" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(3,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r25" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(3,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">其中查实的</td>
    <td><s:textfield name="identityrsb.r26" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(1,3)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r27" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(2,3)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r28" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r29" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(3,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r30" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(3,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">涉及可疑交易</td>
    <td><s:textfield name="identityrsb.r31" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1,4)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r32" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2,4)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r33" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r34" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(4,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r35" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(4,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">其中查实的</td>
    <td><s:textfield name="identityrsb.r36" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(1,4)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r37" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(2,4)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r38" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r39" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(4,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r40" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(4,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">其他情形</td>
    <td><s:textfield name="identityrsb.r41" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(1,5)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r42" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc(2,5)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r43" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r44" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(5,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r45" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck(5,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">其中查实的</td>
    <td><s:textfield name="identityrsb.r46" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(1,5)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r47" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acc1(2,5)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r48" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r49" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(5,1)"></s:textfield></td>
    <td><s:textfield name="identityrsb.r50" size="6" reg="^\d{1,9}$" tip="只允许输入数字" onblur="acck2(5,2)"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">合计</td>
    <td><s:textfield name="identityrsb.r51" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r52" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r53" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r54" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r55" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">查实合计数</td>
    <td><s:textfield name="identityrsb.r56" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r57" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r58" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r59" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
    <td><s:textfield name="identityrsb.r60" size="6" reg="^\d{1,9}$" tip="只允许输入数字" readonly="true" cssStyle="background-color:#eeeeee"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">留存证件失效</td>
    <td><s:textfield name="identityrsb.r61" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r62" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r63" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r64" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r65" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr>
    <td class="tdLabel">已更新数</td>
    <td><s:textfield name="identityrsb.r66" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r67" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r68" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r69" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
    <td><s:textfield name="identityrsb.r70" size="6" reg="^\d{1,9}$" tip="只允许输入数字"></s:textfield></td>
  </tr>
  <tr><td colspan="6" align="center">
  <s:hidden name="identityrsb.rkid"></s:hidden>
  <s:hidden name="identityrsb.reportswitch.switchid" value="%{switchid}"></s:hidden>
  <s:hidden name="switchid" value="%{switchid}"></s:hidden>
		<s:submit theme="simple" align="center"  value="保存" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
</td></tr>
</table>
</s:form>
	</fieldset><br/>
	</div>
</body>
