package edu.hebeu.demo1;

import edu.hebeu.demo1.originator.Originator1;

public class Client {
	public static void main(String[] args) {

		System.out.println("----------------------�����Ϣ--------------------------");
		Originator1 originator1 = new Originator1();
		originator1.setStateInt(50);
		originator1.setStateStr("һ����Ϣ");
		System.out.println(originator1);
		
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(originator1.createMemento()); // ����ǰ��״̬(��Ա����)��װ��һ��Memento���󲢼��뵽Caretaker��
		
		System.out.println("----------------------�����Ϣ--------------------------");
		// �����Ϣ
		originator1.setStateInt(66);
		originator1.setStateStr("�����Ϣ");
		System.out.println(originator1);
		
		System.out.println("-----------------------�ָ�֮��---------------------------");
		originator1.recover(caretaker.getMemento(0)); // ͨ������Ϊ0��Memento����ָ�
		System.out.println(originator1);
		
		System.out.println("-------------------------------------------------------------------------");
		
		
		Originator1 originator2 = new Originator1();
		originator2.setStateInt(100);originator2.setStateStr("��Ϣ...");
		caretaker.addMemento(originator2.createMemento());
		
		originator2.setStateInt(100);originator2.setStateStr("��Ϣ258...");
		caretaker.addMemento(originator2.createMemento());
		
		// ��ʾ���е�Memento����
		caretaker.display();
		
	}
}
