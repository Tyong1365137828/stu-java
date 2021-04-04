package edu.hebeu.demo1;

/**
 * ������ǽ��б��ݵ���
 * @author 13651
 *
 */
public class Memento {
	
	// ��Ҫ���ݵ���Ϣ
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
