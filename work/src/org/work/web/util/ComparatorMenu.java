package org.work.web.util;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ComparatorMenu implements Comparator {

	public int compare(Object obj1, Object obj2) {
		Object[] menu1 = (Object[])obj1;
		Object[] menu2 = (Object[])obj2;
		PrivilegeMenu name1 = (PrivilegeMenu)menu1[0];
		PrivilegeMenu name2 = (PrivilegeMenu)menu2[0];
		if(Integer.parseInt(name1.getId())>Integer.parseInt(name2.getId())){
			return 1;
		}else if(Integer.parseInt(name1.getId())==Integer.parseInt(name2.getId())){
			return 0;
		}else{
		    return -1;
		}
	}

}
