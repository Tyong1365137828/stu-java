package edu.hebeu.interfacefactory.pizza;

public abstract class Pizza {
	
	private String name; // �������������������������
	
	public abstract void prepare(); // �÷����ǰ�������������׼����������ԭ����
	
	public void bake() {
		System.out.println(name + "���濾��");
	}
	
	public void cut() {
		System.out.println(name + "���з���");
	}
	
	public void box() {
		System.out.println(name + "�����...��������ɣ�");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
