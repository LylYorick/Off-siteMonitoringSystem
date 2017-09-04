$(document).ready(function() {
	 		$(document).pngFix(); 
			$("#tabs").tabs();
			$("#accordion").accordion({
						collapsible : true,
						autoHeight : false
					});
		});
$(function() {
			/**//* Use Object Detection to detect IE6 */
			var m = document.uniqueID /**//* IE */
					&& document.compatMode /**//* >=IE6 */
					&& !window.XMLHttpRequest /**//* <=IE6 */
					&& document.execCommand;

			try {
				if (!!m) {
					m("BackgroundImageCache", false, true);/**//* = IE6 only */
				}

			} catch (oh) {
			};
		});
/*
 * ########################### 评分输入框验证 ###########################
 */
$(function() {
			$('.num').blur(function() {
						var patrn = /^-?\d+\.{0,}\d{0,}$/;
						if (!patrn.exec(this.value)) {
							this.value = "0";
							alert("请输入数值");
						}
						var current = parseFloat(this.value);
						var cut = parseFloat($(this).parent().prev().html());
						var add = parseFloat($(this).parent().prev().prev().html());
						if(this.value > add || this.value < cut){
							alert("取值范围不对");
							this.value= "0";
						}
					});
		});
/*
 * ########################### ajax加载左边的功能菜单 parentID：父nav
 * ###########################
 */
function LoadSideNav(parentID, menuId, activeId) {
	$("#mainNav > li >a").css("color", "white");
	$("#liMainNav_" + parentID + " > a").css("color", "#fae16d");
	$("#na").empty();
	$("#na").append("<ul id='accordion'></ul>");
	$("#accordion").load("/work/test/test_LoadSideNav.shtml?navid=" + parentID,
			'', function() {
				if (activeId) {
					$("#accordion").accordion({
								collapsible : true,
								autoHeight : false,
								active : parseInt(activeId)
							});
				} else {
					$("#accordion").accordion({
								collapsible : true,
								autoHeight : false
							});
				}
				if (menuId) {
					$("#" + menuId).css("background", "RGB(255,233,155)");
				}
			});
}
/*
 * ########################### 左侧菜单点击事件 ###########################
 */
function ChangeMenu(menuId, activeId) {
	$.cookie('menu', menuId);
	$.cookie('active', activeId);
}
/*
 * ########################### 换个风格，左侧菜单改成div显示/隐藏效果，需考虑
 * ###########################
 */
function tempLoadMenu() {
	$("#accordion").load("/work/test/test_LoadSideNav.shtml?navid=2", '',
			function() {
				var as = $("#accordion li > h3");
				as.click(function() {
							// 这里需要找到当前的ul中的li,然后让li显示出来
							// 获取当前被点击的ul节点
							var ulNode = $(this);
							// 找到当前a节点的所有li兄弟子结点
							var lis = ulNode.next("div");
							// 让子菜单显示或隐藏
							lis.toggle("slow");
							// 局部刷新
							$("li > a").click(function() {
										$("#content").load($(this).attr("id"));
									});
						});
			})
}