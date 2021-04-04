package edu.hebeu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ���������ʾ��̬����
 * @author 13651
 *
 */
public class ProxyFactory {
	
	private Object target; // Ҫ�����Ŀ�����
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	/**
	 * ���������ͨ�����������target����һ���������
	 * @return
	 */
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() { // �����ñ��������ķ���ʱ����ִ�д�
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("��̬����ʼ��...");
						Object returnValue = method.invoke(target, args); // ִ�б��������(Ŀ�����target)�� �����б�Ϊargs �ķ���ֵΪreturnValue ��method����
						System.out.println("��̬�������");
						return returnValue;
					}
				});
	}
	
}
