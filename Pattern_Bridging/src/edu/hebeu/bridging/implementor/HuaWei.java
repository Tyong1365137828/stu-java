package edu.hebeu.bridging.implementor;

public class HuaWei implements PhoneBrand{
	
	public void open() {
		System.out.println("��Ϊ�ֻ���");
	}
	
	public void close() {
		System.out.println("��Ϊ�ֻ��ر�");
	}
	
	public void call() {
		System.out.println("��Ϊ�ֻ���绰");
	}
	
	public void internet() {
		System.out.println("��Ϊ�ֻ�����");
	}
}
