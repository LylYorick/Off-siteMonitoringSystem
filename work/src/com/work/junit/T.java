/**
 * 
 */
package com.work.junit;

import java.io.File;
import java.text.NumberFormat;

/**
 * @作者 aps-dux
 * @创建日期
 * @{date}
 * @版本 深圳V1.0
 */
public class T {
		//判断是否为奇数，是就返回true
		public static boolean isOdd(int i){
			return i % 2==1;    
		}
		
		public static void main(String[] args){
			Integer a=2;
			Integer b=2;
			System.out.println(a.hashCode());
			System.out.println(b.hashCode());
			System.out.println(a.equals(b));
			System.out.println(a==b);
			System.out.println("------------------------");
			Integer c = new Integer("2");
			Integer d = new Integer("2");
			System.out.println(c.hashCode());
			System.out.println(d.hashCode());
			System.out.println(c.equals(d));
			System.out.println(c==d);

			System.out.println("*************************");
			String e= "tt";
			System.out.println(e.hashCode());
		}
		//请问，这段程序将会输出什么？
	           //请解释并优化该代码
/*	public static void main(String[] args) {
//		getName("c:\\Intel");
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("if (%s != null) {\n\t%s\n}\n", null,"abc"));
		System.out.println(sb.toString());
		Integer a=null;
		Integer b = (Integer)a;
		System.out.println(b+"--");
		System.out.println(b instanceof Integer);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumFractionDigits(0);
		nf.setMaximumFractionDigits(6);
		nf.setGroupingUsed(false);
		double t=11d;
		String aString= "testabc";
		System.out.println(aString.substring(0,4));
	}*/
	
	/**
	 * 遍历文件夹下所有文件，打印文件名
	 * @param pathString
	 */
	public static void getName(String pathString) {
		System.out.println(pathString+":");
		jjj(pathString);
	}

	/**
	 * @param sddd
	 */
	private static void jjj(String sddd) {
		try {
			File file = new File(sddd);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						getName(files[i].getPath());
					} else if (files[i].isFile()) {
						System.out.println(files[i].getName());
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	public int test() {
		try {
			System.out.println("1");
			return 1;
		} catch (Exception e) {
			
		} finally{
			System.out.println("2");
			return 2;
		}
		
	}
}
