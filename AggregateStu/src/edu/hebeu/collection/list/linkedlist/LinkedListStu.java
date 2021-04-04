package edu.hebeu.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList集合学习
 * 
 * LinkedList集合的优点：
 * 	由于链表中的元素空间存储上内存地址不连续，所有随机增删元素时不会涉及到大量的元素位移，因此增删效率高；
 * 在以后的开发中，如果集合随机增删操作较多，建议使用LinkedList集合；
 * LinkedLit集合的缺点：
 * 	不能通过数学表达式计算被查找元素的内存地址，每一次查找都是从头结点开始遍历，直到找到为止，所以LinkedList集合检索效率较低；
 * 
 * 注意LinkedList集合的底层虽然是双向链表，但是其也是有下标的，
 * ArrayList集合的检索效率高不是单纯的因为其有下标，而是因为其底层是数组
 * LinkedList集合虽然同样有下标，但是检索/查找某个元素的效率确比较低，因为底层是链表，只能从头结点一个一个开始遍历；
 * 
 * LinkedList集合没有初始化容量一说，最初这个链表的first和last都是null；
 * 
 * @author 13651
 *
 */
public class LinkedListStu {
	public static void main(String[] args) {
		List l = new LinkedList();
		
		l.add(123);
		l.add('a');
		l.add("abcdef");
		l.add(231);
		l.add(123);
		
		for(int i = 0; i < l.size(); i++) {
			if(i == 0) System.out.print("LinkedList集合：[");
			System.out.print(l.get(i));
			if(i < l.size() - 1) System.out.print(", ");
			else System.out.println("]");
		}
	}
}
