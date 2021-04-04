package edu.hebeu.map.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * ��ʾUser����д���hashCode()��equals()����
 * 	�Դ�������Map�����е�key��hashCode()������equals()����
 * 
 * ��Map�����д棬�Լ���Map������ȡ�����ȵ���key��hashCode()�������ٵ���key��equals()������
 * 	ע�⣺equals()�������ܲ������
 * 		��put(k, v)����������ʲôʱ��equals()����������ã�
 * 			k.hashCode()������ȡ��ϣֵ����ϣֵ���� ��ϣ�㷨/���� ת��Ϊ�����±꣬���±�Ϊnullʱ��ֱ�ӽ��˽����ӣ��������equals()������
 * 		��get(k)����������ʲôʱ��equals()����������ã�
 * 			k.hashCode()������ȡ��ϣֵ����ϣֵ���� ��ϣ�㷨/���� ת��Ϊ�����±꣬���±�Ϊnullʱ��ֱ�ӷ���nulll���������equals()������
 * 
 * 
 * �ص㣺
 * 		���һ�����equals()������д�ˣ���ô������hashCode()����Ҳ������д��
 *  ����equals()��������ֵ���Ϊtrue��hashCode()��������ֵ����Ҫһ����(equals()��������true����ʾ����������ͬ��Ӧ��ȥͬһ�����������ϱȽϣ�
 *  ��ô�ͱ���Ҫ��ͬ��ͬһ�����������ϵĽ����˵���������±������һ���ģ��������±���ͨ����ϣֵ���� ��ϣ����/��ϣ�㷨ת�������ģ���ô��Ҫ��
 *  ��ϣֵһ����ͬ����������ж����hashCode()����������ֵҪ���������ͬ��)
 *  
 *  ���ۣ�����HashMap����key���ֵ�Ԫ�أ��Լ�HashSet���ϵ�Ԫ�أ�����Ҫ��дequals()������hashCode()������
 * 
 * @author 13651
 *
 */
public class UserIsHashCodeANDEqualsOverwriterMethod {
	public static void main(String[] args) {
		User u1 = new User("����");
		User u2 = new User("����");
		
		// ��дequals()����֮ǰ���رض���false
		System.out.println(u1.equals(u2)); // false
		// ��дequals()����֮�󷵻���true
		System.out.println(u1.equals(u2)); // true
		
		System.out.println("u1�Ĺ�ϣֵ��" + u1.hashCode()); // 366712642
		System.out.println("u2�Ĺ�ϣֵ��" + u2.hashCode()); // 1829164700
		
		/**����дequals()������������User����������u1��u2�洢��HashMap/HashSet�����У�������˵Ӧ��ֻ�ܴ洢һ��(HashSet/HashMap����
	      ���ص㣺���򲻿��ظ���equals()������д֮�󣬱Ƚϵ���username����Object����Ĭ�ϵıȽ��ڴ��ַ��u1��u2��username���� "����" )��
		
		    ���ǲ��Ժ�ᷢ��u1��u2���洢��HashMap�������ˣ�����HashMap���ϵ��ص���Υ����������Ϊû����дhashCode()���������������������
		    ��ϣֵ��ͬ����ϣֵֵ��ͬ���¹�ϣ�㷨ת��Ϊ�����±�Ҳ��ͬ���洢������Ĳ�ͬ�±괦(u1��u2����ͬһ������)��equals()������ʹ��д
		    Ҳ�취���е���(equals()��������ͬһ�������н��е��ã��Ծ����� ��ӽ��/���ǽ��ֵ)����Ҫ��ӵ�Ԫ��ֱ�ӷ�����������±괦*/
		Set<User> usersSet = new HashSet<>();
		usersSet.add(u1);
		usersSet.add(u2);
		System.out.println("��дequals()����֮�󣬵���û����дhashCode()������������username��ȵĶ����HashSet���ϳ��ȣ�" + usersSet.size()); // 2
	}
}
