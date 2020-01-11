package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 *  ��������
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * ����uid��ѯ���û����ջ��ַ
	 * @param uid
	 * @return
	 */
	List<Address> selectAddressByUid(Integer uid);

	/**
	 * ����uid�޸�is_default=0
	 * @param uid
	 * @return
	 */
	Integer setCancel(Integer uid);
	/**
	 * ����id�޸�is_default=1
	 * @param id
	 * @return
	 */
	Integer setDefault(Integer id);
	/**
	 * ����id��ѯһ������
	 * @param id
	 * @return
	 */
	Address selectAddressById(Integer id);
	/**
	 * ����id�޸��ջ��˵���Ϣ
	 * @param address
	 */
	void udpateAddressById(Address address);
	
	/**
	 * ����idɾ���ջ�����Ϣ
	 * @param id
	 */
	void deleteAddressById(Integer id);
}






