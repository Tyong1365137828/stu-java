package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Collectio���ͼ��ϵ�������ѧϰ��
 * ע�⣺�����½���ĵ�����ʽ/������ʽ�������е�Collection��˵��ͨ�õ�һ�ַ�ʽ
 * 	���ǣ���Map���ϲ���ʹ�ã�������Collection�Լ���������ʹ��
 * 
 * ע�⣺��Java�У����Ͻṹ�����ı�(�����ڵ�Ԫ����ɾ)�󣬴˼��ϵĵ������������»�ȡ��
 * 	��������»�ȡ���������ͻ�����쳣(java.util.ConcurrentModificationException)��
 * 
 * �ܽ᣺
 * 1���ڵ�������Ԫ�صĹ����У����ܵ��ü��϶����remove()����ɾ��Ԫ�أ���Ϊ�������������ı伯�ϵĽṹ��
 * ͨ������ע�������java.util.ConcurrentModificationException�쳣��
 * 2�����һ��Ҫ�ڵ���������ɾ��Ԫ�أ����Ե��õ����������remove()�������˷����Ὣ��������ǰָ���Ԫ��ɾ����
 * ��Ҫʹ�ü����Դ���remove()����ɾ��Ԫ�أ�����
 * @author 13651
 *
 */
public class CollectionInterableStu {
	public static void main(String[] args) {
		// �������϶���ArrayList��������ظ���
		Collection arrayC = new ArrayList();
		
		// ���Ԫ��������
		arrayC.add(123);
		arrayC.add(123);
		arrayC.add(123);
		arrayC.add("���");
		arrayC.add(2.56);
		arrayC.add("???");
		arrayC.add("???");
		arrayC.add(true);
		arrayC.add(true);
		arrayC.add(true);
		arrayC.add(true);
		
		// �Լ��Ͻ��б���
		// ��һ������ȡ���϶���ĵ���������arrayIterator
		Iterator arrayIterator = arrayC.iterator();
		// �ڶ�����ͨ������ĵ�������ϵ���������ԭ����б���/��������
		System.out.print("ArrayList{");
		while(arrayIterator.hasNext()) { // �жϵ�ǰԪ�ص������Ƿ���Ԫ��(�жϻ��ܷ����)
			Object obj = arrayIterator.next(); // ��������ָ����һ��Ԫ�أ�������ǰָ���Ԫ�ط��س�ȥ(���е���)
			System.out.print(obj);
//			arrayC.remove(obj); // ����������ʹ�ü����ڵķ���ɾ��Ԫ�أ��ı伯�Ͻṹʱ�����java.util.ConcurrentModificationException�쳣
			
			arrayIterator.remove(); // ʹ�õ������ڲ���remove()�������Ὣ��������ǰָ���Ԫ��ɾ��(�ײ�Ὣ�������Ĳ��տ����ڵ�Ԫ�غͼ����ڵ�Ԫ�ض�ɾ�����Ա�֤��������������쳣)
			if(arrayIterator.hasNext()) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
		System.out.println("ArrayList�ڵ�Ԫ�أ�" + arrayC.size());
		
		
		
		// �������϶���HashSet�����򲻿��ظ�
		Collection hashC = new HashSet();
		hashC.add(100);
		hashC.add(200);
		hashC.add("HashSet");
		hashC.add(100);
		hashC.add(100);
		hashC.add(560);
		hashC.add(2.589);
		
		// �Լ��Ͻ��б���
		// ��һ������ȡ���϶���ĵ���������hashIterator
		Iterator hashIterator = hashC.iterator();
		// �ڶ�����ͨ������ĵ�������ϵ���������ԭ����б���/��������
		System.out.print("HashSet{");
		while(hashIterator.hasNext()) { // �жϵ�ǰԪ�ص������Ƿ���Ԫ��(�жϻ��ܷ����)
			Object obj = hashIterator.next(); // ��������ָ����һ��Ԫ�أ�������ǰָ���Ԫ�ط��س�ȥ(���е���)
			System.out.print(obj);
			if(hashIterator.hasNext()) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}
