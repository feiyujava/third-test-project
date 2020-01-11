package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo(){
		return "personInfo";
	}
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(@RequestParam("file") MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		
		
		//��ȡϵͳ����Ŀ�ĸ�·��
		String path = 
				session.getServletContext().getRealPath("/");
		
		System.out.println(path);
		
		//�ϴ��ļ�
		file.transferTo(
				new File(path,"/upload/"+file.getOriginalFilename()));
	
		//�޸�image�ֶε�ֵ
		userService.changeImage(this.getId(session),"/upload/"+file.getOriginalFilename());
		
		session.setAttribute("user",userService.getUserById(this.getId(session)));
		
		rr.setState(1);
		rr.setMessage("�ϴ��ɹ�!");
		return rr;
	}
	
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(
			HttpSession session,String oldPassword,
			String newPassword){
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		
		try{
			userService.changePassword(this.getId(session), oldPassword, newPassword);
			rr.setState(1);
			rr.setMessage("�����޸ĳɹ�");
		}catch(Exception e){
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		
		return rr;
	}
	
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(
			HttpSession session,String userName,
			Integer gender,String email,String phone){
		//1.����rr����
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		try{
		//2.����ҵ��㷽��updateUser();
			
			userService.updateUser(this.getId(session), userName, gender, email, phone);
		//state : 1;message:"�޸ĳɹ�"
			rr.setState(1);
			rr.setMessage("�޸ĳɹ�");
			User user = 
					userService.getUserById(this.getId(session));
			session.setAttribute("user", user);
			
		}catch(Exception e){
		//3.�����쳣
		//state : 0 ;message:e.getMessage()
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:/main/showIndex.do";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(
			String userName,String password,
			HttpSession session){
		//1.���� rr
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		//2.
		try{
			//����ҵ��㷽��login;
			User user = 
					userService.login(userName, password);
			//state : 1 message:��¼�ɹ�
			rr.setState(1);
			rr.setMessage("��¼�ɹ�");
			//��user�������õ�session
			session.setAttribute("user",user);

		}catch(Exception e){
			//state : 0   message:e.getMessage()
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
			return rr;
	}
	
	//�ύ��ť�Ŀ���������
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("uname") String userName,
			@RequestParam("upwd") String password,
			String email,String phone){
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		try{
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			userService.register(user);
			rr.setState(1);
			rr.setMessage("ע��ɹ�!");
		}catch(UserNameAlreadyExistException e){
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
		
	}
	
	//�绰����ʧȥ����Ŀ���������
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr
		       = new ResponseResult<Void>();
		if(userService.checkPhone(phone)){
			rr.setState(1);
			rr.setMessage("�绰�������ʹ��");
		}else{
			rr.setState(0);
			rr.setMessage("�绰���벻����ʹ��");
		}
		return rr;
	}
	
	//����ʧȥ����
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		if(userService.checkEmail(email)){
			rr.setState(1);
			rr.setMessage("�������ʹ��");
		}else{
			rr.setState(0);
			rr.setMessage("���䲻����ʹ��");
		}
		return rr;
	}
	
	//�û���ʧȥ����
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String userName){
		//1.����rr����
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		//2.����ҵ��㷽��:checkUsername;����b
		boolean b = 
				userService.checkUsername(userName);
		//3.���b==true
		if(b){
			//����state:1 message:"�û�������ʹ��"
			rr.setState(1);
			rr.setMessage("�û�������ʹ��");
		}else{
		//4.b==false
		//����state:0 message:"�û���������ʹ��"
			rr.setState(0);
			rr.setMessage("�û���������ʹ��");
		}
		return rr;
	}

}





