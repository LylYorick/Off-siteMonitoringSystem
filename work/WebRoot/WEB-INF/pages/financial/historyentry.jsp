<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构变更记录</title>
</head>
<body>
		<s:url id="remoteurl" action="../financial/financial_history.shtml"/> 
		<sj:grid id="gridtable" caption="金融机构变更记录列表" dataType="json" href="%{remoteurl}" 
			pager="true" gridModel="gridModelhistory"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">			
			<sj:gridColumn name="bname" index="bname" title="机构名称" sortable="false" width="100" />
			<sj:gridColumn name="baddr" index="baddr" title="办公地址" sortable="false" width="200" />
			<sj:gridColumn name="bbrchnum" index="bbrchnum" title="深圳分支机构数量" sortable="false" width="100" />
			<sj:gridColumn name="blead" index="blead" title="分管领导" sortable="false" width="100" />
			<sj:gridColumn name="bleadpst" index="bleadpst" title="领导职务" sortable="false" width="100" />
			<sj:gridColumn name="bleadtel" index="bleadtel" title="领导联系电话" sortable="false" width="100" />
			<sj:gridColumn name="bdept" index="bdept" title="反洗钱部门" sortable="false" width="100" />
			<sj:gridColumn name="bdeptlead" index="bdeptlead" title="部门负责人" 	sortable="false" width="100" />			
			<sj:gridColumn name="bdeptleadtel" index="bdeptleadtel" title="负责人办公电话" 	sortable="false" width="110" />
			<sj:gridColumn name="bdeptleadphe" index="bdeptleadphe" title="负责人手机号码" 	sortable="false" width="110" />
			<sj:gridColumn name="bdeptlead" index="bdeptlead" title="部门负责人" 	sortable="false" width="100" />			
			<sj:gridColumn name="bwork" index="bwork" title="反洗钱联系人" sortable="false" width="100" />
			<sj:gridColumn name="bworktel" index="bworktel" title="联系电话" 	sortable="false" width="100" />
			<sj:gridColumn name="bworkphe" index="bworkphe" title="手机号码" 	sortable="false" width="100" />
			<sj:gridColumn name="bfax" index="bfax" title="传真" sortable="false" width="100" />
			<sj:gridColumn name="bworknum" index="bworknum" title="员工人数" 	sortable="false" width="100" />			
			<sj:gridColumn name="blastamt" index="blastamt" title="上年度总资产" 	sortable="false" width="100" />
			<sj:gridColumn name="blastnet" index="blastnet" title="上年度税后净利润" 	sortable="false" width="110" />
			<sj:gridColumn name="bupdatetime" index="bupdatetime" title="更新时间" 	sortable="false" width="110" />
			<sj:gridColumn name="bupdateuser" index="bupdateuser" title="更改人" 	sortable="false" width="80" />
		</sj:grid>
</body>
