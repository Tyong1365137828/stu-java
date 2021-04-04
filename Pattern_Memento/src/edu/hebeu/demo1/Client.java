package edu.hebeu.demo1;

import edu.hebeu.demo1.originator.Originator1;

public class Client {
	public static void main(String[] args) {

		System.out.println("----------------------最初信息--------------------------");
		Originator1 originator1 = new Originator1();
		originator1.setStateInt(50);
		originator1.setStateStr("一点信息");
		System.out.println(originator1);
		
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(originator1.createMemento()); // 将当前的状态(成员变量)封装成一个Memento对象并加入到Caretaker中
		
		System.out.println("----------------------变更信息--------------------------");
		// 变更信息
		originator1.setStateInt(66);
		originator1.setStateStr("变更信息");
		System.out.println(originator1);
		
		System.out.println("-----------------------恢复之后---------------------------");
		originator1.recover(caretaker.getMemento(0)); // 通过索引为0的Memento对象恢复
		System.out.println(originator1);
		
		System.out.println("-------------------------------------------------------------------------");
		
		
		Originator1 originator2 = new Originator1();
		originator2.setStateInt(100);originator2.setStateStr("信息...");
		caretaker.addMemento(originator2.createMemento());
		
		originator2.setStateInt(100);originator2.setStateStr("信息258...");
		caretaker.addMemento(originator2.createMemento());
		
		// 显示所有的Memento对象
		caretaker.display();
		
	}
}
