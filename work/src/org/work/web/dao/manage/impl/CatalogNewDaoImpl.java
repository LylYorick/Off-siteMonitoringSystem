package org.work.web.dao.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.manage.ICatalogDao;
import org.work.web.dao.manage.ICatalogNewDao;
import org.work.web.po.Catalog;
import org.work.web.po.CatalogNew;
import org.work.web.po.CatalogNewId;
import org.work.web.util.QueryHelper;

public class CatalogNewDaoImpl extends BaseDaoHibernateImpl implements ICatalogNewDao{

	@Override
	public List<CatalogNew> findAllSort() {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from CatalogNew order by id.bfirstid,id.bsecondid,id.bthirdid");
		return getList(helper);
	}

	@Override
	public Class getModelClass() {
	 	return CatalogNew.class;
	}

	@Override
	public List<CatalogNew> findAllFirstCatname() {
		List<Object[]> list = new ArrayList<Object[]>();
		List<CatalogNew> catalogNews= new ArrayList<CatalogNew>();
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("select distinct id.bfirstid,firstCatname from CatalogNew  where id.bfirstid !='00'");
		list =  getList(helper);
		CatalogNew item ;
		CatalogNewId id;
		if(list==null || list.size() ==0 ){
			return null;
		}
 		for (Object[] objects : list) {
 			item = new CatalogNew();
			id = new CatalogNewId();
			id.setBfirstid(objects[0]+"");
			item.setFirstCatname(objects[1]+"");
			item.setId(id);
			catalogNews.add(item);
		}
		return catalogNews;
	}

	@Override
	public List<CatalogNew> findAllFirstCatname2() {
		List<Object[]> list = new ArrayList<Object[]>();
		List<CatalogNew> catalogNews= new ArrayList<CatalogNew>();
		QueryHelper helper = new QueryHelper(getSession());
		//这个方法有问题下次再想 
		helper.append("select distinct new CatalogNew(new org.work.web.po.CatalogNewId(id.bfirstid),firstCatname)from CatalogNew ");
		catalogNews =  getList(helper);
		return catalogNews;
	}

	@Override
	public List<CatalogNew> findSecondCatname(String bfirstid) {
		List<Object[]> list = new ArrayList<Object[]>();
		List<CatalogNew> catalogNews= new ArrayList<CatalogNew>();
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("select distinct id.bsecondid,secondCatname from CatalogNew where id.bfirstid = '" + bfirstid+"'");
		list =  getList(helper);
		CatalogNew item ;
		CatalogNewId id;
		if(list==null || list.size() ==0 ){
			return null;
		}
 		for (Object[] objects : list) {
 			item = new CatalogNew();
			id = new CatalogNewId();
			id.setBsecondid(objects[0]+"");
			item.setSecondCatname(objects[1]+"");
			item.setId(id);
			catalogNews.add(item);
		}
		return catalogNews;
	}

	@Override
	public List<CatalogNew> findThirdCatname(String bfirstid, String bscondid) {
		List<Object[]> list = new ArrayList<Object[]>();
		List<CatalogNew> catalogNews= new ArrayList<CatalogNew>();
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("select distinct id.bthirdid,thirdCatname from CatalogNew where id.bfirstid = '" + bfirstid+"' and id.bsecondid = '" + bscondid +"'");
		list =  getList(helper);
		CatalogNew item ;
		CatalogNewId id;
		if(list==null || list.size() ==0 ){
			return null;
		}
 		for (Object[] objects : list) {
 			item = new CatalogNew();
			id = new CatalogNewId();
			id.setBthirdid(objects[0]+"");
			item.setThirdCatname(objects[1]+"");
			item.setId(id);
			catalogNews.add(item);
		}
		return catalogNews;
	}
	
	

}
