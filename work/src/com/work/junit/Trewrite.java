/**
 * 
 */
package com.work.junit;

/**
 * @作者 ThinkPadh'h
 * @创建日期 Sep 9, 2010
 * @版本 work V1.0
 */
public class Trewrite {

	public static void main(String[] args) {
		abc test = new abc(){
			
		};
		test.add();
		test.print();
	}
	
}
class abc{
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public void add(){
		i= i+200;
	}
	public void print(){
		System.out.println(i);
	}
}