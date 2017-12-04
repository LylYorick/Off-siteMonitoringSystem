package org.work.web.constants;

import org.work.web.po.CatalogNewId;

public class ConstantMethods {

	/**
	 * 是法人金融机构还是分支机构
	 * @param id 机构类别id
	 * @return 法人金融机构(true) 分支机构(false)s
	 */
	public static Boolean isCorporation(CatalogNewId id){
		//法人机构包括一级机构类型为  六类(07)、证券和基金子公司(08)、其他（09）
		//或二级机构类型为 总行(01) ,总公司(03)
		//分支机构包括：除了以上5点的全部类型
		String bfirstid = id.getBfirstid();
		String bsecondid = id.getBsecondid();
		//法人机构   六类(07)、证券和基金子公司(08)、其他（09）
		if("07".equals(bfirstid)|| "08".equals(bfirstid) || "09".equals(bfirstid)){
			return true;
		}//法人机构包括 总行(01) ,总公司(03)
		else if("01".equals(bsecondid) || "03".equals(bsecondid)){
			return true;
		}
		return false;
	}
}
