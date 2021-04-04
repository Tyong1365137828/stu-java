package edu.hebeu.staticinnerclass;

/**
 * 通过此例介绍静态内部类
 * 
 * 静态内部类可以被泛型使用
 * @author 13651
 *
 */
public class StaticInnerClassStu {
	
	// 声明一个静态内部类
	private static class MyInnerClass {
		
		// 静态方法
		public static void m1() {
			System.out.println("静态内部类静态方法m1执行");
		}
		
		// 实例方法
		public void m2() {
			System.out.println("静态内部类实例方法m2执行");
		}
	}
	
	
	
	public static void main(String[] args) {
		StaticInnerClassStu.MyInnerClass.m1(); // 测试静态内部类的静态方法
		
		StaticInnerClassStu.MyInnerClass mic = new StaticInnerClassStu.MyInnerClass(); // 创建静态内部类对象
		mic.m2(); // 通过静态内部类对象调用实例方法
	}
}
 