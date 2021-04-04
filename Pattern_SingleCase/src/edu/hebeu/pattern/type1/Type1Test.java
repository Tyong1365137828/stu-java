package edu.hebeu.pattern.type1;

/**
 * 这个类来演示 饿汉式(静态常量) 实现单例模式
 * 步骤：
 * 		1、构造器私有化
 * 		2、类的内部创建对象
 * 		3、向外暴露一个静态的公共方法：getInstance()
 * 
 * 优缺点说明：
 * 	1、优点：这种方式写法简单，就是在类装载的时候去完成实例化，避免了线程同步问题，是线程安全的；
 * 	2、缺点：在类装载的时候就完成实例化，没有达到懒加载的效果，如果从始至终都未使用这个实例，则会造成内存
 * 的浪费；
 * 	3、这种方式基于classLoader机制避免了多线程的同步问题，不过instance在类装载时就实例化了，在单例模式中
 * 大多数都是调用getInstance()方法，此时导致类装载的原因有很多，因此不能确定有其他的方式(或者其他的静态方
 * 法)导致类装载，这时候初始化instance就没有达到懒加载的效果；
 * 
 * 结论：这种方式实现的单例模式可用，但是可能造成内存的浪费；
 * 
 * @author 13651
 *
 */
public class Type1Test {

	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		System.out.println("instance1的hashCode = " + instance1.hashCode() + "; instance2的hashCode = " + instance2.hashCode());
		System.out.println("instance1和instance2是否是同一个对象：" + (instance1 == instance2));
		
	}
}

class Singleton {
	// 1、私有化构造器
	private Singleton() {}
	
	// 2、类的内部创建对象
	private static final Singleton instance = new Singleton();
	
	// 3、向外提供一个静态的公共方法来获取instance实例对象
	public static Singleton getInstance() {
		return instance;
	}
	
}
