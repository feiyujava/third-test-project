package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * ��ѯ������Ʒ
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> selectGoodsByCategoryId(
			@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	
	/**
	 * ��ѯ����������Ʒ������
	 * @param categoryId
	 * @return
	 */
	Integer selectCountByCategoryId(Integer categoryId);
	
	/**
	 * ��ѯ��Ʒ��Ϣ
	 * @param goodsid
	 * @return
	 */
	Goods selectGoodsById(String goodsid);

}








