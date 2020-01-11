package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@RequestMapping("/main")
@Controller
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService; 
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
		
		//调用业务层方法(161,0,3);返回集合,用computerList变量接收
		List<GoodsCategory> computerList = 
				goodsCategoryService.getCategoryByParentId(161, 0,3);
		//定义List<List<GoodsCategory>> category161List;创建对象;
		List<List<GoodsCategory>> category161List = 
				new ArrayList<List<GoodsCategory>>();
		//遍历computerList集合,得到每个二级分类的三级分类的集合,把此集合添加到category161List集合中;
		for(GoodsCategory goodsC:computerList){
			category161List.add(goodsCategoryService.getCategoryByParentId(goodsC.getId(),null,null));
		}
		//分别把以上两个集合设置到map中
		map.addAttribute("computerList", computerList);
		map.addAttribute("category161List", category161List);
		
		//显示热门商品
		List<Goods> goodsList = 
				goodsService.getGoodsByCategoryId(
						163, 0, 3);
		map.addAttribute("goodsList",goodsList);
		
		return "index";
	}
}






