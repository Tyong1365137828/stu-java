package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class Alarm extends Colleague {

	/**
	 * Alarm的构造器，在创建对象时，会将创建的对象加入到中介者中
	 * @param mediator
	 * @param name
	 */
	public Alarm(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this); // 将当前对象添加到中介者中
	}
	
	public void sendAlarm(int stateChange) {
		sendMessage(stateChange);
	}

	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // 调用中介者的getMessage()方法
	}

}
