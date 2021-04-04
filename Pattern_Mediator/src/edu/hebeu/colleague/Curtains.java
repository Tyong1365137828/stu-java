package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class Curtains extends Colleague{

	public Curtains(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this);
	}
	
	public void upCurtains() {
		System.out.println("窗帘挂起");
	}

	public void sendCurtains(int stateChange) {
		sendMessage(stateChange);
	}
	
	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // 调用中介者的getMessage()方法
	}

}
