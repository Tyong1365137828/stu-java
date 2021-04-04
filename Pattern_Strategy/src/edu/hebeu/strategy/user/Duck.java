package edu.hebeu.strategy.user;

import edu.hebeu.strategy.strategys.flybehavior.FlyBehavior;
import edu.hebeu.strategy.strategys.quackbehavior.QuackBehavior;
import edu.hebeu.strategy.strategys.swimbehavior.SwimBehavior;

/**
 * 所有的鸭子的抽象基类
 * @author 13651
 *
 */
public abstract class Duck {
	
	// 聚合所有的策略
	protected FlyBehavior fly;
	protected QuackBehavior quack;
	protected SwimBehavior swim;
	
	/**
	 * 展示鸭子的所有信息
	 */
	public abstract void display();
	
	/**
	 * 飞的方法
	 */
	public final void fly() {
		if(fly != null) { // 如果fly不为null，就调用fly的fly()方法
			fly.fly();
			return;
		}
		System.out.println("鸭子会飞"); // 程序执行到此，说明fly为null
	}
	
	/**
	 * 叫的方法
	 */
	public final void quack() {
		if(quack != null) { // 如果quack不为null，就调用quack的quack()方法
			quack.quack();
			return;
		}
		System.out.println("鸭子会叫"); // 程序执行到此，说明quack为null
	}
	
	/**
	 * 游泳的方法
	 */
	public final void swim() {
		if(swim != null) { // 如果swim不为null，就调用swim的swim()方法
			swim.swim();
			return;
		}
		System.out.println("鸭子会游泳"); // 程序执行到此，说明swim为null
	}
	
	public void setFly(FlyBehavior fly) {
		this.fly = fly;
	}
	
	public void setQuack(QuackBehavior quack) {
		this.quack = quack;
	}
	
	public void setSwim(SwimBehavior swim) {
		this.swim = swim;
	}
	
}
