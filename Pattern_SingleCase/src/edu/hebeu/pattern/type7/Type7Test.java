package edu.hebeu.pattern.type7;

/**
 * 这个类演示 静态内部类 方式实现单例模式
 * 
 * 优缺点说明：
 * 	1、这种方式采用了类加载的机制来保证初始化实例时只有一个线程(线程安全)
 * 	2、如下代码，静态内部类方式在Singleton类加载时并不会立即实例化，而是在需要实例化时，调用getInstance()
 * 方法才会导致SingletonInstance类装载，从而完成对Singleton的实例化；
 * 	3、类的静态属性只会在第一次加载类的时侯初始化，所以在这里JVM帮助我们保证了线程的安全性，在类进行初始化
 * 时别的线程是无法进入的；
 * 	4、优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高；
 * 
 * 结论：推荐使用；
 * 
 * 总结：
 * 
 * @author 13651
 *
 */
public class Type7Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1的hashCode = " + instance1.hashCode() + "; instance2的hashCode = " + instance2.hashCode());
		System.out.println("instance1和instance2是否是同一个对象：" + (instance1 == instance2));
		
	}
}

/*
 * 须知：
 * 	静态内部类的特点：
 * 		1、当主类进行类装载时，静态内部类不会被装载；
 * 		2、当主类调用静态内部类的静态变量时，会导致静态内部类装载；
 * 
 */
class Singleton {
	
	// 1、私有化构造器
	private Singleton() {}
	
	// 2、创建静态内部类，并在其内部实例化一个Singleton的实例
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	// 3、对外提供一个静态的公共方法来获取instance实例对象
	public static Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}
	
}
