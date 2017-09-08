<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分管理>>整改报告管理</title>
</head>
<body>
<script type="text/javascript"> 
	/**页面加载时渲染日期空间*/
  	$(document).ready(function() {
  	var dates = $("#_startdate, #_enddate").datepicker({
  	 		changeMonth: true,
  	 		changeYear: true,
			onSelect: function(selectedDate) {
				var option = this.id == "_startdate" ? "minDate" : "maxDate";
				var instance = $(this).data("datepicker");
				var date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
				dates.not(this).datepicker("option", option, date);
			}
			}
  	 	);
	});
 
    
     $.subscribe('upload', function(event,data) {
    
    	document.location.href="<%=request.getContextPath()%>/assess/assess_rectificationReportAdd.shtml";
    	});
    	
      $.subscribe('downloadfile', function(event,data) {
     	if(document.getElementById("che1").checked||document.getElementById("che2").checked){
  			window.location.href="<%=request.getContextPath()%>/images/123.docx"; 
		}else{
			alert("请选择要下载的资料！");
		}
   	 }); 	
     $.subscribe('deletefile', function(event,data) {
     	var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	if(s==''){
    	    alert("请选择删除的资料！");
    	    return;
    	} 
    	var r = $("#gridtable").jqGrid('getRowData',s);
    	if(window.confirm("确定要删除吗？")){
    	    document.location.href="<%=request.getContextPath()%>/document/document_delete.shtml?uid="+r.uid;
    	}
    	});
    
		   $(function(){
		        $(':checkbox[type="checkbox"]').each(function(){
		            $(this).click(function(){
		                if($(this).attr('checked')){
		                    $(':checkbox[type="checkbox"]').removeAttr('checked');
		                    $(this).attr('checked','checked');
		                  //  alert(this.id);
		                }
		            });
		        });
		    }); 
    
    </script>     
    <style type="text/css">
    	td{
			text-align:center;
			}
	</style>
	<div class="grid">
		<fieldset>
		<legend>
			监管意见书管理
		</legend>
		<br>
		<s:form namespace="/document" action="document_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<td class="tdLabel" colspan="1">
			 	<label class="label" >年份:</label>
			</td>
			<td>
			 	<input type="text"   name="asdf" value="" id="asdf">
			</td>
				
			<%-- <td class="tdLabel" colspan="1">
    			<label class="label" >金融机构名称:</label>﻿
			</td>   
	    	<td  colspan="1">
				<select style="height:25px;">
   					<option value="1">招商银行</option>
   					<option value="1">上海商业银行有限公司深圳分行</option>
   					<option value="1">华商银行</option>
   					<option value="1">方正证券深圳分公司</option>
   					<option value="1">浙商证券有限责任公司深圳辖区</option>
   					<option value="1">太平人寿保险有限公司深圳分公司</option>
				</select>
			</td>  --%>
		</s:form>
		<div align="center">
			<sj:submit formIds="document_list"   style="margin-top:7px;"  id="searchbutton" value="查  询"
			timeout="2500" 
				button="true" indicator="indicator" onBeforeTopics="before"
				onCompleteTopics="complete" onErrorTopics="errorState"
				effect="highlight" effectOptions="{ color : '#222222' }"
				effectDuration="3000" />
			<img id="indicator" src="<%=request.getContextPath()%>/images/027.gif" alt="Loading..."
				style="display: none" />
		</div>
	</fieldset><br/>
	
		<sj:submit id="grid_upload_colsbutton" value="整改报告上传"
			onClickTopics="upload" button="true"/>
		<sj:submit id="grid_download_colsbutton" value="文件下载" timeout="2500"
			onClickTopics="downloadfile" button="true" indicator="loading" loadingText="正在下载..."/>
		<sj:submit id="grid_delete_colsbutton" value="文件删除" timeout="2500"
			onClickTopics="deletefile" button="true" indicator="loading" loadingText="正在删除..."/>
			<table class="wwFormTable" >
					<tr style="font-weight: bold;">
						<th width="50">序号</th>
						<th width="100">
							<input  type="checkbox"  id="che"  name="che"  class="cbox" disabled="disabled">
						</th>
						<th width="200">
							金融机构名称
						</th>
						<th width="100" >
							人民银行评级等级
						</th>
						<th  width="100">
							年份
						</th>
						<th  width="100">
							报告类型
						</th>
						<th  width="200" align="center">
							报告名称
						</th>
					</tr>
					<tr>
						<td>
							1
						</td>
						<td >
							<input  type="checkbox"  id="che1"  name="che1"  class="cbox">	
						</td>
						<td >
							招商银行
						</td>
						<td >
							B
						</td>
						<td>
						    2017
						</td>
						<td>
							全年制
						</td>
						<td align="center">
							招商银行整改报告（全年制）
						</td>
					</tr>
					<tr>
						<td>
							2
						</td>
						<td >
							<input  type="checkbox"  id="che2"  name="che2"  class="cbox">	
						</td>
						<td >
							招商银行
						</td>
						<td >
							E
						</td>
						<td>
						    2016
						</td>
						<td>
							上半年
						</td>
						<td align="center">
							招商银行整改报告（上半年）
						</td>
					</tr>
					<tr>
						<td>
							3
						</td>
						<td >
							<input  type="checkbox"  id="che3"  name="che3"  class="cbox">	
						</td>
						<td >
							招商银行
						</td>
						<td >
							E
						</td>
						<td>
						    2016
						</td>
						<td>
							下半年
						</td>
						<td align="center">
							招商银行整改报告（下半年）
						</td>
					</tr>
					
				</table>
	</div>
	
</body>
