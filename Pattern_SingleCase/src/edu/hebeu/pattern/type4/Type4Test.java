package edu.hebeu.pattern.type4;

/**
 * 这个类演示 懒汉式(线程安全，同步方法) 实现单例模式
 * 
 * 优缺点说明：
 * 	1、解决了线程不安全问题；
 * 	2、效率太低了，每个线程在想获取类的实例时，执行getInstance()方法都要进行同步，而其实这个方法只要执行一
 * 次实例化代码就够了，后面的想获得这个类的实例，直接return就行，但是使用此方式时是方法体全部同步的，效率
 * 太低了；
 * 
 * 结论：在实际开发中，不推荐使用这种方式实现单例模式；
 * 
 * @author 13651
 *
 */
public class Type4Test {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1的hashCode = " + instance1.hashCode() + "; instance2的hashCode = " + instance2.hashCode());
		System.out.println("instance1和instance2是否是同一个对象：" + (instance1 == instance2));
		
	}
}

class Singleton {
	
	private static Singleton instance;
	
	// 1、私有化构造器
	private Singleton() {}
	
	// 2、对外提供一个静态的公共方法来获取instance实例对象
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
