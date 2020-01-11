package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	/**
	 * 添加收货地址
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 *根据uid查询用户的收货地址
	 * @param uid
	 * @return
	 */
	List<Address> getAddressByUid(Integer uid);
	/**
	 * 设置默认收货地址
	 * @param uid
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * 根据id获取数据
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * 修改收货人信息
	 * @param address
	 */
	void updateAddress(Address address);
	/**
	 * 根据id删除收货人信息
	 * @param id
	 */
	void deleteAddress(Integer id);

}





