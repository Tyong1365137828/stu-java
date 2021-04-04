package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class TV extends Colleague{

	public TV(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this);
	}
	
	public void startTV() {
		System.out.println("电视机已经打开...");
	}
	
	public void stopTV() {
		System.out.println("电视机已关闭！");
	}
	
	public void sendTV(int stateChange) {
		sendMessage(stateChange);
	}

	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // 调用中介者的getMessage()方法
	}

}
