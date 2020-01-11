package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 *  插入数据
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * 根据uid查询该用户的收获地址
	 * @param uid
	 * @return
	 */
	List<Address> selectAddressByUid(Integer uid);

	/**
	 * 根据uid修改is_default=0
	 * @param uid
	 * @return
	 */
	Integer setCancel(Integer uid);
	/**
	 * 根据id修改is_default=1
	 * @param id
	 * @return
	 */
	Integer setDefault(Integer id);
	/**
	 * 根据id查询一条数据
	 * @param id
	 * @return
	 */
	Address selectAddressById(Integer id);
	/**
	 * 根据id修改收货人的信息
	 * @param address
	 */
	void udpateAddressById(Address address);
	
	/**
	 * 根据id删除收货人信息
	 * @param id
	 */
	void deleteAddressById(Integer id);
}






