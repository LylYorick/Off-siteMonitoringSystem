package com.work.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import java.io.File;
import java.io.IOException;

public class TestTXT {

	void testFile(File file) throws IOException{
		LineIterator it = FileUtils.lineIterator(file);
		int count = 0;
		try {
			while (it.hasNext()) {
				count++;
				String line = it.nextLine();
				System.out.println(line);
				String[] strs = line.split(",");
				for(String str : strs){
					if(str.equals(strs[13])||str.equals(strs[14])){
						try{
						    Double num = Double.valueOf(str);
						    System.out.println(" --- "+num);
						}catch(NumberFormatException e){
							e.printStackTrace();
							break;
						}
					}else{
						System.out.println(str);
					}
				}
			}
			System.out.println("文件总行数 ：： "+count);
		} finally {
			LineIterator.closeQuietly(it);
		}
	}

	public static void main(String[] arg){
		TestTXT test = new TestTXT();
		try{
			File file = new File("D:/abc4.txt");
			test.testFile(file);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
