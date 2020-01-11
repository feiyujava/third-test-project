package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	void updateImage(
			@Param("id") Integer id,@Param("image") String image);
	
	/**
	 * 插入数据
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 通过用户名查询User信息
	 * @param userName
	 * @return 如果没有此用户,返回null;
	 *             否则,返回该用户对象
	 */
	User selectUserByUserName(String userName);

	/**
	 * 通过email查询数据
	 * @param email
	 * @return 如果邮箱存在,则返回值>=1,否则,返回0
	 */
	Integer selectByEmail(String email);
	/**
	 * 通过phone查询数据
	 * @param phone
	 * @return
	 */
	Integer selectByPhone(String phone);
	
	/**
	 * 修改个人信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return
	 */
	User selectUserByid(Integer id);
	
	
}





