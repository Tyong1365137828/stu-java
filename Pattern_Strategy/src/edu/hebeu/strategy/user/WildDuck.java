package edu.hebeu.strategy.user;

import edu.hebeu.strategy.strategys.flybehavior.GoodFlyBehavior;
import edu.hebeu.strategy.strategys.quackbehavior.GeGeQuackBehavior;
import edu.hebeu.strategy.strategys.swimbehavior.GoodSwimBehavior;

public class WildDuck extends Duck{

	public WildDuck() {
		fly = new GoodFlyBehavior();
		quack = new GeGeQuackBehavior();
		swim = new GoodSwimBehavior();
	}
	
	@Override
	public void display() {
		System.out.println("------------------’‚ «“∞—º-----------------");
		fly();
		quack();
		swim();
		System.out.println("---------------------------------------------");
	}

}
