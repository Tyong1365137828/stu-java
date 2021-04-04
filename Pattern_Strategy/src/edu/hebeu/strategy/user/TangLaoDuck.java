package edu.hebeu.strategy.user;

import edu.hebeu.strategy.strategys.flybehavior.NotFlyBehavior;
import edu.hebeu.strategy.strategys.quackbehavior.GaGaQuackBehavior;
import edu.hebeu.strategy.strategys.swimbehavior.NotSwimBehavior;

public class TangLaoDuck extends Duck{

	public TangLaoDuck() {
		fly = new NotFlyBehavior();
		quack = new GaGaQuackBehavior();
		swim = new NotSwimBehavior();
	}
	
	@Override
	public void display() {
		System.out.println("------------------’‚ «Ã∆¿œ—º-----------------");
		fly();
		quack();
		swim();
		System.out.println("---------------------------------------------");
	}

}
