package edu.hebeu.prototype;

public class Client {
	public static void main(String[] args) {
		Sheep tomSheep = new Sheep("tom", 1, "��ɫ");
		
		// ʹ��ԭ��ģʽʵ�ֿ�¡
		Sheep tomSheep1 = (Sheep) tomSheep.clone();
		Sheep tomSheep2 = (Sheep) tomSheep.clone();
		Sheep tomSheep3 = (Sheep) tomSheep.clone();
		// ...
		
		// ע�⣺�������hashCodeҲ�ǲ�ͬ�ģ������Щ������ͨ����¡�������Ķ���
		System.out.println("tomSheep = " + tomSheep + ";hashCode" + tomSheep.hashCode());
		System.out.println("tomSheep1 = " + tomSheep1 + ";hashCode" + tomSheep1.hashCode());
		System.out.println("tomSheep2 = " + tomSheep2 + ";hashCode" + tomSheep2.hashCode());
		System.out.println("tomSheep3 = " + tomSheep3 + ";hashCode" + tomSheep3.hashCode());
		// ...
		
		
	}
}
