package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {

	/**
	 * 查询商品分类信息
	 * @param parentId:父级id
	 * @param offset:偏移量
	 * @param count:查询数据的数量
	 * @return 返回二级分类和三级分类的集合
	 */
	List<GoodsCategory> selectGoodsCategoryByParentId(
			@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
}








