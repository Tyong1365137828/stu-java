package edu.hebeu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 这个例子演示动态代理的实现
 * 
 * 可以发现动态代理的代码实现较困难，但是一旦实现，任何类的对象都可以直接使用，且使用简单(两行甚至一行代码即可实现代理对象的创建)；
 * @author 13651
 *
 */
public class DynamicProxy {
	
	public static void main(String[] args) {
		SuperMan superMan = new SuperMan(); // 创建被代理对象		
		Human proxySuperMan = (Human) DynamicProxyFactory.getDynamicProxyObj(superMan); // 获取 通过被代理对象superMan 获取 代理对象proxySuperMan
		/**调用代理对象的getBelief()、setInfo()、getName()方法，底层会自动调用 被代理对象的同名方法*/
		proxySuperMan.getBelief();
		proxySuperMan.setInfo("超人", 1000, new Date());
		System.out.println("姓名：" + proxySuperMan.getName());
		
		System.out.println("********************************************************************************");
		
		NikeFactory nike = new NikeFactory(); // 创建被代理对象
		ClothFactory proxyNike = (ClothFactory) DynamicProxyFactory.getDynamicProxyObj(nike); // 获取 通过被代理对象nike 获取 代理对象proxyNike
		proxyNike.produceCloth();
		
		
	}
}

/***一套试验类***/
interface Human {
	
	void getBelief();
	
	void setInfo(String name, Integer age, Date birthday);
	
	String getName();
}
class SuperMan implements Human {
	private String name;

	@Override
	public void getBelief() {
		System.out.println("我相信，我能飞！");
	}

	@Override
	public void setInfo(String name, Integer age, Date birthday) {
		this.name = name;
		System.out.println("已录入信息：name = " + name + "; age = " + age + "; birthday = " + birthday);
	}

	@Override
	public String getName() {
		return name;
	}
}
/******/
/***一套试验类***/
interface ClothFactory {
	
	void produceCloth();
}

/**
 * 被代理类
 */
class NikeFactory implements ClothFactory {
	@Override
	public void produceCloth() {
		System.out.println("Nike厂商生产了一批产品");
	}
}
/******/
class Utils {
	public static void beforeAdvice() {
		System.out.println("前置通知...");
	}
	public static void afterAdvice() {
		System.out.println("后置通知...");
	}
}


/**
 * 这个类是用来进行动态代理的类
 * 
 * 要实现动态代理需要解决的问题：
 * 	1、如何根据加载到内存中的被代理类。动态的创建一个代理类及其对象；
 * 	2、当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法；
 */
class DynamicProxyFactory {
	
	/**
	 * 这个方法用来 通过被代理类对象获取一个代理类对象
	 * @param byTheProxyObj 被代理类对象
	 * @return 被代理类对象 对应的 代理类对象
	 */
	public static Object getDynamicProxyObj(Object byTheProxyObj) {
		System.err.println("开始进行代理...");
		
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		myInvocationHandler.byTheProxyObjGet(byTheProxyObj); // 将被代理类对象 获取至 MyInvocationHandler类中
		
		/*
		 * newProxyInstance()方法的详解：
		 * 	参数1、被代理类对象的类加载器
		 * 	参数2、被代理类对象实现的所有接口
		 * 	参数3、主要是InvocationHandler的实现类中的invoke()方法，以执行 代理类对象 对应的 被代理类对象的同名方法
		 * 	返回值、被代理类对象对应的 动态代理类对象
		 * 该方法会执行到 参数3的invoke()方法
		 */
		Object proxyObj = Proxy.newProxyInstance(byTheProxyObj.getClass().getClassLoader(), byTheProxyObj.getClass().getInterfaces(), myInvocationHandler);
		return proxyObj; // 将 被代理类对象对应的 动态代理类对象 返回
	}
	
}

class MyInvocationHandler implements InvocationHandler {
	
	private Object byTheProxyObj; // 这个对象就是被代理类对象
	
	/**
	 * 这个方法用来获取被代理类对象
	 * @param byTheProxyObj
	 */
	public void byTheProxyObjGet(Object byTheProxyObj) {
		this.byTheProxyObj = byTheProxyObj;
		System.err.println("已经获取被代理类对象");
	}

	/**
	 * 参数1、代理类对象《在本例中就是 Proxy.newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler ih)方法的返回值》
	 * 参数2、代理类的方法(因为代理类和被代理类的方法名是一样的，因此也可以看作是被代理类的方法)
	 * 参数3、被代理类方法的参数列表
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Utils.beforeAdvice();
		
		Object returnValue = method.invoke(byTheProxyObj, args); // 执行被代理类对象byTheProxyObj的 method方法，参数为args，并获取该方法的返回值
		
		Utils.afterAdvice();
		
		System.err.println("已经执行被代理类对象的同名方法，代理结束");
		return returnValue; // 将被代理类对象 执行的方法 的返回值返回出去
	}
	
}