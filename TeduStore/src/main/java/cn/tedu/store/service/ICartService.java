package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	/**
	 * ��ӹ��ﳵ
	 * @param cart
	 */
	void addCart(Cart cart);
	/**
	 * ��ȡ���ﳵ����Ʒ��Ϣ
	 * @param uid
	 * @return
	 */
	List<CartVo> getCartByUid(Integer uid);
	/**
	 * ����ɾ��
	 * @param ids
	 */
	void deleteBatch(Integer[] ids);
	/**
	 * ɾ����ǰ��
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * �޸�����
	 * @param id
	 * @param num
	 */
	void updateCart(Integer id,Integer num);

}






