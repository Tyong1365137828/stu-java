package edu.hebeu.game;

public class Client {
	public static void main(String[] args) {
		
		GameRole gameRole = new GameRole();
		
		System.out.println("--------------------���״̬------------------------------");
		// ���״̬
		gameRole.setVit(100);
		gameRole.setDef(66);
		gameRole.display();
		
		// ���浱ǰ��״̬
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(gameRole.createMemento()); // �����״̬��Memento���󱣴浽Caretaker������
		
		System.out.println("����ս����");
		// ս��֮��
		gameRole.setVit(91);
		gameRole.setDef(50);
		gameRole.display();
		
		System.out.println("---------------------�ָ�֮��-----------------------------");
		// �ָ�����
		gameRole.recover(caretaker.getMemento());
		gameRole.display();
		
	}
}
