package edu.hebeu.mediator;

import edu.hebeu.colleague.Colleague;

/**
 * ������н�����
 * @author 13651
 *
 */
public abstract class Mediator {
	
	/**
	 * �÷��������������ͬͬ������ӵ�HashMap������
	 * @param colleagueName
	 * @param mediator
	 */
	public abstract void register(String colleagueName, Colleague colleague);
	
	/**
	 * ������Ϣ������Ϣһ�����о����ͬʱ����󷢳�
	 * @param stateChange
	 * @param colleagueName
	 */
	public abstract void getMessage(int stateChange, String colleagueName);
	
	/**
	 * ������Ϣ
	 */
	public abstract void sendMessage();
	
}
