package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.IDictService;

public class TestDict {
	@Test
	public void testGetNameByCode(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DictMapper dm = ac.getBean("dictMapper",
				DictMapper.class);
/*		System.out.println(
				dm.selectProvinceNameByCode("130000"));*/
		/*System.out.println(
				dm.selectCityNameByCode("130100"));*/
		System.out.println(
				dm.selectAreaNameByCode("130101"));
	}
	
	@Test
	public void testGetProinve(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IDictService ds  = 
				ac.getBean("dictService",IDictService.class);
		/*System.out.println(
				ds.getProvince().size());*/
		/*System.out.println(
				ds.getCity("130000").size());*/
		System.out.println(
				ds.getArea("130100"));
	}

	@Test
	public void testSelectProvince(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DictMapper dm = 
				ac.getBean("dictMapper",DictMapper.class);
		/*System.out.println(
				dm.selectProvince());*/
		/*System.out.println(
				dm.selectCity("130000"));*/
		System.out.println(
				dm.selectArea("130100"));
	}
}





