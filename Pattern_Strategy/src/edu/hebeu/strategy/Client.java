package edu.hebeu.strategy;

import edu.hebeu.strategy.strategys.quackbehavior.NotQuackBehavior;
import edu.hebeu.strategy.user.BeiJingDuck;
import edu.hebeu.strategy.user.TangLaoDuck;
import edu.hebeu.strategy.user.ToyDuck;
import edu.hebeu.strategy.user.WildDuck;

public class Client {
	
	public static void main(String[] args) {
		
		// 测试
		BeiJingDuck beiJingDuck = new BeiJingDuck();
//		beiJingDuck.quack();
		beiJingDuck.display();
		
		TangLaoDuck tangLaoDuck = new TangLaoDuck();
		tangLaoDuck.display();
		// 也可以动态的更改信息
		tangLaoDuck.setQuack(new NotQuackBehavior());
		tangLaoDuck.display();
		
		WildDuck wildDuck = new WildDuck();
		wildDuck.display();
		
		ToyDuck toyDuck = new ToyDuck();
		toyDuck.display();
	}
}
