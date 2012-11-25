package aj.ch12;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Arrays;

public class SecureProxy implements InvocationHandler{

	private Object target;
	private List<String> secureMethods;
	
	
	public SecureProxy(Object target){
		this(target,"a");
	}
	
	public SecureProxy(Object target,String... secureMethods){
		this.target = target;
		this.secureMethods = Arrays.asList(secureMethods);
	}
	
	
	public Object invoke(Object proxy,Method method,Object[] params) throws Exception{
		String methodName = method.getName();
		if(this.secureMethods.contains(methodName)){
			System.out.println(methodName + " is security");
			throw new PermissionException(methodName);
		}
		else{
			return method.invoke(this.target, params);
		}
	}
	
}
