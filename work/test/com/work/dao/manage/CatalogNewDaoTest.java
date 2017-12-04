package com.work.dao.manage;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.work.web.dao.manage.ICatalogNewDao;
import org.work.web.po.CatalogNew;

public class CatalogNewDaoTest {
	private ApplicationContext ctx;
	private ICatalogNewDao iCatalogNewDao;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext-*.xml");
		iCatalogNewDao = (ICatalogNewDao) ctx.getBean("catalogNewDao");
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testfindAllFirstCatname(){
		List<CatalogNew> list = iCatalogNewDao.findAllFirstCatname();
		System.out.println(list.size());
		System.out.println(list);
	}
	@Test
	public void testfindAllFirstCatname2(){
		List<CatalogNew> list = iCatalogNewDao.findAllFirstCatname2();
		System.out.println(list.size());
		System.out.println(list);
	}
}
