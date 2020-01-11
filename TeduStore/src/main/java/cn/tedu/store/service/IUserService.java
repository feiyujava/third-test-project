package cn.tedu.store.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.User;
@Transactional
public interface IUserService {
	/**
	 * 修改image图片信息
	 * @param Id
	 * @param image
	 */
	void changeImage(Integer id,String image);
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return 如果用户名密码存在,发回user对象,
	 * 		      否则抛出异常
	 */
	@Transactional(readOnly=true)
	User login(String userName,String password);
	/**
	 * 实现用户注册
	 * @param user
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	void register(User user);
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return 返回true,表示邮箱可以用;
	 * 			否则邮箱不可以使用
	 */
	@Transactional(readOnly=true)
	boolean checkEmail(String email);
	
	/**
	 * 验证电话号码是否存在
	 * @param phone
	 * @return
	 */
	@Transactional(readOnly=true)
	boolean checkPhone(String phone);
	
	/**
	 * 验证用户名是否存在
	 * @param userName
	 * @return
	 */
	@Transactional(readOnly=true)
	boolean checkUsername(String userName);
	/**
	 * 修改个人信息
	 * @param id
	 * @param userName
	 * @param gender
	 * @param email
	 * @param phone
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	void updateUser(Integer id,String userName,Integer gender,String email,String phone);

	/**
	 * 获取User对象
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	User getUserById(Integer id);
	/**
	 * 修改密码
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	void changePassword(Integer id,String oldPassword,String newPassword);
	
	
}





