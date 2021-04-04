package edu.hebeu.reflectmethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 这个例子展示如何通过反射机制执行方法(即通过反射机制实现对象调用实例方法)
 * @author 13651
 *
 */
public class AccessObjOfMethod {
	public static void main(String[] args) {
		Class methodEntityClass = null;
		try {
			methodEntityClass = Class.forName("edu.hebeu.entity.MethodEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		try {
			obj = methodEntityClass.newInstance(); // 调用无参构造方法通过字节码创建对象
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Method loginMethod =null;
		try {
			loginMethod = methodEntityClass.getDeclaredMethod("login", String.class, String.class); // 通过方法名和形参类型获取methodEntityClass(MethodEntity字节码)的login(String, String)方法(Method对象)
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object loginSuccess = null;
		try {
			/**
			 * 如下所示：
			 * 	调用obj对象的loginMethod方法(login对应的Method对象)，传递参数 "1365137828", "0727316052"，返回值通过loginSuccess接收
			 */
			loginSuccess = loginMethod.invoke(obj, "1365137828", "0727316052"); // 调用实例方法(执行)
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("登录成功与否？" + loginSuccess);
		
	}
}
