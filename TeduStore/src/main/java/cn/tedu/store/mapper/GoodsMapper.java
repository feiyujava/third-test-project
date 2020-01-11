package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 查询热门商品
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
	 * 查询三级分类商品的数量
	 * @param categoryId
	 * @return
	 */
	Integer selectCountByCategoryId(Integer categoryId);
	
	/**
	 * 查询商品信息
	 * @param goodsid
	 * @return
	 */
	Goods selectGoodsById(String goodsid);

}








