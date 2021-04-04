package edu.hebeu.map.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 演示User类重写与否hashCode()和equals()方法
 * 	以此来引出Map集合中的key的hashCode()方法和equals()方法
 * 
 * 向Map集合中存，以及从Map集合中取都会先调用key的hashCode()方法，再调用key的equals()方法！
 * 	注意：equals()方法可能不会调用
 * 		以put(k, v)方法举例，什么时候equals()方法不会调用？
 * 			k.hashCode()方法获取哈希值，哈希值经过 哈希算法/函数 转换为数组下标，该下标为null时会直接将此结点添加，不会调用equals()方法；
 * 		以get(k)方法举例，什么时候equals()方法不会调用？
 * 			k.hashCode()方法获取哈希值，哈希值经过 哈希算法/函数 转换为数组下标，该下标为null时会直接返回nulll，不会调用equals()方法；
 * 
 * 
 * 重点：
 * 		如果一个类的equals()方法重写了，那么这个类的hashCode()方法也必须重写，
 *  并且equals()方法返回值如果为true，hashCode()方法返回值必须要一样。(equals()方法返回true，表示两个对象相同，应该去同一个单向链表上比较，
 *  那么就必须要求同于同一个单向链表上的结点来说，其数组下标必须是一样的，而数组下标是通过哈希值经过 哈希函数/哈希算法转换而来的，那么就要求
 *  哈希值一定相同，该类的所有对象的hashCode()方法发返回值要求必须是相同的)
 *  
 *  结论：放在HashMap集合key部分的元素，以及HashSet集合的元素，必须要重写equals()方法和hashCode()方法；
 * 
 * @author 13651
 *
 */
public class UserIsHashCodeANDEqualsOverwriterMethod {
	public static void main(String[] args) {
		User u1 = new User("张三");
		User u2 = new User("张三");
		
		// 重写equals()方法之前返回必定是false
		System.out.println(u1.equals(u2)); // false
		// 重写equals()方法之后返回是true
		System.out.println(u1.equals(u2)); // true
		
		System.out.println("u1的哈希值：" + u1.hashCode()); // 366712642
		System.out.println("u2的哈希值：" + u2.hashCode()); // 1829164700
		
		/**当重写equals()方法后，若将该User的两个对象u1和u2存储到HashMap/HashSet集合中，按理来说应该只能存储一个(HashSet/HashMap集合
	      的特点：无序不可重复，equals()方法重写之后，比较的是username而非Object类中默认的比较内存地址，u1和u2的username都是 "张三" )；
		
		    但是测试后会发现u1和u2都存储进HashMap集合中了，这与HashMap集合的特点相违背，这是因为没有重写hashCode()方法，导致这两个对象的
		    哈希值不同，哈希值值不同导致哈希算法转换为数组下标也不同，存储进数组的不同下标处(u1和u2不在同一个链表)，equals()方法即使重写
		    也办法进行调用(equals()方法是在同一个链表中进行调用，以决定是 添加结点/覆盖结点值)，将要添加的元素直接放入了数组的下标处*/
		Set<User> usersSet = new HashSet<>();
		usersSet.add(u1);
		usersSet.add(u2);
		System.out.println("重写equals()方法之后，但是没有重写hashCode()方法存入两个username相等的对象的HashSet集合长度：" + usersSet.size()); // 2
	}
}
