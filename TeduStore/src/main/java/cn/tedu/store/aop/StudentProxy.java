package cn.tedu.store.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentProxy implements IStudentService{
	@Autowired
	private IStudentService studentService;
	@Autowired
	private StudentAop studentAop;
	public void add() {
		studentAop.log();
		studentService.add();
		
	}

	public void upate() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void get() {
		// TODO Auto-generated method stub
		
	}

}
