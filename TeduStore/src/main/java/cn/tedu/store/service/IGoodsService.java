package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	/**
	 * ��ȡ������Ʒ����
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offset,Integer count);

	/**
	 * ��ȡ��¼��
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	
	/**
	 * ��ȡ��Ʒ��Ϣ
	 * @param goodsId
	 * @return
	 */
	Goods getGoodsById(String goodsId);
	
}






