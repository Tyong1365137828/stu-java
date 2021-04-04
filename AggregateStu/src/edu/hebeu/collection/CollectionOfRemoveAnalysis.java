package edu.hebeu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * remove()��������
 * 	ͨ�����Ժ�Դ�������remove()�����ײ������equals()����
 * @author 13651
 *
 */
public class CollectionOfRemoveAnalysis {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		String s1 = new String("abc");
		c.add(s1);
		System.out.println("�����е�Ԫ�ظ�����" + c.size());
		
		String s2 = new String("abc");
		c.remove(s2);
		System.out.println("�����е�Ԫ�ظ�����" + c.size());
		/**
		 * ͬ�����������ӿ��Է��֣�remove�Ѿ���s2����s1�ˣ����������������ϾͲ���һ���������ͨ��Դ��ͷ�����֪��
		 * 	�˴�remove()����ɾ��������equals()���������������ж���ɾ���Ǹ�Ԫ��
		 */
		
		
		// ��֤����ķ���
		c.clear();
		Test t1 = new Test("tyong");
		c.add(t1);
		System.out.println("�����е�Ԫ�ظ�����" + c.size());
		
		Test t2 = new Test("tyong");
		c.remove(t2);
		System.out.println("�����е�Ԫ�ظ�����" + c.size());
		/**
		 * ���Է��֣����Test����д����equals()����������remove()����ɾ��ʱ�ͻὫt1��t2����һ���ģ���˿���ͨ��u2��
		 * u1ɾ���������������дequals()��������remove()�����ĵײ����Test���equals()�������ǵ���Object���equals()������
		 * Object���equals()����Ĭ��ʹ�� == ���бȽϣ��Ƚϵ���t1��t2����������ڴ��ַ����Ȼu1��u2�Ͳ��ܳ�����Ϊ��һ�����ˣ�
		 * ���޷�ʵ��ʹ��u2ɾ��u1��
		 */
		
	}

}

class Test {
	private String username;
	public Test() {}
	public Test(String s) {
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
		Test other = (Test) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}*/	
		
}
