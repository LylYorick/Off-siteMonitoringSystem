<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构基本信息新增</title>
	<script type="text/javascript">
	 $(getsort);   
	function getsort(){   
	    var bfirstid=$("#archives_catalogNew_id_bfirstid").val();   
	    var time=new Date();   
	    $.ajax({   
	        cache:false,   
	        url:'<%=request.getContextPath()%>/archives/archives_findSecondCataName.shtml',    
	        type:'post',   
	        dataType:'json',   
	        data:{'bfirstid':bfirstid,'t':time},   
	        success:updateBsecondCataName
	    });   
	}
	//更新第二级金融机构类别列表
	function updateBsecondCataName(json){
		var catalogNewList = json.catalogNewList
		//console.table(catalogNewList);
		var bsecondid = $("#archives_catalogNew_id_bsecondid");
		//清除子元素
		bsecondid.empty();
		var trBsecondid = $("#trBsecondid");
		if(catalogNewList.length == 1){
			trBsecondid.hide();
		}else{
			trBsecondid.show();
		}
 		catalogNewList.forEach(function(item){
			bsecondid.append("<option value='" +item.id.bsecondid+ "'>" + item.secondCatname+"</option>")
		});
		getThirdCataName();
	}
	//通过金融机构的一级类和二级类别查询三级机构类别
	function getThirdCataName(){   
	    var bfirstid=$("#archives_catalogNew_id_bfirstid").val();   
	    var bsecondid=$("#archives_catalogNew_id_bsecondid").val();   
	    var time=new Date();   
	    $.ajax({   
	        cache:false,   
	        url:'<%=request.getContextPath()%>/archives/archives_findThirdCataName.shtml',    
	        type:'post',   
	        dataType:'json',   
	        data:{
	        'bfirstid':bfirstid,
	        'bsecondid':bsecondid,
	        't':time},   
	        success:updateThirdCataName
	    });   
	}
	//更新第三级金融机构类别列表
	function updateThirdCataName(json){
		var catalogNewList = json.catalogNewList
		console.table(catalogNewList);
		var thirdCataName = $("#archives_catalogNew_id_bthirdid");
		//清除子元素
		thirdCataName.empty();
		//如果没有多个三级指标，选择则隐藏
		var trBthirdid = $("#trBthirdid");
		if(catalogNewList.length == 1){
			trBthirdid.hide();
		}else{
			trBthirdid.show();
		}
		catalogNewList.forEach(function(item){
			thirdCataName.append("<option value='" +item.id.bthirdid+ "'>" + item.thirdCatname+"</option>")
		});
	}
	</script>
	
</head>
<body>

	<br>
	<div class="grid">
		<fieldset>
			<legend>
				金融机构基本信息录入
			</legend>
			<br>
			<s:form namespace="/archives" action="archives_basesave" method="post" target="_self">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{3}" />
				</s:bean>
			<tr>  
			    <td class="tdLabel" colspan="1">
			   		 <label for="archives_basesave_archives_BOrgCatalog_bid" class="label">金融机构一级类别:</label>
			    </td> 
			    <td colspan="2">
			     <select name="archives.catalogNew.id.bfirstid" id="archives_catalogNew_id_bfirstid" onchange="getsort()">
	   		   			<s:iterator value="#list" id="item" >
   		   				<option value='<s:property value="#item.id.bfirstid"/>' /><s:property value="#item.firstCatname"/> <s:property value="#item.partName"/></option>
	   		   			</s:iterator>
		   		    </select>
				</td>  
  			</tr>
  			<tr id="trBsecondid">
  				 <td class="tdLabel" colspan="1">
			   		<label for="archives_basesave_archives_BOrgCatalog_bid" class="label">金融机构二级类别:</label>
			    </td> 
			    <td colspan="2">
				    <select name="archives.catalogNew.id.bsecondid" id="archives_catalogNew_id_bsecondid" onchange="getThirdCataName()">
		   		    </select>
				</td>
  			</tr>
  			<tr id="trBthirdid">
  				<td class="tdLabel" colspan="1">
			   		 <label for="archives_basesave_archives_BOrgCatalog_bid" class="label">金融机构三级类别:</label>
			    </td> 
			    <td colspan="2">
				    <select name="archives.catalogNew.id.bthirdid" id="archives_catalogNew_id_bthirdid" >
		   		   	</select>
				</td>
  			</tr>
			<s:textfield label="金融机构名称" required="true" name="archives.bname" size="60">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:textfield>
			<s:select label="评级类别" required="true" name="archives.rateType" list='@org.work.web.constants.Constants@RATE_TYPE' listKey="key" listValue="value">
				<s:param name="labelcolspan" value="%{1}" />
				<s:param name="inputcolspan" value="%{2}" />
			</s:select>
			<tr><td colspan="3" align="center">
			<s:submit theme="simple" align="center"  value="提    交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
			</s:form>
		</fieldset><br/>
	</div>
</body>
