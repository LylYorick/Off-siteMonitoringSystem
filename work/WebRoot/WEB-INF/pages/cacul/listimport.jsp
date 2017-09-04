<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>统计>>客户身份识别情况统计表</title>
		<script type="text/javascript"> 
 
  	  	$(getsort);   
function getsort(){   
    var cid=$("#bpid").val();   
    var time=new Date();   
    $.ajax({   
        cache:false,   
        url:'<%=request.getContextPath()%>/financial/financial_findInformation.shtml',    
        type:'post',   
        dataType:'json',   
        data:{cid:cid,t:time},   
        success:update_c   
    });   
}
function update_c(json){
   var sort=json.informationSet;   
   var cbanner=json.bname;   
   var s_root=document.getElementById('bannerid');   
   s_root.options.length=0; 
   
   var option = document.createElement("option");    
   option.text="---请选择---";   
   option.value="";   
   s_root.options[s_root.options.length] =option;  
           
   for(var i in sort){   
       var option = document.createElement("option");   
       var value=sort[i].oid;      
       var text=sort[i].bname;   
           option.text=text;   
           option.value=value;   
           s_root.options[s_root.options.length] =option;   
   }   
}
    </script>
</head>
<body>
<div>
	<br>
		<fieldset>
			<legend>
				客户身份识别情况统计表
			</legend>
			<br>
			<s:form namespace="/jsonlist" action="cacul_listimport" method="post">

				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{4}" />
				</s:bean>
				<s:select list="#list" label="金融机构类别" id="bpid" name="bid"
					headerKey="" headerValue="所有" listKey="bid" listValue="catname"
					onchange="getsort()">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:select>
				<s:select list="#{'':'--请选择--'}" label="金融机构名称" id="bannerid"
					name="oid" cssStyle="width:240px">
					<s:param name="labelcolspan" value="%{1}" />
					<s:param name="inputcolspan" value="%{1}" />
				</s:select>
				<s:textfield label="年份" name="year"></s:textfield>
				<s:textfield label="季度" name="quater"></s:textfield>
				<tr><td colspan="4" align="center">
				<s:submit align="center" value="查 询" theme="simple"
					cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
					</td></tr>
			</s:form>
			

		</fieldset>
		<br />
		<s:if test="#listp.size != 0">
			<table width="3500" class="list-table" style="width: 3500px">
				  <tr>
    <th colspan="2" rowspan="4" style="width:300px">金融机构类别</th>
    <th colspan="24">对公客户</th>
    <th colspan="24">对私客户</th>
    <th colspan="4">客户身份识别发现可疑情况（个）</th>
  </tr>
  <tr>
    <th colspan="5" rowspan="2">初次
      识别
    （个）</th>
    <th colspan="7" rowspan="2">发现问
      题情况
    （个）</th>
    <th colspan="6" rowspan="2">重新
    识别（个）</th>
    <th colspan="6" rowspan="2">查实问
    题情况（个）</th>
    <th colspan="5" rowspan="2">初次
      识别
    （个）</th>
    <th colspan="7" rowspan="2">发现问
      题情况
    （个）</th>
    <th colspan="6" rowspan="2">重新
    识别（个）</th>
    <th colspan="6" rowspan="2">查实问
    题情况（个）</th>
    <th colspan="2">新建立业务关系和提供一次性服务中识别的</th>
    <th colspan="2">客户身份重新识别中发现的</th>
  </tr>
  <tr>
    <th width="91" rowspan="2">新建业务可疑数</th>
    <th width="155" rowspan="2">限额以上一次性服务可疑数</th>
    <th width="91" rowspan="2">客户身份可疑数</th>
    <th width="139" rowspan="2">客户交易行为可疑数</th>
  </tr>
  <tr>
    <th width="39">新客户</th>
    <th width="65">一次性交易</th>
    <th width="52">跨境汇兑</th>
    <th width="52">其他情形</th>
    <th width="41">总数    1</th>
    <th width="60">匿名,假名</th>
    <th width="52">证件造假</th>
    <th width="52">证件失效</th>
    <th width="78">利用他人证件</th>
    <th width="65">犯罪嫌疑人</th>
    <th width="52">其他情形</th>
    <th width="26">合计</th>
    <th width="78">变更重要信息</th>
    <th width="52">行为异常</th>
    <th width="65">犯罪嫌疑人</th>
    <th width="78">涉及可疑交易</th>
    <th width="52">其他情形</th>
    <th width="26">合计</th>
    <th width="78">变更重要信息</th>
    <th width="52">行为异常</th>
    <th width="65">犯罪嫌疑人</th>
    <th width="78">涉及可疑交易</th>
    <th width="52">其他情形</th>
    <th width="26">合计</th>
    <th width="39">新客户</th>
    <th width="65">一次性交易</th>
    <th width="52">跨境汇兑</th>
    <th width="52">其他情形</th>
    <th width="34">总数2</th>
    <th width="60">匿名,假名</th>
    <th width="52">证件造假</th>
    <th width="52">证件失效</th>
    <th width="78">利用他人证件</th>
    <th width="65">犯罪嫌疑人</th>
    <th width="52">其他情形</th>
    <th width="26">合计</th>
    <th width="78">变更重要信息</th>
    <th width="52">行为异常</th>
    <th width="65">犯罪嫌疑人</th>
    <th width="78">涉及可疑交易</th>
    <th width="52">其他情形</th>
    <th width="26">合计</th>
    <th width="78">变更重要信息</th>
    <th width="52">行为异常</th>
    <th width="65">犯罪嫌疑人</th>
    <th width="78">涉及可疑交易</th>
    <th width="52">其他情形</th>
    <th width="26">合计</th>
  </tr>
				<s:iterator value="listp" status="index" var="l">
					<s:if test="#index.odd==true">
									<tr style="background-color: #ffffff">
				  </s:if>
								<s:else>
									<tr>
								</s:else>
     <td width="50"><s:property value="#l[3]" /></td>
    <td width="250"><s:property value="#l[4]" /></td>
    <td><s:property value="#l[6]" /></td>
    <td><s:property value="#l[7]" /></td>
    <td><s:property value="#l[8]" /></td>
    <td><s:property value="#l[9]" /></td>
    <td><s:property value="#l[10]" /></td>
    <td><s:property value="#l[11]" /></td>
    <td><s:property value="#l[12]" /></td>
    <td><s:property value="#l[13]" /></td>
    <td><s:property value="#l[14]" /></td>
    <td><s:property value="#l[15]" /></td>
    <td><s:property value="#l[16]" /></td>
    <td><s:property value="#l[17]" /></td>
    <td><s:property value="#l[18]" /></td>
    <td><s:property value="#l[19]" /></td>
    <td><s:property value="#l[20]" /></td>
    <td><s:property value="#l[21]" /></td>
    <td><s:property value="#l[22]" /></td>
    <td><s:property value="#l[23]" /></td>
    <td><s:property value="#l[24]" /></td>
    <td><s:property value="#l[25]" /></td>
    <td><s:property value="#l[26]" /></td>
    <td><s:property value="#l[27]" /></td>
    <td><s:property value="#l[28]" /></td>
    <td><s:property value="#l[29]" /></td>
    <td><s:property value="#l[31]" /></td>
    <td><s:property value="#l[32]" /></td>
    <td><s:property value="#l[33]" /></td>
    <td><s:property value="#l[34]" /></td>
    <td><s:property value="#l[35]" /></td>
    <td><s:property value="#l[36]" /></td>
    <td><s:property value="#l[37]" /></td>
    <td><s:property value="#l[38]" /></td>
    <td><s:property value="#l[39]" /></td>
    <td><s:property value="#l[40]" /></td>
    <td><s:property value="#l[41]" /></td>
    <td><s:property value="#l[42]" /></td>
    <td><s:property value="#l[43]" /></td>
    <td><s:property value="#l[44]" /></td>
    <td><s:property value="#l[45]" /></td>
    <td><s:property value="#l[46]" /></td>
    <td><s:property value="#l[47]" /></td>
    <td><s:property value="#l[48]" /></td>
    <td><s:property value="#l[49]" /></td>
    <td><s:property value="#l[50]" /></td>
    <td><s:property value="#l[51]" /></td>
    <td><s:property value="#l[52]" /></td>
    <td><s:property value="#l[53]" /></td>
    <td><s:property value="#l[54]" /></td>
    <td><s:property value="#l[56]" /></td>
    <td><s:property value="#l[57]" /></td>
    <td><s:property value="#l[58]" /></td>
    <td><s:property value="#l[59]" /></td>
  </tr>
				</s:iterator>
			</table>
			<jsp:include flush="true" page="/WEB-INF/layout/paginater.jsp"></jsp:include>
		</s:if>
		<s:else>
			<font color="red">对不起，没有查询到您想要的数据！</font>
		</s:else>
		</div>
</body>
