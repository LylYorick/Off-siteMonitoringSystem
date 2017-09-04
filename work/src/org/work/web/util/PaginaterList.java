package org.work.web.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PaginaterList extends ArrayList {
	private static final long serialVersionUID = 1L;

	private Paginater paginater;

	public Paginater getPaginater() {
		return paginater;
	}

	public void setPaginater(Paginater paginater) {
		this.paginater = paginater;
	}

	public List getList() {
		return paginater.getList();
	}
	
	@Override
	public Iterator iterator() {
		return paginater.getList().iterator();
	}

	@Override
	public Object get(int index) {
		return paginater.getList().get(index);
	}
	
	
}
