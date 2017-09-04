/**
 * 
 */
package com.work.report;

import java.util.List;

/**
 * @作者 ThinkPad
 * @创建日期 Aug 12, 2010
 * @版本 work V1.0
 */
public class Banks {

	private List<Bank> bank;

	public List<Bank> getBank() {
		return bank;
	}

	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}
	
}
class Bank{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}