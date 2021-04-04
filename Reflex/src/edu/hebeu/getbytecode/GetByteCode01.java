package edu.hebeu.getbytecode;

import java.util.Date;

/**
 * Ҫ����һ������ֽ��룬����Ҫ��ȡ�������ֽ��룻
 * 
 * ��һ�ַ�ʽ��ȡ����ֽ��룺Class c = Class.forName("��������������");
 * java.lang.Class��ľ�̬����forName(String classFullName);
 * 
 * 	�磺	Class static forName(String classFullName); // ��ȡclassFullName����ֽ��룬ע��classFullName����������ȫ�޶���(����������)��
 * 		Class c1 = Class.forName("java.lang.String");
 * 
 * 
 * 
 * �ڶ��ַ�ʽ��ȡ����ֽ���: Class c = ����.getClass();
 * java���κ�һ��������getClass()����
 * 
 * �磺String s = "abc"; Class c = s.getClass();
 * 
 * 
 * 
 * �����ַ�ʽ��ȡ����ֽ��룺Java�����У��κ�һ�����ͣ����������������ͣ�����class���ԣ�
 * 	�磺	Class c1 = int.class;	Class c2 = Object.class;	Class c3 = Date.class;	Class c4 = String.class;
 * 
 * @author 13651
 *
 */
public class GetByteCode01 {
	public static void main(String[] args) {
		
		/**��һ�ַ�ʽ��ȡ����ֽ���*/
		try {
			Class c1 = Class.forName("java.lang.String"); // ��ʱc1����String.class�ļ�������˵c1����String����
			Class c2 = Class.forName("java.util.Date"); // ��ʱc2����Date����
			Class c3 = Class.forName("java.lang.Integer"); // ��ʱc3����Integer����
			Class c4 = Class.forName("java.lang.Double"); // ��ʱc4����Double����
			Class c5 = Class.forName("java.lang.System"); // ��ʱc5����System����
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Class c1 = null;
		Class c2 = null;
		try {
			c1 = Class.forName("java.lang.String");
			c2 = Class.forName("java.util.Date");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**�ڶ��ַ�ʽ��ȡ����ֽ���*/
		String s = "abc";
		Class x = s.getClass();
		System.out.println(c1 == x); // == �Ƚϵ����ڴ��ַ��c1��x����ָ�򷽷������ֽ����ļ�(String.class)
		
		Date d = new Date();
		Class y = d.getClass();
		System.out.println(c2 == y); // == �Ƚϵ����ڴ��ַ��c2��y����ָ�򷽷������ֽ����ļ�(Date.class)
		
		
		
		/**Java�����У��κ�һ�����ͣ����������������ͣ�����class����*/
		Class intClass = int.class; // intClass����int����
		Class stringClass = String.class; // stringClass����String����
		Class dateClass = Date.class; // dateClass����Date����
		Class intClass2 = int.class;
		
		System.out.println(intClass == intClass2);
		
	}
}
