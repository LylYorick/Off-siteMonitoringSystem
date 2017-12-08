package org.work.web.constants;

import java.math.BigDecimal;

import org.work.web.po.Archives;
import org.work.web.po.CatalogNew;
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
	
	/**
	 * 获取金融机构类别名称
	 * @param catalogNew
	 * @return
	 */
	public static String getCatalogName(CatalogNew catalogNew){
		String mold ="";
		CatalogNewId id = catalogNew.getId();
		mold += catalogNew.getFirstCatname();
		if("00".equals(id.getBsecondid())){
			return mold;
		}else{
			mold += " " + catalogNew.getSecondCatname();
		}
		if("00".equals(id.getBthirdid())){
			return mold;
		}else{
			mold += " " + catalogNew.getThirdCatname();
		}
		return mold;
	}
	
	/**
	 * 重置 档案的 法人信息和分支机构信息
	 * @param archives
	 */
	public static void resetArchvies(Archives archives){
		//重置  法人机构的特有信息
		archives.setEstablishTime(null);//成立时间
		archives.setRegisteredCapital(null);//注册资本（单位：万元，下同）
		archives.setRegisteredArea("");//注册地
		
		archives.setBusinessArea("");//经营地
		//公司股东结构（列明前5名股东及其占比）
		archives.setShareholder1("");
		archives.setShareholder2("");
		archives.setShareholder3("");
		archives.setShareholder4("");
		archives.setShareholder5("");
		archives.setRate1(new BigDecimal(0.00));
		archives.setRate2(new BigDecimal(0.00));
		archives.setRate3(new BigDecimal(0.00));
		archives.setRate4(new BigDecimal(0.00));
		archives.setRate5(new BigDecimal(0.00));
		archives.setNumberOfBranchOffice(0);//分支机构数
		archives.setOverseasBranchOffice("");//境外分支机构信息
		//重置 分支机构 信息
		archives.setHeadquarter(""); //总部所在地
		//重置 证券公司和期货公司分公司 特有
		archives.setNumberOfHall(null);//在深的营业部家数
		
		CatalogNewId catalogNewId = archives.getCatalogNew().getId();
		//根据机构id设置机构是法人机构还是分支机构
		if(ConstantMethods.isCorporation(catalogNewId)){
			archives.setCorporationType(Constants.IS_CORPORATION);
		}else{
			archives.setCorporationType(Constants.IS_BRANCH);
		}
	}
	
}
