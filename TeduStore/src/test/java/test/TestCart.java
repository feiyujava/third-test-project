package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;

public class TestCart {
	@Test
	public void testDeleteBatch(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		CartMapper cm = 
				ac.getBean("cartMapper",CartMapper.class);
		
		cm.updateCart(9, 1);
		
		/*Integer[] ids = {1,2,3};
		cm.deleteBatchById(ids);*/
	}
	@Test
	public void testSelectCart(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		ICartService cs = 
				ac.getBean("cartService",ICartService.class);
		System.out.println(
				cs.getCartByUid(1).size());
		
		/*CartMapper cm = 
				ac.getBean("cartMapper",CartMapper.class);
		System.out.println(
				cm.selectCartByUid(1).size());*/
	}
	@Test
	public void testInsert(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		ICartService cs = 
				ac.getBean("cartService",ICartService.class);
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGoodsId("10000044");
		cart.setNum(1);
		cs.addCart(cart);
		/*CartMapper cm = 
				ac.getBean("cartMapper",CartMapper.class);
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGoodsId("10000044");
		cart.setNum(1);
		cm.insertCart(cart);*/
	}

}





