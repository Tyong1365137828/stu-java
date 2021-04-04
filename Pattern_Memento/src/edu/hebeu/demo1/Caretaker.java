package edu.hebeu.demo1;

import java.util.ArrayList;

/**
 * �����������е�Memento����(����¼����)
 * @author 13651
 *
 */
public class Caretaker {
	
	// ����Ҫ����һ��Memento����Ķ�α���ʱ
	private ArrayList<Memento> mementos;
	// ����Ҫ�������Memento����Ķ�α���ʱ
//	private HashMap<String, ArrayList<Memento>> mementoMap;
	
	public Caretaker() {
		mementos = new ArrayList<>();
	}
	
	/**
	 * ���һ��Memento����(���ݶ���)
	 * @param memento
	 */
	public void addMemento(Memento memento) {
		mementos.add(memento);
	}
	
	/**
	 * ͨ��������ȡһ��Memento����(���ݶ���)
	 * @param index
	 * @return
	 */
	public Memento getMemento(int index) {
		return mementos.get(index);
	}
	
	/**
	 * ��ʾ���еı���
	 */
	public void display() {
		for (Memento memento : mementos) {
			System.out.println(memento);
		}
	}
	
}
