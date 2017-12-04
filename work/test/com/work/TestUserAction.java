package com.work;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.work.web.dao.archives.ArchivesDao;
import org.work.web.po.Archives;
import org.work.web.po.BankUser;
import org.work.web.po.Information;
import org.work.web.po.Role;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.manage.IManageService;

public class TestUserAction {
	private ApplicationContext ctx;
	private IManageService manageService;
	private ArchivesDao archivesDao;
	private IFinancialService financialService;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext-*.xml");
		manageService = (IManageService) ctx.getBean("manageService");
		archivesDao = (ArchivesDao)ctx.getBean("archivesDao");
		financialService = (IFinancialService)ctx.getBean("financialService");
	}

	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testSaveUser(){
		BankUser user1 = new BankUser();
		Archives archives = new Archives();
		archives = (Archives) archivesDao.findById(130);
		Information information = financialService.findByOid(41);
		String userName = archives.getOid()+"11";
		user1.setBuname(userName);
		user1.setArchives(archives);
		user1.setInformation(information);
		Set<Role> roles = new HashSet<Role>();
		Role role = manageService.findRoleById("11");
		roles.add(role);
		user1.setTPubRoleusers(roles);
		user1.setBrname(archives.getBname()+"自评者");
		manageService.saveUser(user1);
	}
}
