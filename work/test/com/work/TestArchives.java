package com.work;

import net.sf.json.util.JSONUtils;

import org.apache.struts2.json.JSONUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.work.web.dao.archives.ArchivesDao;
import org.work.web.dao.archives.impl.ArchivesDaoImpl;
import org.work.web.po.Archives;
import org.work.web.po.Catalog;
import org.work.web.service.archives.ArchivesService;

import com.google.gson.Gson;

public class TestArchives {
	private ApplicationContext ctx;
	private ArchivesDao archivesDao=null;
	private ArchivesService archivesService;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext-*.xml");
		archivesDao = (ArchivesDao) ctx.getBean("archivesDao");
		archivesService = (ArchivesService) ctx.getBean("archivesService");
	}

	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testArchivesSave(){
		Gson gson = new Gson();
		String jsonString = "{\"oid\":4,\"boid\":\"G3477743-9\",\"corporation_type\":\"00\",\"bname\":\"中国农业银行深圳市分行\",\"bwork\":\"王五\",\"bworktel\":\"0755-22590240\",\"bworkphe\":\"13159823165\",\"blastamt\":500000.00,\"blastnet\":54545.01,\"blead\":\"张三\",\"bleadtel\":\"0755-22590240\",\"bdeptlead\":\"深圳市罗湖区\",\"bdeptleadtel\":\"0755-22590240\",\"bdeptleadphe\":\"18645642135\",\"establishTime\":\"020014030002\",\"registeredCapital\":501213.15,\"registeredArea\":\"中国上海\",\"businessArea\":\"经营地\",\"numberOfBranchOffice\":20,\"overseasBranchOffice\":\"海外分支机构\",\"headquarter\":\"中国深圳\",\"numberOfHall\":20,\"bworknum\":20000,\"isneed\":\"1\",\"bupdatetime\":\"2017-11-06 15:39:29\",\"bupdateuser\":\"nonghang\",\"shareholder1\":\"股东1\",\"rate1\":0.00,\"shareholder2\":\"22\",\"rate2\":0.00,\"shareholder3\":\"22\",\"rate3\":0.00,\"shareholder4\":\"22\",\"rate4\":0.00,\"shareholder5\":\"22\",\"rate5\":0.00}"; 
		Archives archives = gson.fromJson(jsonString, Archives.class);
		Catalog bOrgCatalog = new Catalog();
		bOrgCatalog.setBid(3);
		archives.setBOrgCatalog(bOrgCatalog);
		archivesService.updateInformation(null, archives);
	}
	@Test
	public void testArchivesget(){
		Archives archives = (Archives) archivesDao.findById(4);
		archives.setBOrgCatalog(null);
		Gson gson = new Gson();
		String aa = gson.toJson(archives);
		System.out.println(aa);
	}
}
