// 是法人金融机构还是分支机构
function isCorporation(bfirstid,bsecondid){
	//法人机构包括一级机构类型为  六类(07)、证券和基金子公司(08)、其他（09）
	//或二级机构类型为 总行(01) ,总公司(03)

	//法人机构   六类(07)、证券和基金子公司(08)、其他（09）
	if("07" == bfirstid || "08" == bfirstid || "09" == bfirstid){
		return true;
	}//法人机构包括 总行(01) ,总公司(03)
	else if("01" == bsecondid || "03" == bsecondid){
		return true;
	}
	//分支机构包括：除了以上5点的全部类型
	return false;
}

/* 	$.validator.setDefaults({
submitHandler: function() {
  alert("提交事件!");
}
});
function validateform(){
$("#testForm").validate({
rules:{
	'archives.catalogNew.id.bfirstid':{
		required:true,
	}
}
});
}; */