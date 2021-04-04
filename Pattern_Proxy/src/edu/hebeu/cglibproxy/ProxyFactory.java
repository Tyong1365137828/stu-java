package edu.hebeu.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
	
	private Object target; // Ҫ�����Ŀ�����
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	/**
	 * �����������ͨ�����������target ����һ���������
	 * @return
	 */
	public Object getProxyInstance() {
		// 1���������������
		Enhancer enhancer = new Enhancer();
		// 2�����ø���(��������������Ӧ������)
		enhancer.setSuperclass(target.getClass());
		// 3�����ûص�����
		enhancer.setCallback(this);
		// 4�������������(���������)		
		return enhancer.create();
	}

	/**
	 * ����������Ե��ñ��������target�ķ���
	 */
	@Override
	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		System.out.println("cglib����ʼ...");
		Object returnValue = method.invoke(target, args); // ���ñ��������target ��method����,�÷����Ĳ����б���args������ֵ��returnValue
		System.out.println("cglib�������");
		return returnValue;
	}
	
	
	
}
