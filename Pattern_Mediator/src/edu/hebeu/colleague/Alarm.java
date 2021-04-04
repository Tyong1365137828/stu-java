package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

public class Alarm extends Colleague {

	/**
	 * Alarm�Ĺ��������ڴ�������ʱ���Ὣ�����Ķ�����뵽�н�����
	 * @param mediator
	 * @param name
	 */
	public Alarm(Mediator mediator, String name) {
		super(mediator, name);
		mediator.register(name, this); // ����ǰ������ӵ��н�����
	}
	
	public void sendAlarm(int stateChange) {
		sendMessage(stateChange);
	}

	@Override
	protected void sendMessage(int stateChange) {
		this.getMediator().getMessage(stateChange, this.name); // �����н��ߵ�getMessage()����
	}

}
