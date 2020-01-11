package cn.tedu.store.md5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class TestMd5 {
	//字符串的消息摘要
	public static void test1(){
		String str1 = "你们好,未来的程序员!";
		String strMessage = DigestUtils.md5Hex(str1);
	
		String str2 = "你们好,未来的程序员!";
		String strMessage2 = DigestUtils.md5Hex(str2);
		
		System.out.println(strMessage);
		System.out.println(strMessage2);
	}
	//文件的消息摘要
	public static void test2() throws IOException{
		InputStream in1 = 
				new FileInputStream("pom.xml");
		InputStream in2 = 
				new FileInputStream("pom.xml");
		
		String strMsg1 = 
				DigestUtils.md5Hex(in1);
		String strMsg2 = 
				DigestUtils.md5Hex(in2);
	
		System.out.println(strMsg1);
		System.out.println(strMsg2);
	}
	
	//加盐之后生成消息摘要
	public static void test3(){
		String str = "123456";
		String salt = "今天你吃了吗?";
		
		String strMsg = 
				DigestUtils.md5Hex(str+salt);
		System.out.println(strMsg);
		
	}
	
	
	public static void main(String args[]) throws IOException{
		test3();
	}
}







