<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>重点可疑交易管理>>重点可疑交易明细</title>
	<script type="text/javascript">
		$.subscribe('add', function(event,data) {
    	    var s; 
    	    s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	    var id = '<s:property value="#insurancebase.siid" />';    	    
    	    document.location.href="<%=request.getContextPath()%>/suspiciousinsurancedetail/suspiciousinsurancedetail_add.shtml?id="+id;
    	}); 
        $.subscribe('update', function(event,data) { 
	       	var s = $("#gridtable").jqGrid('getGridParam','selrow');	       	
	       	if(s==null){
    	        alert("请选择要修改的记录！");
    	        return;
    	    }
    		var r = $("#gridtable").jqGrid('getRowData',s);    		  		 		
	  		window.location.href="<%=request.getContextPath()%>/suspiciousinsurancedetail/suspiciousinsurancedetail_modify.shtml?dssid="+r.dssid;
	    }); 	
	   $.subscribe('delete', function(event,data) {
     	    var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	    if(s==''){
    	        alert("请选择要删除的记录！");
    	        return;
    	    } 
    	    var r = $("#gridtable").jqGrid('getRowData',s);
    	    if(window.confirm("确定要删除吗？")){
    	        document.location.href="<%=request.getContextPath()%>/suspiciousinsurancedetail/suspiciousinsurancedetail_delete.shtml?dssid="+r.dssid;
    	    }
    	});  
	</script>
</head>
<body>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				保险业可疑交易基本信息
			</legend>
			<br>
			<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						金融机构名称
					</td>
					<td>
						<s:property value="#insurancebase.BOrgInformation.bname" />
					</td>
					<td class="tdLabel">
						金融机构代码
					</td>
					<td>
						<s:property value="#insurancebase.BOrgInformation.oid" />
					</td>

				</tr>
				<tr>
					<td class="tdLabel">
						投保人名称/姓名
					</td>
					<td>
						<s:property value="#insurancebase.cname" />
					</td>
					<td class="tdLabel">
						投保人类型
					</td>
					<td>
						<s:property value="#insurancebase.ctype" />
					</td>					
				</tr>
				<tr>					
					<td class="tdLabel">
						投保人身份证件类型
					</td>
					<td>
						<s:property value="#insurancebase.cctype" />
					</td>
					<td class="tdLabel">
						投保人身份证件号码
					</td>
					<td>
						<s:property value="#insurancebase.ccid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						客户职业和客户行业
					</td>
					<td>
						<s:property value="#insurancebase.professional" />
					</td>
					<td class="tdLabel">
						对公客户法定代表人姓名
					</td>
					<td>
						<s:property value="#insurancebase.clegal" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						对公客户法定代表人身份证件类型
					</td>
					<td>
						<s:property value="#insurancebase.clegaltype" />
					</td>
					<td class="tdLabel">
						对公客户法定代表人身份证件号码
					</td>
					<td>
						<s:property value="#insurancebase.clegalid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						被保险人总数
					</td>
					<td>
						<s:property value="#insurancebase.cpnum" />
					</td>
					<td class="tdLabel">
						被保险人名称
					</td>
					<td>
						<s:property value="#insurancebase.ciname" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						被保险人身份证件类型
					</td>
					<td>
						<s:property value="#insurancebase.citype" />
					</td>
					<td class="tdLabel">
						被保险人身份证件号码
					</td>
					<td>
						<s:property value="#insurancebase.ciid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						投保人与被保险人的关系
					</td>
					<td>
						<s:property value="#insurancebase.crelation" />
					</td>
					<td class="tdLabel">
						受益人总数
					</td>
					<td>
						<s:property value="#insurancebase.ctotal" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						受益人名称
					</td>
					<td>
						<s:property value="#insurancebase.csname" />
					</td>
					<td class="tdLabel">
						受益人身份证件类型
					</td>
					<td>
						<s:property value="#insurancebase.cstype" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						受益人身份证件号码
					</td>
					<td>
						<s:property value="#insurancebase.csid" />
					</td>
					<td class="tdLabel">
						线索编号
					</td>
					<td>
						<s:property value="#insurancebase.lineid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						可疑交易特征
					</td>
					<td colspan="3">
						<s:property value="#insurancebase.cfeature" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						保险合同总份数
					</td>
					<td>
						<s:property value="#insurancebase.cmnum" />
					</td>
					<td class="tdLabel">
						外币累计交易金额
					</td>
					<td>
						<s:property value="#insurancebase.cfamt" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						保险种类
					</td>
					<td>
						<s:property value="#insurancebase.cmtype" />
					</td>
					<td class="tdLabel">
						保险合同号
					</td>
					<td>
						<s:property value="#insurancebase.cmcid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						保险名称
					</td>
					<td>
						<s:property value="#insurancebase.cmname" />
					</td>
					<td class="tdLabel">
						保险期间
					</td>
					<td>
						<s:property value="#insurancebase.cmperiod" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						保险标的
					</td>
					<td>
						<s:property value="#insurancebase.cmsubject" />
					</td>
					<td class="tdLabel">
						保险金额
					</td>
					<td>
						<s:property value="#insurancebase.cmamt" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						保险费
					</td>
					<td>
						<s:property value="#insurancebase.cmpay" />
					</td>
					<td class="tdLabel">
						缴费方式
					</td>
					<td>
						<s:property value="#insurancebase.cmmethod" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						采取措施
					</td>
					<td colspan="3">
						<s:property value="#insurancebase.cmethod" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						其他需要说明的情况
					</td>
					<td colspan="3">
						<s:property value="#insurancebase.cother" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						补充文件
					</td>
					<td colspan="3">
						<s:a href="suspiciousinsurance/suspiciousinsurance_download.shtml?id=%{#insurancebase.siid}" title="点击下载"><s:property value="#insurancebase.cfile" /></s:a>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<sj:submit id="grid_add_colsbutton" value="添加可疑交易明细"
							onClickTopics="add" button="true" />
						<sj:submit id="grid_update_colsbutton" value="修改"
							onClickTopics="update" button="true" />
						<sj:submit id="grid_delete_colsbutton" value="删除"
							onClickTopics="delete" button="true" />						

						<sj:grid id="gridtable" caption="保险业可疑交易明细列表" dataType="json"
							href="../suspiciousinsurancedetail/suspiciousinsurancedetail_insurancedetaillist.shtml?id=%{#id}" pager="true"
							gridModel="gridModelInsuranceDetail" rowList="10,15,20" rowNum="20"
							rownumbers="true" viewrecords="true" multiselect="true"
							cssStyle="line-height:30px;"
							onSelectRowTopics="rowselect"
							height="400">
							<sj:gridColumn name="dssid" index="dssid" title="ID" sortable="false" hidden="true"
								width="50"/>
							<sj:gridColumn name="bname"
								index="bname" title="金融机构名称" sortable="false"
								width="160" />
							<sj:gridColumn name="iaccount" index="iaccount" title="资金账号"
								sortable="false" width="130" />
							<sj:gridColumn name="BInsuranceBase.lineid" index="BInsuranceBase.lineid" title="线索编号"
								sortable="false" width="130" />
							<sj:gridColumn name="trandate" index="trandate" title="交易日期"
								sortable="false" width="130" />
							<sj:gridColumn name="tranmethod" index="tranmethod" title="交易方式"
								sortable="false" width="130" />	
							<sj:gridColumn name="lamt" index="lamt" title="交易额（按原币计）"
								sortable="false" width="130" />
							<sj:gridColumn name="fmat" index="fmat" title="交易额（折合美元）"
								sortable="false" width="130" />
						</sj:grid>
					</td>
				</tr>
			</table>
		</fieldset><br/>
	</div>
</body>
