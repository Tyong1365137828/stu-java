package edu.hebeu.demo1.originator;

import edu.hebeu.demo1.Memento;

/**
 * ��������Ҫ�����ݵ���
 * @author 13651
 *
 */
public class Originator2 {
	// ��Ϣ
	private String stateStr;
	private Integer stateInt;
	
	/**
	 * ����������һ��Memento����(����)
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(stateStr, stateInt);
	}
	
	/**
	 * ͨ��Memento����ָ���ǰ����Ϣ
	 */
	public void recover(Memento memento) {
		stateStr = memento.getStateStr();
		stateInt = memento.getStateInt();
	}
	
	public String getStateStr() {
		return stateStr;
	}
	
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
	public Integer getStateInt() {
		return stateInt;
	}
	
	public void setStateInt(Integer stateInt) {
		this.stateInt = stateInt;
	}
}
