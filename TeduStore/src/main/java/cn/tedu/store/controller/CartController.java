package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVo;

@RequestMapping("/cart")
@Controller
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		List<CartVo> listVo = 
				cartService.getCartByUid(this.getId(session));
		map.addAttribute("listVo",listVo);
		return "cart";
	
	}
	@RequestMapping("/updateCart.do")
	@ResponseBody
	public ResponseResult<Void> updateCart(Integer id,Integer num){
		cartService.updateCart(id, num);
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		return rr;
	}
	
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id){
		cartService.deleteById(id);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/deleteBatch.do")
	public String deleteBatch(Integer[] ids){
		cartService.deleteBatch(ids);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String goodsId,Integer num){
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setGoodsId(goodsId);
		cart.setNum(num);
		cartService.addCart(cart);
		
		rr.setState(1);
		rr.setMessage("Ìí¼Ó³É¹¦");
		
		return rr;
	}
}







