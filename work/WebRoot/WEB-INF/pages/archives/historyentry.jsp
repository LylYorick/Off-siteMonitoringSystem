<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>金融机构管理>>金融机构变更记录</title>
</head>
<body>
		<s:url id="remoteurl" action="../archives/archives_history.shtml"/> 
		<sj:grid id="gridtable" caption="金融机构变更记录列表" dataType="json" href="%{remoteurl}" 
			pager="true" gridModel="gridModelhistory"
			rowList="10,15,20" rowNum="20" rownumbers="true" viewrecords="true"
			multiselect="true" 
			cssStyle="line-height:30px;" onSelectRowTopics="rowselect"
			height="400">			
			<sj:gridColumn name="bname" index="bname" title="机构名称" sortable="false" width="100" />
			<sj:gridColumn name="mold" index="mold" title="机构类型" sortable="false" width="100" />
			<sj:gridColumn name="address" index="address" title="联系地址" sortable="false" width="100" />
			<sj:gridColumn name="responsiblePerson" index="responsiblePerson" title="机构负责人" sortable="false" width="100" />
			<sj:gridColumn name="address" index="baddr" title="办公地址" sortable="false" width="200" />
			<sj:gridColumn name="bworknum" index="bworknum" title="员工人数" sortable="false" width="100" />
			<sj:gridColumn name="blastamt" index="blastamt" title="上年度末度总资产" sortable="false" width="100" />
			<sj:gridColumn name="blastnet" index="blastnet" title="上年度税后净利润" sortable="false" width="100" />
			<sj:gridColumn name="blead" index="blead" title="反洗钱工作分管领导" sortable="false" width="100" />
			<sj:gridColumn name="bleadtel" index="bleadtel" title="分管领导电话" sortable="false" width="100" />
			<sj:gridColumn name="bdeptlead" index="bdeptlead" title="反洗钱部门负责人" sortable="false" width="100" />
			<sj:gridColumn name="bdeptleadtel" index="bdeptleadtel" title="反洗钱部门负责人电话" sortable="false" width="100" />
			<sj:gridColumn name="bdeptleadphe" index="bdeptleadphe" title="反洗钱部门负责人手机" sortable="false" width="100" />
			<sj:gridColumn name="bwork" index="bwork" title="反洗钱岗位人员" sortable="false" width="100" />
			<sj:gridColumn name="bworktel" index="bworktel" title="反洗钱岗位人员电话" sortable="false" width="100" />
			<sj:gridColumn name="bworkphe" index="bworkphe" title="反洗钱岗位人员手机" sortable="false" width="100" />
			<sj:gridColumn name="establishTime" index="establishTime" title="成立时间" sortable="false" width="100" />
			<sj:gridColumn name="registeredCapital" index="registeredCapital" title="注册资本" sortable="false" width="100" />
			<sj:gridColumn name="registeredArea" index="registeredArea" title="注册地" sortable="false" width="100" />
			<sj:gridColumn name="businessArea" index="businessArea" title="经营地" sortable="false" width="100" />
			<sj:gridColumn name="numberOfBranchOffice" index="numberOfBranchOffice" title="分支机构数" sortable="false" width="100" />
			<sj:gridColumn name="overseasBranchOffice" index="overseasBranchOffice" title="海外机构信息" sortable="false" width="100" />
			<sj:gridColumn name="shareholder1" index="shareholder1" title="股东信息1" sortable="false" width="100" />
			<sj:gridColumn name="rate1" index="rate1" title="股东1持股比例" sortable="false" width="100" />
			<sj:gridColumn name="headquarter" index="headquarter" title="总部所在地" sortable="false" width="100" />
			<sj:gridColumn name="numberOfHall" index="numberOfHall" title="在深的营业部家数" sortable="false" width="100" />
			<sj:gridColumn name="bupdatetime" index="bupdatetime" title="更新时间" sortable="false" width="100" />
			<sj:gridColumn name="bupdateuser" index="bupdateuser" title="更新人" sortable="false" width="100" />
		</sj:grid>
</body>
