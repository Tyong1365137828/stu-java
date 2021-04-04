package edu.hebeu.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap���ϣ�
 * 	1��HashMap���ϵײ��ǹ�ϣ��/ɢ�б�����ݽṹ
 * 	2����ϣ����һ�����������ݽṹ��
 * 		��ϣ����һ�������뵥������Ľ���塣
 * 		���飺�ڲ�ѯ����Ч�ʸߣ������������ɾ����Ч�ʺܵͣ�
 * 		���������������ɾ����Ч�ʽϸߣ������ڲ�ѯ����Ч�ʺܵͣ�
 * 		��ϣ��/ɢ�б������������ݽṹ�ں���һ��
 * 
 * 3��HashMap�ײ��Դ���룺
 * 	public class HashMap {
 * 		Node<K, V>[] table; // HashMap�ײ�ʵ������һ������(����һά����)
 * 
 * 		// ��̬���ڲ���HashMap.Node
 * 		static class Node<K, V> implements Map.Entry<K, V> {
 * 			final int hash; // ��ϣֵ(��ϣֵ��ͨ��keyִ��hashCode()�����Ľ��)����ϣֵ����ͨ����ϣ����/�㷨��ת����������±�
 * 			final K key; // �洢��Map�����е�key
 * 			V value; // �洢��Map�����е�value
 * 			Node<K, V> next; // ��һ�������ڴ��ַ * 			
 * 		}
 * 	}
 * 
 * ��ϣ��/ɢ�б���һ��һά���飬��������е�ÿ��Ԫ����һ����������;(���������Ľ����)
 * 
 * 4��HashMap���ϵ�key���ص㣺
 * 	���򲻿��ظ���
 * 	������ΪHashMap�ײ��ǹ�ϣ��/ɢ�б����������뵥������Ľ���壬��Ȼ�������ڴ�ռ��ڵ�ַ�ռ����������������Ԫ��ʱ(���������
 * ���)���ܱ�֤����ӵ��Ǹ����������ϣ������������ģ�
 * 	�����ظ���ͨ��equals()��������֤HashMap��key�����ظ������key�ظ��ˣ�value�ᱻ����
 * 
 * ע�⣺�ŵ�HashMap����key���ֵ�Ԫ��ʵ������HashSet���ϵ�Ԫ�أ����HashSet����ҲӦ��Ҫ��дhashCode()��equals()����
 *
 *
 *	5��HashMapʹ�ò���ʱ�޷����������ܣ�
 *		�������е�hashCode()��������ֵΪĳ���̶���ֵ����ô�ᵼ�µײ��ϣ��/ɢ�б��ɴ��������������������ɢ�зֲ������ȣ�
 *		�������е�haxshCode()����ֵ���趨Ϊ��һ����ֵ����ײ����һ��һά���飬û������ĸ��Ҳ��ɢ�зֲ������ȣ�
 *
 *	6��ʲô��ɢ�зֲ����ȣ�
 *		������100��Ԫ�أ�������ܻ���Ϊ10����������ÿ��������������10��Ԫ�أ������������õģ���ɢ�зֲ����ȵģ�
 *
 *	ɢ�зֲ�������Ҫ����дhashCode()����ʱ��һ���ļ���
 *
 *	7���ص㣺����HashMap���ϵ�key���ֵ�Ԫ�أ��Լ�HashSet���ϵ�Ԫ�أ���Ҫͬʱ��дequals()��hashCode()����
 *	
 *	8��HashMap���ϵ�Ĭ�ϳ�ʼ��������16��Ĭ�ϼ���������0.75��
 *		���Ĭ�ϼ��������ǵ�HashMap���ϵײ������ռ�������ﵽ������75%ʱ�����鿪ʼ���ݣ�һ������֮���������ԭ������2����
 *		HashMap���ϳ�ʼ������������2�ı�������Ҳ�ǹٷ��Ƽ��ģ�������Ϊ�ﵽɢ�о��ȣ�Ϊ�����HashMap���ϵĴ�ȡЧ��������ġ�
 *
 *	9��HashMap��JDK8֮��ĸĽ���Ϊ����߼���Ч�ʣ������ϣ���е�ĳ�����������Ԫ�ش���8��ʱ(static final int TREEIFY_THRESHOLD = 8)���˵��������������ݽṹ�ͻ��ɺ����(������)���ݽṹ��
 *	  ��������(������)�������ݽṹ�ڵ�Ԫ��С��6��(static final int UNTREEIFY_THRESHOLD = 6)�������(������)�������ݽṹ�ֻ��ɵ����������ݽṹ��
 *	  ���ֻ�����Ϊ����߼���Ч�ʣ��������ļ������ٴ���Сɨ�跶Χ�����Ч�ʣ�
 *
 *	10�����ڹ�ϣ�����ݽṹ��
 *		�����������a1��a2�Ĺ�ϣֵ��ͬ��������һ������ͬһ�������ϵ�(��ϣֵ�ᾭ����ϣ�㷨/��ϣ���� ת���������±꣬��Ӧ�ľ���ĳ������)��
 *		ע�⣺��a1��a2�Ĺ�ϣֵ��ͬ����������Ȼ�п�����ͬһ�������ϣ���Ϊ������ͬ�Ĺ�ϣֵ������ϣ�㷨/��ϣ���� �п��ܻ�ת��Ϊͬһ�������±�(����� "��ϣ��ײ");
 *	
 *	11��HashMap�����Ƿ��̰߳�ȫ�ģ�
 * @author 13651
 *
 */
public class HashMapStu {
	public static void main(String[] args) {
		Map<Integer, Character> map = new HashMap<>(); //�������϶���
		// ���Ԫ��
		map.put(25, 'h');
		map.put(22, 'e');
		map.put(58, 'f');
		map.put(1, 'l');
		map.put(22, 'W'); // key�ظ����Ὣ��һ��key��Ӧ�ľ�value����
		map.put(null, null); /**HashMap���ϵ�����keyΪnull*/
		map.put(null, 'N'); /**���ٴ����keyΪnull��Ԫ��(��ֵ��)ʱ���Ὣ��һ��keyΪnull��Ԫ��(��ֵ��)����*/
		Character c = map.get(null); /**��ȡkeyΪnull��Ԫ�ص�value*/
		System.out.println("keyΪnull��Ԫ�ص�valueΪ��" + c);
		/**
		 * ���ۣ���
		 * 	HashMap���ϵ�Ԫ�ص�key����Ϊnull��ֻ����һ��keyΪnull��Ԫ��(��ֵ��)��
		 * 	HashMap���ϵ�Ԫ�ص�key��value����Ϊnull��
		 */
		
		System.out.println("Map���ϵ�Ԫ�ظ�����" + map.size());
		
		// ����Map����
		Set<Map.Entry<Integer, Character>> mapToSet = map.entrySet(); // ��Map����ȫ��ת����Set���ϣ�ע�ⷺ��
		// ͨ��for��ǿд������Map����
		System.out.print("Map����(����key������){");
		for(Map.Entry<Integer, Character> node : mapToSet) {
			Integer key = node.getKey(); // ��ȡkey
			Character value = node.getValue(); // ��ȡvalue
			System.out.print(key + "=" + value + ", "); // �൱�� System.out.print(node);
		}
		System.out.println("}");
		/**
		 * ��ʱ���֣�key�����ظ�
		 */
		
	}
}
