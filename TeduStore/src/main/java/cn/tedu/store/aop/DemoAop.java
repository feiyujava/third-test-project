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
		
		System.out.println("方法之前执行...");
	}
	@After("bean(userService)")
	public void test2(){
		System.out.println("方法之后执行...");
	}
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("方法之后执行...AfterReturning");
	}
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("方法发生异常...");
	}
	/**
	 * 注意:
	 * 	1.方法要有参数ProceedingJoinPoint
	 * 	2.方法有返回值
	 * 	3.jp.proceed();
	 * @param jp
	 * @throws Throwable 
	 */
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("环绕通知---前");
		Object obj = jp.proceed();//调用层的方法
		System.out.println("环绕通知---后");
		return obj;
	}
}






