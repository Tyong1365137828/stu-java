package edu.hebeu.game;

/**
 * 守护者类，保存和取出备份的对象
 * @author 13651
 *
 */
public class Caretaker {
	
	// 如果只保存一个状态
	private Memento memento;
	// 如果保存一种Memento对象的多个状态
//	private ArrayList<Memento> mementos;
	// 如果保存多种Memento对象的多个状态
//	private HashMap<String, ArrayList<Memento>> mementos;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
	
}
