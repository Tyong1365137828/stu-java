package edu.hebeu.colleague;

import edu.hebeu.mediator.Mediator;

/**
 * 抽象的同事类
 * @author 13651
 *
 */
public abstract class Colleague {
	
	private Mediator mediator;
	protected String name;
	
	public Colleague(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}
	
	public Mediator getMediator() {
		return this.mediator;
	}
	
	protected abstract void sendMessage(int stateChange);
	
}
