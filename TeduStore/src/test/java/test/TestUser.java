package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {
	@Test
	public void testChangePassword(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		IUserService us = 
				ac.getBean("userService",IUserService.class);
		us.changePassword(1, "123456", "222");
	}
	
	@Test
	public void testGetUserById(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		IUserService us = 
				ac.getBean("userService",IUserService.class);
		System.out.println(
				us.getUserById(1));
	}
	@Test
	public void testUpdateUserService(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		IUserService us = 
				ac.getBean("userService",IUserService.class);
		
		us.updateUser(1, "admin2", 1, "admin111@tedu.cn", "12300138009");
	}
	@Test
	public void testSelectUserById(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		UserMapper um = 
			ac.getBean("userMapper",UserMapper.class);
		System.out.println(
				um.selectUserByid(11));
	}
	@Test
	public void testUpdateUser(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		UserMapper um = 
			ac.getBean("userMapper",UserMapper.class);
		User user = new User();
		user.setId(4);
		user.setPassword("123456");
		/*user.setUserName("admin44");
		user.setGender(0);
		user.setPhone("12345678987");
		user.setEmail("admin44@tedu.cn");
		user.setModifiedUser("admin");
		user.setModifiedTime(new Date());*/
		um.updateUser(user);
		
		ac.close();
		
	}
	@Test
	public void testLogin(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us = 
				ac.getBean("userService",IUserService.class);
		System.out.println(
				us.login("admin1", "223456"));
	}
	
	@Test
	public void testCheckEmail(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us = 
				ac.getBean("userService",IUserService.class);
		/*System.out.println(
				us.checkEmail("amdin1@tedu.cn"));*/
		/*System.out.println(
				us.checkPhone("13820138000"));*/
		System.out.println(
				us.checkUsername("admin3"));
		
	}
	@Test
	public void testSelectByEmail(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper um = 
				ac.getBean("userMapper",UserMapper.class);
		/*Integer n = 
				um.selectByEmail("amdin1@tedu.cn");
		System.out.println(n);*/
		Integer n = 
				um.selectByPhone("13820138000");
		System.out.println(n);
	}
	@Test
	public void testRegister(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService us = 
				ac.getBean("userService",IUserService.class);
		User user = new User();
		user.setUserName("admin2");
		user.setPassword("123456");
		user.setEmail("amdin2@tedu.cn");
		user.setPhone("13800138001");
		us.register(user);
	}
	@Test
	public void testSelectUserByUsername(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = 
				ac.getBean("userMapper",UserMapper.class);
		User user = 
				um.selectUserByUserName("admin");
		System.out.println(user);
	}

	@Test
	public void testInsertUser(){
		//IOC:控制权的转移(创建对象)
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um = 
				ac.getBean("userMapper",UserMapper.class);
		User user = new User();
		user.setUserName("admin1");
		user.setPassword("123456");
		user.setEmail("amdin1@tedu.cn");
		user.setPhone("13800138000");
		um.insertUser(user);
	}
}








