package edu.hebeu.sources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JDK5.0新特性for循环增强写法foreach
 * 
 * 本例用for循环增强写法来遍历数组和集合
 * 
 * 但是，这种循环有一个缺点：
 *		没有下标，因此在需要下标的循环时，不建议使用这种forEach循环
 * @author 13651
 *
 */
public class ForEachStu {
	public static void main(String[] args) {
		// 动态创建数组
		int[] array = new int[5];
		// 向数组添加元素
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		/**普通for循环*/
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("=======================================================");
		
		/**增强for循环(foreach)，element是数组内的元素*/
		for(int element : array) {
			System.out.println(element);
		}
		System.out.println("=======================================================");
		
		
		// 创建集合对象
		List<String> l = new ArrayList<>();
		// 向集合添加元素
		l.add("45");
		l.add("你好");
		l.add("???");
		l.add("8888");
		
		/**使用迭代器遍历集合*/
		Iterator<String> i = l.iterator(); // 创建l集合的迭代器对象(内存储集合的快照)
		while(i.hasNext()) {
			String s = i.next();
			System.out.println(s);
		}
		System.out.println("=======================================================");
		
		/**这种集合是有下标的，使用for循环的方式通过下标遍历集合*/
		for(int j = 0; j < l.size(); j++) {
			System.out.println(l.get(j));
		}
		System.out.println("=======================================================");
		
		/**使用for循环增强写法(foreach)*/
		for(String element : l) {
			System.out.println(element);
		}
		System.out.println("=======================================================");
		
	}
}
