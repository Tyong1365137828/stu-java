package edu.hebeu.simplefactory.order;

/**
 * 
 * 从这个例子 通过简单工厂模式 来实现披萨的购买(相当于一个客户端，完成披萨的订购任务)
 * 
 * 如果此时项目出现新的需求；客户在点披萨时，可以先选择地点，然后在该地点选择披萨，如：北京的奶酪披萨、
 * 北京的希腊披萨、伦敦的奶酪披萨、伦敦的希腊披萨等；
 * 
 * 思路：如果此时继续使用这种 简单工厂模式，就需要创建不同的简单工厂类，如：BJPizzaSimpleFactory类、
 * LDPizzaSimpleFactory类等，但是这样子会导致工厂类过多，对项目的扩展性、维护性不是特别好！
 * 	此时我们可以使用工厂方法模式去实现该需求，如包methodfactory所示
 * 	
 * @author 13651
 *
 */
public class PizzaStore {

	public static void main(String[] args) {
//		System.out.println("***使用简单工厂模式***");
//		new OrderPizza1(new PizzaSimpleFactory());
		
		System.out.println("***使用简单工厂模式的第二种写法(静态工厂模式)***");
		new OrderPizza2();
	}
}
