package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {

	/**
	 * 插入购物车数据
	 * @param cart
	 */
	void insertCart(Cart cart);
	
	/**
	 * 查询购物车的商品
	 * @param uid
	 * @return
	 */
	List<CartVo> selectCartByUid(Integer uid);
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteBatchById(Integer[] ids);
	/**
	 * 删除当前行
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 根据id修改数量
	 * @param id
	 * @param num
	 */
	void updateCart(@Param("id") Integer id,@Param("num") Integer num);
	
}








