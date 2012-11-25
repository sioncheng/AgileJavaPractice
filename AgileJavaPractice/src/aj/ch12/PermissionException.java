package aj.ch12;

public class PermissionException extends Exception{

	public static final long serialVersionUID = 1L;
	
	private String method;
	public PermissionException(String method){
		this.method = method;
	}
	
	@Override
	public String getMessage(){
		return "you don't have permission to invoke method " + this.method;
	}
}
