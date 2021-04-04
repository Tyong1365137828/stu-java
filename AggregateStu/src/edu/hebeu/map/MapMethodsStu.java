package edu.hebeu.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ͨ�����������չʾmap���ϵĳ��÷���
 * 
 * ע�⣺
 * 	Map������Collection����û�м̳й�ϵ��
 * 	Map������key��value�Դ洢���ݣ�����ֵ��
 * 		key��value����������������
 * 		key��value���Ǵ洢������ڴ��ַ
 * 		key���������ã�value��key�ĸ�ӹƷ
 * 
 * ���÷�����
 * 	V put(K key, V value); // ��Map���������Ԫ��
 * 	V get(Object key); // ͨ��key��ȡvalue�������ȡ��������null
 * 	void clear(); // ���Map����
 * 	boolean containsKey(Object key); // �ж�Map�������Ƿ����ĳ��key
 * 	boolean containsValue(Object value); // �ж�Map�������Ƿ����ĳ��value
 * 	boolean equals(Object o); // �Ƚ�ָ���������ӳ���Ƿ����
 * 	boolean isEmpty(); // �ж�Map�����Ƿ�Ϊ��(Ԫ�ظ����Ƿ�Ϊ0)	�� ? true : false
 * 	Set<K> keySet(); // ��ȡMap�������е�key
 * 	V reomve(Object key); // ͨ��keyɾ�������е�Ԫ��(ɾ����ֵ��)
 * 	int size(); // ��ȡ���ϵļ�ֵ�Թ�ϵ��(���ϵ�Ԫ�ظ���)
 * 	Collection<V> values(); // ��ȡMap�������е�value
 * 	Set<Map.Entry<K, V>> entrySet(); // ��Map����ת����Set����
 * 		�磺
 * 			Map���϶���Map map1 = ????; // map1���϶���
 * 				Key					Value
 * 			----------------------------------
 * 				1					����
 * 				2					����
 * 				3					����
 * 				4					����
 * 			����entrySet()������Set set = map1.entrySet(); // ����entrySet()�������Set���ϣ�Set���϶���set
 * 			Set���϶���set
 * 				1 = ���� // ����Set�����е�һ��Ԫ�أ���һ������
 * 				2 = ����
 * 				3 = ����
 * 				4 = ����
 * 			ע�⣺Map����ͨ��entrySet()����ת���ɵ����Set���ϣ�Set����Ԫ�ص������� Map.Entry<K, V>,����Map.Entry��������
 * 		  �������Ϊ��һ�����͵����֣�Map.Entry�Ǿ�̬�ڲ��࣬��Map�µľ�̬�ڲ��ࣻSet�����µĶ���(Ԫ��)��������Map.Entry
 * @author 13651
 *
 */
public class MapMethodsStu {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>(); // ����HashMap���϶���
		/**��Map��������Ӽ�ֵ��(Ԫ��)*/
		map.put(1, "����"); // ��Ϊ���͵�ԭ�������1��Integer���ͣ��Զ�װ�����ʵ��
		map.put(2, "����");
		map.put(3, "����");
		map.put(4, "����");
		
		/**ͬkey��ȡvalue*/
		String value = map.get(3);
		System.out.println("keyΪ3�ļ�ֵ���е�ֵ��" + value);
		
		/**��ȡ��ֵ�Ե�����*/
		System.out.println("�˼����ڵ�Ԫ��(��ֵ��)������" + map.size());
		
		/**��ȡ���е�key*/
		Set<Integer> s = map.keySet();
		System.out.print("Map���ϵ�����key��");
		for(Integer key : s) {
			System.out.print(key + ", ");
		}
		System.out.println();
		
		/**��ȡ���е�value*/
		Collection<String> c = map.values();
		System.out.print("Map���ϵ�����value��");
		for(String data : c) {
			System.out.print(data + ", ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
						
		/**
		 * Map���ϵı�����
		 * 	��ʽһ����ȡ���е�keyͨ������key������value
		 */
		// ��ȡ���е�key��ע�ⷺ��
		Set<Integer> keys = map.keySet();
		// ʹ�õ���������key
		Iterator<Integer> ite = keys.iterator(); // ������������ע��������ķ���Ҫ��Map���ϵ�key���ַ��ͱ���һ��
		System.out.print("ͨ����������������keyʵ��Map���ϵı���{");
		while(ite.hasNext()) {
			Integer k = ite.next(); // ��ȡkey
			String v = map.get(k); // ͨ��key��ȡvalue
			System.out.print(k + "---" + v);
			if(ite.hasNext()) System.out.print(", ");
			else System.out.println("}");
		}
		System.out.println();
		// ʹ��foreach������ʽ
		System.out.print("ͨ��foreach��ʽ��������keyʵ��Map���ϵı���{");
		for(Integer key : keys) {
			String v = map.get(key); // ͨ��key��ȡvalue
			System.out.print(key + "---" + v + "; ");
		}
		System.out.println("}");
		System.out.println();
		/**
		 * Map���ϵı�����
		 * 	��ʽ����ͨ�� Set<Map.Entry<K, V>> entrySet(); ����ʵ��Map���ϵı���
		 * 		�˷����ὫMap����ȫ��ת��ΪSet���ϣ�Set���ϵ�Ԫ����Map.Entry
		 */
		Set<Map.Entry<Integer, String>> mapToSet = map.entrySet(); // ��Map����ȫ��ת��ΪSet����
		// ͨ������������ת�����Map����(�Ѿ����Set����)
		Iterator<Map.Entry<Integer, String>> it = mapToSet.iterator(); // ������Set���ϵĵ���������ע��������ķ���Ҫ��Set���ϵķ��ͱ���һ��
		System.out.print("ͨ������������Map���Ͼ���entrySet()����ת�ͳɵ�Set����{");
		while(it.hasNext()) {
			Map.Entry<Integer, String> mapEntry = it.next(); // ��ȡ������
			Integer k = mapEntry.getKey(); // ͨ������ȡkey
			String v = mapEntry.getValue(); // ͨ������ȡvalue
			System.out.print(k + "=" + v); // �൱��ֱ�������㣬����System.out.print(mapEntry);
			
			if(it.hasNext()) System.out.print(", ");
			else System.out.println("}");
		}
		System.out.println();
		// ͨ��foreach��ʽ����ת�����Map����(�Ѿ����Set����)
		System.out.print("ͨ��foreach��ʽ����Map���Ͼ���entrySet()����ת�ͳɵ�Set����{");
		for(Map.Entry<Integer, String> mapEntry : mapToSet) {
			Integer k = mapEntry.getKey(); // ͨ������ȡkey
			String v = mapEntry.getValue(); // ͨ������ȡvalue
			System.out.print(k + "=" + v + ", "); // �൱��ֱ�������㣬����System.out.print(mapEntry + ", ");
		}
		System.out.println("}");
		System.out.println();
		/***
		 * ���ۣ�����Map���ϵı������ڶ��ַ�ʽ�ȵ�һ�ַ�ʽҪ�ߣ���Ϊ��һ���ڱ�����key��Ҫͨ��keyȥHash���л�ȡValue��Ч��Ҫ�ͣ�
		 * ���Ƕ��ڵڶ��ַ�ʽ��ֱ�ӱ���������key��value�Ľ�㣬ͨ���˽���ȡ��key��value�����Ч��Ҫ�ߣ�
		 * �����ڴ���������Map���ϱ���ʱ�����ʹ�õڶ��ַ�ʽ
		 */
		
		
		/**ͨ��keyɾ����ֵ��(Ԫ��)*/
		map.remove(2);
		System.out.println("ɾ�������󼯺��ڵ�Ԫ��(��ֵ��)������" + map.size());
		
		/**�ж��Ƿ����ĳ��key*/
		System.out.println("�ж��Ƿ����keyΪ1�ļ�ֵ�ԣ�" + map.containsKey(1));		
		/**�ж��Ƿ����ĳ��value*/
		System.out.println("�ж��Ƿ����valueΪ '����' �ļ�ֵ�ԣ�" + map.containsValue("����"));
		/**
		 * ע�⣺contains�����ײ���õĶ���equals()���������Զ�������������дequals()����
		 */
		
		/**���Map����*/
		map.clear();
		/**�ж�Map�����Ƿ�Ϊ��*/
		System.out.println("���֮�������Ƿ�Ϊ�գ�" + map.isEmpty());
	}
}
