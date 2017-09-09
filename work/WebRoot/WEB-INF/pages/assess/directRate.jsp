<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分>>人民银行初评管理</title>

	<script type="text/javascript">
		 $.subscribe('firstRate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateList.shtml";
	  	});
	  	$(function(){
			 $("#return").click(function(){
				 window.history.back();
			 });
		});
		</script>

<style type="text/css">
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}
td{
	text-align:center;
}
textarea.erji{width:90%; height:100%;}
</style>
</head>
<body>
	<div class="grid">
	<fieldset>
		<legend>
			查看附件
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_list" method="post">
		<table class="wwFormTable">
	   		 <tbody>
	   		 	<tr>  
	   		 		<td class="tdLabel" colspan="1">
		    			<label class="label" >直接评定等级:</label>﻿
					</td>   
			    	<td  colspan="1">
						<select style="height:25px;">
							<option value="1">请选择等级</option>
	    					<option value="1">D</option>
	    					<option value="1">E</option>
						</select>
					</td> 
	        	</tr>
	        	
	        	<tr>
	        		<td  colspan="1">
						直接评定理由
					</td> 
					<td>
						<textarea style="width:230px;height:50px;" ></textarea>
					</td>
	        	</tr>
	        	
	        	
	        	
			</tbody>
		</table>
		</s:form>
		<div align="center">
			<input type="submit" id="searchbutton" value="提交" style="margin-top:7px;" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<input type="button" id="return" value="返回" 
									class="ui-button ui-state-default ui-corner-all">			
		</div> 
	</fieldset>
	</div>
	
</body>
