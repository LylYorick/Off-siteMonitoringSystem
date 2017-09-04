<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>统计>>重点可疑交易统计</title>
</head>
<body>
<script type="text/javascript"> 
    $.subscribe('complete', function(event,data) { 
    	var myjsongrid = eval("("+event.originalEvent.request.responseText+")");
    	$("#gridtable").trigger("clearGrid"); 
    	$("#gridtable")[0].addJSONData(myjsongrid);
    }); 
    $.subscribe('errorState', function(event,data) { 
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status); 
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
			重点可疑交易统计
		</legend>
		<br>
		<s:form namespace="/jsonlist" action="cacul_listimport" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
				<s:select list="#list" label="金融机构类别" id="bpid" name="bid"  headerKey="" headerValue="所有"
				listKey="bid" listValue="catname" onchange="getsort()">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:select list="#{'':'--请选择--'}" label="金融机构名称" id="bannerid" name="oid"
				cssStyle="width:240px">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{1}" />
			</s:select>
			<s:textfield label="年份" name="year"></s:textfield>
			<s:textfield label="季度" name="quater"></s:textfield>
		</s:form>
		<div align="center">
			<sj:submit formIds="cacul_list" id="searchbutton" value="查  询"
				button="true" indicator="indicator"
				onCompleteTopics="complete" onErrorTopics="errorState"/>
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>

	</fieldset><br/>
			
		<sj:grid id="gridtable" caption="重点可疑交易统计" dataType="json"
			href="../jsonlist/cacul_listimport.shtml" gridModel="gridModel"
			rowList="10,15,20" rowNum="300" rownumbers="true" viewrecords="true"
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect">
			<sj:gridColumn name="oid" index="oid" title="金融机构" sortable="true"
				width="290" search="true" />
			<sj:gridColumn name="r1" index="r1" title="报表1" width="70"/>
			<sj:gridColumn name="r2" index="r2" title="报表2" width="70"/>
			<sj:gridColumn name="r3" index="r3" title="报表3" width="70"/>
			<sj:gridColumn name="r4" index="r4" title="报表4" width="70"/>
			<sj:gridColumn name="r5" index="r5" title="报表5" width="70"/>
			<sj:gridColumn name="r6" index="r6" title="报表6" width="70"/>
			<sj:gridColumn name="r7" index="r7" title="报表7" width="70"/>
			<sj:gridColumn name="r8" index="r8" title="报表8" width="70"/>
			<sj:gridColumn name="r9" index="r9" title="报表9" width="70"/>
			<sj:gridColumn name="r10" index="r10" title="报表10" width="70"/>
		</sj:grid>

	</div>
</body>
