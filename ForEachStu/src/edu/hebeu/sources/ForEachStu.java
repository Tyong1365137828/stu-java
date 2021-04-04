package edu.hebeu.sources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JDK5.0������forѭ����ǿд��foreach
 * 
 * ������forѭ����ǿд������������ͼ���
 * 
 * ���ǣ�����ѭ����һ��ȱ�㣺
 *		û���±꣬�������Ҫ�±��ѭ��ʱ��������ʹ������forEachѭ��
 * @author 13651
 *
 */
public class ForEachStu {
	public static void main(String[] args) {
		// ��̬��������
		int[] array = new int[5];
		// ���������Ԫ��
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		/**��ͨforѭ��*/
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("=======================================================");
		
		/**��ǿforѭ��(foreach)��element�������ڵ�Ԫ��*/
		for(int element : array) {
			System.out.println(element);
		}
		System.out.println("=======================================================");
		
		
		// �������϶���
		List<String> l = new ArrayList<>();
		// �򼯺����Ԫ��
		l.add("45");
		l.add("���");
		l.add("???");
		l.add("8888");
		
		/**ʹ�õ�������������*/
		Iterator<String> i = l.iterator(); // ����l���ϵĵ���������(�ڴ洢���ϵĿ���)
		while(i.hasNext()) {
			String s = i.next();
			System.out.println(s);
		}
		System.out.println("=======================================================");
		
		/**���ּ��������±�ģ�ʹ��forѭ���ķ�ʽͨ���±��������*/
		for(int j = 0; j < l.size(); j++) {
			System.out.println(l.get(j));
		}
		System.out.println("=======================================================");
		
		/**ʹ��forѭ����ǿд��(foreach)*/
		for(String element : l) {
			System.out.println(element);
		}
		System.out.println("=======================================================");
		
	}
}
