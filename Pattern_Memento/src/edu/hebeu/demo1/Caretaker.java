package edu.hebeu.demo1;

import java.util.ArrayList;

/**
 * 用来保存所有的Memento对象(备忘录对象)
 * @author 13651
 *
 */
public class Caretaker {
	
	// 当需要保存一种Memento对象的多次保存时
	private ArrayList<Memento> mementos;
	// 当需要保存多种Memento对象的多次保存时
//	private HashMap<String, ArrayList<Memento>> mementoMap;
	
	public Caretaker() {
		mementos = new ArrayList<>();
	}
	
	/**
	 * 添加一个Memento对象(备份对象)
	 * @param memento
	 */
	public void addMemento(Memento memento) {
		mementos.add(memento);
	}
	
	/**
	 * 通过索引获取一个Memento对象(备份对象)
	 * @param index
	 * @return
	 */
	public Memento getMemento(int index) {
		return mementos.get(index);
	}
	
	/**
	 * 显示所有的备份
	 */
	public void display() {
		for (Memento memento : mementos) {
			System.out.println(memento);
		}
	}
	
}
