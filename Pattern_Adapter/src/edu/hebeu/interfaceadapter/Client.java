package edu.hebeu.interfaceadapter;

public class Client {
	public static void main(String[] args) {
		
		// ��ʱ����Ҫʹ�õľ��巽�����о���ʵ��
		AbsUtils absUtils = new AbsUtils() {

			@Override
			public void m2() {
				System.out.println("�����ʵ��m2()����...");
			}
			
		};
		
		absUtils.m2();
	}
}
