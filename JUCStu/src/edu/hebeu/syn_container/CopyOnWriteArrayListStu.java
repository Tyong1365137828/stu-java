package edu.hebeu.syn_container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ���������ѧϰCopyOnWriteArrayList��ʹ�ó�����ע������
 * 
 * ��ʹ�ô�ͳ�ķ�ʽ��List����ͬ�����ڵ������ϵ�ͬʱ�򼯺����Ԫ�أ�������쳣java.util.ConcurrentModificationException(�����޸��쳣)
 * 
 * ��ʱ���Խ�List���ϱ��CopyOnWriteArrayList���͵ļ��ϼ��ɱ������ִ��󣡣���
 * ��Ҫע�⣺CopyOnWriteArrayList���ַ�ʽ����Ӳ�����ʱЧ�ʵͣ���Ϊÿ�����ʱ������и�ֵ�������ǳ���
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

//	private static List<String> list = Collections.synchronizedList(new ArrayList<>()); // ʹ��ԭ�ȵ�˼·���List�����̰߳�ȫ����
	private static List<String> list = new CopyOnWriteArrayList<>(); // ʹ���������͵ļ��Ͻ������

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
			list.add("AAAAA"); // �ڵ������ϵ�ͬʱ�򼯺����Ԫ��
		}
	}

}
