package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
	//1000�˺ŵ����
	Integer select1();
	//1001�˺ŵ����
	Integer select2();
	//�޸�id�����Ϊmoney(1000)
	Integer update1(@Param("id") String id,@Param("money") Integer money);
	//�޸�id�����Ϊmoney(1001)
	Integer update2(@Param("id") String id,@Param("money") Integer money);

}





