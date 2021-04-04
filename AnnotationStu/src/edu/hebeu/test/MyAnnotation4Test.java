package edu.hebeu.test;

import java.lang.reflect.Method;

import edu.hebeu.annotation.MyAnnotation;
import edu.hebeu.annotation.MyAnnotation4;

/**
 * 这个例子用来测试MyAnnotation4的注解
 * @author 13651
 *
 */

public class MyAnnotation4Test {
	public static void main(String[] args) {
		
		Class<?> cClass = null;
		try {
			cClass = Class.forName("edu.hebeu.test.MyClass");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * isAnnotationPresent(Annotation类型的字节码)
		 * 如下所示：
		 */
		boolean isExist = cClass.isAnnotationPresent(MyAnnotation4.class);
		System.out.println("MyClass类是否存在MyAnnotation4注解？" + isExist);
		
		if(isExist) { // 如果为true，即MyClass类上存在MyAnnotation4注解
			/**
			 * public <A extends Annotation> A getAnnotation(Class<A> annotationClass)
			 * 通过A注解的字节码获取A的注解对象，返回A注解类的对象；
			 * 如下所示：
			 */
			MyAnnotation4 myAnnotation4 = (MyAnnotation4)cClass.getAnnotation(MyAnnotation4.class); // 向下转型
			System.out.println("MyClass类上的注解对象：" + myAnnotation4);
			
			/**
			 *获取注解对象的属性 ，与普通Java类对象的获取方法一样
			 */
			String addressClassUseS = myAnnotation4.address();
			String describeClassUseS = myAnnotation4.describe();
			System.out.println("MyAnnotation4类上注解的属性：address = " + addressClassUseS + "; describe = " + describeClassUseS);
			
			/**
			 * 获取方法上的注解属性
			 */
			Method doSomeMethod = null;
			try {
				doSomeMethod = cClass.getDeclaredMethod("doSome"); // 获取名为 doSome() 的方法
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(doSomeMethod.isAnnotationPresent(MyAnnotation4.class)) { // 如果doSome()方法上存在MyAnnotation的注解
				MyAnnotation4 myAnnotation4MethodUse = doSomeMethod.getAnnotation(MyAnnotation4.class);
				String addressMethodUseS = myAnnotation4MethodUse.address();
				String describeMethodUseS = myAnnotation4MethodUse.describe();
				System.out.println("MyAnnotation类的doSome()方法上的注解的属性：address = " + addressMethodUseS + "; describe = " + describeMethodUseS);
			}
			
		}
		
		boolean isExist2 = cClass.isAnnotationPresent(MyAnnotation.class);
		System.out.println("MyClass类是否存在MyAnnotation注解？" + isExist2);
		
		
		
		
	}
}

@MyAnnotation4(describe = "类")
class MyClass {
	
	@MyAnnotation4(address = "陕西省", describe = "方法")
	public void doSome() {
		System.out.println("doSome...");
	}
}
