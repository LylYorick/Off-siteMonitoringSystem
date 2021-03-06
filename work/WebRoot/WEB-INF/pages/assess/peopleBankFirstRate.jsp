<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
	<title>监管评分>>人民银行初评管理</title>

	<script type="text/javascript">
		 $.subscribe('rate', function(event,data) {
			 if(document.getElementById("checkbox1").checked||document.getElementById("checkbox2").checked||document.getElementById("checkbox3").checked
			 ||document.getElementById("checkbox4").checked||document.getElementById("checkbox5").checked ){
			 	if(document.getElementById("checkbox2").checked || document.getElementById("checkbox3").checked||document.getElementById("checkbox4").checked){
			 	 if(confirm("该记录已经初评过,是否仍要再次初评。")){
	  				window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateList.shtml";
			 	 }
			 	
			 	}else  if(document.getElementById("checkbox5").checked){
			 	 alert("此记录。已经审核通过。禁止再次初评。");
			 	 }else{
		  			window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateList.shtml";
			 	}
			}else{
				alert("请选择一条记录");
			}
	  	});
	  	 $.subscribe('view', function(event,data) {
	  	  if(document.getElementById("checkbox1").checked||document.getElementById("checkbox2").checked||document.getElementById("checkbox3").checked
			 ||document.getElementById("checkbox4").checked||document.getElementById("checkbox5").checked ){
	  			window.location.href="<%=request.getContextPath()%>/assess/assess_peopleBankFirstRateView.shtml";
			}else{
				alert("请选择一条记录");
			}
	  	});
	  	 $.subscribe('processOpposition', function(event,data) {
	  	  if(document.getElementById("checkbox1").checked||document.getElementById("checkbox2").checked||document.getElementById("checkbox3").checked
			 ||document.getElementById("checkbox4").checked||document.getElementById("checkbox5").checked ){
	  			document.location.href="<%=request.getContextPath()%>/assess/assess_manageOppositionList.shtml";
			}else{
				alert("请选择一条记录");
			}
    	});
	  	 $.subscribe('updateOpinion', function(event,data) {
	  		 if(document.getElementById("checkbox1").checked||document.getElementById("checkbox2").checked||document.getElementById("checkbox3").checked
			 ||document.getElementById("checkbox4").checked||document.getElementById("checkbox5").checked ){
	  			document.location.href="<%=request.getContextPath()%>/assess/assess_superviseOpinionAdd.shtml";
			}else{
				alert("请选择一条记录");
			}
    	});
	  	<%--  $.subscribe('directRate', function(event,data) {
	    	window.location.href="<%=request.getContextPath()%>/assess/assess_directRate.shtml";
	  	}); --%>
	  	
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
.span_left{
	float:right; 
	padding:.4em 1em; 
	height:17px;
	margin-left:5px;
}


</style>
</head>
<body>
	<div class="grid">
	<fieldset>
		<legend>
			查询条件
		</legend>
		<br>
		<s:form namespace="/assess" action="assess_list" method="post">
		<table class="wwFormTable" >
	   		 <tbody>
	   		 	<tr>  
	   		 		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">年度:</label>
					</td> 
					<td class="ldLabel" colspan="1" >
		    			<input type="text" name="year" value="2017" id="assess_list_year" >﻿
					</td>   
		    		<td class="tdLabel" colspan="1">
						<label for="assess_list_year" class="label">评级表类型:</label>
					</td> 
					<td class="ldLabel" colspan="1" >
						<select style="height:25px;">
		    					<option value="1">法人评级类型</option>
		    					<option value="1">非法人评级类型</option>
		    			</select>
					</td>   
	        	</tr>
	        	<tr>  
	        		<td class="tdLabel" colspan="1">
		    			<label class="label" >机构类型:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;">
						    <option value="01">银行业</option>
						    <option value="02">证券业</option>
						    <option value="03">保险业</option>
						    <option value="04">基金业</option>
						    <option value="05">期货业</option>
						    <option value="06">第三方支付</option>
						    <option value="07">六类</option>
						    <option value="08">证券或基金子公司</option>
						    <option value="09">其他</option>
						</select>
					</td> 
					<td class="tdLabel" colspan="1">
		    			<label class="label" >金融机构名称:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;">
							<option value="1">--请选择--</option>
	    					<option value="1">招商银行</option>
	    					<option value="1">上海商业银行有限公司深圳分行</option>
	    					<option value="1">华商银行</option>
	    					<option value="1">渤海银行深圳分行</option>
	    					<option value="1">浙商证券有限责任公司深圳辖区</option>
	    					<option value="1">太平人寿保险有限公司深圳分公司</option>
						</select>
					</td> 
	        	</tr>
	        	<tr>  
	        		<td class="tdLabel" colspan="1">
		    			<label class="label" >状态:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;">
						    <option value="01">自评阶段—>自评中</option>
						    <option value="01">自评阶段—>待复核</option>
						    <option value="01">自评阶段—>复核通过</option>
						    <option value="01">自评阶段—>复核拒绝</option>
						    <option value="01">初评阶段-->待初评</option>
						    <option value="01">初评阶段-->已初评</option>
						    <option value="01">复评阶段-->复评公示</option>
						    <option value="01">复评阶段-->复评中</option>
						    <option value="01">结果公示阶段</option>
						</select>
					</td> 
					<td class="tdLabel" colspan="1">
		    			<label class="label" >自评得分:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<input type="text" name="year" style="width:50px;" > - <input type="text" name="year" style="width:50px;" >
					</td> 
	        	</tr>
	        	<tr>
					<td class="tdLabel" colspan="1">
		    			<label class="label" >评级得分:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<input type="text" name="year" style="width:50px;" > - <input type="text" name="year" style="width:50px;" >
					</td> 
					<td class="tdLabel" colspan="1">
		    			<label class="label" >最终等级:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
							<select style="height:25px;">
						    <option value="01">AAA</option>
						    <option value="01">AA</option>
						    <option value="01">A</option>
						    <option value="01">BBB</option>
						    <option value="01">BB</option>
						    <option value="01">B</option>
						    <option value="01">CCC</option>
						    <option value="01">CC</option>
						    <option value="01">C</option>
						    <option value="01">D</option>
						    <option value="01">E</option>
						</select>
					</td> 
	        	</tr>
			</tbody>
		</table>
		</s:form>
		<div align="center">
			<input type="submit" id="searchbutton" value="查  询" style="margin-top:7px;" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<img id="indicator" src="/work/images/027.gif" alt="Loading..." style="display: none">
			<input type="submit" id="searchbutton" value="导出excel" style="margin-top:7px;" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" aria-disabled="false">
			<img id="indicator" src="/work/images/027.gif" alt="Loading..." style="display: none">
		</div>
	</fieldset>
	<div  class="ui-banner  ui-noBottomboder">
		<sj:submit id="view" value="查看"
			onClickTopics="view" button="true" />
		<sj:submit id="rate" value="评级"
			onClickTopics="rate" button="true" />
	<%-- 	<sj:submit id="directRate" value="直接定级提交"
			onClickTopics="directRate" button="true" /> --%>
		<%-- <span  class=" span_left ">当前机构类型:银行业</span> --%>
	</div>
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
			<table class="wwFormTable" style="width: 100%;" id="tabel_detail" >
				<tr style="font-weight: bold;">
					<th width="3%">
						
					</th>
					<th width="3%">
						<input type="checkbox" id="checkbox" name="checkbox" value="checkbox" disabled="disabled">
					</th>
					<th width="5%">年度</th>
					<th width="10%">
						机构类型
					</th>
					<th width="20%">
						机构名称
					</th>
					<th width="10%">
						状态
					</th>
					<th width="5%" >
						自评得分
					</th>
					<th  width="5%">
					 	评级得分
					</th>
					<th  width="5%">
						评级等级
					</th>
					<th  width="5%">
						定级等级
					</th>
					<th  width="20%">
						定级理由
					</th>
					<th  width="20%">
						审核拒绝理由
					</th>
				</tr>
				<tr>
					<td>
						1
					</td>
					<td>
						<input type="checkbox"  id="checkbox1"  name="checkbox1" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						上海商业银行有限公司深圳分行
					</td>
					<td>
						人行初评
					</td>
					<td>
						80
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
						
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
					
				</tr>
				<tr>
					<td>
						2
					</td>
					<td>
						<input type="checkbox"  id="checkbox2"  name="checkbox2" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						渤海银行深圳分行
					</td>
					<td>
						初评结束
					</td>
					<td>
						90
					</td>
					<td>
						89
					</td>
					<td>
						A
					</td>
					<td>
						
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						3
					</td>
					<td>
						<input type="checkbox"  id="checkbox3"  name="checkbox3" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						平安银行总行
					</td>
					<td>
						待复核
					</td>
					<td>
						80
					</td>
				
					<td>
					</td>
					<td>
					</td>
					<td>
						E
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled">违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						4
					</td>
					<td>
						<input type="checkbox"  id="checkbox4"  name="checkbox4" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						华商银行
					</td>
					<td>
						待复核
					</td>
					<td>
						90
					</td>
					<td>
						51
					</td>
					<td>
						D
					</td>
					<td>
						
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
				</tr>
				
				<tr>
					<td>
						5
					</td>
					<td>
						<input type="checkbox"  id="checkbox5"  name="checkbox5" value="checkbox">
					</td>
					<td>
						2017
					</td>
					<td>
						银行业
					</td>
					<td>
						广东发展银行深圳分行
					</td>
					<td>
						初评结束
					</td>
					<td>
						90
					</td>
					<td>
						51
					</td>
					<td>
						D
					</td>
					<td>
						
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
					<td>
						<textarea   class="textarea alterTextarea" disabled="disabled"></textarea>
					</td>
				</tr>
			</table>
	</div>
	
</body>

	<script type="text/javascript">
		function checkNum(cellvalue, options, rowObject) { 
			if(cellvalue>=80){
				return "<span style='color:green;'>"+cellvalue+"</span>";
				}else if(cellvalue>50){
					return "<span style='color:red'>"+cellvalue+"</span>";
				}else{
					return "<span style='color:blue;font-weight:bold'>"+cellvalue+"</span>";
				}
        } 
	</script>