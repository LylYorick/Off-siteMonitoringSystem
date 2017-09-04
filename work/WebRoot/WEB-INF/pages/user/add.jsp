<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>用户管理>>用户新增</title>
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
   option.text="人行用户";   
   option.value=0;   
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
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			用户新增
		</legend>
		<br>
		<s:form namespace="/user" action="user_save" method="post">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:select list="#list" label="金融机构类别" id="bpid" name="bid" listKey="bid" listValue="catname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'--请选择--'}" label="金融机构名称" id="bannerid" name="oid" cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield label="登录名称" required="true" name="buname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="用户名称" required="true" name="brname">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="联系电话" required="true" name="btel">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield label="联系邮件" required="true" name="bmail">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textarea label="备注" required="true" name="bumark" cols="40" rows="4">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textarea>
			<tr><td colspan="2" align="center">
			<s:submit theme="simple" align="center"  value="用户新增" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
		</s:form>

	</fieldset><br/>
	</div>
</body>
