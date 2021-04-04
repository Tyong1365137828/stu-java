package edu.hebeu.collection.set;

import java.util.HashSet;

/**
 * ��ʾhashSet���ϵ��ص�
 * 
 * �ص㣺���򲻿��ظ�
 * 	1���洢�Ĵ洢ʱ��˳���ȡ��ʱ��˳��һ��
 * 	2�������ڵ�Ԫ�ز����ظ�
 * 	3���洢��HashSet�����ڵ�Ԫ��ʵ�����Ǵ洢��HashMap���ϵ�key������
 * 
 * 	���췽����
 * 		new HashSet();
 * 		new HashSet(int initialCapacity); // ������ʼ������ΪinitialCapacity�ļ��ϣ���������Ϊ0.75
 * 		new HashSet(Colllection<? extends E> c); // ��ָ����Collection���ͼ���ת��ΪHashSet����
 * 
 * ��ʼ������������ϸ�ڵȸ������ݻ���ͬHashMap����
 * @author 13651
 *
 */
public class HashSetStu {
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet(); // ����HashSet����
		hashSet.add(74);
		hashSet.add(58);
		hashSet.add(36);
		hashSet.add(28);
		hashSet.add(75);
		hashSet.add(74);
		hashSet.add(74);
		
		for(int i : hashSet) {
			System.out.print(i + ", ");
		}
	}
}
