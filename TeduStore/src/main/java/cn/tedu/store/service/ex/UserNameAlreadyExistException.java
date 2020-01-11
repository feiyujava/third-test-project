package cn.tedu.store.service.ex;

public class UserNameAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 7825131247605616824L;

	public UserNameAlreadyExistException(){
		
	}
	public UserNameAlreadyExistException(String msg){
		super(msg);
	}
}
