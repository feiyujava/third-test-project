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
	//练习:给login方法添加环绕通知,
	//测试业务方法的性能
	//思路:在login方法之前获取系统时间,
	//在login方法之后获取系统时间;两个时间相减,得到毫秒数
   
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object testArounc(ProceedingJoinPoint jp) throws Throwable{
		long start = System.currentTimeMillis();
		Object obj = jp.proceed();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		return obj;
	}
	
}






