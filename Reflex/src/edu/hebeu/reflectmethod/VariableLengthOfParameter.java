package edu.hebeu.reflectmethod;

/**
 * �������չʾ�ɱ䳤�Ȳ�����ʹ��
 * 	�﷨��
 * 		����... ��(�� int... args)
 * 	
 * 	1���ɱ䳤�ȵĲ���Ҫ������ĸ�����0-n����
 * 	2���ɱ䳤�Ȳ����ڲ����б��б����������һ��λ����(��ô�ɱ䳤�Ȳ�����ֻ����1��)��
 * 	3���ɱ䳤�Ȳ������Ե���һ��������������
 * @author 13651
 *
 */
public class VariableLengthOfParameter {
	public static void main(String[] args) {
		m1(); // ���Բ���
		m1(13); // ���Դ�1��
		m1(13, 15, 88, 99); // ���Դ����
//		m1("gsdg"); // ���ǲ��ܴ�����������
				
		m3(2);
		m3(5, "abc");
		m3(9, "abc", "bvf", "sdfsfd", "ryss", "ssfsf");
		
		String[] strings = {"dsdfsf", "gfdfggd", "ddd", "ahadgh", "iqwuiq"};
		m4(strings); // ���Դ���һ���Ϳɱ��������һ��������
		m4(new String[] {"abc", "bvf", "sdfsfd","ddd", "ahadgh", "iqwuiq"}); // ����ֱ�Ӵ���һ����������
		
	}
	
	public static void m1(int... args) {
		System.out.println("m1()ִ��...");
	}
	
//	public static void m2(int... args, String... strings) {} //���󣡿ɱ䳤�Ȳ���ֻ����һ�����ұ��������һ��λ����
//	public static void m2(int...is, String a) {}
	
	public static void m3(int a, String... strings) {
		System.out.println("m3()ִ��...");
	}
	
	public static void m4(String...strings) {
		// �ɱ䳤�Ȳ�����length���ԣ��൱������
		for(int i = 0; i < strings.length; i++) {
			System.out.print(strings[i]);
			if(i < strings.length - 1) System.out.print(", ");
		}System.out.println();
	}
	
}
