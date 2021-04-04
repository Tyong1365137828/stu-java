package edu.hebeu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这个例子演示动态代理
 * @author 13651
 *
 */
public class ProxyFactory {
	
	private Object target; // 要代理的目标对象
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	/**
	 * 这个方法会通过被代理对象target返回一个代理对象
	 * @return
	 */
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() { // 当调用被代理对象的方法时，会执行此
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("动态代理开始了...");
						Object returnValue = method.invoke(target, args); // 执行被代理对象(目标对象target)的 参数列表为args 的返回值为returnValue 的method方法
						System.out.println("动态代理结束");
						return returnValue;
					}
				});
	}
	
}
