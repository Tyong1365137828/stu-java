package edu.hebeu.strategy.user;

import edu.hebeu.strategy.strategys.flybehavior.NotFlyBehavior;
import edu.hebeu.strategy.strategys.quackbehavior.GeGeQuackBehavior;
import edu.hebeu.strategy.strategys.swimbehavior.BadSwimBehavior;

public class ToyDuck extends Duck{

	public ToyDuck() {
		fly = new NotFlyBehavior();
		quack = new GeGeQuackBehavior();
		swim = new BadSwimBehavior();
	}
	
	@Override
	public void display() {
		System.out.println("------------------ÕâÊÇÍæ¾ßÑ¼-----------------");
		fly();
		quack();
		swim();
		System.out.println("---------------------------------------------");
	}
}
