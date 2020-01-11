package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
	//1000账号的余额
	Integer select1();
	//1001账号的余额
	Integer select2();
	//修改id的余额为money(1000)
	Integer update1(@Param("id") String id,@Param("money") Integer money);
	//修改id的余额为money(1001)
	Integer update2(@Param("id") String id,@Param("money") Integer money);

}





