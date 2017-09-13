// 所有的class为alterTextarea的输入框修改值时都变成红色
function alterTextarea() {
	var  obj = $(".alterTextarea");
	obj.each(function(){
		$(this).bind('input propertychange',function(){
			$(this).css("color","red");
		});
	});
}

//是否允许自评的checkbox 状态改变
function alterCheckbox() {
	var  obj = $(".alterCheckbox");
	obj.change(function(){
		$("#allowLabel").css("color","red");
		if($(this).is(':checked')==false){
			$("#allowTextarea").val("");
			$("#allowTextarea").hide();
		}else{
			$("#allowTextarea").show();
		}
	});

}
$(function(){
	alterTextarea();
	alterCheckbox();
});