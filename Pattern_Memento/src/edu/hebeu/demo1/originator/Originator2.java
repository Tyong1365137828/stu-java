package edu.hebeu.demo1.originator;

import edu.hebeu.demo1.Memento;

/**
 * 该类是需要被备份的类
 * @author 13651
 *
 */
public class Originator2 {
	// 信息
	private String stateStr;
	private Integer stateInt;
	
	/**
	 * 创建并返回一个Memento对象(备份)
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(stateStr, stateInt);
	}
	
	/**
	 * 通过Memento对象恢复当前的信息
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
