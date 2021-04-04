package edu.hebeu.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 通过这个例子里展示map集合的常用方法
 * 
 * 注意：
 * 	Map集合与Collection集合没有继承关系；
 * 	Map集合以key和value对存储数据，即键值对
 * 		key和value都是引用数据类型
 * 		key和value都是存储对象的内存地址
 * 		key起到主导作用，value是key的附庸品
 * 
 * 常用方法：
 * 	V put(K key, V value); // 往Map集合中添加元素
 * 	V get(Object key); // 通过key获取value，如果获取不到返回null
 * 	void clear(); // 清空Map集合
 * 	boolean containsKey(Object key); // 判断Map集合中是否存在某个key
 * 	boolean containsValue(Object value); // 判断Map集合中是否存在某个value
 * 	boolean equals(Object o); // 比较指定对象与此映射是否相等
 * 	boolean isEmpty(); // 判断Map集合是否为空(元素个数是否为0)	空 ? true : false
 * 	Set<K> keySet(); // 获取Map集合所有的key
 * 	V reomve(Object key); // 通过key删除集合中的元素(删除键值对)
 * 	int size(); // 获取集合的键值对关系数(集合的元素个数)
 * 	Collection<V> values(); // 获取Map集合所有的value
 * 	Set<Map.Entry<K, V>> entrySet(); // 将Map集合转换成Set集合
 * 		如：
 * 			Map集合对象：Map map1 = ????; // map1集合对象
 * 				Key					Value
 * 			----------------------------------
 * 				1					张三
 * 				2					李四
 * 				3					王五
 * 				4					赵六
 * 			调用entrySet()方法：Set set = map1.entrySet(); // 调用entrySet()方法变成Set集合，Set集合对象set
 * 			Set集合对象：set
 * 				1 = 张三 // 这是Set集合中的一个元素，是一个对象
 * 				2 = 李四
 * 				3 = 王五
 * 				4 = 赵六
 * 			注意：Map集合通过entrySet()方法转换成的这个Set集合，Set集合元素的类型是 Map.Entry<K, V>,其中Map.Entry是类名，
 * 		  可以理解为是一种类型的名字，Map.Entry是静态内部类，是Map下的静态内部类；Set集合下的对象(元素)的类型是Map.Entry
 * @author 13651
 *
 */
public class MapMethodsStu {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>(); // 创建HashMap集合对象
		/**向Map集合中添加键值对(元素)*/
		map.put(1, "张三"); // 因为泛型的原因，这里的1是Integer类型，自动装箱机制实现
		map.put(2, "李四");
		map.put(3, "王五");
		map.put(4, "赵六");
		
		/**同key获取value*/
		String value = map.get(3);
		System.out.println("key为3的键值对中的值：" + value);
		
		/**获取键值对的数量*/
		System.out.println("此集合内的元素(键值对)数量：" + map.size());
		
		/**获取所有的key*/
		Set<Integer> s = map.keySet();
		System.out.print("Map集合的所有key：");
		for(Integer key : s) {
			System.out.print(key + ", ");
		}
		System.out.println();
		
		/**获取所有的value*/
		Collection<String> c = map.values();
		System.out.print("Map集合的所有value：");
		for(String data : c) {
			System.out.print(data + ", ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
						
		/**
		 * Map集合的遍历，
		 * 	方式一：获取所有的key通过遍历key来遍历value
		 */
		// 获取所有的key，注意泛型
		Set<Integer> keys = map.keySet();
		// 使用迭代器遍历key
		Iterator<Integer> ite = keys.iterator(); // 创建迭代器，注意迭代器的泛型要与Map集合的key部分泛型保持一致
		System.out.print("通过迭代器遍历所有key实现Map集合的遍历{");
		while(ite.hasNext()) {
			Integer k = ite.next(); // 获取key
			String v = map.get(k); // 通过key获取value
			System.out.print(k + "---" + v);
			if(ite.hasNext()) System.out.print(", ");
			else System.out.println("}");
		}
		System.out.println();
		// 使用foreach遍历方式
		System.out.print("通过foreach方式遍历所有key实现Map集合的遍历{");
		for(Integer key : keys) {
			String v = map.get(key); // 通过key获取value
			System.out.print(key + "---" + v + "; ");
		}
		System.out.println("}");
		System.out.println();
		/**
		 * Map集合的遍历，
		 * 	方式二：通过 Set<Map.Entry<K, V>> entrySet(); 方法实现Map集合的遍历
		 * 		此方法会将Map集合全部转换为Set集合；Set集合的元素是Map.Entry
		 */
		Set<Map.Entry<Integer, String>> mapToSet = map.entrySet(); // 将Map集合全部转换为Set集合
		// 通过迭代器遍历转换后的Map集合(已经变成Set集合)
		Iterator<Map.Entry<Integer, String>> it = mapToSet.iterator(); // 创建此Set集合的迭代器对象，注意迭代器的泛型要与Set集合的泛型保持一致
		System.out.print("通过迭代器遍历Map集合经过entrySet()方法转型成的Set集合{");
		while(it.hasNext()) {
			Map.Entry<Integer, String> mapEntry = it.next(); // 获取这个结点
			Integer k = mapEntry.getKey(); // 通过结点获取key
			String v = mapEntry.getValue(); // 通过结点获取value
			System.out.print(k + "=" + v); // 相当于直接输出结点，即：System.out.print(mapEntry);
			
			if(it.hasNext()) System.out.print(", ");
			else System.out.println("}");
		}
		System.out.println();
		// 通过foreach方式遍历转换后的Map集合(已经变成Set集合)
		System.out.print("通过foreach方式遍历Map集合经过entrySet()方法转型成的Set集合{");
		for(Map.Entry<Integer, String> mapEntry : mapToSet) {
			Integer k = mapEntry.getKey(); // 通过结点获取key
			String v = mapEntry.getValue(); // 通过结点获取value
			System.out.print(k + "=" + v + ", "); // 相当于直接输出结点，即：System.out.print(mapEntry + ", ");
		}
		System.out.println("}");
		System.out.println();
		/***
		 * 结论：对于Map集合的遍历，第二种方式比第一种方式要高，因为第一种在遍历到key后还要通过key去Hash表中获取Value，效率要低；
		 * 但是对于第二种方式，直接遍历到存在key和value的结点，通过此结点获取到key和value，因此效率要高；
		 * 所以在大数据量的Map集合遍历时，最好使用第二种方式
		 */
		
		
		/**通过key删除键值对(元素)*/
		map.remove(2);
		System.out.println("删除操作后集合内的元素(键值对)数量：" + map.size());
		
		/**判断是否包含某个key*/
		System.out.println("判断是否包含key为1的键值对：" + map.containsKey(1));		
		/**判断是否包含某个value*/
		System.out.println("判断是否包含value为 '赵六' 的键值对：" + map.containsValue("赵六"));
		/**
		 * 注意：contains方法底层调用的都是equals()方法，所以定义的类型最好重写equals()方法
		 */
		
		/**清空Map集合*/
		map.clear();
		/**判断Map集合是否为空*/
		System.out.println("清空之后数组是否为空？" + map.isEmpty());
	}
}
