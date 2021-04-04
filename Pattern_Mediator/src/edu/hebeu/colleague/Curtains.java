package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class Curtains extends Colleague{

	public Curtains(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this);
	}
	
	public void upCurtains() {
		System.out.println("��������");
	}

	public void sendCurtains(int stateChange) {
		sendMessage(stateChange);
	}
	
	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // �����н��ߵ�getMessage()����
	}

}
