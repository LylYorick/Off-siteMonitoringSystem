/**
 * 
 */
package org.work.web.constants;

import java.util.HashMap;
import java.util.Map;

import org.work.web.po.CatalogNewId;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class Constants {
	public static final String DIR_REPORT_FORM = "/WEB-INF/reportForm";

	public static final String DIR_INSTITUTION = "/WEB-INF/institution";
	
	public static final String DIR_DOCUMENT = "/WEB-INF/document";

	public static final String DIR_SUSPICIOUS = "/WEB-INF/suspicious";

	public static final String DIR_SUSPICIOUSDATA = "/WEB-INF/suspiciousdata";

	public static final String DIR_INFOR_SURVEYDATA = "/WEB-INF/information/surveydata";
	
	public static final String DIR_INFOR_CHECKDATA = "/WEB-INF/information/checkdata";
	
	public static final String DIR_INFOR_ACTIVESOURCEDATA = "/WEB-INF/information/activesourcedata";
	
	public static final String DIR_INFOR_HEADOFFICESOURCEDATA = "/WEB-INF/information/headofficesourcedata";
	
	public static final String DIR_INFOR_JUDICIALSOURCEDATA = "/WEB-INF/information/judicialsourcedata";
	
	public static final String DIR_INFOR_REPORTSOURCEDATA = "/WEB-INF/information/reportsourcedata";
	
	public static final String DIR_INFOR_TRANSFERSOURCEDATA = "/WEB-INF/information/transfersourcedata";

	public static final String DIR_REPORT = "/WEB-INF/report";
	
	public static final String SESSION_USER = "userinfo";
	
	public static final String SESSION_USERPRIVILETE = "privilege";

	public static final String SESSION_REPORTS = "reports";

	public static final String DEFAULT_PASSWORD = "888888";

	public static final String USER_ID_PREFIX = "aml";

	public static final String START_USER_ID = "00001";
	
	public static final String PBC_SHENZHENCODE = "001584099999";

	public static final Double DEFAULT_SCORE = 100d;

	public static final String SYSTEM_URL = "http://localhost:8080/work";
	
	public static final String DIR_FINANCIAL = "WEB-INF\\financial\\";
	
	public static final String DIR_DOCUMENT_XLS = "WEB-INF\\document\\xls\\";
	public static final String DIR_SUSPICIOUS_XLS = "WEB-INF\\suspicious\\xls\\";
	public static final String USER_ORG = "人民银行";
	
	/**
	 * 用户状态
	 */
	public static final String USER_STATUS_NORMAL = "0";//有效
	public static final String USER_STATUS_STOP = "1";//暂停
	public static final String USER_STATUS_VALID = "2";//无效
	public static Map<String, String> USER_STATUS = new HashMap<String, String>();
	static {
		USER_STATUS.put(USER_STATUS_NORMAL, "有效");
		USER_STATUS.put(USER_STATUS_STOP, "暂停");
		USER_STATUS.put(USER_STATUS_VALID, "无效");
	}
	/**
	 * 报表上报状态
	 */
	public static final String REPORT_STATUS_UPLOAD = "0";
	public static final String REPORT_STATUS_TOUPLOAD = "1";
	public static final String REPORT_STATUS_NOUPLOAD = "2";
	public static Map<String, String> REPORT_STATUS = new HashMap<String, String>();
	static {
		REPORT_STATUS.put(REPORT_STATUS_UPLOAD, "已上报");
		REPORT_STATUS.put(REPORT_STATUS_TOUPLOAD, "待上报");
		REPORT_STATUS.put(REPORT_STATUS_NOUPLOAD, "未上报");
	}
	/*
	 * 报表类型
	 */
	public static final String REPORT_TYPE_YEAR = "1";
	public static final String REPORT_TYPE_QUATER = "2";	
	public static Map<String, String> REPORT_TYPE = new HashMap<String, String>();
	static {
		REPORT_TYPE.put(REPORT_TYPE_YEAR, "年报");
		REPORT_TYPE.put(REPORT_TYPE_QUATER, "季报");
	}
	/*
	 * 报表季度
	 */
	public static final String REPORT_QUATER_A = "1";
	public static final String REPORT_QUATER_B = "2";	
	public static final String REPORT_QUATER_C = "3";	
	public static final String REPORT_QUATER_D = "4";	
	public static Map<String, String> REPORT_QUATER = new HashMap<String, String>();
	static {
		REPORT_QUATER.put(REPORT_QUATER_A, "第一季度");
		REPORT_QUATER.put(REPORT_QUATER_B, "第二季度");
		REPORT_QUATER.put(REPORT_QUATER_C, "第三季度");
		REPORT_QUATER.put(REPORT_QUATER_D, "第四季度");
	}
	/*
	 * 是否选择
	 */
	public static final String REPORT_CHOOSE_NO = "0";
	public static final String REPORT_CHOOSE_YES = "1";	
	public static Map<String, String> REPORT_CHOOSE = new HashMap<String, String>();
	static {
		REPORT_CHOOSE.put(REPORT_CHOOSE_NO, "否");
		REPORT_CHOOSE.put(REPORT_CHOOSE_YES, "是");
	}
	
	//是否是法人机构
	/**
	 * 法人机构
	 */
	public static final String IS_CORPORATION = "00";
	
	/**
	 * 是分支机构
	 */
	public static final String IS_BRANCH = "01";	
	public static Map<String, String> CORPORATION_TYPE = new HashMap<String, String>();
	static {
		CORPORATION_TYPE.put(IS_CORPORATION, "是");
		CORPORATION_TYPE.put(IS_BRANCH, "否");
	}
	
	//评级类型
	/**
	 * 法人机构评级
	 */
	public static final String IS_CORPORATION_RATE = "00";
	
	/**
	 *非法人机构评级 
	 */
	public static final String IS_NOCORPORATION_RATE = "01";
	
	public static Map<String, String> RATE_TYPE = new HashMap<String, String>();
	static {
		RATE_TYPE.put(IS_CORPORATION_RATE, "法人机构评级");
		RATE_TYPE.put(IS_NOCORPORATION_RATE, "非法人机构评级 ");
	}
	
	/*
	 * 协助单位
	 */
	public static final String REPORT_ORG_GONGAN = "公安机关";
	public static final String REPORT_ORG_OTHER = "其他机关";	
	public static Map<String, String> REPORT_ORG = new HashMap<String, String>();
	static {
		REPORT_ORG.put(REPORT_ORG_GONGAN, "公安机关");
		REPORT_ORG.put(REPORT_ORG_OTHER, "其他机关");
	}
	/*
	 * 某一季度最后一天
	 */
	public static final String REPORT_QUATER_D1 = "03-31";
	public static final String REPORT_QUATER_D2 = "06-30";
	public static final String REPORT_QUATER_D3 = "09-30";
	public static final String REPORT_QUATER_D4 = "12-31";
	public static final String REPORT_YEAR_D = "12-31";
	public static Map<String, String> REPORT_LAST_D = new HashMap<String, String>();
	static {
		REPORT_LAST_D.put("1",REPORT_QUATER_D1);
		REPORT_LAST_D.put("2",REPORT_QUATER_D2);
		REPORT_LAST_D.put("3",REPORT_QUATER_D3);
		REPORT_LAST_D.put("4",REPORT_QUATER_D4);
		REPORT_LAST_D.put("0",REPORT_YEAR_D);
	}
	/**
	 * 日志记录类别
	 */
	public static final String LOG_TYPE_SELECT = "查询";
	public static final String LOG_TYPE_UPDATE = "修改";
	public static final String LOG_TYPE_ADD = "增加";
	public static final String LOG_TYPE_DOWNLOAD = "增加";
	public static final String LOG_TYPE_DELETE = "删除";
	public static final String LOG_TYPE_LOGIN = "登录";
	

}
