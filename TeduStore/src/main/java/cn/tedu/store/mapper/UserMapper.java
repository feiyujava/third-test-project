package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	void updateImage(
			@Param("id") Integer id,@Param("image") String image);
	
	/**
	 * ��������
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * ͨ���û�����ѯUser��Ϣ
	 * @param userName
	 * @return ���û�д��û�,����null;
	 *             ����,���ظ��û�����
	 */
	User selectUserByUserName(String userName);

	/**
	 * ͨ��email��ѯ����
	 * @param email
	 * @return ����������,�򷵻�ֵ>=1,����,����0
	 */
	Integer selectByEmail(String email);
	/**
	 * ͨ��phone��ѯ����
	 * @param phone
	 * @return
	 */
	Integer selectByPhone(String phone);
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * ͨ��id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	User selectUserByid(Integer id);
	
	
}





