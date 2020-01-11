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
	
	//��ȡ��̬������Ķ���
	public Object getObject(){
		//Proxy.newProxyInstance:��ȡ��̬������Ķ���
		//1.��ȡĿ����������������
		//2.��ȡĿ����Ľӿ�
		//3.ʵ����InvocationHandler�ӿڵ�ʵ����Ķ���
			//Ϊ�˻ص�invoke����
		return Proxy.newProxyInstance(
				studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), 
				this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		studentAop.log();
		//ͨ���������Ŀ����ķ���
		Object obj = method.invoke(studentService, args);
		//�൱��:Object obj = studentService.login(args)
		
		return obj;
	}

}
