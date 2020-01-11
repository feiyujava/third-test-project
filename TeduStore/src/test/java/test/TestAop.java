package test;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.IStudentService;
import cn.tedu.store.aop.StudentProxyHandler;

public class TestAop {
	@Test
	public void testAop(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-aop.xml");
		IStudentService ss = ac.getBean("studentProxy",IStudentService.class);
		ss.add();
	}
	
	@Test
	public void testAopHandler(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml","spring-aop.xml");
		
		StudentProxyHandler sp = 
				ac.getBean("studentProxyHandler",StudentProxyHandler.class);
		IStudentService ss = 
				(IStudentService)sp.getObject();
		ss.add();
	
	}
	
	/*public void test(){
		conn.setAutoCommit(false);
		try{
			//sql
			conn.commit();		
			
		}catch(xxx){
			conn.rollback();
		}
	}*/

}











