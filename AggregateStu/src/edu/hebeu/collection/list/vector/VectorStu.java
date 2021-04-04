package edu.hebeu.collection.list.vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * ͨ���������ѧϰVector����
 * 
 * Vector�����ص㣺
 * 	1���ײ������飻
 * 	2��Ĭ�ϳ�ʼ������Ϊ10��
 * 	3��������ݣ�
 * 		����֮���������ԭ������2��
 * 	5��Vector�����еķ��������߳�ͬ���ģ�������synchronized�ؼ��֣����̰߳�ȫ�ģ�Ч�ʱȽϵͣ�ʹ�ý��٣�
 * 	6��ʹ�÷�ʽ��ArrayList������List����һ�£�
 * 
 * 
 * 	7����ν�һ�����̰߳�ȫ�ļ���ArrayList����̰߳�ȫ�ģ�
 * 		ʹ�ü��Ϲ����ࣺ
 * 			java.util.Collections // ע�⣺��java.util.Collection��ͬ��Collections�Ǽ��Ϲ�����
 * 			
 * @author 13651
 *
 */
public class VectorStu {
	public static void main(String[] args) {
		Vector v = new Vector(); // ����һ��Vector���ϣ�Ĭ������Ϊ10
		// ���Ԫ��
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		
		// ��ʱ��������ݣ�����֮����ԭ������2������10 -> 20 -> 40 -> 80 -> 160 -> ...
		v.add(11);
		
		
		/**
		 * ��ʾ�����̰߳�ȫ��ArrayList���϶������̰߳�ȫ��
		 */
		List l = new ArrayList(); // ����ArrayList���϶��󣬴�ʱ�Ƿ��̰߳�ȫ��
		// ����̰߳�ȫ��
		Collections.synchronizedList(l); // ִ����˷����󼯺�l�ͱ���̰߳�ȫ��
		
		l.add(123);
		l.add('b');
		l.add("fg");
		l.add(12);
		l.add(123);
		l.add(1.89);
		
	}
}
