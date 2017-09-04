package org.work.web.util;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class Comparatorpm implements Comparator {

	public int compare(Object obj1, Object obj2) {
		PrivilegeMenu name1 = (PrivilegeMenu)obj1;
		PrivilegeMenu name2 = (PrivilegeMenu)obj2;
		if(Integer.parseInt(name1.getId())>Integer.parseInt(name2.getId())){
			return 1;
		}else if(Integer.parseInt(name1.getId())==Integer.parseInt(name2.getId())){
			return 0;
		}else{
		    return -1;
		}
	}

}
