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
		
		//����ҵ��㷽��(161,0,3);���ؼ���,��computerList��������
		List<GoodsCategory> computerList = 
				goodsCategoryService.getCategoryByParentId(161, 0,3);
		//����List<List<GoodsCategory>> category161List;��������;
		List<List<GoodsCategory>> category161List = 
				new ArrayList<List<GoodsCategory>>();
		//����computerList����,�õ�ÿ�������������������ļ���,�Ѵ˼�����ӵ�category161List������;
		for(GoodsCategory goodsC:computerList){
			category161List.add(goodsCategoryService.getCategoryByParentId(goodsC.getId(),null,null));
		}
		//�ֱ�����������������õ�map��
		map.addAttribute("computerList", computerList);
		map.addAttribute("category161List", category161List);
		
		//��ʾ������Ʒ
		List<Goods> goodsList = 
				goodsService.getGoodsByCategoryId(
						163, 0, 3);
		map.addAttribute("goodsList",goodsList);
		
		return "index";
	}
}






