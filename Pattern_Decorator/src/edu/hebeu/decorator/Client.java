package edu.hebeu.decorator;

import edu.hebeu.decorator.component.Decaf;
import edu.hebeu.decorator.component.DrinkComponent;
import edu.hebeu.decorator.component.Espresso;
import edu.hebeu.decorator.component.LongBlack;
import edu.hebeu.decorator.component.ShortBlack;
import edu.hebeu.decorator.decorator.Chocolate;
import edu.hebeu.decorator.decorator.Milk;
import edu.hebeu.decorator.decorator.Soy;

public class Client {
	
	public static void main(String[] args) {
		
		// 点一份意大利咖啡
		DrinkComponent drink = new Espresso();
//		System.out.println("费用：" + drink.coast());
//		System.out.println("描述：" + drink.getDesc());
		
		// 加一份牛奶
		drink = new Milk(drink);
//		System.out.println("费用：" + drink.coast());
//		System.out.println("描述，加入：" + drink.getDesc());
		
		// 加一份巧克力
		drink = new Chocolate(drink);
//		System.out.println("费用：" + drink.coast());
//		System.out.println("描述，加入：" + drink.getDesc());
		
		// 再加一份牛奶
		drink = new Milk(drink);
//		System.out.println("费用：" + drink.coast());
//		System.out.println("描述，加入：" + drink.getDesc());
		
		// 再加入一份豆浆
		drink = new Soy(drink);
		System.out.println("费用：" + drink.coast());
		System.out.println("描述，加入：" + drink.getDesc());	
		
		
		System.out.println("--------------------------------------------");
		
		DrinkComponent drink2 = new LongBlack(); // 点一份美式咖啡
		Float coffeePrice = drink2.getPrice(); // 获取纯咖啡的单价并进行保存
		drink2 = new Milk(drink2); // 加一份牛奶
		drink2 = new Chocolate(drink2); // 加一份巧克力
		drink2 = new Milk(drink2); // 加一份牛奶
		System.out.println("费用：" + drink2.coast());
		System.out.println("描述，加入：" + drink2.getDesc() + " " + coffeePrice);
		
		System.out.println("--------------------------------------------");
		
		DrinkComponent drink3 = new ShortBlack(); // 点一份ShortBlack咖啡
		drink3 = new Soy(drink3); // 加一份豆浆
		drink3 = new Chocolate(drink3); // 加一份巧克力
		System.out.println("费用：" + drink3.coast());
		System.out.println("描述，加入：" + drink3.getDesc());
		
		System.out.println("--------------------------------------------");
		
		DrinkComponent drink4 = new Decaf(); // 点一份无因咖啡
		System.out.println("费用：" + drink4.coast());
		System.out.println("描述：" + drink4.getDesc());
		
	}
}
