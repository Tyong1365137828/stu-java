package edu.hebeu.annotation;

/**
 * �������չʾDeprecatedע����÷������ã�
 * 
 * 	���ע���ע��Ԫ�أ���ʾ��Ԫ���ѹ�ʱ(��ͨ���л��߱�ʶ)��
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
