<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>反洗钱调查信息管理>>调查档案信息修改</title>
</head>
<body>
<script type="text/javascript"> 
    $(document).ready(function() {
  	 	$("#date").datepicker({changeMonth: true,changeYear: true});
  	 	$("#lettertime").datepicker({changeMonth: true,changeYear: true});
  	 	$("#feedbacktime").datepicker({changeMonth: true,changeYear: true});
  	 	$("#realtime").datepicker({changeMonth: true,changeYear: true});
        
	});
    
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
	<br>
	<div class="grid">
		<fieldset>
		<legend>
			调查档案信息修改
		</legend>
		<br>
		<s:form namespace="/information" action="information_surveyupdate" method="post" enctype="multipart/form-data">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{2}" />
			</s:bean>
			<s:hidden name="iaid" value="%{#info.iaid}"></s:hidden>
			<s:select list="#list" label="金融机构类别" id="bpid" name="bid"
				listKey="bid" listValue="catname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="{'--请选择--'}" label="金融机构名称" id="bannerid" name="oid"
				cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield name="date" id="date" label="日期" required="true" value="%{#info.date}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			 
			<s:textfield name="approvalid" label="审批表编号" required="true" value="%{#info.approvalid}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield name="letterid" label="函号" required="true" value="%{#info.letterid}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield name="lettertime" id="lettertime" label="发函时间" required="true" value="%{#info.lettertime}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield name="feedbacktime" id="feedbacktime" label="要求反馈时间" required="true" value="%{#info.feedbacktime}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield name="realtime" id="realtime" label="各金融机构实际反馈时间" required="true" value="%{#info.realtime}">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:textfield>
			<s:textfield name="subjectname" value="%{#info.subjectname}" label="主体名称" required="true"></s:textfield>
			<s:textfield name="idnumber" value="%{#info.idnumber}" label="证件号" required="true"></s:textfield>
			<!--<s:file name="surveyFile" required="true" label="可疑主体数据"><s:param name="remark" value="%{'[说明:可疑主体信息包括主体名称，主体证件号码'}" /></s:file>-->
			<s:submit align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
		</s:form>

	</fieldset><br/>
	</div>
</body>
