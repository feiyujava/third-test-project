package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class TestAddress {
	@Test
	public void testDelete(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		/*AddressMapper am = ac.getBean("addressMapper",
				AddressMapper.class);
		am.deleteAddressById(6);*/
		IAddressService as = ac.getBean("addressService",
				IAddressService.class);
		
		as.deleteAddress(5);
	}
	
	@Test
	public void updateAddress(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as = ac.getBean("addressService",
				IAddressService.class);
		Address address = new Address();
		address.setId(1);
		address.setRecvName("22222");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130105");
		address.setRecvAddress("中鼎大厦8层");
		address.setRecvPhone("10000139000");
		address.setRecvTag("单位");
		as.updateAddress(address);
		
				
		/*AddressMapper am = ac.getBean("addressMapper",
				AddressMapper.class);
		Address address = new Address();
		address.setId(1);
		address.setRecvName("111111");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130105");
		address.setRecvDistrict("XXXXXXXX");
		address.setRecvAddress("中鼎大厦8层");
		address.setRecvPhone("10000139000");
		address.setRecvTag("单位");
		
		am.udpateAddressById(address);*/
		
	}
	
	@Test
	public void testSelectById(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressMapper am = 
				ac.getBean("addressMapper",AddressMapper.class);
		/*System.out.println(
				am.selectAddressById(1));*/
		IAddressService as = ac.getBean("addressService",
				IAddressService.class);
		System.out.println(
				as.getAddressById(2));
	}
	@Test
	public void testSetDefualtService(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as = ac.getBean("addressService",
				IAddressService.class);
		as.setDefault(1, 2);
	}
	@Test
	public void testSetDefault(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressMapper am = ac.getBean("addressMapper",
				AddressMapper.class);
		/*System.out.println(
				am.setCancel(1));*/
		System.out.println(
				am.setDefault(1));
	}
	
	@Test
	public void testGetAddress(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as = 
				ac.getBean("addressService",
						IAddressService.class);
		System.out.println(
				as.getAddressByUid(1));
	}
	@Test
	public void testAddAddress(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService as = 
				ac.getBean("addressService",
						IAddressService.class);
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("李四");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130105");
		address.setRecvAddress("中鼎大厦7层");
		address.setRecvPhone("13800139000");
		address.setRecvTag("单位");
		as.addAddress(address);
	}
	@Test
	public void testSelectByUid(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressMapper am = ac.getBean("addressMapper",
				AddressMapper.class);
		System.out.println(
				am.selectAddressByUid(2).size());
	}
	
	@Test
	public void testInsertAddress(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressMapper am = ac.getBean("addressMapper",
				AddressMapper.class);
		Address address = new Address();
		address.setUid(1);
		address.setRecvName("张三");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130101");
		address.setRecvDistrict("河北省石家庄市XX区");
		address.setRecvAddress("中鼎大厦7层");
		address.setRecvPhone("13800138000");
		am.insertAddress(address);
	}

}






