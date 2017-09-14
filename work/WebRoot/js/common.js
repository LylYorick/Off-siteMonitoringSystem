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
//设定 所有class有 numberInput 只能输入正整数 且最大值为20
function numberInput() {
	$(".numberInput").keyup(function(){
		this.value=this.value.replace(/\D/g,'');
		if(this.value>20){
	  		this.value = 20;
		}
	});
}
//文件点击下载后 新字去掉
function downLoadFile() {
	$(".proposeFileA").click(function(){
		$(".proposeFileLabel").hide();
	});
	$(".reportFileA").click(function(){
		$(".reportFileLabel").hide();
	});
}
$(function(){
	alterTextarea();
	alterCheckbox();
	numberInput();
	downLoadFile();
});