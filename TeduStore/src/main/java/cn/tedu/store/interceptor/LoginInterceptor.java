package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor 
	implements HandlerInterceptor{

	//ִ�п���������֮ǰִ��
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1.��ȡsession����
		HttpSession session = request.getSession();
		//2.��session�����л�ȡ���� user;�ж��Ƿ�Ϊnull
		
		Object obj = session.getAttribute("user");
		if(obj==null){
			//�ض���showLogin.do
			String path = request.getContextPath();
			response.sendRedirect(path+"/user/showLogin.do");
			return false;
		}
		
		return true;
	}
	//��Ӧ��ͼ֮ǰִ��
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//��Ӧ��ͼ���֮��ִ��
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
