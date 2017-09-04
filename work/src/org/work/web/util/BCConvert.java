/**
 * 
 */
package org.work.web.util;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 5, 2010
 * @版本 work V1.0
 */
public class BCConvert {
	public static String ToDBC(String input) {
		if(null==input){
			return null;
		}
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	public static void main(String[] args) {
		System.out.println(ToDBC("【"));
	}
}
