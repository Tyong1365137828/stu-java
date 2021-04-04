package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class TV extends Colleague{

	public TV(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this);
	}
	
	public void startTV() {
		System.out.println("���ӻ��Ѿ���...");
	}
	
	public void stopTV() {
		System.out.println("���ӻ��ѹرգ�");
	}
	
	public void sendTV(int stateChange) {
		sendMessage(stateChange);
	}

	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // �����н��ߵ�getMessage()����
	}

}
