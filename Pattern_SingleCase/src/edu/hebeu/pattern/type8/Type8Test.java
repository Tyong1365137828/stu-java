package edu.hebeu.pattern.type8;

/**
 * 这个类演示 枚举 方式实现单例模式
 * 
 * 优缺点说明：
 * 	1、借助JDK1.5中新增的枚举类来实现单例模式，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的
 * 对象；
 * 	2、这种方式是 Effective JAVA 作者 Josh Bloch 提倡的方式；
 * 
 * 结论：推荐使用
 * 
 * @author 13651
 *
 */
public class Type8Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.INSTANCE;
		Singleton instance2 = Singleton.INSTANCE;
		
		System.out.println("instance1的hashCode = " + instance1.hashCode() + "; instance2的hashCode = " + instance2.hashCode());
		System.out.println("instance1和instance2是否是同一个对象：" + (instance1 == instance2));
		
		instance1.method1();
		instance2.method1();
	}
}

enum Singleton {
	INSTANCE;
	public void method1() {
		System.out.println("方法method1执行了...");
	}
}
