package edu.hebeu.game;

public class Client {
	public static void main(String[] args) {
		
		GameRole gameRole = new GameRole();
		
		System.out.println("--------------------最初状态------------------------------");
		// 最初状态
		gameRole.setVit(100);
		gameRole.setDef(66);
		gameRole.display();
		
		// 保存当前的状态
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(gameRole.createMemento()); // 将存放状态的Memento对象保存到Caretaker对象中
		
		System.out.println("遭遇战斗！");
		// 战斗之后
		gameRole.setVit(91);
		gameRole.setDef(50);
		gameRole.display();
		
		System.out.println("---------------------恢复之后-----------------------------");
		// 恢复备份
		gameRole.recover(caretaker.getMemento());
		gameRole.display();
		
	}
}
