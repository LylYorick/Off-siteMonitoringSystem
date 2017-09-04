<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
		<ul id="accordion">
			<s:iterator id="ms" value="#session.userinfo.menus" status="status">
				<s:if test="#ms[0]!=null">
					<li class="menu">
						<h3>
							<a href="#"> <s:property value="#ms[0].name" /> </a>
						</h3>
						<div>
							<ul>

								<s:iterator id="plrg" value="#ms[1]" status="status2">
									<li>
										<a id=_s<s:property value="#status.index"/><s:property value="#status2.index"/>
											<s:if test='url.contains("?")' >
											href="../<s:property value="#plrg.url"/>&p=_s<s:property value="#status.index"/><s:property value="#status2.index"/>&q=<s:property value="#status.index"/>"
										</s:if>
											<s:else>
											href="../<s:property value="#plrg.url"/>?p=_s<s:property value="#status.index"/><s:property value="#status2.index"/>&q=<s:property value="#status.index"/>"
										</s:else>
											target="_self"><s:property value="#plrg.name" /> </a>
									</li>
								</s:iterator>
							</ul>
						</div>
					</li>
				</s:if>
			</s:iterator>
			
		</ul>

	<s:hidden value="%{#session.p}" id="p"></s:hidden>
	<s:hidden value="%{#session.q}" id="q"></s:hidden>
	<script type="text/javascript">

		if($("#q").val() != ""){
			$("#accordion").accordion({
							collapsible : true,
							autoHeight : false,
							active:parseInt($("#q").val())
						});
		}
		if($("#p").val() != ""){
			$("#"+$("#p").val()).css("background","RGB(255,233,155)");
		} else {
			document.getElementById("_s00").className="selected";
		}
	</script>
</body>