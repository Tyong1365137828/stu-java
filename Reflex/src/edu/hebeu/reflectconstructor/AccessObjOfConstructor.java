package edu.hebeu.reflectconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 这个例子展示如何通过反射机制调用构造方法，以创建对象
 * @author 13651
 *
 */
public class AccessObjOfConstructor {
	public static void main(String[] args) {
		Class constructorEntityClass = null;
		try {
			constructorEntityClass = Class.forName("edu.hebeu.entity.ConstructorEntity");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object obj = null;
		try {
			obj = constructorEntityClass.newInstance(); // 调用无参数构造方法创建对象，JDK9之后已经过时，调用构造方法可以使用下面的方式！
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("obj：" + obj);
		
		Object obj2 = null;
		Constructor constructor = null;
		try {
			constructor = constructorEntityClass.getDeclaredConstructor(int.class, boolean.class, String.class, Date.class); // 调用形参类型为 int、boolean、String、Date 的构造方法
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			obj2 = constructor.newInstance(110, true, "tyong", new Date()); // 通过获取到的构造方法传入实参进行调用这个构造方法
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.out.println("obj2：" + obj2);
		
	}
}
