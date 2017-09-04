<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>用户管理>>用户角色管理</title>
	<s:head/>
</head>
<body><br>
	<div class="grid">
		<fieldset>
		<legend>
			角色修改
		</legend>
		<br>
		    <s:form action="user_bankuserGrantRoleSave" namespace="/user" target="_self" theme="simple">
    <s:hidden name="buid" value="%{buid}"></s:hidden>
    <s:optiontransferselect 
            name="residualRoles" 
            leftTitle="您未选角色"
            rightTitle="您已选角色"
            list="#residualRoles"
            listKey="rid"
            listValue ="rname" 
            multiple="true"
            headerKey="headerKey"
            headerValue="请选择"
            emptyOption="false"
            doubleList="#haveRoles" 
            doubleListKey="rid"
            doubleListValue="rname"
            doubleName="selectedRoles"
            doubleHeaderKey="doubleHeaderKey"
            doubleHeaderValue="请选择" 
            doubleEmptyOption="false"
            doubleMultiple="true" 
            addAllToLeftLabel="全部取消"
			addToRightLabel="右移"
            addToLeftLabel="左移"
            addAllToRightLabel="全部选择"
            allowUpDownOnLeft="false"
            allowUpDownOnRight="false"
            allowSelectAll="false"
            buttonCssClass="ui-button"
            doubleCssClass="mutipleselect"
            leftUpLabel="向上"
            leftDownLabel="向下"
            rightUpLabel="向上"
            size="10"
            doubleSize="10"
            rightDownLabel="向下"
            cssClass="mutipleselect"
            />
			<table>
				<tr>
					<td colspan="2" align="center"><s:submit theme="simple" align="center" value="提 交" cssClass="ui-button ui-state-default ui-corner-all"></s:submit></td>
				</tr>
			</table>
    </s:form>
	</fieldset><br/>
	</div>
</body>
