package org.work.web.util;

public class Global {
	
	public static int boder_style = 10 & 0x3;
	
	/**
	 * 将NULL或空格转换为指定的字符
	 * 
	 * @param source
	 * @param result
	 * @return
	 */
	public static String nullTOString(String source, String result) {
		if (source == null || source.trim().equals(""))
			return result;
		else
			return source;
	}
	
	
	/**
	 * 将.xx字符转换成0.xx
	 * 
	 * @param source
	 * @param result
	 * @return
	 */
	public static String numTOString(String str) {
		if(str == null || str.equals(""))
			str = "";
		else if(str.indexOf(".")==0)
			str = "0" + str;
		
		return str;
	}

}
