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
	//ͨ�������ļ�����Ա������ֵ
	@Value("#{messageConfig.salt}")
	private String salt;
	
	@Resource
	private UserMapper userMapper;
	public void register(User user) {
		System.out.println("UserService.register...");
		//1.����selectUserByUserName(user.getUserName());����User���� user
			User user1 = 
					userMapper.selectUserByUserName(user.getUserName());
		//2.�ж�user==null
			if(user1==null){
				//3.���Ϊ��,����insertUser(user)����;	
				
				String newPwd = 
						DigestUtils.md5Hex(user.getPassword()+salt);
				
				user.setPassword(newPwd);
				userMapper.insertUser(user);
			}else{
				//4.�����Ϊ��,�׳��쳣UserNameAlreadyExistException
				throw new UserNameAlreadyExistException("�û����Ѿ�����!");
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

	//��֤�û����Ƿ����
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
		//1.���ó־ò㷽��selectUserByUsername(),����user����
		User user = 
				userMapper.selectUserByUserName(userName);
		//2.�ж�user�Ƿ�Ϊ��
		if(user!=null){
		//3.���user!=null
		//4.��user������ȡ������,�Ͳ���password�ж�
			
		    String newPwd =
		    		DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(newPwd)){
		//5.��������ж�Ϊtrue,����user����
				return user;
			}else{
		//6.��������ж�Ϊfalse,�׳��쳣PasswordNotMatchExceptin;
				throw new PasswordNotMatchExceptin("�������");
			}
		}else{
		//7.���user==null,�׳��쳣UserNotFoundException
			throw new UserNotFoundException("���û��Ѳ�����");
		}
	}

	public void updateUser(Integer id, String userName, Integer gender, String email, String phone) {
		User user = new User();
		//1.�û��Ƿ����
		User user1 = 
				userMapper.selectUserByid(id);
		if(user1!=null){
			//2.�ж��û����Ƿ����
			User user2 = 
					userMapper.selectUserByUserName(userName);
			if(user2==null){
				user.setUserName(userName);
			}else{
				//3.�û�������,�û���Ϊ��¼��ʱ,��������
				if(user1.getUserName().equals(userName)){
					
				}else{
					throw new UserNameAlreadyExistException("�û����Ѵ���");
				}
			}
		}else{
			throw new UserNotFoundException("�û�������");
		}
		
		user.setId(id);
		user.setEmail(email);
		user.setPhone(phone);
		user.setGender(gender);
		userMapper.updateUser(user);
	}

	public User getUserById(Integer id) {
		//����User����
		return userMapper.selectUserByid(id);
	}

	public void changePassword(Integer id, String oldPassword, String newPassword) {
		//1.����selectUserById����,����User����
		User user = userMapper.selectUserByid(id);
		//���user==null,�׳��쳣UserNotFoundException
		if(user==null){
			throw new UserNotFoundException("���û�������");
		}else{
			//2.���user!=null,��ô��user�����л�ȡpassword,�Ͳ���oldPassword�Ƚ�
			
			String oldPwd = 
					DigestUtils.md5Hex(oldPassword + salt);
			if(user.getPassword().equals(oldPwd)){
				//3.����ȽϷ���true, 
				User u = new User();
				u.setId(id);
				String newPwd = 
						DigestUtils.md5Hex(newPassword+salt);
				u.setPassword(newPwd);
				userMapper.updateUser(u);
			}else{
				//4.����ȽϷ���false,�׳��쳣��PasswordNotMatchException
				throw new PasswordNotMatchExceptin("���벻ƥ��");
			}
			
		}
	}

	public void changeImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}
	
}





