package edu.hebeu.annotation;

/**
 * 这个例子展示Deprecated注解的用法和作用；
 * 
 * 	这个注解标注的元素，表示该元素已过时(会通过中划线标识)；
 * 
 * @author 13651
 *
 */
public class DeprecatedAnnotation {
	public static void main(String[] args) {
		MyClass.m3();
		
		MyClass myClass = new MyClass();
		myClass.m1();
		myClass.m2();
		myClass.mAll();
	}
}

class MyClass {
	
	@Deprecated
	public void m1() {
		System.out.println("m1");
	}
	
	@Deprecated
	public int m2() {
		System.out.println("m2");
		return 0;
	}
	
	@Deprecated
	public static void m3() {
		System.out.println("static m3");
	}
	
	@Deprecated
	public void mAll() {
		System.out.println("mAll");
		m3();
	}
	
}
