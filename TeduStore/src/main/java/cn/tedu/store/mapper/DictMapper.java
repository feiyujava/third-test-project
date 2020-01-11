package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * 查询省份信息
	 * @return
	 */
	List<Province> selectProvince();
	
	/**
	 * 查询城市信息
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * 查询区县的信息
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	
	String selectProvinceNameByCode(String provinceCode);
	String selectCityNameByCode(String cityCode);
	String selectAreaNameByCode(String areaCode);
}







