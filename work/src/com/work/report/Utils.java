/**
 * 
 */
package com.work.report;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @作者 ThinkPad
 * @创建日期 Aug 12, 2010
 * @版本 work V1.0
 */
public class Utils {

	public static void main(String[] args) {
		XStream xstream = new XStream(new DomDriver());
		Banks banks = new Banks();
		List list = new ArrayList<Bank>();
		Bank bank = new Bank();
		bank.setName("test");
		Bank bank1 = new Bank();
		bank1.setName("test1");
		list.add(bank);
		list.add(bank1);
		banks.setBank(list);
		String xml = xstream.toXML(banks);
		System.out.println(xml);
	}
}
