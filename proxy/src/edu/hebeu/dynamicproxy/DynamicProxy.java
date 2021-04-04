package edu.hebeu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * ���������ʾ��̬�����ʵ��
 * 
 * ���Է��ֶ�̬����Ĵ���ʵ�ֽ����ѣ�����һ��ʵ�֣��κ���Ķ��󶼿���ֱ��ʹ�ã���ʹ�ü�(��������һ�д��뼴��ʵ�ִ������Ĵ���)��
 * @author 13651
 *
 */
public class DynamicProxy {
	
	public static void main(String[] args) {
		SuperMan superMan = new SuperMan(); // �������������		
		Human proxySuperMan = (Human) DynamicProxyFactory.getDynamicProxyObj(superMan); // ��ȡ ͨ�����������superMan ��ȡ �������proxySuperMan
		/**���ô�������getBelief()��setInfo()��getName()�������ײ���Զ����� ����������ͬ������*/
		proxySuperMan.getBelief();
		proxySuperMan.setInfo("����", 1000, new Date());
		System.out.println("������" + proxySuperMan.getName());
		
		System.out.println("********************************************************************************");
		
		NikeFactory nike = new NikeFactory(); // �������������
		ClothFactory proxyNike = (ClothFactory) DynamicProxyFactory.getDynamicProxyObj(nike); // ��ȡ ͨ�����������nike ��ȡ �������proxyNike
		proxyNike.produceCloth();
		
		
	}
}

/***һ��������***/
interface Human {
	
	void getBelief();
	
	void setInfo(String name, Integer age, Date birthday);
	
	String getName();
}
class SuperMan implements Human {
	private String name;

	@Override
	public void getBelief() {
		System.out.println("�����ţ����ܷɣ�");
	}

	@Override
	public void setInfo(String name, Integer age, Date birthday) {
		this.name = name;
		System.out.println("��¼����Ϣ��name = " + name + "; age = " + age + "; birthday = " + birthday);
	}

	@Override
	public String getName() {
		return name;
	}
}
/******/
/***һ��������***/
interface ClothFactory {
	
	void produceCloth();
}

/**
 * ��������
 */
class NikeFactory implements ClothFactory {
	@Override
	public void produceCloth() {
		System.out.println("Nike����������һ����Ʒ");
	}
}
/******/
class Utils {
	public static void beforeAdvice() {
		System.out.println("ǰ��֪ͨ...");
	}
	public static void afterAdvice() {
		System.out.println("����֪ͨ...");
	}
}


/**
 * ��������������ж�̬�������
 * 
 * Ҫʵ�ֶ�̬������Ҫ��������⣺
 * 	1����θ��ݼ��ص��ڴ��еı������ࡣ��̬�Ĵ���һ�������༰�����
 * 	2����ͨ��������Ķ�����÷���ʱ����ζ�̬��ȥ���ñ��������е�ͬ��������
 */
class DynamicProxyFactory {
	
	/**
	 * ����������� ͨ��������������ȡһ�����������
	 * @param byTheProxyObj �����������
	 * @return ����������� ��Ӧ�� ���������
	 */
	public static Object getDynamicProxyObj(Object byTheProxyObj) {
		System.err.println("��ʼ���д���...");
		
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		myInvocationHandler.byTheProxyObjGet(byTheProxyObj); // ������������� ��ȡ�� MyInvocationHandler����
		
		/*
		 * newProxyInstance()��������⣺
		 * 	����1���������������������
		 * 	����2�������������ʵ�ֵ����нӿ�
		 * 	����3����Ҫ��InvocationHandler��ʵ�����е�invoke()��������ִ�� ��������� ��Ӧ�� ������������ͬ������
		 * 	����ֵ��������������Ӧ�� ��̬���������
		 * �÷�����ִ�е� ����3��invoke()����
		 */
		Object proxyObj = Proxy.newProxyInstance(byTheProxyObj.getClass().getClassLoader(), byTheProxyObj.getClass().getInterfaces(), myInvocationHandler);
		return proxyObj; // �� ������������Ӧ�� ��̬��������� ����
	}
	
}

class MyInvocationHandler implements InvocationHandler {
	
	private Object byTheProxyObj; // ���������Ǳ����������
	
	/**
	 * �������������ȡ�����������
	 * @param byTheProxyObj
	 */
	public void byTheProxyObjGet(Object byTheProxyObj) {
		this.byTheProxyObj = byTheProxyObj;
		System.err.println("�Ѿ���ȡ�����������");
	}

	/**
	 * ����1������������ڱ����о��� Proxy.newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler ih)�����ķ���ֵ��
	 * ����2��������ķ���(��Ϊ������ͱ�������ķ�������һ���ģ����Ҳ���Կ����Ǳ�������ķ���)
	 * ����3���������෽���Ĳ����б�
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Utils.beforeAdvice();
		
		Object returnValue = method.invoke(byTheProxyObj, args); // ִ�б����������byTheProxyObj�� method����������Ϊargs������ȡ�÷����ķ���ֵ
		
		Utils.afterAdvice();
		
		System.err.println("�Ѿ�ִ�б�����������ͬ���������������");
		return returnValue; // ������������� ִ�еķ��� �ķ���ֵ���س�ȥ
	}
	
}