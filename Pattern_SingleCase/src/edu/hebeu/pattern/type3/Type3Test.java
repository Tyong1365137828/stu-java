package edu.hebeu.pattern.type3;

/**
 * 这个类演示 懒汉式(线程不安全) 实现单例模式
 * 
 * 优缺点说明：
 * 	1、起到了懒加载的效果，但是只能在单线程下使用；
 * 	2、如果在多线程下，一个线程进入if(instance == null)判断语句，可能还未来得及往下执行，另一个线程也通过
 * 了这个判断语句，这时便会产生多个实例，所以在多线程环境下不可以使用这种方式；
 * 
 * 结论：在实际开发中，不要使用这种方式实现单例模式；
 * 
 * 
 * @author 13651
 *
 */
public class Type3Test {
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
			instance = new Singleton();
		}
		return instance;
	}

}
