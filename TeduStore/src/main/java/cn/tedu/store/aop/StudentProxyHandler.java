package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class StudentProxyHandler 
			implements InvocationHandler{
	@Autowired
	private Object studentService;
	@Autowired
	private StudentAop studentAop;
	
	//获取动态代理类的对象
	public Object getObject(){
		//Proxy.newProxyInstance:获取动态代理类的对象
		//1.获取目标类的类加载器对象
		//2.获取目标类的接口
		//3.实现了InvocationHandler接口的实现类的对象
			//为了回到invoke方法
		return Proxy.newProxyInstance(
				studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), 
				this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		studentAop.log();
		//通过反射调用目标类的方法
		Object obj = method.invoke(studentService, args);
		//相当于:Object obj = studentService.login(args)
		
		return obj;
	}

}
