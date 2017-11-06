package org.work.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.work.web.web.InstitutionAction;

public class DateUtil {
	
	
	private static final Logger logger = Logger.getLogger(DateUtil.class);
	/* 年月日时分秒模式字符串 */
	public static final String YMDHMS_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/** 年月日模式字符串 */
	public static final String YEAR_MONTH_DAY_PATTERN_MIDLINE = "yyyy-MM-dd";
	
	public static final String YEAR_MONTH_DAY_PATTERN_BLANK = "yyyyMMdd";

	public static Date parseToDateTime() {

		DateFormat df = new SimpleDateFormat(YMDHMS_PATTERN);
		try {
			Date   date   =   df.parse(df.format(new Date()));
			return date;
		} catch (ParseException e) {			
			return new Date();
		}  
	}
	/**
	 * 获取当前时间的字符串，格式为yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getCurrentPrettyDateTime()
	{
		return new SimpleDateFormat(YMDHMS_PATTERN).format(new Date());
	}
	
	public static String formatDateTime(){
		DateFormat df = new SimpleDateFormat(YMDHMS_PATTERN);
		String dateTime = "";
		try{
			dateTime = df.format(new Date());			 
		}catch(Exception e){
			
		}
		return dateTime;
	}
	
	public static String formatDate(){
		DateFormat df = new SimpleDateFormat(YEAR_MONTH_DAY_PATTERN_MIDLINE);
		String date = "";
		try{
			date = df.format(new Date());			 
		}catch(Exception e){
			
		}
		return date;
	}
	
	/**
	 * 获取系统当前年份
	 * @return
	 */
	public static String getCurrentYear(){
		DateFormat df = new SimpleDateFormat("yyyy");
		String dateTime = "";
		try{
			dateTime = df.format(new Date());			 
		}catch(Exception e){
			
		}
		return dateTime;
	}	
	/**
	 * 获取系统当前季度
	 * @return
	 */
    public static int getThisSeasonTime(int month){ 
        int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};   
        int season = 1;   
        if(month>=1&&month<=3){   
            season = 1;   
        }   
        if(month>=4&&month<=6){   
            season = 2;   
        }   
        if(month>=7&&month<=9){   
            season = 3;   
        }   
        if(month>=10&&month<=12){   
            season = 4;   
        }   
        return season;
    }
    /**
     * 本季度
     * @return
     */
	public static int getSeason(int endday){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -endday);
    	return getThisSeasonTime(cal.get(Calendar.MONTH)+1);
    }
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		System.out.println(cal.getTime());
	}
	/**
	 * @param object
	 * @return
	 */
	public static String getQuaterPeriod(String year,String quater) {
		String aim ="";
		if("1".equals(quater)){
			aim = "'"+year+"-"+"01-01' and '"+year+"-03-31'";
		}else if ("2".equals(quater)){
			aim = "'"+year+"-"+"04-01' and '"+year+"-06-31'";
		}else if ("3".equals(quater)){
			aim = "'"+year+"-"+"07-01' and '"+year+"-09-31'";
		}else if ("4".equals(quater)){
			aim = "'"+year+"-"+"10-01' and '"+year+"-12-31'";
		}
		return aim;
	}
	
	/**
	 * 将当前日期增加指定天数，并返回结果。如果传入负数，则为减。
	 * 
	 * @param ammount 要增加天的数目
	 * @return 结果日期对象
	 */
	public static String addDayFromCurrentDate(final int ammount) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(System.currentTimeMillis()));
		c.add(Calendar.DATE, ammount);
		return format(c.getTime(), YMDHMS_PATTERN);
	}	
	
	
	/**
	 * 根据传入的日期格式化pattern将传入的日期格式化成字符串。
	 * 
	 * @param date
	 *            要格式化的日期对象
	 * @param pattern
	 *            日期格式化pattern
	 * @return 格式化后的日期字符串
	 */
	public static String format(final Date date, final String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	
	public static  Date parse(String date,final String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		Date s;
		try {
			s = df.parse(date);
		} catch (ParseException e) {
			logger.error("字符串转换日期出错，当前字符串："+date+",转换格式为："+pattern+"。后续将返回null");
			e.printStackTrace();
			return  null;
		}
		return s;
	}
	
	
}
