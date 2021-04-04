package edu.hebeu.collection.list.vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * 通过这个例子学习Vector集合
 * 
 * Vector集合特点：
 * 	1、底层是数组；
 * 	2、默认初始化容量为10；
 * 	3、如何扩容：
 * 		扩容之后的容量是原容量的2倍
 * 	5、Vector内所有的方法都是线程同步的，都带有synchronized关键字，是线程安全的，效率比较低，使用较少；
 * 	6、使用方式与ArrayList等其他List数组一致；
 * 
 * 
 * 	7、如何将一个非线程安全的集合ArrayList变成线程安全的？
 * 		使用集合工具类：
 * 			java.util.Collections // 注意：和java.util.Collection不同，Collections是集合工具类
 * 			
 * @author 13651
 *
 */
public class VectorStu {
	public static void main(String[] args) {
		Vector v = new Vector(); // 创建一个Vector集合，默认容量为10
		// 添加元素
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		
		// 此时会进行扩容，扩容之后是原容量的2倍，即10 -> 20 -> 40 -> 80 -> 160 -> ...
		v.add(11);
		
		
		/**
		 * 演示将非线程安全的ArrayList集合对象变成线程安全的
		 */
		List l = new ArrayList(); // 创建ArrayList集合对象，此时是非线程安全的
		// 变成线程安全的
		Collections.synchronizedList(l); // 执行完此方法后集合l就变成线程安全的
		
		l.add(123);
		l.add('b');
		l.add("fg");
		l.add(12);
		l.add(123);
		l.add(1.89);
		
	}
}
