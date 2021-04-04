package edu.hebeu.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 此例展示List集合特有的常用的方法;
 * 
 * List集合存储元素的特点，有序可重复，
 * 	有下标：List集合中的元素有下标；从0开始，以1递增；
 * 	可重复：存储一个1还可再存储1；
 * 
 * List集合是Collection接口的子接口，List集合的特有常用方法：
 * 	void add(int index, Object obj); // 向特定的索引处添加元素
 * 	Object get(int index); // 通过索引获取集合中指定的元素
 * 	int indexOf(Object obj); // 通过元素获取其在集合中第一次出现的下标，没有返回-1
 * 	int lastIndexOf(Object obj); // 通过元素获取其在集合中最后一次出现的下标，没有返回-1
 * 	Object remove(inde index); // 移除集合中指定位置的元素
 * 	Object set(int index ,Object obj); // 通过指定的元素替换集合中指定位置的元素
 * @author 13651
 *
 */
public class ListSpecialANDOftenUserMethods {
	
	public static void main(String[] args) {
		List l = new ArrayList();
//		List l2 = new Vector();
//		List l3 = new LinkedList();
		
		l.add(0); // 默认在集合的最后一位添加
		l.add("a"); // 默认在集合的最后一位添加
		l.add(12); // 默认在集合的最后一位添加
		l.add(3.1415926); // 默认在集合的最后一位添加
		l.add(1); // 默认在集合的最后一位添加
		l.add(1); // 默认在集合的最后一位添加
		
		/**List集合的特有方法，向集合中的指定位置添加元素，效率较低，使用不多*/
		l.add(2, "king"); // 在索引 为2的位置(集合中的第3个元素处)添加 "king" String类型的引用
		
		Iterator arrayL = l.iterator(); // 创建迭代器
		System.out.print("List集合通过迭代器遍历：[");
		while(arrayL.hasNext()) { // 通过迭代器遍历集合，取出集合内的元素
			Object obj = arrayL.next();
			System.out.print(obj);
			
			if(arrayL.hasNext()) System.out.print(", ");
			else System.out.println("]");
		}
		for(Iterator i = l.iterator(); i.hasNext();) {
			System.out.print(i.next() + ", ");
		}// 将while改成for循环方式
		System.out.println();
		
		int index = 3; // 下标
		/**List集合的特有方法，通过下标获取集合内的元素*/
		Object obj = l.get(index); // 获取集合中下标为3的元素，即第4个元素
		System.out.println("集合的下标为" + index + "的元素是: " + obj);
		
		/**通过List集合特殊的方法进行的遍历(通过下标遍历)*/
		for(int i = 0; i < l.size(); i++) {
			if(i == 0) System.out.print("List集合通过下标遍历：[");
			System.out.print(l.get(i));
			if(i < l.size() - 1) System.out.print(", ");
			else System.out.println("]");
		}
		
		/**List集合的特有方法，获取指定对象元素第一次出现在集合的索引*/
		int firstShowIndex = l.indexOf(12); // 获取Integer类型 12 第一次出现在集合的索引
		/**List集合的特有方法，获取指定对象元素最后一次出现在集合的索引*/
		int lastShowIndex = l.lastIndexOf(1); // 获取Integer类型 1 最后一次出现在集合的索引
		System.out.println("firstShowIndex=" + firstShowIndex + "; lastShowIndex=" + lastShowIndex);
		
		System.out.print("删除之前，集合长度：" + l.size() + "; ");
		/**List集合的特有方法，删除集合中指定下标的元素*/
		l.remove(2); // 删除集合中下标为2的元素，即第3个元素
		System.out.println("删除之后，集合长度：" + l.size());
		
		System.out.print("删除之前，索引为0的元素是：" + l.get(0) + "; ");
		/**将集合中指定下标的元素更改*/
		l.set(0, "king吗?"); // 修改集合中下标为0的元素为String类型的 "king吗?"
		System.out.println("删除之后，索引为0的元素是：" + l.get(0));
	}
	
}
