package edu.hebeu.original;

public class Demo {
	public static void main(String[] args) {
		A a = new A();
		a.depend1(new B());
		a.depend2(new B());
		a.depend3(new B());
		
		C c = new C();
		c.depend1(new D());
		c.depend4(new D());
		c.depend5(new D());
		
	}
}

interface Interface1 {
	void operation1();
	void operation2();
	void operation3();
	void operation4();
	void operation5();
}

class B implements Interface1 {

	@Override
	public void operation1() {
		System.out.println("类B 实现了operation1()方法");
	}

	@Override
	public void operation2() {
		System.out.println("类B 实现了operation2()方法");
	}

	@Override
	public void operation3() {
		System.out.println("类B 实现了operation3()方法");
	}

	@Override
	public void operation4() {
		System.out.println("类B 实现了operation4()方法");
	}

	@Override
	public void operation5() {
		System.out.println("类B 实现了operation5()方法");
	}
}

class D implements Interface1 {

	@Override
	public void operation1() {
		System.out.println("类D 实现了operation1()方法");
	}

	@Override
	public void operation2() {
		System.out.println("类D 实现了operation2()方法");
	}

	@Override
	public void operation3() {
		System.out.println("类D 实现了operation3()方法");
	}

	@Override
	public void operation4() {
		System.out.println("类D 实现了operation4()方法");
	}

	@Override
	public void operation5() {
		System.out.println("类D 实现了operation5()方法");
	}
}

// 类A使用接口Interface1的1、2、3方法依赖类B
class A {
	public void depend1(Interface1 interface1) {
		interface1.operation1();
	}
	
	public void depend2(Interface1 interface1) {
		interface1.operation2();
	}
	
	public void depend3(Interface1 interface1) {
		interface1.operation3();
	}
}

//类C使用接口Interface1的1、4、5方法依赖类D
class C {
	public void depend1(Interface1 interface1) {
		interface1.operation1();
	}
	
	public void depend4(Interface1 interface1) {
		interface1.operation4();
	}
	
	public void depend5(Interface1 interface1) {
		interface1.operation5();
	}
}
