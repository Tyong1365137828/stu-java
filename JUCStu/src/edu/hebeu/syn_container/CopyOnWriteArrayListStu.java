package edu.hebeu.syn_container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 这个类用来学习CopyOnWriteArrayList的使用场景和注意事项
 * 
 * 当使用传统的方式将List集合同步，在迭代集合的同时向集合添加元素，会出现异常java.util.ConcurrentModificationException(并发修改异常)
 * 
 * 此时可以将List集合变成CopyOnWriteArrayList类型的集合即可避免这种错误！！！
 * 需要注意：CopyOnWriteArrayList这种方式在添加操作多时效率低，因为每次添加时都会进行赋值，开销非常大！
 * 
 * @author 13651
 *
 */
public class CopyOnWriteArrayListStu {

	public static void main(String[] args) {

		MyRunnable myRunnable = new MyRunnable();

		for (int i = 0; i < 10; i++) {
			new Thread(myRunnable).start();
		}
	}
}

class MyRunnable implements Runnable {

//	private static List<String> list = Collections.synchronizedList(new ArrayList<>()); // 使用原先的思路解决List集合线程安全问题
	private static List<String> list = new CopyOnWriteArrayList<>(); // 使用这种类型的集合解决问题

	static {
		list.add("AA");
		list.add("BB");
		list.add("CC");
	}

	@Override
	public void run() {
		Iterator<String> iterator = list.iterator();

		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			list.add("AAAAA"); // 在迭代集合的同时向集合添加元素
		}
	}

}
