package edu.hebeu.original.house;

public abstract class House {
	
	public abstract void piling(); // ����������������д�׮��
	
	public abstract void buildWall(); // �������������ǽ
	
	public abstract void capping(); // ������������ⶥ
	
	public void build() { // ��������������췿��
		piling();
		buildWall();
		capping();
		System.out.println("������ϣ�");
	}
	
}
