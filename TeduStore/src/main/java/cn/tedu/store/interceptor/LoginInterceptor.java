package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor 
	implements HandlerInterceptor{

	//执行控制器方法之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1.获取session对象
		HttpSession session = request.getSession();
		//2.从session对象中获取属性 user;判断是否为null
		
		Object obj = session.getAttribute("user");
		if(obj==null){
			//重定向到showLogin.do
			String path = request.getContextPath();
			response.sendRedirect(path+"/user/showLogin.do");
			return false;
		}
		
		return true;
	}
	//响应视图之前执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//响应视图组件之后执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
