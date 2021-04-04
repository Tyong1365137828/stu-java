package edu.hebeu.strategy.user;

import edu.hebeu.strategy.strategys.flybehavior.FlyBehavior;
import edu.hebeu.strategy.strategys.quackbehavior.QuackBehavior;
import edu.hebeu.strategy.strategys.swimbehavior.SwimBehavior;

/**
 * ���е�Ѽ�ӵĳ������
 * @author 13651
 *
 */
public abstract class Duck {
	
	// �ۺ����еĲ���
	protected FlyBehavior fly;
	protected QuackBehavior quack;
	protected SwimBehavior swim;
	
	/**
	 * չʾѼ�ӵ�������Ϣ
	 */
	public abstract void display();
	
	/**
	 * �ɵķ���
	 */
	public final void fly() {
		if(fly != null) { // ���fly��Ϊnull���͵���fly��fly()����
			fly.fly();
			return;
		}
		System.out.println("Ѽ�ӻ��"); // ����ִ�е��ˣ�˵��flyΪnull
	}
	
	/**
	 * �еķ���
	 */
	public final void quack() {
		if(quack != null) { // ���quack��Ϊnull���͵���quack��quack()����
			quack.quack();
			return;
		}
		System.out.println("Ѽ�ӻ��"); // ����ִ�е��ˣ�˵��quackΪnull
	}
	
	/**
	 * ��Ӿ�ķ���
	 */
	public final void swim() {
		if(swim != null) { // ���swim��Ϊnull���͵���swim��swim()����
			swim.swim();
			return;
		}
		System.out.println("Ѽ�ӻ���Ӿ"); // ����ִ�е��ˣ�˵��swimΪnull
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
