package edu.hebeu.principle;

public class Demo1 {
	public static void main(String[] args) {
		A a = new A();
		// 以下的每行代码都是 类A 通过接口的1、2、3方法去依赖(使用)类B
		a.depend1(new B());
		a.depend2(new B());
		a.depend3(new B());
		
		C c = new C();
		// 以下的每行代码都是 类C 通过接口的1、4、5方法去依赖(使用)类D
		c.depend1(new D());
		c.depend4(new D());
		c.depend5(new D());
	}
}

interface Interface1 {
	void operation1();
}

interface Interface2 {
	void operation2();
	void operation3();
}

interface Interface3 {
	void operation4();
	void operation5();
}

class B implements Interface1, Interface2 {

	@Override
	public void operation2() {
		System.out.println("类B 实现了operation2()方法");
	}

	@Override
	public void operation3() {
		System.out.println("类B 实现了operation3()方法");
	}

	@Override
	public void operation1() {
		System.out.println("类B 实现了operation1()方法");
	}
}

class D implements Interface1, Interface3 {

	@Override
	public void operation4() {
		System.out.println("类D 实现了operation4()方法");
	}

	@Override
	public void operation5() {
		System.out.println("类D 实现了operation5()方法");
	}

	@Override
	public void operation1() {
		System.out.println("类D 实现了operation1()方法");
	}
}

//类A使用 接口Interface1的1方法 和 接口Interface2的2、3方法 依赖类B
class A {
	public void depend1(Interface1 interface1) {
		interface1.operation1();
	}
	
	public void depend2(Interface2 interface2) {
		interface2.operation2();
	}
	
	public void depend3(Interface2 interface2) {
		interface2.operation3();
	}
}

//类C使用接口Interface1的1方法 和 接口Interface3的4、5方法 依赖类D
class C {
	public void depend1(Interface1 interface1) {
		interface1.operation1();
	}
	
	public void depend4(Interface3 interface3) {
		interface3.operation4();
	}
	
	public void depend5(Interface3 interface3) {
		interface3.operation5();
	}
}

