package edu.hebeu.pattern.type6;

/**
 * 这个类演示 双重检查 方式实现单例模式
 * 
 * 优缺点说明：
 * 	1、双重检查(Double Check)是多线程开发中常使用到的；
 * 	2、如下面的代码所示使用两次if(instance == null)检查，保证线程更加安全，这样实例化代码只用执行一次，
 * 在首次执行这个方法，即使外部的if(instance == null)进入多个线程，其内部还会有一个if(instance == null)
 * 保证只能出现一个instance，不会创建多个instance；后面再次访问时，会通过外层的if(instance == null)检查
 * 是后，直接return出instance，避免了执行同步的代码块synchronized(Singleton.class)的执行，极大的提高了
 * 效率；
 * 	3、此方式实现的单例模式线程安全、能延迟加载、效率较高；
 * 
 * 结论：在实际开发中，推荐使用这种方式实现单例模式；
 * 
 * @author 13651
 *
 */
public class Type6Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1的hashCode = " + instance1.hashCode() + "; instance2的hashCode = " + instance2.hashCode());
		System.out.println("instance1和instance2是否是同一个对象：" + (instance1 == instance2));
		
	}
}

class Singleton {
	
	private static volatile Singleton instance; // volatile修饰这个变量表示：当这个变量发生变化，值立刻会刷入主存中，在一定程度上达到同步的效果
	
	// 1、私有化构造器
	private Singleton() {}
	
	// 2、对外提供一个静态的公共方法来获取instance实例对象
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
}
