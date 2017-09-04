<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构明细</title>
	<script type="text/javascript">
		$.subscribe('add', function(event,data) {
    	    var s; 
    	    s = $("#gridtable").jqGrid('getGridParam','selarrrow');
    	    var id = <s:property value="#bankbase.id" />;    	    
    	    document.location.href="<%=request.getContextPath()%>/suspiciousbankdetail/suspiciousbankdetail_add.shtml?id="+id;
    	}); 
        $.subscribe('update', function(event,data) { 
	       	var s = $("#gridtable").jqGrid('getGridParam','selrow');	       	
	       	if(s==null){
    	        alert("请选择要修改的记录！");
    	        return;
    	    }
    		var r = $("#gridtable").jqGrid('getRowData',s);    		  		 		
	  		window.location.href="<%=request.getContextPath()%>/suspiciousbankdetail/suspiciousbankdetail_modify.shtml?did="+r.did;
	    }); 	
	   $.subscribe('delete', function(event,data) {
     	    var s = $("#gridtable").jqGrid('getGridParam','selarrrow');
     	    if(s==''){
    	        alert("请选择要删除的记录！");
    	        return;
    	    } 
    	    var r = $("#gridtable").jqGrid('getRowData',s);
    	    if(window.confirm("确定要删除吗？")){
    	        document.location.href="<%=request.getContextPath()%>/suspiciousbankdetail/suspiciousbankdetail_delete.shtml?did="+r.did;
    	    }
    	});  
	</script>
</head>
<body>
	<br>
	<div class="grid">
		<fieldset>
			<legend>
				银行业可疑交易基本信息
			</legend>
			<br>
			<table width="100%" frame="void" class="wwFormTable">
				<tr>
					<td class="tdLabel">
						金融机构名称
					</td>
					<td>
						<s:property value="#bankbase.BOrgInformation.bname" />
					</td>
					<td class="tdLabel">
						金融机构代码
					</td>
					<td>
						<s:property value="#bankbase.BOrgInformation.boid" />
					</td>

				</tr>
				<tr>
					<td class="tdLabel">
						客户名称/姓名
					</td>
					<td>
						<s:property value="#bankbase.cname" />
					</td>
					<td class="tdLabel">
						客户号
					</td>
					<td>
						<s:property value="#bankbase.cid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						客户类型
					</td>
					<td>
						<s:property value="#bankbase.ctype" />
					</td>
					<td class="tdLabel">
						客户国籍
					</td>
					<td>
						<s:property value="#bankbase.cnation" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						客户身份证件/证明文件类型
					</td>
					<td>
						<s:property value="#bankbase.cctype" />
					</td>
					<td class="tdLabel">
						客户身份证件/证明文件号码
					</td>
					<td>
						<s:property value="#bankbase.ccid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						对公客户法定代表人姓名
					</td>
					<td>
						<s:property value="#bankbase.clegal" />
					</td>
					<td class="tdLabel">
						对公客户法定代表人证件类型/号码
					</td>
					<td>
						<s:property value="#bankbase.clegaltype" />/<s:property value="#bankbase.clegalid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						交易期间
					</td>
					<td>
						<s:property value="#bankbase.cperiod" />
					</td>
					<td class="tdLabel">
						线索编号
					</td>
					<td>
						<s:property value="#bankbase.lineid" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						本币累计交易笔数
					</td>
					<td>
						<s:property value="#bankbase.clnum" />
					</td>
					<td class="tdLabel">
						本币累计交易金额
					</td>
					<td>
						<s:property value="#bankbase.clamt" /><s:property value="%{getText('Suspicious.addunit')}"/>
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						外币累计交易笔数
					</td>
					<td>
						<s:property value="#bankbase.cfnum" />
					</td>
					<td class="tdLabel">
						外币累计交易金额
					</td>
					<td>
						<s:property value="#bankbase.cfamt" /><s:property value="%{getText('Suspicious.addunit')}"/>
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						可疑交易特征
					</td>
					<td colspan="3">
						<s:property value="#bankbase.cfeature" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						可疑行为描述
					</td>
					<td colspan="3">
						<s:property value="#bankbase.cdes" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						采取措施
					</td>
					<td colspan="3">
						<s:property value="#bankbase.cmethod" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						其他需要说明的情况
					</td>
					<td colspan="3">
						<s:property value="#bankbase.cother" />
					</td>
				</tr>
				<tr>
					<td class="tdLabel">
						补充文件
					</td>
					<td colspan="3">
						<s:a href="suspicious/suspicious_download.shtml?id=%{#bankbase.id}" title="点击下载"><s:property value="#bankbase.cfile" /></s:a>
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

						<sj:grid id="gridtable" caption="银行业可疑交易明细列表" dataType="json"
							href="../suspiciousbankdetail/suspiciousbankdetail_bankdetaillist.shtml?id=%{#id}" pager="true"
							gridModel="gridModelBankDetail" rowList="10,15,20" rowNum="20"
							rownumbers="true" viewrecords="true" multiselect="true"
							cssStyle="line-height:30px;"
							onSelectRowTopics="rowselect" 
							height="400">
							<sj:gridColumn name="did" index="did" title="ID" sortable="false"
								width="50" hidden="true" />
							<sj:gridColumn name="bname"
								index="bname" title="金融机构名称" sortable="false"
								width="160" />
							<sj:gridColumn name="account" index="account" title="账号"
								sortable="false" width="130" />
							<sj:gridColumn name="BBankBase.lineid" index="BBankBase.lineid" title="线索编号"
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
