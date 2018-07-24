package cn.hist.flow.exception;

public class UserException extends Exception{
	

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public UserException() {
		super();
	}
	public UserException(String message) {
		super(message);
		this.msg=message;
	}

	public String getMsg() {
		return msg;
	}
}