package edu.hebeu.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ����չʾList�������еĳ��õķ���;
 * 
 * List���ϴ洢Ԫ�ص��ص㣬������ظ���
 * 	���±꣺List�����е�Ԫ�����±ꣻ��0��ʼ����1������
 * 	���ظ����洢һ��1�����ٴ洢1��
 * 
 * List������Collection�ӿڵ��ӽӿڣ�List���ϵ����г��÷�����
 * 	void add(int index, Object obj); // ���ض������������Ԫ��
 * 	Object get(int index); // ͨ��������ȡ������ָ����Ԫ��
 * 	int indexOf(Object obj); // ͨ��Ԫ�ػ�ȡ���ڼ����е�һ�γ��ֵ��±꣬û�з���-1
 * 	int lastIndexOf(Object obj); // ͨ��Ԫ�ػ�ȡ���ڼ��������һ�γ��ֵ��±꣬û�з���-1
 * 	Object remove(inde index); // �Ƴ�������ָ��λ�õ�Ԫ��
 * 	Object set(int index ,Object obj); // ͨ��ָ����Ԫ���滻������ָ��λ�õ�Ԫ��
 * @author 13651
 *
 */
public class ListSpecialANDOftenUserMethods {
	
	public static void main(String[] args) {
		List l = new ArrayList();
//		List l2 = new Vector();
//		List l3 = new LinkedList();
		
		l.add(0); // Ĭ���ڼ��ϵ����һλ���
		l.add("a"); // Ĭ���ڼ��ϵ����һλ���
		l.add(12); // Ĭ���ڼ��ϵ����һλ���
		l.add(3.1415926); // Ĭ���ڼ��ϵ����һλ���
		l.add(1); // Ĭ���ڼ��ϵ����һλ���
		l.add(1); // Ĭ���ڼ��ϵ����һλ���
		
		/**List���ϵ����з������򼯺��е�ָ��λ�����Ԫ�أ�Ч�ʽϵͣ�ʹ�ò���*/
		l.add(2, "king"); // ������ Ϊ2��λ��(�����еĵ�3��Ԫ�ش�)��� "king" String���͵�����
		
		Iterator arrayL = l.iterator(); // ����������
		System.out.print("List����ͨ��������������[");
		while(arrayL.hasNext()) { // ͨ���������������ϣ�ȡ�������ڵ�Ԫ��
			Object obj = arrayL.next();
			System.out.print(obj);
			
			if(arrayL.hasNext()) System.out.print(", ");
			else System.out.println("]");
		}
		for(Iterator i = l.iterator(); i.hasNext();) {
			System.out.print(i.next() + ", ");
		}// ��while�ĳ�forѭ����ʽ
		System.out.println();
		
		int index = 3; // �±�
		/**List���ϵ����з�����ͨ���±��ȡ�����ڵ�Ԫ��*/
		Object obj = l.get(index); // ��ȡ�������±�Ϊ3��Ԫ�أ�����4��Ԫ��
		System.out.println("���ϵ��±�Ϊ" + index + "��Ԫ����: " + obj);
		
		/**ͨ��List��������ķ������еı���(ͨ���±����)*/
		for(int i = 0; i < l.size(); i++) {
			if(i == 0) System.out.print("List����ͨ���±������[");
			System.out.print(l.get(i));
			if(i < l.size() - 1) System.out.print(", ");
			else System.out.println("]");
		}
		
		/**List���ϵ����з�������ȡָ������Ԫ�ص�һ�γ����ڼ��ϵ�����*/
		int firstShowIndex = l.indexOf(12); // ��ȡInteger���� 12 ��һ�γ����ڼ��ϵ�����
		/**List���ϵ����з�������ȡָ������Ԫ�����һ�γ����ڼ��ϵ�����*/
		int lastShowIndex = l.lastIndexOf(1); // ��ȡInteger���� 1 ���һ�γ����ڼ��ϵ�����
		System.out.println("firstShowIndex=" + firstShowIndex + "; lastShowIndex=" + lastShowIndex);
		
		System.out.print("ɾ��֮ǰ�����ϳ��ȣ�" + l.size() + "; ");
		/**List���ϵ����з�����ɾ��������ָ���±��Ԫ��*/
		l.remove(2); // ɾ���������±�Ϊ2��Ԫ�أ�����3��Ԫ��
		System.out.println("ɾ��֮�󣬼��ϳ��ȣ�" + l.size());
		
		System.out.print("ɾ��֮ǰ������Ϊ0��Ԫ���ǣ�" + l.get(0) + "; ");
		/**��������ָ���±��Ԫ�ظ���*/
		l.set(0, "king��?"); // �޸ļ������±�Ϊ0��Ԫ��ΪString���͵� "king��?"
		System.out.println("ɾ��֮������Ϊ0��Ԫ���ǣ�" + l.get(0));
	}
	
}
