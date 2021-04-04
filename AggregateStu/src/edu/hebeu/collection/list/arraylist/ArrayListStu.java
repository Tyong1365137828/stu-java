package edu.hebeu.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * ArrayList���ϣ�
 * 	1��Ĭ�ϳ�ʼ����Ϊ10��(ע�⣺JDK8~13�еײ��ȴ�������Ϊ0�Ŀ����飬����ӵ�һ��Ԫ��ʱ�����ȱ�Ϊ10������)
 * 	2���ײ���һ��Object���͵����飻
 * 	3�����췽����
 * 		new ArrayList();
 * 		new ArrayList(20);
 * 		new ArrayList(Collection<? extends E> c); // ��ָ��Collection���ͼ���ͨ�����췽��ת��ΪArryList����
 * 	4��ArratList���ϵ�����:
 * 		ArrayList���ϵ����������ݵ�ԭ������1.5��(������1.5��)��
 * 		ArrayList�ײ������飬����Ż���
 * 			�������ٵ����ݣ���Ϊ��������Ч�ʵͣ�������ʹ��ArrayList����ʱ����һ��Ԥ���Ƶĳ�ʼ������������������ݴ�����
 * 	5��ArrayList�����Ƿ��̰߳�ȫ��
 * 
 * �����ŵ㣺
 * 		����Ч�ʱȽϸߣ�(�ߵ�ԭ��ÿ��Ԫ��ռ�õĿռ��С��ͬ���ڴ��ַ�������ģ�֪����Ԫ�ص��ڴ��ַ��Ȼ��֪���±꣬
 * 	  ͨ����ѧ���ʽ����Ԫ�ص��ڴ��ַ�����м���Ч�����)��
 * ����ȱ�㣺
 * 		�����ɾԪ��Ч�ʽϵͣ�
 * 		���������޷��洢������������Ϊ���ڴ��к����ҵ�һ��ǳ�����������ڴ��ַ�ռ䣻
 * 	ע�⣺
 * 		������ĩβ����Ԫ��Ч�ʺܸߣ�����Ӱ�죻
 * 
 * ���ԣ���ô�༯�ϣ��Ǹ����ϵ�Ӧ����ࣿ
 * 	��ArrarList���ϣ���Ϊ������õľ�����Ӻͼ���Ԫ�أ�ArrayList�������Ԫ����������ĩβ���Ԫ�أ�Ч�ʲ���Ӱ�죬
 * 	����ArrayList���ϵ����ݽṹ�����飬������м���Ч�ʸߵ��ŵ㣻
 * @author 13651
 *
 */
public class ArrayListStu {
	public static void main(String[] args) {
		List l1 = new ArrayList(); // Ĭ�ϳ�ʼ��������10
		List l2 = new ArrayList(100); // ָ����ʼ��������100
		
		Collection c = new HashSet();
		c.add("hash");
		c.add(123);
		c.add(2256);
		List l3 = new ArrayList(c); // ͨ���˹��췽�����Խ�HashSet����ת��ΪArrayList����
		
		System.out.println("l1�ĳ��ȣ�" + l1.size() + "; l2�ĳ���" + l2.size()); // ���ֶ���0������size()�����ǻ�ȡ��ǰ������Ԫ�صĸ������Ǽ��ϵ�����
		
		for(int i = 0; i < l3.size(); i++) {
			if(i == 0) System.out.print("HashSet���ArraYList[");
			System.out.print(l3.get(i));
			if(i < l3.size() - 1) System.out.print(", ");
			else System.out.println("]");
		}
	}
}
