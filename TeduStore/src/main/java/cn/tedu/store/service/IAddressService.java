package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	/**
	 * ����ջ���ַ
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 *����uid��ѯ�û����ջ���ַ
	 * @param uid
	 * @return
	 */
	List<Address> getAddressByUid(Integer uid);
	/**
	 * ����Ĭ���ջ���ַ
	 * @param uid
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * �޸��ջ�����Ϣ
	 * @param address
	 */
	void updateAddress(Address address);
	/**
	 * ����idɾ���ջ�����Ϣ
	 * @param id
	 */
	void deleteAddress(Integer id);

}





