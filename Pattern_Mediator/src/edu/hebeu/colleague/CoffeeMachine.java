package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class CoffeeMachine extends Colleague{

	public CoffeeMachine(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this);
	}
	
	public void startCoffee() {
		System.out.println("咖啡机开始工作......");
	}
	
	public void stopCoffee() {
		System.out.println("咖啡机停止工作！");
	}
	
	public void sendCoffeeMachine(int stateChange) {
		sendMessage(stateChange);
	}

	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // 调用中介者的getMessage()方法
	}

}
