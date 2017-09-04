<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分管理>>监管评分</title>
	<script type="text/javascript">
		/**年份改变就刷新*/
		function refreshData(){
			
			var currOid=$("#oid").val();
			var selYear=$("#year").val();
			var dfltYear=${defaultYear};//默认年份为现在年份
			
			if(parseInt(selYear)>parseInt(dfltYear)){
				alert("当前年份还不能录入评分！");
				$("#year").val(dfltYear);
				selYear=dfltYear;
			}
			window.location.href="<%=request.getContextPath()%>/assess/assess_selfevalentry.shtml?oid="+currOid+"&year="+selYear;
		}
	</script>
</head>
<body>
	<fieldset>
		<legend>
			机构自评评分录入
		</legend>
		<br>
			
		<s:form namespace="/assess" action="assess_save2" method="post"
			cssClass="inputform" theme="simple">
			<table class="wwFormTable">
			<tr>
				<td class="tdLabel">金融机构:</td><td width="40%" style="color:red;font-weight:bold"><s:property value="#information.bname"/></td>
				<%-- <td class="tdLabel">考核年度:</td><td width="25%"><s:textfield name="year" value="%{#defaultYear}" reg="^\d{4}$" tip="只能输入4位数字" onblur="refreshData();"/></td> --%>
				<td class="tdLabel">考核年度:</td><td width="25%"><s:select id="year" name="year" list="#yearList"
					 headerKey="-1" headerValue="%{#defaultYear}" multiple="false" onchange="refreshData();"/></td>
				<td class="tdLabel">自评分数:</td><td width="25%"><s:textfield name="s_evalScore" value="%{#s_evalScore}" disabled="true"/></td>
				
			</tr>
			</table><br>
<table id="gridtable" class="wwFormTable"></table> 
<div id="gridtable_pager"></div> 
 
<%-- <script type='text/javascript'> 
$(document).ready(function () { 
	var options_gridtable = {};
	var options_gridtable_colmodels = new Array();
	var options_gridtable_colnames = new Array();


			
options_gridtable_colmodels_taidi = {};
options_gridtable_colmodels_taidi.name = "taidi";
options_gridtable_colmodels_taidi.jsonmap = "taidi";
options_gridtable_colmodels_taidi.index = "taidi";
options_gridtable_colmodels_taidi.width = 30;
options_gridtable_colmodels_taidi.editable = false;
options_gridtable_colmodels_taidi.sortable = false;
options_gridtable_colmodels_taidi.resizable = true;
options_gridtable_colmodels_taidi.search = true;
options_gridtable_colnames.push("ID");
options_gridtable_colmodels.push(options_gridtable_colmodels_taidi);


			
options_gridtable_colmodels_taidate = {};
options_gridtable_colmodels_taidate.name = "taidate";
options_gridtable_colmodels_taidate.jsonmap = "taidate";
options_gridtable_colmodels_taidate.index = "taidate";
options_gridtable_colmodels_taidate.width = 140;
options_gridtable_colmodels_taidate.editable = false;
options_gridtable_colmodels_taidate.sortable = false;
options_gridtable_colmodels_taidate.resizable = true;
options_gridtable_colmodels_taidate.search = true;
options_gridtable_colnames.push("日期");
options_gridtable_colmodels.push(options_gridtable_colmodels_taidate);


			
options_gridtable_colmodels_taiauthor = {};
options_gridtable_colmodels_taiauthor.name = "taiauthor";
options_gridtable_colmodels_taiauthor.jsonmap = "taiauthor";
options_gridtable_colmodels_taiauthor.index = "taiauthor";
options_gridtable_colmodels_taiauthor.width = 100;
options_gridtable_colmodels_taiauthor.editable = false;
options_gridtable_colmodels_taiauthor.sortable = false;
options_gridtable_colmodels_taiauthor.resizable = true;
options_gridtable_colmodels_taiauthor.search = true;
options_gridtable_colnames.push("修改人");
options_gridtable_colmodels.push(options_gridtable_colmodels_taiauthor);


			
options_gridtable_colmodels_taireason = {};
options_gridtable_colmodels_taireason.name = "taireason";
options_gridtable_colmodels_taireason.jsonmap = "taireason";
options_gridtable_colmodels_taireason.index = "taireason";
options_gridtable_colmodels_taireason.width = 660;
options_gridtable_colmodels_taireason.editable = false;
options_gridtable_colmodels_taireason.sortable = false;
options_gridtable_colmodels_taireason.resizable = true;
options_gridtable_colmodels_taireason.search = true;
options_gridtable_colnames.push("事由");
options_gridtable_colmodels.push(options_gridtable_colmodels_taireason);


			options_gridtable.datatype = "json";
	options_gridtable.url = "/work/assess/../financial/financial_tailist.shtml?oid=<s:property value='oid'/>&amp;year=";
	options_gridtable.height = 'auto';
	options_gridtable.pager = "gridtable_pager";
	options_gridtable.rowNum = 20;
	options_gridtable.rowList = [10,15,20];
	options_gridtable.viewrecords = true;
	options_gridtable.multiselect = true;
	options_gridtable.caption = "台账列表";
	options_gridtable.shrinkToFit = true;
	options_gridtable.autoencode = true;
	options_gridtable.rownumbers = true;
	options_gridtable.onselectrowtopics = "rowselect";
 
 
	options_gridtable.colNames = options_gridtable_colnames;
	options_gridtable.colModel = options_gridtable_colmodels;
	options_gridtable.jsonReader = {};
	options_gridtable.jsonReader.root = "gridModel";
	options_gridtable.jsonReader.page = "page";
	options_gridtable.jsonReader.total = "total";
	options_gridtable.jsonReader.records = "records";
	options_gridtable.jsonReader.repeatitems = false;
	options_gridtable.jqueryaction = "grid";

	options_gridtable.id = "gridtable";

 
$.struts2_jquery.bind($('#gridtable'),options_gridtable);



 });  
</script>  --%>
			<!-- <br> -->
			<table class="wwFormTable">
				<tr style="font-weight: bold;">
					<th width="5%">序号</th>
					<th width="15%">
						考核项目
					</th>
					<th width="27%">
						考核细项
					</th>
					<th width="17%">
						备注说明
					</th>
					<th width="6%">
						+极值
					</th>
					<th width="6%">
						-极值
					</th>
					<th width="8%">
						自评得分
					</th>
					<th width="16%">
						自评备注
					</th>
				</tr>
				<s:iterator value="list" status="index" var="l">
					<s:if test="%{#l[8]==0}">
								<tr style="font-weight: bold;font-style: italic"><td><s:property value='#l[0]' /></td><td colspan="7"><s:property value='#l[1]' /></td></tr>
					</s:if>
					<s:else>
					<tr>
						<td>
							<s:property value="#l[0]"/>
						</td>
						<td>
							<s:property value="#l[1]"/>
						</td>
						<td>
							<s:property value="#l[2]"/>
						</td>
						<td>
							<s:property value="#l[3]"/>
						</td>
						<td>
							<s:property value="#l[4]"/>
						</td>
						<td>
							<s:property value="#l[5]"/>
						</td>
						<td>
							<s:textfield name="%{#l[9]}" size="2" cssClass="num" value="%{#l[6]}"></s:textfield>
						</td>
						<td>
							<s:textarea name="input%{#l[9]}"  value="%{#l[7]}" cssStyle="width:90%;height:100%;overflow:hidden" cols="10"></s:textarea>
						</td>
						<s:hidden name="orgScore_%{#l[9]}" value="%{#l[10]}"></s:hidden>
						<s:hidden name="orgRemark_%{#l[9]}" value="%{#l[11]}"></s:hidden>
					</tr>
					</s:else>
				</s:iterator>
				<tr><td colspan="8" align="center">
				<s:hidden id="oid" name="oid" value="%{oid}"></s:hidden>
				<s:submit theme="simple" align="center"  value="录入" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
			</table>
		</s:form>
	</fieldset><br/>

</body>
