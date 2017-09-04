<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>监管评分管理>>监管评分</title>
</head>
<body>
	<fieldset>
		<legend>
			评分录入
		</legend>
		<br>
			
		<s:form namespace="/assess" action="assess_save" method="post"
			cssClass="inputform" theme="simple">
			<table class="wwFormTable">
			<tr>
			<td class="tdLabel">金融机构:</td><td width="35%" style="color:red;font-weight:bold"><s:property value="#information.bname"/></td><!-- session.userinfo. -->
			<td class="tdLabel">考核年度:</td><td width="35%"><s:textfield name="year" reg="^\d{4}$" tip="只能输入4位数字"/></td>
			</tr>
			</table>
			<br>
<table id="gridtable" class="wwFormTable"></table> 
<div id="gridtable_pager"></div> 
 
<script type='text/javascript'> 
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
</script> 
			<br>
			<table class="wwFormTable">
				<tr style="font-weight: bold;">
					<th width="5%">序号</th>
					<th width="13%"><!-- -2 -->
						考核项目
					</th>
					<th width="27%">
						考核细项
					</th>
					<th width="15%"><!-- -2 -->
						备注说明
					</th>
					<th width="8%">
						自评得分
					</th>
					<th width="5%"><!-- -1 -->
						+极值
					</th>
					<th width="5%"><!-- -1 -->
						-极值
					</th>
					<th width="6%">
						得分
					</th>
					<th width="16%"><!-- -2 -->
						备注
					</th>
				</tr>
				<s:iterator value="list" status="index" var="l">
					<s:if test="%{#l[8]==0}">
								<tr style="font-weight: bold;font-style: italic"><td><s:property value='#l[0]' /></td><td colspan="8"><s:property value='#l[1]' /></td></tr>
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
							<s:property value="#l[10]"/>
						</td>
						<td>
							<s:property value="#l[4]"/>
						</td>
						<td>
							<s:property value="#l[5]"/>
						</td>
						<td>
							<s:textfield name="%{#l[9]}" size="1" cssClass="num" value="%{#l[6]}"></s:textfield>
						</td>
						<td>
							<s:textarea name="input%{#l[9]}"  value="%{#l[7]}" cssStyle="width:88%;height:100%;overflow:hidden" cols="10"></s:textarea>
						</td>
						<s:hidden name="orgZpScore_%{#l[9]}" value="%{#l[10]}"></s:hidden>
						<s:hidden name="orgzPRemark_%{#l[9]}" value="%{#l[11]}"></s:hidden>
					</tr>
					</s:else>
				</s:iterator>
				<tr><td colspan="9" align="center">
				<s:hidden name="oid" value="%{oid}"></s:hidden>
				<s:submit theme="simple" align="center"  value="评分录入" cssClass="ui-button ui-state-default ui-corner-all"></s:submit>
			</td></tr>
			</table>
		</s:form>
	</fieldset><br/>

</body>
