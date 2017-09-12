// 所有的class为alterTextarea的输入框修改值时都变成红色
function alterTextarea() {
	var  obj = $(".alterTextarea");
	obj.each(function(){
		$(this).bind('input propertychange',function(){
			$(this).css("color","red");
		});
	});
}
$(function(){
	alterTextarea();
});