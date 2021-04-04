package edu.hebeu.original;

/**
 * 这个例子使用 传统方式 解决克隆羊问题；
 * 
 * 优缺点分析：
 * 	1、优点是比较好理解，简单易操作。
 *	2、在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂时，效率较低
 *	3、总是需要重新初始化对象，而不是动态地获得对象运行时的状态, 不够灵活
 *
 *	解决：Java 中 Object 类是所有类的根类，Object 类提供了一个 clone()方法，该方法可以将一个
 * Java 对象复制一份，但是需要实现 clone 的 Java 类必须要实现一个接口 Cloneable，该接口表示该
 * 类能够复制且具有复制的能力  =>原型模式
 * 
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		
		Sheep tomSheep = new Sheep("tom", 1, "白色");

		//传统的方法
		Sheep tomSheep1 = new Sheep(tomSheep.getName(), tomSheep.getAge(), tomSheep.getColor()); 
		Sheep tomSheep2 = new Sheep(tomSheep.getName(), tomSheep.getAge(), tomSheep.getColor()); 
		Sheep tomSheep3 = new Sheep(tomSheep.getName(), tomSheep.getAge(), tomSheep.getColor());
		// ...
		
		System.out.println(tomSheep);
		System.out.println(tomSheep1);
		System.out.println(tomSheep2);
		System.out.println(tomSheep3);
		// ...
	}
}
