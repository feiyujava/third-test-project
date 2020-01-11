package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;

@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
		
	}
	public List<CartVo> getCartByUid(Integer uid) {
		
		return cartMapper.selectCartByUid(uid);
	}
	public void deleteBatch(Integer[] ids) {
		cartMapper.deleteBatchById(ids);
		
	}
	public void deleteById(Integer id) {
		cartMapper.deleteById(id);
		
	}
	public void updateCart(Integer id, Integer num) {
		cartMapper.updateCart(id, num);
		
	}

}
