package edu.hebeu.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * ���������ѧϰJDK8��������֮һ��Lamda���ʽ
 * 
 * ��֪��
 * 	1������ʽ�ӿڣ�����ӿ���ֻ��������һ�����󷽷����ýӿھͳ�Ϊ����ʽ�ӿڣ����ǿ����ڶ���ĺ���ʽ�ӿ������һ�� @FunctionalInterface ע�⣬
 * ��ʱ����ڱ�д����ӿڳ��ֲ����Ϻ���ʽ�ӿڵ��ص�ʱ(�������˶�����󷽷�)�������������������Ӧ����ʾ��
 * 	2��Lamda���ʽ�ı��ʣ���Ϊ�ӿڵ�ʵ����
 * 
 * ���ӣ�(o1, o2) -> Integer.compare(o1, o2);
 * ���ϵĸ�ʽ��
 * 	->�� Lamda������ �� ��ͷ������
 * 	->��߲��֣�Lamda�β��б�(��ʵ���� ����ʽ�ӿ� �г��󷽷����β��б�)
 *  ->�ұ߲��֣�Lamda������(��ʵ���Ǻ���ʽ�ӿ� ����д�ĳ��󷽷��ķ�����)
 *  
 *  Lamda���ʽ��6�������
 *  	1���޲��޷���ֵ
 *  	2����1���������޷���ֵ
 *  	3���������Ϳ�ʡ�ԣ���Ϊ�����б������Ƴ�����Ϊ�������ƶϡ�
 *  	4��Lamda��ֻ��1��������������С���ſ���ʡ��
 *  	5����2����2�����ϵĲ���������ִ����䣬�ҿ����з���ֵ
 *  	6����Lamda��ֻ��һ����䣬�Ҹ������returnʱ�����Խ� return�ʹ�����ʡ��
 *  	�ܽ᣺
 *  		->��ߣ�Lamda�β��б�Ĳ������Ϳ���ʡ��(�����ƶϻ���)�����Lamda�β��б�ֻ��һ����������һ��()Ҳ����ʡ��
 *  		->�ұߣ�Lamda��Ӧ����һ��{}���������Lamda��ֻ��һ�����ʱ����������ǲ���return��䣬�ɽ�{}ʡ�ԣ������������return��䣬���Խ�{}ʡ�ԣ�����ע�⣺{}ʡ�Ժ�return����return�ؼ��ֱ���ҲҪʡ��
 *			  
 * @author 13651
 *
 */
public class LamdaStu {
	
	/**
	 * Lamda���ʽ�ĵ�һ�����
	 */
	@Test
	public void demo1() {
		/*Runnable runnable = () -> { // ��ʱLamda���൱��Runnable����ʽ�ӿ���� run()��������д
			System.out.println("Demo1ִ����...");
		};*/
		// Ҳ����д��
		Runnable runnable = () -> System.out.println("demo1ִ����...");
		
		runnable.run();
	}
	
	/**
	 * Lamda���ʽ�ĵڶ������
	 */
	@Test
	public void demo2() {
		Consumer<String> consumer = (String s) -> { // ��ʱLamda����൱��Consumer����ʽ�ӿ����accept()��������д
			System.out.println("accept()����ִ����");
			System.out.println("s = " + s);
		};
		
		consumer.accept("demo2����ã�Lamda��");
	}
	
	/**
	 * Lamda���ʽ�ĵ��������
	 */
	@Test
	public void demo3() {
		Consumer<String> consumer = (s) -> { // ��ʱLamda����൱��Consumer����ʽ�ӿ����accept()��������д
			System.out.println("accept()����ִ����");
			System.out.println("s = " + s);
		};
		
		consumer.accept("demo3");
	}
	
	/**
	 * Lamda���ʽ�ĵ��������
	 */
	@Test
	public void demo4() {
		Consumer<String> consumer = s -> { // ��ʱLamda����൱��Consumer����ʽ�ӿ����accept()��������д
			System.out.println("accept()����ִ����");
			System.out.println("s = " + s);
		};
		
		consumer.accept("demo4");
	}
	
	/**
	 * Lamda���ʽ�ĵ��������
	 */
	@Test
	public void demo5() {
		Comparator<Integer> comparator = (o1, o2) -> {
			System.out.println("demo5��compare����ִ����");
			System.out.println("o1 = " + o1);
			System.out.println("o2 = " + o2);
			return o1 * o2;
		};
		
		Integer comparatorValue = comparator.compare(10,  85);
		System.out.println(comparatorValue);
	}
	
	/**
	 * Lamda���ʽ�ĵ��������
	 */
	@Test
	public void demo6() {
		Comparator<Integer> comparator = (o1, o2) -> o1 * o2;
		
		Integer comparatorValue = comparator.compare(10,  85);
		System.out.println("demo6��compare()����ִ���ˣ�comparatorValue = " + comparatorValue);
	}

}
