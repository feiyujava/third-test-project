package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	/**
	 * 获取GoodsCategory的集合
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> getCategoryByParentId(
			Integer parentId,Integer offset,Integer count);
}
