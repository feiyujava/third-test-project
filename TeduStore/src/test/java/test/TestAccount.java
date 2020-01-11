package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.service.IAccountService;

public class TestAccount {
	@Test
	public void test1(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-aop.xml");
		IAccountService as = 
				ac.getBean("accountService",IAccountService.class);
		as.test("1000", "1002",100);
	}

}




