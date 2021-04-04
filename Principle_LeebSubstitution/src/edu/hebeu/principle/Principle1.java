package edu.hebeu.principle;

/**
 * 这个例子用来解决Demo例子中出现的问题
 * @author 13651
 *
 */
public class Principle1 {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("11 - 3 =" + a.fun1(11, 3));
		System.out.println("1 - 8 = " + a.fun1(1, 8));
		
		System.out.println("----------------------------------------");
		
		B b = new B();
		System.out.println("11 + 3 = " + b.fun1(11, 3)); // 这里B类没有继承A类，所以程序员也就不会想到去用B类的fun1方法进行减操作
		System.out.println("1 + 8 =" + b.fun1(1, 8)); // 这里B类没有继承A类，所以程序员也就不会想到去用B类的fun1方法进行减操作
		System.out.println("11 + 3 + 9 = " + b.fun1(11, 3));
		// B和A之间的关系是组合，但是任然可以通过B去访问调用A中的方法，如下，通过B的fun3去调用A中的fun1进行减法操作
		System.out.println("11 - 3 = " + b.fun3(11, 3));
		
	}
}

class Base { // 创建一个更基础的基类
	// 把更基础的方法和成员写到Base类
}

class A extends Base {
	public int fun1(int x, int y) {
		return x- y;
	}
}

class B extends Base {
	// 这里B要使用A中的方法，使用组合关系，可以发现B中任然能够使用A中的方法，且A和B之间的耦合关系也不那么高了
	private A a = new A();
	
	public int fun1(int x, int y) {
		return x + y;
	}
	
	public int fun2(int x, int y) {
		return fun1(x, y) + 9;
	}
	
	// 使用A的相关方法
	public int fun3(int x, int y) {
		return this.a.fun1(x, y);
	}
}
