package edu.hebeu.sources;

/**
 * ͨ������������˵��String����д�����ڲ��洢ԭ��
 * ���Ҹ����ʵ����ַ����ȽϷ����������ָ���쳣
 * @author 13651
 *
 */
public class StringCompare {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2); // ���true
		/*���� == �Ƚϵ���String����洢���ڴ��ַ����Ϊ���ַ�ʽû��new�����򲻻��ڶ������¿��ٿռ䣬
		 * s1��s2�洢���Ƿ��������ַ������ݳ������е�"abc"�ڴ��ַ������Ϊ���ַ������ݳ������лṫ����ͬ��ֵ��
		 * ��ֻ����һ��"abc"��s1��s2����"abc"�����s1 == s2�Աȵ��ڴ��ַ��ͬ��Ϊtrue*/
		
		String x = new String("xyz");
		String y = new String("xyz");
		System.out.println(x == y);
		/*���� == �Ƚϵ���String����洢���ڴ��ַ����Ϊ���ַ�ʽnew�����ˣ����Ի��ڶ��п��ٿռ�(�м���new�Ϳ��ټ���)��
		 * x��y�洢���ǶѵĶ�Ӧ��ַ�����д洢���Ƿ������ڵ��ַ������ݳ������еĵ�ַ(��Ϊ����"xyz"���򷽷����ڵ��ַ������ݳ����ػṫ��
		 * ��"xyz"��������������new���Ŀռ�������ָ��Ķ���"xyz"�ĵ�ַ)������x��y�д洢���Ƕѵ�ַ����ÿ��new���󶼻Ὺ�ٵ�ַ����x == �ض���false*/
	
		
		/**
		 * �ɴ˰������Եó������ַ����Ƚ�ʱ�����ʹ��equals��������������Ӧ == ������д�ĸ�ʽҲҪע�⣬���£�
		 */
		String k = null;
		System.out.println("abc".equals(k));
//		System.out.println(k.equals("abc")); // ������д���kΪ�ջᱨ��ָ���쳣
	}
}
