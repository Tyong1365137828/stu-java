package edu.hebeu.sources;

/**
 * ����finally��һ��������
 * @author 13651
 *
 */
public class FinallyInterview {
	public static void main(String[] args) {
		int res = m1();
		System.out.println(res);; // �ʣ���ʱ�������? ���100
	}
	
	
	/**
	 * Java�е��﷨����һ��
	 * 		�������еĴ��������ϵ�������ִ��(����Υ��������)
	 * Java�е��﷨�������
	 * 		return���һ��ִ�У������������(����Υ��������)
	 * 
	 * ������������������˵Ӧ���Ƿ���101������Ϊ���ܱ�֤�����������﷨���򲻿�Υ������˷���100����101��
	 * 		����ע�⣺finally{}�ڵĴ��뻹���� ��return i;�� ֮ǰִ�еģ���return i;�� Ҳ���������ִ�еģ���
	 * 	��Ϊ�˱�֤���������﷨����i��Ϊ100��
	 * 
	 * �������߷������������class�ļ����£�
	 * 	public static int m1() {
	 * 		int i = 100;
	 * 		int j = i;
	 * 		i++;
	 * 		return j;
	 *	
	 *		// �쳣��أ��������
	 * 		Exception exception;
	 * 		exception;
	 * 		i++;
	 * 		throw exception;
	 * 	}
	 * ���Է��ִ˴��뼴����������������Java�﷨�����ұ�֤��return ������ִ�У���˵õ�����ֵ100����101 ������
	 * @return
	 */
	public static int m1() {
		int i = 100;
		try {
			return i;
		} finally {
			i++;
		}
	}
	
	
	
	/**
	 * ���������final��finally��finalize������
	 * 	final�ǹؼ��֣���ʾ���յġ����ɱ�ģ�
	 * 		final���εı���ֻ�ܸ�һ��ֵ(�������¸�ֵ)
	 * 		final���εķ������ܱ�����
	 * 		final���ε��಻�ܱ��̳�
	 * 
	 * 	finally�ǹؼ��֣���try����ʹ�ã�ʹ�����쳣��������У�
	 * 	��finally{}�ڵĴ���һ����ִ�У�
	 * 
	 * 	finalize��Object��ķ���������JVM������������GC�������
	 */
}
