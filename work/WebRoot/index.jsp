<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
	<title>首页：：</title>
	</script>
</head>
<body>
	<div id="tabs">
		<ul>
			<li>
				<a href="#d2">报表上报提示</a>
			</li>
			<li>
				<a href="#d1">金融机构修改信息提示</a>
			</li>
		</ul>
		<div id="d2" align="center">
			<s:if test="#session.userinfo.information!=null">
			<table class="list-table">
				<s:iterator value="reportlist" status="index">
					<s:if test="#index.odd==true">
									<tr style="background-color: #ffffff">
								</s:if>
								<s:else>
									<tr>
								</s:else>
						<td>
							机构名称：
							<s:property value="BOrgInformation.bname" />
						</td>
						<td>
							报表名称：
							<s:property value="report.rptname" />
						</td><td>
							年度：
							<s:property value="year" />
						</td><td>
							季度：
							<s:property value="quater" />
						</td><td>
							是否有数据：
							<s:if test="isreport == 1">
								<font color="#0000ff" style="font-weight:bold">有</font>
							</s:if><s:else>
								<font color="#ff0000" style="font-weight:bold">无</font>
						</s:else>
						</td>
						<td>
							报表状态:
							<s:if test="status == 0">
								<font color="#000000" style="font-weight:bold"><s:property value="@org.work.web.constants.Constants@REPORT_STATUS.get(status)" /></font>
							</s:if><s:elseif test="status == 1">
								<font color="#ff0000"><s:property value="@org.work.web.constants.Constants@REPORT_STATUS.get(status)" /></font>
							</s:elseif><s:else>
								<font color="#0000ff" style="font-weight:bold"><s:property value="@org.work.web.constants.Constants@REPORT_STATUS.get(status)" /></font>
						</s:else>
						</td>
					</tr>
				</s:iterator>

			</table>
			</s:if>
			<s:else>
				<s:iterator value="reportlist" status="index" var="l">
				 <div align="center" style="width: 600px;margin: 10px auto">
   	<div id="effect" class="ui-widget-content ui-corner-all">
		<h3 class="ui-widget-header ui-corner-all">报送情况提示</h3>
		<p>
			<table class="list-table">
				<tr>
				<td>
					年报：
					</td><td align="left">未报送数量:<s:if test="#l[0]==null">0</s:if><s:else><s:property value="#l[0]" />张</s:else></td>
					</tr>
					<tr><td>
					季报：</td><td align="left">未报送数量:<s:if test="#l[1]==null">0</s:if><s:else><s:property value="#l[1]" />张</s:else></td>
					</tr>
					</table>
			</p>
	</div>

    </div>
				</s:iterator>
			</s:else>
		</div>
		<div id="d1" align="center">
			<table class="list-table">
				<s:iterator value="history" status="index">
					<s:if test="#index.odd==true">
									<tr style="background-color: #ffffff">
								</s:if>
								<s:else>
									<tr>
								</s:else>
						<td>
							金融机构：
							<s:property value="BOrgInformation.bname" />
							</td>
							<td>
							用户:
							<s:property value="bupdateuser" />
							</td>
							<td>
							操作时间:
							<s:property value="bupdatetime" />
							更新金融机构信息.
						</td>
					</tr>
				</s:iterator>

			</table>
		</div>
	</div>
</body>
