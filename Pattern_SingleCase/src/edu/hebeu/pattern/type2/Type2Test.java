package edu.hebeu.pattern.type2;

/**
 * 这个类来演示 饿汉式(静态代码块) 实现单例模式
 * 
 * 优缺点说明：
 * 	1、这种方法和上面的方法其实类似，只不过将类实例化的过程放到了静态代码块中，也是在类装载的时候就执行静态
 * 代码块中的代码，初始化类的实例，优点和缺点与方式一一样；
 * 
 * 结论：这种方式实现的单例模式可用，但是可能造成内存浪费；
 * @author 13651
 *
 */
public class Type2Test {
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
	
	private static Singleton instance;
	// 2、静态代码块
	static {
		instance = new Singleton();
	}
	
	// 3、对外提供一个静态的公共方法来获取instance实例对象
	public static Singleton getInstance() {
		return instance;
	}
	
}
