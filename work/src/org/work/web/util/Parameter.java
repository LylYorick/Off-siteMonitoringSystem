package org.work.web.util;

import java.util.ArrayList;
import java.util.List;

public class Parameter {	
	
	private String parvalue;//
	private List list = new ArrayList();	
	

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	public String getParvalue() {
		return parvalue;
	}
	public void setParvalue(String parvalue) {
		this.parvalue = parvalue;
	}	

}
