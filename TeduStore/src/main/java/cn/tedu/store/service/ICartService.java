package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	/**
	 * 添加购物车
	 * @param cart
	 */
	void addCart(Cart cart);
	/**
	 * 获取购物车的商品信息
	 * @param uid
	 * @return
	 */
	List<CartVo> getCartByUid(Integer uid);
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteBatch(Integer[] ids);
	/**
	 * 删除当前行
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 修改数量
	 * @param id
	 * @param num
	 */
	void updateCart(Integer id,Integer num);

}






