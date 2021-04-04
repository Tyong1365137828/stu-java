package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ѧϰCollection�ӿ��еĳ��÷���
 * 1��Collection���ܴ洢ʲôԪ�أ�
 * 	ûʹ�÷���֮ǰ���ܴ���Object�����������ͣ�
 * 	ʹ�÷��ͺ�Collectionֻ�ܴ洢ĳ����������ͣ�
 * 	���ϵ��в���ֱ�Ӵ洢�����������ͣ�Ҳ���ܴ�4��Java����ֻ�ܴ�Java������ڴ��ַ��
 * 
 * 2��Collection�еĳ��÷�����
 * 	boolean add(Object object); // �򼯺������Ԫ��,��������ϵ����һλ
 * 	int size(); // ��ȡ������Ԫ�صĸ���
 * 	void clear(); // ��ռ���
 * 	boolean contains(Object object); // �жϵ�ǰ�������Ƿ������Ԫ�أ����� ? true : false
 * 	boolean remove(Object object); // ɾ�������еĶ�ӦԪ�� ɾ���ɹ� ? true : false
 * 	boolean isEmpty(); // �жϼ����Ƿ�Ϊ��(�������Ƿ����Ԫ��) Ϊ�� ? true : false
 * 	Object[] toArray(); // ������ת������
 * 	void addAll(Collection<? extends E> c); // ����collection�ڵ�����Ԫ�ض���ӵ���collection��
 * @author 13651
 *
 */
public class ColllectionOftenUseMethodsStu {
	
	public static void main(String[] args) {
		Collection c = new ArrayList(); // ��ΪCollection�ǽӿڣ�����ʹ�ö�̬�ķ�ʽ�������󣬲���Collection�ڵķ���
		
		c.add(12); // ע���ʱ���뼯�ϵĲ���12�������Ƚ�12�Զ�װ��ΪInteger���͵Ķ��󣬴��뼯�ϵ��Ǵ˶�����ڴ��ַ
		c.add(1.23); // ͬ��
		c.add(true); // ͬ��
		c.add("���"); // ͬ��
		c.add('b'); // ͬ��
		
		c.add(new Object()); // ע�⣬��ʱ����Ĳ��Ǵ�Object���󣬶��Ǵ�Object������ڴ��ַ
		c.add(new Student()); // ��ʱ�����Ҳ���Ǵ�Student���󣬶��Ǵ�Student������ڴ��ַ
		
		System.out.println("�����е�Ԫ�ظ�����" + c.size()); // ���㼯��Ԫ�صĸ���
		
		c.clear(); // ��ռ���
		System.out.println("�����е�Ԫ�ظ�����" + c.size());
		
		c.add(23);
		c.add("��ü���");
		System.out.println("�����е�Ԫ�ظ�����" + c.size());
		
		System.out.println(c.contains("��ü���")); // �жϼ������Ƿ����ֵΪ"��ü���"��String ���� �����õ�Ԫ��
		System.out.println(c.contains("���")); // �жϼ������Ƿ����ֵΪ"���"��String ���� �����õ�Ԫ��
		
		System.out.println(c.contains(23)); // �жϼ������Ƿ����ֵΪ 23 ��Integer ���� �����õ�Ԫ��
		c.remove(23); // ɾ�������е�ֵΪ 23 ��Integer���͵����õ�Ԫ�ص�Ԫ��
		System.out.println(c.contains(23)); // �жϼ������Ƿ����ֵΪ 23 ��Integer ���� �����õ�Ԫ��
		
		System.out.println("�����Ƿ�Ϊ�գ�" + c.isEmpty());
		c.clear(); // ��ռ���
		System.out.println("�����Ƿ�Ϊ�գ�" + c.isEmpty());
		
		c.add(122);
		c.add("ToArray");
		c.add(2.56);
		c.add(25);
		c.add(new Student());
		Object[] objs = c.toArray(); // ������ת��Ϊ����
		System.out.print("[");
		for(int i = 0; i < objs.length; i++) {
			Object obj = objs[i];
			System.out.print(obj);
			if(i < objs.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
	}
}

class Student {
	
}
