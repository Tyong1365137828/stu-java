package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �������������˽�boolean contains()����
 * boolean contains(Object o) // �жϼ������Ƿ���ڴ�Ԫ�أ����� ? true : false
 * 	
 * ͨ����������ӽ��Դ����ó����ۣ�contains()���������Ƚϵ���Ԫ�ص����ݶ����ڴ��ַ������
 * 	contains()�����ڲ�������equals()������ʵ�ֱȽ����ݣ������� == �Ƚ��ڴ��ַ
 * @author 13651
 *
 */
public class CollectionOfContainsAnalysis {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		String s1 = new String("abc");
		c.add(s1);
		
		String s2 = new String("def");
		c.add(s2);
		
		String s3 = new String("abc");
		
		System.out.println("�������Ƿ���� abc ? " + c.contains(s3)); // true
		c.clear();
		
		
		
		User u1 = new User("tyong");
		User u2 = new User("tyong");
		
		c.add(u1);
		System.out.println("�������Ƿ���� u2 ? " + c.contains(u2)); 
		/**ע�⣬��User��û������equals()����ʱ���˽��Ϊfalse����Ϊcontains()���������User���equals()������
		����User�ಢδ����equals()��������ʱ�������Object���equals()������Object���е�equals()�������� == ����
		�Ƚϵ�(�Ƚϵ����ڴ��ַ)��u1��u2����new�����Ķ��󣬴�ʱ�൱�ڱȽ�����������ڴ��ַ���ý����Ȼ����false��
		*/
		
		
		
	}

}

class User {
	private String username;
	public User() {	
	}
	public User(String s) {
		this.username = s;
	}
	
	
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}*/
	
	
}
