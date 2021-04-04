package edu.hebeu.collection.set;

import java.util.HashSet;

/**
 * 演示hashSet集合的特点
 * 
 * 特点：无序不可重复
 * 	1、存储的存储时的顺序和取出时的顺序不一样
 * 	2、集合内的元素不可重复
 * 	3、存储到HashSet集合内的元素实际上是存储到HashMap集合的key部分了
 * 
 * 	构造方法：
 * 		new HashSet();
 * 		new HashSet(int initialCapacity); // 创建初始化容量为initialCapacity的集合，加载因子为0.75
 * 		new HashSet(Colllection<? extends E> c); // 将指定的Collection类型集合转换为HashSet集合
 * 
 * 初始化容量、扩容细节等各种扩容机制同HashMap集合
 * @author 13651
 *
 */
public class HashSetStu {
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet(); // 创建HashSet集合
		hashSet.add(74);
		hashSet.add(58);
		hashSet.add(36);
		hashSet.add(28);
		hashSet.add(75);
		hashSet.add(74);
		hashSet.add(74);
		
		for(int i : hashSet) {
			System.out.print(i + ", ");
		}
	}
}
