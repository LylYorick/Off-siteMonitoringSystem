<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ERROR</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery.validation/1.10.0/validate.css" />
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.10.0/jquery.validate.js"></script> 
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.10.0/jquery.validate.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 

	<script type="text/javascript">
	$(function(){
		getsort();
	});   
	function getsort(){   
	    var bfirstid=$("#archives_catalogNew_id_bfirstid").val();   
	    $.ajax({   
	        cache:false,   
	        url:'<%=request.getContextPath()%>/archives/archives_findSecondCataName.shtml',    
	        type:'post',   
	        dataType:'json',   
	        data:{'bfirstid':bfirstid},   
	        success:updateBsecondCataName
	    });   
	}
	//更新第二级金融机构类别列表
	function updateBsecondCataName(json){
		var catalogNewList = json.catalogNewList
		var bsecondid = $("#archives_catalogNew_id_bsecondid");
		//清除子元素
		bsecondid.empty();
		var trBsecondid = $("#trBsecondid");
		if(catalogNewList==null || catalogNewList.length == 1){
			trBsecondid.hide();
		}else{
			trBsecondid.show();
			var oldBsecondid=$("#bsecondid").val();
			catalogNewList.forEach(function(item){
				//将原二级指标id设为选中
				if(oldBsecondid ==  item.id.bsecondid){
					bsecondid.append("<option value='" +item.id.bsecondid+ "' selected>" + item.secondCatname+"</option>")
				}else{
					bsecondid.append("<option value='" +item.id.bsecondid+ "'>" + item.secondCatname+"</option>")
				}
			});;
		}
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
		var thirdCataName = $("#archives_catalogNew_id_bthirdid");
		//清除子元素
		thirdCataName.empty();
		//如果没有多个三级指标，选择则隐藏
		var trBthirdid = $("#trBthirdid");
		if(catalogNewList==null){
			trBthirdid.hide();
			return;
		}else if(catalogNewList.length == 1) {
			trBthirdid.hide();
		
		}else{
			trBthirdid.show();
		}
		var Bthirdid=$("#bthirdid").val();
		catalogNewList.forEach(function(item){
			if(Bthirdid ==  item.id.bthirdid){
				thirdCataName.append("<option value='" +item.id.bthirdid + "' selected>" + item.thirdCatname + "</option>")
			}else{
				thirdCataName.append("<option value='" +item.id.bthirdid + "'>" + item.thirdCatname + "</option>")
			}
		});
	}
	function confirmTips(){
	  	var firstCatname = $("#archives_catalogNew_id_bfirstid option:selected").text();
	  	var bthirdid = 	"<s:property value='#info.catalogNew.id.bfirstid'/>"
	  	//如果是首次设金融机构类型，提示如下
	  	if('00' == bthirdid){
	  		if(confirm("警告:是否确认当前机构的类别为："+firstCatname +",以后将无法进行修改。")){
	   		$("#testForm").submit();
	   		}
	  	}else{
	  	//如果不是首次设金融机构类型，提示如下
		   	if(confirm("警告:是否确认修改机构的类型?此操作将重置部分的机构信息！")){
		   		$("#testForm").submit();
		   	}
	  	}
	}
  </script>
  </head>
  <body>
   <div align="center" style="width:500px;margin: 10px auto">
   	<div id="effect" class="ui-widget-content ui-corner-all">
		<h3 class="ui-widget-header ui-corner-all">操作提示</h3>
			<s:hidden id="bsecondid" value="%{#info.catalogNew.id.bsecondid}"></s:hidden>
			<s:hidden id="bthirdid" value="%{#info.catalogNew.id.bthirdid}"></s:hidden>
			<s:form namespace="/archives" action="archives_doClassify" id="testForm" method="post" target="_self">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{3}" />
				</s:bean>
				<tr>  
			    <td class="tdLabel" colspan="1" style="width:150px;">
			   		 <label for="archives_basesave_archives_BOrgCatalog_bid" class="label">金融机构一级类别:</label>
			    </td> 
			    <td colspan="2">
			    <s:if test="!#info.catalogNew.id.bfirstid.equals('00')">
					<input type="hidden" name="archives.catalogNew.id.bfirstid"  id="archives_catalogNew_id_bfirstid" value="${info.catalogNew.id.bfirstid}" >			    
			   		 <label id="firstCatname" class="label">
			   		 	<s:property value="#info.catalogNew.firstCatname"></s:property>
			   		 </label>
			    </s:if>
			    <s:else>
			     	<select name="archives.catalogNew.id.bfirstid" id="archives_catalogNew_id_bfirstid" onchange="getsort()">
		   		   		<s:iterator value="#list" id="item" >
		  		   				<option value='<s:property value="#item.id.bfirstid"/>' ><s:property value="#item.firstCatname"/> </option>
		   		   		</s:iterator>
		   		   </select>
			    </s:else>
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
 			<tr align="center">
				<td colspan="3" >
					<input type="button" id="testForm_0" value="提    交" class="ui-button ui-state-default ui-corner-all" onclick="confirmTips()">
				</td>
			</tr>
		</s:form>
	</div>
	</div>
    
  </body>
</html>
