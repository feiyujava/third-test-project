package cn.tedu.store.service.ex;

public class PasswordNotMatchExceptin extends RuntimeException {

	private static final long serialVersionUID = -1405484391523308687L;
	public PasswordNotMatchExceptin(){
		
	}
	public PasswordNotMatchExceptin(String message){
		super(message);
	}
}
