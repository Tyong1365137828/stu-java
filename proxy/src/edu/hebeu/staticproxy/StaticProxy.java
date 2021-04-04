package edu.hebeu.staticproxy;

/**
 * 这个例子展示和测试静态代理的实现；
 * 可以看出，静态代理的特点：代理类和被代理类在编译期间就被确定下来了
 * @author 13651
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		ProxyFactory nikeProxyFactory = new ProxyFactory(new NikeFactory()); // 通过NikeFactory类的实例创建代理类的实例
		nikeProxyFactory.produceCloth();
	}

}

/**
 * 衣服工厂的接口类
 */
interface ClothFactory {
	
	/**
	 * 声明一个方法，该方法用于生产对象
	 */
	void produceCloth();
}

/**
 * 被代理类
 */
class NikeFactory implements ClothFactory {

	@Override
	public void produceCloth() {
		System.out.println("Nike厂商生产了一批产品");
	}
	
}

/**
 * 静态代理类
 */
class ProxyFactory implements ClothFactory {
	
	private ClothFactory clothFactory;
	
	public ProxyFactory(ClothFactory clothFactory) {
		this.clothFactory = clothFactory;
	}

	@Override
	public void produceCloth() {
		System.out.println("代理方：准备生产...");
		clothFactory.produceCloth(); // 调用被代理类实例的方法
		System.out.println("代理方：生产完毕！");
	}
	
}
