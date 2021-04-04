package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 学习Collection接口中的常用方法
 * 1、Collection中能存储什么元素？
 * 	没使用泛型之前，能存入Object的所有子类型，
 * 	使用泛型后，Collection只能存储某个具体的类型，
 * 	集合当中不能直接存储基本数据类型，也不能村4存Java对象，只能存Java对象的内存地址；
 * 
 * 2、Collection中的常用方法：
 * 	boolean add(Object object); // 向集合中添加元素,添加至集合的最后一位
 * 	int size(); // 获取集合中元素的个数
 * 	void clear(); // 清空集合
 * 	boolean contains(Object object); // 判断当前集合中是否包含此元素，包含 ? true : false
 * 	boolean remove(Object object); // 删除集合中的对应元素 删除成功 ? true : false
 * 	boolean isEmpty(); // 判断集合是否为空(集合中是否存在元素) 为空 ? true : false
 * 	Object[] toArray(); // 将集合转换数组
 * 	void addAll(Collection<? extends E> c); // 将将collection内的所有元素都添加到此collection中
 * @author 13651
 *
 */
public class ColllectionOftenUseMethodsStu {
	
	public static void main(String[] args) {
		Collection c = new ArrayList(); // 因为Collection是接口，所以使用多态的方式创建对象，测试Collection内的方法
		
		c.add(12); // 注意此时存入集合的并非12，而是先将12自动装箱为Integer类型的对象，存入集合的是此对象的内存地址
		c.add(1.23); // 同上
		c.add(true); // 同上
		c.add("你好"); // 同上
		c.add('b'); // 同上
		
		c.add(new Object()); // 注意，此时存入的并非此Object对象，而是此Object对象的内存地址
		c.add(new Student()); // 此时存入的也并非此Student对象，而是此Student对象的内存地址
		
		System.out.println("集合中的元素个数：" + c.size()); // 计算集合元素的个数
		
		c.clear(); // 清空集合
		System.out.println("集合中的元素个数：" + c.size());
		
		c.add(23);
		c.add("你好集合");
		System.out.println("集合中的元素个数：" + c.size());
		
		System.out.println(c.contains("你好集合")); // 判断集合中是否包含值为"你好集合"的String 类型 的引用的元素
		System.out.println(c.contains("你好")); // 判断集合中是否包含值为"你好"的String 类型 的引用的元素
		
		System.out.println(c.contains(23)); // 判断集合中是否包含值为 23 的Integer 类型 的引用的元素
		c.remove(23); // 删除集合中的值为 23 的Integer类型的引用的元素的元素
		System.out.println(c.contains(23)); // 判断集合中是否包含值为 23 的Integer 类型 的引用的元素
		
		System.out.println("集合是否为空？" + c.isEmpty());
		c.clear(); // 清空集合
		System.out.println("集合是否为空？" + c.isEmpty());
		
		c.add(122);
		c.add("ToArray");
		c.add(2.56);
		c.add(25);
		c.add(new Student());
		Object[] objs = c.toArray(); // 将集合转变为数组
		System.out.print("[");
		for(int i = 0; i < objs.length; i++) {
			Object obj = objs[i];
			System.out.print(obj);
			if(i < objs.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
	}
}

class Student {
	
}
