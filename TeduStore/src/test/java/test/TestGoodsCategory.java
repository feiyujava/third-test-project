package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IGoodsCategoryService;

public class TestGoodsCategory {

	@Test
	public void testSelectCategory(){
		AbstractApplicationContext ac  = 
				new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsCategoryService cm = 
				ac.getBean("goodsCategoryService",IGoodsCategoryService.class);
		//二级分类
		List<GoodsCategory> list = 
				cm.getCategoryByParentId(161,0, 3);
		//System.out.println(list);
		//三级分类
		for(GoodsCategory goodsC:list){
			
			List<GoodsCategory> list161 = 
					cm.getCategoryByParentId(
					goodsC.getId(), null, null);
			System.out.println(list161);
			System.out.println("------------------");
		}
	}
}






