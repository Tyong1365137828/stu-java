package edu.hebeu.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
	
	private Object target; // 要代理的目标对象
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	/**
	 * 这个方法用来通过被代理对象target 返回一个代理对象
	 * @return
	 */
	public Object getProxyInstance() {
		// 1、创建工具类对象
		Enhancer enhancer = new Enhancer();
		// 2、设置父类(即被代理类对象对应的类型)
		enhancer.setSuperclass(target.getClass());
		// 3、设置回调函数
		enhancer.setCallback(this);
		// 4、创建子类对象(即代理对象)		
		return enhancer.create();
	}

	/**
	 * 这个方法可以调用被代理对象target的方法
	 */
	@Override
	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		System.out.println("cglib代理开始...");
		Object returnValue = method.invoke(target, args); // 调用被代理对象target 的method方法,该方法的参数列表是args，返回值是returnValue
		System.out.println("cglib代理结束");
		return returnValue;
	}
	
	
	
}
