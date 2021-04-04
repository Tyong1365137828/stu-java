package edu.hebeu.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * ArrayList集合：
 * 	1、默认初始长度为10；(注意：JDK8~13中底层先创建长度为0的空数组，当添加第一个元素时，长度变为10！！！)
 * 	2、底层是一个Object类型的数组；
 * 	3、构造方法：
 * 		new ArrayList();
 * 		new ArrayList(20);
 * 		new ArrayList(Collection<? extends E> c); // 将指定Collection类型集合通过构造方法转换为ArryList集合
 * 	4、ArratList集合的扩容:
 * 		ArrayList集合的扩容是扩容到原容量的1.5倍(增长到1.5倍)；
 * 		ArrayList底层是数组，如何优化？
 * 			尽可能少的扩容，因为数组扩容效率低，建议在使用ArrayList集合时给定一个预估计的初始容量，减少数组的扩容次数；
 * 	5、ArrayList集合是非线程安全的
 * 
 * 数组优点：
 * 		检索效率比较高；(高的原因：每个元素占用的空间大小相同，内存地址是连续的，知道首元素的内存地址，然后知道下标，
 * 	  通过数学表达式计算元素的内存地址，所有检索效率最高)；
 * 数组缺点：
 * 		随机增删元素效率较低；
 * 		另外数组无法存储大数据量，因为在内存中很难找到一块非常大的连续的内存地址空间；
 * 	注意：
 * 		向数组末尾增加元素效率很高，不受影响；
 * 
 * 面试：这么多集合，那个集合的应用最多？
 * 	答：ArrarList集合，因为集合最常用的就是添加和检索元素，ArrayList集合添加元素是往数组末尾添加元素，效率不受影响，
 * 	并且ArrayList集合的数据结构是数组，数组具有检索效率高的优点；
 * @author 13651
 *
 */
public class ArrayListStu {
	public static void main(String[] args) {
		List l1 = new ArrayList(); // 默认初始化容量是10
		List l2 = new ArrayList(100); // 指定初始化容量是100
		
		Collection c = new HashSet();
		c.add("hash");
		c.add(123);
		c.add(2256);
		List l3 = new ArrayList(c); // 通过此构造方法可以将HashSet集合转换为ArrayList集合
		
		System.out.println("l1的长度：" + l1.size() + "; l2的长度" + l2.size()); // 发现都是0，所以size()方法是获取当前集合中元素的个数而非集合的容量
		
		for(int i = 0; i < l3.size(); i++) {
			if(i == 0) System.out.print("HashSet变成ArraYList[");
			System.out.print(l3.get(i));
			if(i < l3.size() - 1) System.out.print(", ");
			else System.out.println("]");
		}
	}
}
