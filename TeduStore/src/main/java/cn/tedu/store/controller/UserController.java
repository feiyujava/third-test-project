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
		
		
		//获取系统的项目的根路径
		String path = 
				session.getServletContext().getRealPath("/");
		
		System.out.println(path);
		
		//上传文件
		file.transferTo(
				new File(path,"/upload/"+file.getOriginalFilename()));
	
		//修改image字段的值
		userService.changeImage(this.getId(session),"/upload/"+file.getOriginalFilename());
		
		session.setAttribute("user",userService.getUserById(this.getId(session)));
		
		rr.setState(1);
		rr.setMessage("上传成功!");
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
			rr.setMessage("密码修改成功");
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
		//1.创建rr对象
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		try{
		//2.调用业务层方法updateUser();
			
			userService.updateUser(this.getId(session), userName, gender, email, phone);
		//state : 1;message:"修改成功"
			rr.setState(1);
			rr.setMessage("修改成功");
			User user = 
					userService.getUserById(this.getId(session));
			session.setAttribute("user", user);
			
		}catch(Exception e){
		//3.处理异常
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
		//1.创建 rr
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		//2.
		try{
			//调用业务层方法login;
			User user = 
					userService.login(userName, password);
			//state : 1 message:登录成功
			rr.setState(1);
			rr.setMessage("登录成功");
			//把user对象设置到session
			session.setAttribute("user",user);

		}catch(Exception e){
			//state : 0   message:e.getMessage()
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
			return rr;
	}
	
	//提交按钮的控制器方法
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
			rr.setMessage("注册成功!");
		}catch(UserNameAlreadyExistException e){
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
		
	}
	
	//电话号码失去焦点的控制器方法
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr
		       = new ResponseResult<Void>();
		if(userService.checkPhone(phone)){
			rr.setState(1);
			rr.setMessage("电话号码可以使用");
		}else{
			rr.setState(0);
			rr.setMessage("电话号码不可以使用");
		}
		return rr;
	}
	
	//邮箱失去焦点
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		if(userService.checkEmail(email)){
			rr.setState(1);
			rr.setMessage("邮箱可以使用");
		}else{
			rr.setState(0);
			rr.setMessage("邮箱不可以使用");
		}
		return rr;
	}
	
	//用户名失去焦点
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String userName){
		//1.创建rr对象
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		//2.调用业务层方法:checkUsername;返回b
		boolean b = 
				userService.checkUsername(userName);
		//3.如果b==true
		if(b){
			//设置state:1 message:"用户名可以使用"
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		}else{
		//4.b==false
		//设置state:0 message:"用户名不可以使用"
			rr.setState(0);
			rr.setMessage("用户名不可以使用");
		}
		return rr;
	}

}





