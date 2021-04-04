package edu.hebeu.staticinnerclass;

/**
 * ͨ���������ܾ�̬�ڲ���
 * 
 * ��̬�ڲ�����Ա�����ʹ��
 * @author 13651
 *
 */
public class StaticInnerClassStu {
	
	// ����һ����̬�ڲ���
	private static class MyInnerClass {
		
		// ��̬����
		public static void m1() {
			System.out.println("��̬�ڲ��ྲ̬����m1ִ��");
		}
		
		// ʵ������
		public void m2() {
			System.out.println("��̬�ڲ���ʵ������m2ִ��");
		}
	}
	
	
	
	public static void main(String[] args) {
		StaticInnerClassStu.MyInnerClass.m1(); // ���Ծ�̬�ڲ���ľ�̬����
		
		StaticInnerClassStu.MyInnerClass mic = new StaticInnerClassStu.MyInnerClass(); // ������̬�ڲ������
		mic.m2(); // ͨ����̬�ڲ���������ʵ������
	}
}
 