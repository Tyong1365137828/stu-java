package edu.hebeu.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList����ѧϰ
 * 
 * LinkedList���ϵ��ŵ㣺
 * 	���������е�Ԫ�ؿռ�洢���ڴ��ַ�����������������ɾԪ��ʱ�����漰��������Ԫ��λ�ƣ������ɾЧ�ʸߣ�
 * ���Ժ�Ŀ����У�������������ɾ�����϶࣬����ʹ��LinkedList���ϣ�
 * LinkedLit���ϵ�ȱ�㣺
 * 	����ͨ����ѧ���ʽ���㱻����Ԫ�ص��ڴ��ַ��ÿһ�β��Ҷ��Ǵ�ͷ��㿪ʼ������ֱ���ҵ�Ϊֹ������LinkedList���ϼ���Ч�ʽϵͣ�
 * 
 * ע��LinkedList���ϵĵײ���Ȼ��˫������������Ҳ�����±�ģ�
 * ArrayList���ϵļ���Ч�ʸ߲��ǵ�������Ϊ�����±꣬������Ϊ��ײ�������
 * LinkedList������Ȼͬ�����±꣬���Ǽ���/����ĳ��Ԫ�ص�Ч��ȷ�Ƚϵͣ���Ϊ�ײ�������ֻ�ܴ�ͷ���һ��һ����ʼ������
 * 
 * LinkedList����û�г�ʼ������һ˵�������������first��last����null��
 * 
 * @author 13651
 *
 */
public class LinkedListStu {
	public static void main(String[] args) {
		List l = new LinkedList();
		
		l.add(123);
		l.add('a');
		l.add("abcdef");
		l.add(231);
		l.add(123);
		
		for(int i = 0; i < l.size(); i++) {
			if(i == 0) System.out.print("LinkedList���ϣ�[");
			System.out.print(l.get(i));
			if(i < l.size() - 1) System.out.print(", ");
			else System.out.println("]");
		}
	}
}
