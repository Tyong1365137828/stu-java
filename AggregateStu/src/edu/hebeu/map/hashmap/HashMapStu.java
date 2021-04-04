package edu.hebeu.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap集合：
 * 	1、HashMap集合底层是哈希表/散列表的数据结构
 * 	2、哈希表是一个怎样的数据结构？
 * 		哈希表是一个数组与单向链表的结合体。
 * 		数组：在查询方面效率高，但是在随机增删方面效率很低；
 * 		单向链表：在随机增删方面效率较高，但是在查询方面效率很低；
 * 		哈希表/散列表将以上两种数据结构融合在一起
 * 
 * 3、HashMap底层的源代码：
 * 	public class HashMap {
 * 		Node<K, V>[] table; // HashMap底层实际上是一个数组(且是一维数组)
 * 
 * 		// 静态的内部类HashMap.Node
 * 		static class Node<K, V> implements Map.Entry<K, V> {
 * 			final int hash; // 哈希值(哈希值是通过key执行hashCode()方法的结果)，哈希值可以通过哈希函数/算法能转化成数组的下标
 * 			final K key; // 存储到Map集合中的key
 * 			V value; // 存储到Map集合中的value
 * 			Node<K, V> next; // 下一个结点的内存地址 * 			
 * 		}
 * 	}
 * 
 * 哈希表/散列表：是一个一维数组，这个数组中的每个元素是一个单向链表;(数组和链表的结合体)
 * 
 * 4、HashMap集合的key的特点：
 * 	无序不可重复；
 * 	无序：因为HashMap底层是哈希表/散列表，其是数组与单向链表的结合体，虽然数组在内存空间内地址空间连续，但是在添加元素时(单向链表的
 * 结点)不能保证被添加到那个单向链表上，因此其是无序的；
 * 	不可重复：通过equals()方法来保证HashMap的key不可重复，如果key重复了，value会被覆盖
 * 
 * 注意：放到HashMap集合key部分的元素实际上是HashSet集合的元素，因此HashSet集合也应该要重写hashCode()和equals()方法
 *
 *
 *	5、HashMap使用不当时无法发挥其性能：
 *		假设所有的hashCode()方法返回值为某个固定的值，那么会导致底层哈希表/散列表变成纯单向链表，这种情况就是散列分布不均匀；
 *		假设所有的haxshCode()返回值都设定为不一样的值，其底层会变成一个一维数组，没有链表的概念，也是散列分布不均匀；
 *
 *	6、什么是散列分布均匀？
 *		假设有100个元素，其最好能划分为10个单向链表，每个单向链表上有10个元素，这种情况是最好的，是散列分布均匀的；
 *
 *	散列分布均匀需要在重写hashCode()方法时有一定的技巧
 *
 *	7、重点：放在HashMap集合的key部分的元素，以及HashSet集合的元素，需要同时重写equals()和hashCode()方法
 *	
 *	8、HashMap集合的默认初始化容量是16，默认加载因子是0.75，
 *		这个默认加载因子是当HashMap集合底层的数组占用容量达到容量的75%时，数组开始扩容；一次扩容之后的容量是原容量的2倍；
 *		HashMap集合初始化容量必须是2的倍数，这也是官方推荐的，这是因为达到散列均匀，为了提高HashMap集合的存取效率所必须的。
 *
 *	9、HashMap在JDK8之后的改进：为了提高检索效率，如果哈希表中的某个单向链表的元素大于8个时(static final int TREEIFY_THRESHOLD = 8)，此单向链表这种数据结构就会变成红黑树(二叉树)数据结构；
 *	  如果红黑树(二叉树)这种数据结构内的元素小于6个(static final int UNTREEIFY_THRESHOLD = 6)，红黑树(二叉树)这种数据结构又会变成单向链表数据结构；
 *	  这种机制是为了提高检索效率，二叉树的检索会再次缩小扫描范围，提高效率；
 *
 *	10、对于哈希表数据结构：
 *		如果两个对象a1和a2的哈希值相同，这两个一定是在同一个链表上的(哈希值会经过哈希算法/哈希函数 转换成数组下标，对应的就是某个链表)；
 *		注意：当a1和a2的哈希值不同，这两个任然有可能在同一个链表上，因为两个不同的哈希值经过哈希算法/哈希函数 有可能会转换为同一个数组下标(这就是 "哈希碰撞");
 *	
 *	11、HashMap集合是非线程安全的；
 * @author 13651
 *
 */
public class HashMapStu {
	public static void main(String[] args) {
		Map<Integer, Character> map = new HashMap<>(); //创建集合对象
		// 添加元素
		map.put(25, 'h');
		map.put(22, 'e');
		map.put(58, 'f');
		map.put(1, 'l');
		map.put(22, 'W'); // key重复，会将上一个key对应的旧value覆盖
		map.put(null, null); /**HashMap集合的运行key为null*/
		map.put(null, 'N'); /**当再次添加key为null的元素(键值对)时，会将上一个key为null的元素(键值对)覆盖*/
		Character c = map.get(null); /**获取key为null的元素的value*/
		System.out.println("key为null的元素的value为：" + c);
		/**
		 * 结论：、
		 * 	HashMap集合的元素的key可以为null且只能有一个key为null的元素(键值对)；
		 * 	HashMap集合的元素的key和value都能为null；
		 */
		
		System.out.println("Map集合的元素个数：" + map.size());
		
		// 遍历Map集合
		Set<Map.Entry<Integer, Character>> mapToSet = map.entrySet(); // 将Map集合全部转换成Set集合，注意泛型
		// 通过for增强写法遍历Map集合
		System.out.print("Map集合(测试key的特性){");
		for(Map.Entry<Integer, Character> node : mapToSet) {
			Integer key = node.getKey(); // 获取key
			Character value = node.getValue(); // 获取value
			System.out.print(key + "=" + value + ", "); // 相当于 System.out.print(node);
		}
		System.out.println("}");
		/**
		 * 此时发现：key无序不重复
		 */
		
	}
}
