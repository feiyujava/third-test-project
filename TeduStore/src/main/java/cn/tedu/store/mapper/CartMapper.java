package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {

	/**
	 * ���빺�ﳵ����
	 * @param cart
	 */
	void insertCart(Cart cart);
	
	/**
	 * ��ѯ���ﳵ����Ʒ
	 * @param uid
	 * @return
	 */
	List<CartVo> selectCartByUid(Integer uid);
	/**
	 * ����ɾ��
	 * @param ids
	 */
	void deleteBatchById(Integer[] ids);
	/**
	 * ɾ����ǰ��
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * ����id�޸�����
	 * @param id
	 * @param num
	 */
	void updateCart(@Param("id") Integer id,@Param("num") Integer num);
	
}








