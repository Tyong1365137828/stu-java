package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class CoffeeMachine extends Colleague{

	public CoffeeMachine(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this);
	}
	
	public void startCoffee() {
		System.out.println("���Ȼ���ʼ����......");
	}
	
	public void stopCoffee() {
		System.out.println("���Ȼ�ֹͣ������");
	}
	
	public void sendCoffeeMachine(int stateChange) {
		sendMessage(stateChange);
	}

	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // �����н��ߵ�getMessage()����
	}

}
