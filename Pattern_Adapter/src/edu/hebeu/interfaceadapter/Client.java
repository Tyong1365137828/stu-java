package edu.hebeu.interfaceadapter;

public class Client {
	public static void main(String[] args) {
		
		// 此时将需要使用的具体方法进行具体实现
		AbsUtils absUtils = new AbsUtils() {

			@Override
			public void m2() {
				System.out.println("具体的实现m2()方法...");
			}
			
		};
		
		absUtils.m2();
	}
}
