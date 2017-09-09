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
	   		 		<td  colspan="1">
	   		 			测试图片
						<%-- <img alt="测试图片" src="<%=request.getContextPath()%>/images/logo1.jpg"> --%>
					</td> 
					<td  colspan="1">
						<a target="_blank" href="<%=request.getContextPath()%>/images/logo1.jpg" >查看图片</a>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="w3logo">下载图片</a>
					</td> 
	        	</tr>
	        	
	        	<tr>
	        		<td  colspan="1">
						测试附件
					</td> 
					<td  colspan="1">
					<%-- 	<a target="_blank" href="<%=request.getContextPath()%>/images/123.docx" >查看附件</a> --%>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="自评附件">下载</a>
					</td> 
	        	</tr>
			</tbody>
		</table>
		</s:form>
		 <div align="center"  style="margin-top: 5px">
			<input type="button" id="return" value="返回" 
									class="ui-button ui-state-default ui-corner-all">
		</div> 
	</fieldset>
	</div>
	
</body>
