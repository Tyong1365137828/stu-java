package edu.hebeu.original;

public class Demo {
	
	/**
	 * 解决如下的问题，通用的做法是：原先的父类和子类都继承一个更通俗的基类，原先的继承关系去掉，采用依赖、
	 * 聚合、组合等关系代替；
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		System.out.println("11 - 3 =" + a.fun1(11, 3));
		System.out.println("1 - 8 = " + a.fun1(1, 8));
		
		System.out.println("----------------------------------------");
		
		B b = new B();
		System.out.println("11 - 3 = " + b.fun1(11, 3)); // 这里程序员的本意是求出11 - 3 的结果，但是该方法已经被重写了！
		System.out.println("1 - 8 =" + b.fun1(1, 8)); // 这里程序员的本意是求出11 - 3 的结果，但是该方法已经被重写了！
		System.out.println("11 + 3 + 9 = " + b.fun1(11, 3));
		
	}
}

class A {
	public int fun1(int x, int y) {
		return x - y;
	}
}

class B extends A {
	public int fun1(int x, int y) { // 假设这里无意识的重写了A的fun1()方法
		return x + y;
	}
	
	public int fun2(int x, int y) {
		return fun1(x, y) + 9;
	}
}
