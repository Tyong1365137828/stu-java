package edu.hebeu.multithreading;

/**
 * 分析一下程序，除垃圾回收线程之外，有几个线程？
 * 		1个(因为此程序只有1个栈<main栈>)
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
