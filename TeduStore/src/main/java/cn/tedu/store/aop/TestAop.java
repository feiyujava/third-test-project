package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAop {
	@Before("execution(* cn.tedu.store.service.UserService.login(..))")
	public void test(){
		System.out.println("TestAop.test...");
	}
	//��ϰ:��login������ӻ���֪ͨ,
	//����ҵ�񷽷�������
	//˼·:��login����֮ǰ��ȡϵͳʱ��,
	//��login����֮���ȡϵͳʱ��;����ʱ�����,�õ�������
   
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object testArounc(ProceedingJoinPoint jp) throws Throwable{
		long start = System.currentTimeMillis();
		Object obj = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		return obj;
	}
	
}






