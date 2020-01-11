package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {

	/**
	 * ��ѯ��Ʒ������Ϣ
	 * @param parentId:����id
	 * @param offset:ƫ����
	 * @param count:��ѯ���ݵ�����
	 * @return ���ض����������������ļ���
	 */
	List<GoodsCategory> selectGoodsCategoryByParentId(
			@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
}








