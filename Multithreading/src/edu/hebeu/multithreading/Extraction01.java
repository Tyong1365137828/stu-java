package edu.hebeu.multithreading;

/**
 * ����һ�³��򣬳����������߳�֮�⣬�м����̣߳�
 * 		1��(��Ϊ�˳���ֻ��1��ջ<mainջ>)
 * @author 13651
 *
 */
public class Extraction01 {

	public static void main(String[] args) {
		System.out.println("main begin");
		m1();
		System.out.println("main end");
	}

	private static void m1() {
		System.out.println("m1 begin");
		m2();
		System.out.println("m2 end");
	}

	private static void m2() {
		System.out.println("m2 begin");
		m3();
		System.out.println("m2 end");
	}

	private static void m3() {
		System.out.println("m3 arrive");
	}

}
