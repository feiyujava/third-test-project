package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@RequestMapping("/goods")
@Controller
public class GoodsController extends BaseController{
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map){
		//��������ʱ,pageΪnull
		if(page==null){
			page = 1;
		}
		
		int offset = (page-1)*12;
		//��ȡ��һҳ����
		List<Goods> goodsList = 
				goodsService.getGoodsByCategoryId(categoryId, offset, 12);
		//�Ѽ�����ӵ�map
		map.addAttribute("goodsList",goodsList);
		
		//�����ݵļ�¼����ӵ�map
		Integer count = goodsService.getCount(categoryId);
		map.addAttribute("count",count);
		
		//�Ѽ�¼�ֶ���ҳ��ӵ�map
		int pageSize = 
				count%12==0 ? count/12 : count/12+1;
		map.addAttribute("pageSize",pageSize);
		
		map.addAttribute("categoryId", categoryId);
		
		map.addAttribute("curPage",page);
		
		return "search";
	}
	@RequestMapping("/showProductInfo.do")
	public String showProductInfo(String goodsId,ModelMap map){
		Goods goods = goodsService.getGoodsById(goodsId);
		map.addAttribute("goods", goods);
		
		return "product_details";
	}
}









