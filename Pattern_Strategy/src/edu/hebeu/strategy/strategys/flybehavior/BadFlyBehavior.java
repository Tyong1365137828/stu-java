package edu.hebeu.strategy.strategys.flybehavior;

public class BadFlyBehavior implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("飞的技术很一般");
	}

}
