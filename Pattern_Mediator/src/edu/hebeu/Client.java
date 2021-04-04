package edu.hebeu;

import edu.hebeu.colleague.Alarm;
import edu.hebeu.colleague.CoffeeMachine;
import edu.hebeu.colleague.Curtains;
import edu.hebeu.colleague.TV;
import edu.hebeu.mediator.ConcreteMediator;
import edu.hebeu.mediator.Mediator;

public class Client {
	public static void main(String[] args) {
		
		// 创建中介者对象
		Mediator mediator = new ConcreteMediator();
		
		// 创建同事类对象，注意：在创建后会将对象加入到中介者对象中
		Alarm alarm = new Alarm(mediator, "al");
		CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffee");
		Curtains curtains = new Curtains(mediator, "cu");
		TV tv = new TV(mediator, "tv");
		
		alarm.sendAlarm(0); // 闹钟对象发出消息
		System.out.println("---------------------------------------------------------");
		coffeeMachine.stopCoffee();
		System.out.println("---------------------------------------------------------");
		alarm.sendAlarm(1);
	}
}
