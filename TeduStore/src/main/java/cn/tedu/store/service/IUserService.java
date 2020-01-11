package cn.tedu.store.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.User;
@Transactional
public interface IUserService {
	/**
	 * �޸�imageͼƬ��Ϣ
	 * @param Id
	 * @param image
	 */
	void changeImage(Integer id,String image);
	
	/**
	 * �û���¼
	 * @param userName
	 * @param password
	 * @return ����û����������,����user����,
	 * 		      �����׳��쳣
	 */
	@Transactional(readOnly=true)
	User login(String userName,String password);
	/**
	 * ʵ���û�ע��
	 * @param user
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	void register(User user);
	/**
	 * ��֤�����Ƿ����
	 * @param email
	 * @return ����true,��ʾ���������;
	 * 			�������䲻����ʹ��
	 */
	@Transactional(readOnly=true)
	boolean checkEmail(String email);
	
	/**
	 * ��֤�绰�����Ƿ����
	 * @param phone
	 * @return
	 */
	@Transactional(readOnly=true)
	boolean checkPhone(String phone);
	
	/**
	 * ��֤�û����Ƿ����
	 * @param userName
	 * @return
	 */
	@Transactional(readOnly=true)
	boolean checkUsername(String userName);
	/**
	 * �޸ĸ�����Ϣ
	 * @param id
	 * @param userName
	 * @param gender
	 * @param email
	 * @param phone
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	void updateUser(Integer id,String userName,Integer gender,String email,String phone);

	/**
	 * ��ȡUser����
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	User getUserById(Integer id);
	/**
	 * �޸�����
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	void changePassword(Integer id,String oldPassword,String newPassword);
	
	
}





