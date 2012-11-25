package aj.ch12;

import java.lang.reflect.Proxy;
import java.lang.Class;

import org.junit.Test;
import org.junit.Assert;

public class SecureProxyTest {

	@Test
	public void test() throws Throwable{
		
		SomeImpl impl = new SomeImpl();
		SecureProxy proxy = new SecureProxy(impl,"a","b");
		
		try{
			proxy.invoke(proxy, impl.getClass().getDeclaredMethod("a"), null); 
		}
		catch(Throwable e){
			Assert.assertEquals("you don't have permission to invoke method a", e.getMessage());
		}
		
	}
	
	@Test
	public void testDynamic() throws Throwable{
		
		SomeImpl impl = new SomeImpl();
		SecureProxy proxy = new SecureProxy(impl,"a","b");
		
		Class<SomeInterface> clazz = SomeInterface.class;
		SomeInterface someProxy = (SomeInterface) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, proxy);
		try{
			someProxy.b();
		}
		catch(Throwable e){
			//Assert.assertEquals("you don't have permission to invoke method b", e.getMessage());
			Assert.assertEquals("you don't have permission to invoke method b", e.getCause().getMessage());
		}
	}
}
