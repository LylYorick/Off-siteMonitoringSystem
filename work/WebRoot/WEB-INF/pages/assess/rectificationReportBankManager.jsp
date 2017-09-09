<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分管理>>整改报告管理</title>
</head>
<body>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
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
  			window.location.href="<%=request.getContextPath()%>/images/123.docx"; 
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
	<div class="grid">
		<fieldset>
		<legend>
			报告查询
		</legend>
		<br>
		<s:form namespace="/document" action="document_list" method="post">

			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{4}" />
			</s:bean>
			<td class="tdLabel" colspan="1">
			 	<label class="label" >年份:</label>
			</td>
			<td align="left">
			 	<input type="text"   name="asdf" value="" id="asdf">
			</td>
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
		<div  class="ui-banner  ui-noBottomboder">
			<sj:submit id="grid_upload_colsbutton" value="整改报告上传"
				onClickTopics="upload" button="true"/>
		</div>
			<table class="wwFormTable"  id="tabel_detail" style="width: 100%" >
					<tr style="font-weight: bold;">
						<th width="50">序号</th>
						<th style="min-width:100px">
							文件操作
						</th>
						<th style="min-width:200px">
							金融机构名称
						</th>
						<th width="100" >
							评级等级
						</th>
						<th  width="100">
							年份
						</th>
						<th  width="100">
							报告类型
						</th>
						<th  style="min-width:320px" align="center">
							报告名称
						</th>
					</tr>
					<tr>
						<td>
							1
						</td>
						<td >
							<sj:submit id="grid_download_colsbutton" value="下载" timeout="2500"
									onClickTopics="downloadfile" button="true" indicator="loading" loadingText="正在下载..."/>
							<sj:submit id="grid_delete_colsbutton" value="删除" timeout="2500"
									onClickTopics="deletefile" button="true" indicator="loading" loadingText="正在删除..."/>
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
							<sj:submit id="grid_download_colsbutton1" value="下载" timeout="2500"
										onClickTopics="downloadfile" button="true" indicator="loading" loadingText="正在下载..."/>
							<sj:submit id="grid_delete_colsbutton1" value="删除" timeout="2500"
										onClickTopics="deletefile" button="true" indicator="loading" loadingText="正在删除..."/>
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
							<sj:submit id="grid_download_colsbutton2" value="下载" timeout="2500"
									onClickTopics="downloadfile" button="true" indicator="loading" loadingText="正在下载..."/>
							<sj:submit id="grid_delete_colsbutton2" value="删除" timeout="2500"
									onClickTopics="deletefile" button="true" indicator="loading" loadingText="正在删除..."/>
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
