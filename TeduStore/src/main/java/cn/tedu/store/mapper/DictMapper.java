package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * ��ѯʡ����Ϣ
	 * @return
	 */
	List<Province> selectProvince();
	
	/**
	 * ��ѯ������Ϣ
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * ��ѯ���ص���Ϣ
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	
	String selectProvinceNameByCode(String provinceCode);
	String selectCityNameByCode(String cityCode);
	String selectAreaNameByCode(String areaCode);
}







