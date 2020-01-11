package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchExceptin;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;
@Service
public class UserService implements IUserService{
	//通过配置文件给成员变量赋值
	@Value("#{messageConfig.salt}")
	private String salt;
	
	@Resource
	private UserMapper userMapper;
	public void register(User user) {
		System.out.println("UserService.register...");
		//1.调用selectUserByUserName(user.getUserName());返回User对象 user
			User user1 = 
					userMapper.selectUserByUserName(user.getUserName());
		//2.判断user==null
			if(user1==null){
				//3.如果为空,调用insertUser(user)方法;	
				
				String newPwd = 
						DigestUtils.md5Hex(user.getPassword()+salt);
				
				user.setPassword(newPwd);
				userMapper.insertUser(user);
			}else{
				//4.如果不为空,抛出异常UserNameAlreadyExistException
				throw new UserNameAlreadyExistException("用户名已经存在!");
			}		
	}
	
	public boolean checkEmail(String email) {
		
		return 
			userMapper.selectByEmail(email)==0;
	}

	public boolean checkPhone(String phone) {
		
		return 
			userMapper.selectByPhone(phone)==0;
	}

	//验证用户名是否存在
	public boolean checkUsername(String userName) {
		User user = 
				userMapper.selectUserByUserName(userName);
		if(user==null){
			return true;
		}else{
			return false;
		}
		
	}

	public User login(String userName, String password) {
		System.out.println("UserService.login...");
		//1.调用持久层方法selectUserByUsername(),返回user对象
		User user = 
				userMapper.selectUserByUserName(userName);
		//2.判断user是否为空
		if(user!=null){
		//3.如果user!=null
		//4.从user对象中取出密码,和参数password判断
			
		    String newPwd =
		    		DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(newPwd)){
		//5.如果密码判断为true,返回user对象
				return user;
			}else{
		//6.如果密码判断为false,抛出异常PasswordNotMatchExceptin;
				throw new PasswordNotMatchExceptin("密码错误");
			}
		}else{
		//7.如果user==null,抛出异常UserNotFoundException
			throw new UserNotFoundException("此用户已不存在");
		}
	}

	public void updateUser(Integer id, String userName, Integer gender, String email, String phone) {
		User user = new User();
		//1.用户是否存在
		User user1 = 
				userMapper.selectUserByid(id);
		if(user1!=null){
			//2.判断用户名是否存在
			User user2 = 
					userMapper.selectUserByUserName(userName);
			if(user2==null){
				user.setUserName(userName);
			}else{
				//3.用户名存在,用户名为登录名时,不做处理
				if(user1.getUserName().equals(userName)){
					
				}else{
					throw new UserNameAlreadyExistException("用户名已存在");
				}
			}
		}else{
			throw new UserNotFoundException("用户不存在");
		}
		
		user.setId(id);
		user.setEmail(email);
		user.setPhone(phone);
		user.setGender(gender);
		userMapper.updateUser(user);
	}

	public User getUserById(Integer id) {
		//返回User对象
		return userMapper.selectUserByid(id);
	}

	public void changePassword(Integer id, String oldPassword, String newPassword) {
		//1.调用selectUserById方法,返回User对象
		User user = userMapper.selectUserByid(id);
		//如果user==null,抛出异常UserNotFoundException
		if(user==null){
			throw new UserNotFoundException("该用户不存在");
		}else{
			//2.如果user!=null,那么从user对象中获取password,和参数oldPassword比较
			
			String oldPwd = 
					DigestUtils.md5Hex(oldPassword + salt);
			if(user.getPassword().equals(oldPwd)){
				//3.如果比较返回true, 
				User u = new User();
				u.setId(id);
				String newPwd = 
						DigestUtils.md5Hex(newPassword+salt);
				u.setPassword(newPwd);
				userMapper.updateUser(u);
			}else{
				//4.如果比较返回false,抛出异常行PasswordNotMatchException
				throw new PasswordNotMatchExceptin("密码不匹配");
			}
			
		}
	}

	public void changeImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}
	
}





