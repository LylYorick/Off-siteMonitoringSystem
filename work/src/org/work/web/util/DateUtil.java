package org.work.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date parseToDateTime() {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	public static String formatDateTime(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = "";
		try{
			dateTime = df.format(new Date());			 
		}catch(Exception e){
			
		}
		return dateTime;
	}
	
	public static String formatDate(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
}
