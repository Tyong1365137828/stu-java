package edu.hebeu.mediator;

import edu.hebeu.colleague.Colleague;

/**
 * 抽象的中介者类
 * @author 13651
 *
 */
public abstract class Mediator {
	
	/**
	 * 该方法用来将具体的同同事类添加到HashMap集合中
	 * @param colleagueName
	 * @param mediator
	 */
	public abstract void register(String colleagueName, Colleague colleague);
	
	/**
	 * 接收消息，该消息一般是有具体的同时类对象发出
	 * @param stateChange
	 * @param colleagueName
	 */
	public abstract void getMessage(int stateChange, String colleagueName);
	
	/**
	 * 发送消息
	 */
	public abstract void sendMessage();
	
}
