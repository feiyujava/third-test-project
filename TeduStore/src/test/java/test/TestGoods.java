package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

public class TestGoods {
	@Test
	public void testSelectGoodsById(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		/*GoodsMapper mapper = 
				ac.getBean("goodsMapper",GoodsMapper.class);
		
		System.out.println(
				mapper.selectGoodsById("10000044"));*/
		
		IGoodsService is = 
				ac.getBean("goodsService",IGoodsService.class);
		System.out.println(
				is.getGoodsById("10000044"));
	}
	
	@Test
	public void testSelectCount(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		GoodsMapper mapper = 
				ac.getBean("goodsMapper",GoodsMapper.class);
		IGoodsService is = 
				ac.getBean("goodsService",IGoodsService.class);
		System.out.println(
				is.getCount(163));
		
		/*
		System.out.println(
				mapper.selectCountByCategoryId(163));*/
	}
	@Test
	public void testGetgoods(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsService is = 
				ac.getBean("goodsService",IGoodsService.class);
		System.out.println(
				is.getGoodsByCategoryId(163, 0,3));
	}
	@Test
	public void testSelectGoods(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		GoodsMapper mapper = 
				ac.getBean("goodsMapper",GoodsMapper.class);
		List<Goods> list = 
				mapper.selectGoodsByCategoryId(163,0,3);
		//System.out.println(list);
		for(Goods good:list){
			System.out.println(good.getTitle());
		}
	}

}





