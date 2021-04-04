package edu.hebeu.demo1;

/**
 * 这个类是进行备份的类
 * @author 13651
 *
 */
public class Memento {
	
	// 需要备份的信息
	private String stateStr;
	private Integer stateInt;
	
	public Memento(String stateStr, Integer stateInt) {
		this.stateStr = stateStr;
		this.stateInt = stateInt;
	}

	public String getStateStr() {
		return stateStr;
	}

	public Integer getStateInt() {
		return stateInt;
	}

	@Override
	public String toString() {
		return "Memento [stateStr=" + stateStr + ", stateInt=" + stateInt + "]";
	}
	
}
