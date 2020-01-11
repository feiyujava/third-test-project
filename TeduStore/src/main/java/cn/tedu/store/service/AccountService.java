package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.mapper.AccountMapper;

@Service
@Transactional
public class AccountService implements IAccountService{
	@Resource
	private AccountMapper accountMapper;
	//@Transactional(propagation=Propagation.REQUIRED)
	//@Transactional(readOnly=true)
	public void test(String id1, String id2, Integer money) {
		//1.����update1����(id1,����select1����()-money);
		Integer n1 = accountMapper.update1(id1, 
				accountMapper.select1()-money);
		if(n1==0){
			throw new RuntimeException("update1�쳣");
		}
		//2.����update2����(id2,����select2����()+money);
		Integer  n2 = accountMapper.update2(id2,
				accountMapper.select2()+money);
		if(n2==0){
			throw new RuntimeException("update2�쳣");
		}
	}

}




