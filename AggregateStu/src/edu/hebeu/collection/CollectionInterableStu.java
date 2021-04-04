package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Collectio类型集合迭代器的学习，
 * 注意：本例下讲解的迭代方式/遍历方式，对所有的Collection来说是通用的一种方式
 * 	但是，对Map集合不能使用，仅能在Collection以及其子类中使用
 * 
 * 注意：在Java中，集合结构发生改变(集合内的元素增删)后，此集合的迭代器必须重新获取，
 * 	如果不重新获取迭代器，就会出现异常(java.util.ConcurrentModificationException)；
 * 
 * 总结：
 * 1、在迭代集合元素的过程中，不能调用集合对象的remove()方法删除元素，因为调用这个方法会改变集合的结构，
 * 通过上述注意点会出现java.util.ConcurrentModificationException异常；
 * 2、如果一定要在迭代过程中删除元素，可以调用迭代器对象的remove()方法，此方法会将迭代器当前指向的元素删除；
 * 不要使用集合自带的remove()方法删除元素！！！
 * @author 13651
 *
 */
public class CollectionInterableStu {
	public static void main(String[] args) {
		// 创建集合对象ArrayList，有序可重复；
		Collection arrayC = new ArrayList();
		
		// 添加元素至集合
		arrayC.add(123);
		arrayC.add(123);
		arrayC.add(123);
		arrayC.add("你好");
		arrayC.add(2.56);
		arrayC.add("???");
		arrayC.add("???");
		arrayC.add(true);
		arrayC.add(true);
		arrayC.add(true);
		arrayC.add(true);
		
		// 对集合进行遍历
		// 第一步：获取集合对象的迭代器对象arrayIterator
		Iterator arrayIterator = arrayC.iterator();
		// 第二步：通过上面的迭代器结合迭代器工作原理进行遍历/迭代集合
		System.out.print("ArrayList{");
		while(arrayIterator.hasNext()) { // 判断当前元素的下面是否还有元素(判断还能否迭代)
			Object obj = arrayIterator.next(); // 将迭代器指向下一个元素，并将当前指向的元素返回出去(进行迭代)
			System.out.print(obj);
//			arrayC.remove(obj); // 迭代过程中使用集合内的方法删除元素，改变集合结构时会出现java.util.ConcurrentModificationException异常
			
			arrayIterator.remove(); // 使用迭代器内部的remove()方法，会将迭代器当前指向的元素删除(底层会将迭代器的参照快照内的元素和集合内的元素都删除，以保证不会出现上述的异常)
			if(arrayIterator.hasNext()) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
		System.out.println("ArrayList内的元素：" + arrayC.size());
		
		
		
		// 创建集合对象HashSet，无序不可重复
		Collection hashC = new HashSet();
		hashC.add(100);
		hashC.add(200);
		hashC.add("HashSet");
		hashC.add(100);
		hashC.add(100);
		hashC.add(560);
		hashC.add(2.589);
		
		// 对集合进行遍历
		// 第一步：获取集合对象的迭代器对象hashIterator
		Iterator hashIterator = hashC.iterator();
		// 第二步：通过上面的迭代器结合迭代器工作原理进行遍历/迭代集合
		System.out.print("HashSet{");
		while(hashIterator.hasNext()) { // 判断当前元素的下面是否还有元素(判断还能否迭代)
			Object obj = hashIterator.next(); // 将迭代器指向下一个元素，并将当前指向的元素返回出去(进行迭代)
			System.out.print(obj);
			if(hashIterator.hasNext()) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}
