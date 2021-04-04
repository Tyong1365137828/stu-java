package edu.hebeu.original.order;

/**
 * 
 * 从这个例子用来实现披萨的购买(相当于一个客户端，完成披萨的订购任务)
 * 
 * 采用这种传统的方式的优缺点：
 * 	1、优点是比较好理解，简单易操作；
 * 	2、缺点是违反了设计原则的OCP原则(即对扩展开放，对修改关闭)；
 * 	3、如果此时我们要新增一个Pizza的种类ChinaPizza，我们需要修改很多地方，如在创建Pizza对象时
 * (OrderPizza类的构造方法)，往往是多个OrderPizza类进行购买的，所以有几个OrderPizza类就要添加
 * 多少个创建的Pizza类型的代码
 * 
 * 
 * 解决思路：
 * 	把创建Pizza对象封装到一个类中，这样我们有新的Pizza种类时，只需要修改该类中的代码即可，其他
 * 有创建Pizza对象的代码就不要修改了--> 简单工厂模式，如包simplefactory所示
 * 	
 * @author 13651
 *
 */
public class PizzaStore {

	public static void main(String[] args) {
		new OrderPizza1();
	}
}
