package edu.hebeu.pattern.type5;

/**
 * 这个类演示 懒汉式(线程安全，同步代码块) 方式实现单例模式，注意该方式其实没有实现同步
 * 
 * 优缺点说明：
 * 	1、这种方式本意是想对第四种方式进行改进，因为前者的效率太低了；
 * 	2、但是仔细分析发现该方式并不能实现同步的作用，因为当出现第三种方式的情景时，多个线程进入
 * if(instance == null)中，此时synchronized(){}只能让这些线程一个一个的创建实例instance，此
 * 时会产生多个instance实例；
 * 
 * 结论：在实际开发中，不能使用这种方式实现单例模式；
 * 
 * @author 13651
 *
 */
public class Type5Test {
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
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}
	
}
