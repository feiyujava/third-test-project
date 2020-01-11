package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAop {
	@Before("bean(userService)")
	public void test1(){
		
		System.out.println("����֮ǰִ��...");
	}
	@After("bean(userService)")
	public void test2(){
		System.out.println("����֮��ִ��...");
	}
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("����֮��ִ��...AfterReturning");
	}
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("���������쳣...");
	}
	/**
	 * ע��:
	 * 	1.����Ҫ�в���ProceedingJoinPoint
	 * 	2.�����з���ֵ
	 * 	3.jp.proceed();
	 * @param jp
	 * @throws Throwable 
	 */
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("����֪ͨ---ǰ");
		Object obj = jp.proceed();//���ò�ķ���
		System.out.println("����֪ͨ---��");
		return obj;
	}
}






