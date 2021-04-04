package edu.hebeu.getfather;

import java.util.Scanner;

/**
 * �������չʾ��λ�ȡһ����ĸ����ʵ�ֵ����и��ӿ�
 * @author 13651
 *
 */
public class GetFatherClassANDInterfaces {
	public static void main(String[] args) {
		Class cClass = null;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("������Ҫ��ѯ�����ʵ�ֽӿڵ��ࣺ");
			String className = scanner.next();
			scanner.close();
			cClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**��ȡ�����ĸ���(��Ϊֱ�Ӹ���ֻ����һ�������Է���ֵ������Class)*/
		Class fatherClass = cClass.getSuperclass();
		System.out.println("������ֱ�Ӹ����ǣ�" + fatherClass.getName());
		
		/**��ȡ����������ʵ�ֵĽӿ�(�ӿڿ����ж�������Է���ֵ������Class[]����)*/
		Class[] fatherIntefaces = cClass.getInterfaces();
		System.out.print("�����ʵ�ֵĽӿ��У�");
		for(Class i : fatherIntefaces) {
			System.out.print(i.getName() + "		");
		}System.out.println();
		
	}
}
