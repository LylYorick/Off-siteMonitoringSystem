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
#core{
overflow-x:hidden;
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
		    			<label class="label" >一级指标名称:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;">
						    <option value="01">1制度完善程度</option>
						    <option value="02">2.机制合理性</option>
						    <option value="03">3.技术保障能力</option>
						    <option value="04">4.人员配备、资质及履职情况</option>
						</select>
					</td> 
						<td class="tdLabel" colspan="1">
		    			<label class="label" >二级指标名称:</label>﻿
					</td>   
			    	<td class="ldLabel" colspan="1">
						<select style="height:25px;width:250px">
	    					<option value="1">1.1内控制度体系全面覆盖法律法规和监管要求涉及的反洗钱各方面义务，各项反洗钱内控措施符合法规要求</option>
	    					<option value="1">1.2根据法律法规和监管要求以及本机构业务发展和反洗钱工作实际及时修订或更新内控制度</option>
	    					<option value="1">1.3及时向人民银行报备内控制度</option>
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
	<table id="gridtable" class="wwFormTable"></table> 
	<div id="gridtable_pager" ></div> 
	<table class="wwFormTable" style="width: 100%" id="tabel_detail">
				<tr style="font-weight: bold;">
					<th width="15%">
						指标名称
					</th>
					<th width="25%">
						指标描述
					</th>
					<th  width="30%">
					    评分标准
					</th>
					<th  width="25%">
						自评理由要求
					</th>
					<th  width="5%" align="center">
						分值
					</th>
				</tr>
					<tr>
					<td >
						<textarea readonly="readonly" class="erji textarea alterTextarea" >1制度完善程度</textarea>
					</td>
					<td >
						<textarea  readonly="readonly" class="erji textarea alterTextarea" >结合自身业务特点，按照洗钱风险防控、预警和处理程序以及相应的反洗钱要求，建立健全反洗钱内控制度，落实各项监管要求。重点评价制度完备性、修订及时性、报备自觉性。</textarea>
					</td>
					<td>
						<textarea readonly="readonly"class="erji alterTextarea">1.未建立客户身份识别、客户风险等级划分和分类管理、大额交易和可疑交易报告、客户身份资料和交易记录保存、反恐怖融资、涉恐资产冻结、洗钱风险自评估、分支机构反洗钱工作管理、反洗钱保密、内部审计、宣传培训、绩效考核、责任追究以及协助反洗钱调查等制度，缺1项扣1分；2.未将反洗钱工作要求分解、细化到每一个业务环节和操作岗位，发现1次扣1分。最多扣3分。</textarea>
					</td>
					<td>
						<textarea   readonly="readonly"class="erji textarea alterTextarea" id="allowTextarea">请重点说明xx年度制度新建、修订和废止情况。</textarea>
					</td>
					<td>
						5
					</td>
				</tr>
			</table>
			<br/>
			<table class="wwFormTable" style="width: 100%;" id="tabel_detail" >
				<tr style="font-weight: bold;">
					<th  width="5%">
						年度
					</th>
					<th  width="5%">
						机构类型
					</th>
					<th width="10%">
						机构名称
					</th>
					<th width="5%">
						自评得分
					</th>
					<th width="15%">
						自评理由
					</th>
					<th  width="10%">
						自评附件
					</th>
					<th width="5%" >
						评级得分
					</th>
					<th  width="15%">
					 	评级理由
					</th>
				</tr>
				<tr>
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
						4
					</td>
					<td>
						<textarea class="textarea alterTextarea" disabled="disabled">本机构认为并没有存在下列任一情形，可以直接评定为E类机构：（1）不配合反洗钱调查工作，拒绝提供信息资料；
						（2）提供信息资料存在重大事项隐瞒、重大信息遗漏、虚假陈述或误导性陈述，情节严重的；（3）存在其他重大问题，严重影响反洗钱调查工作的。希望重新评定为B级。申请材料详见附件</textarea>
						</textarea>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<br/>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="内控措施.docx">内控措施.docx</a></br>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="各项举措.docx">各项举措.docx</a>
						<br/>
						<a href="<%=request.getContextPath()%>/images/logo1.jpg" download="材料图片.jpg">材料图片.jpg</a>
					</td>
					<td>
						4
					</td>
					<td>
						<textarea  class="textarea alterTextarea" disabled="disabled">违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
					</td>
				</tr>
				<tr>
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
						5
					</td>
					<td>
						<textarea class="textarea alterTextarea" disabled="disabled">本机构认为完全符合此指标的标准，详情见附件</textarea>
						</textarea>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="制度体系.docx">制度体系.docx</a>
						<br/>
						<a href="<%=request.getContextPath()%>/images/123.docx" download="内控措施.docx">内控措施.docx</a></br>
					</td>
					<td>
						4
					</td>
					<td>
						<textarea  class="textarea alterTextarea" disabled="disabled">违反保密规定，出现失密、泄密情况，导致严重后果</textarea>
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