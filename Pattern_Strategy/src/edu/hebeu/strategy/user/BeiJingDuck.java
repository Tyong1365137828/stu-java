package edu.hebeu.strategy.user;

import edu.hebeu.strategy.strategys.flybehavior.NotFlyBehavior;
import edu.hebeu.strategy.strategys.quackbehavior.GaGaQuackBehavior;
import edu.hebeu.strategy.strategys.swimbehavior.GoodSwimBehavior;

public class BeiJingDuck extends Duck{

	public BeiJingDuck() {
		fly = new NotFlyBehavior();
		quack = new GaGaQuackBehavior();
		swim = new GoodSwimBehavior();
	}

	@Override
	public void display() {
		System.out.println("------------------这是北京鸭-----------------");
		fly();
		quack();
		swim();
		System.out.println("---------------------------------------------");
	}
	
}
