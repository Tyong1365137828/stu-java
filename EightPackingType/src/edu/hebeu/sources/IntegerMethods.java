package edu.hebeu.sources;

/**
 * ����Integer��ķ��������Խ���Ƴ�����7����װ��ķ����Լ���Щ����������
 * @author 13651
 *
 */
public class IntegerMethods {
	
	/**
	 * Integer���parseInt()��������̬����
	 * ����һ�������� int ���ݣ�ͨ��String���͵����ݵõ�
	 * @param s
	 */
	public void parseIntTest(String s) {
		int i = Integer.parseInt(s);
		System.out.println(i);
	}
	
	/**
	 * ����һ�������Ƶ�String��������
	 * Integer���toBinaryString()��������̬����
	 * ��ʮ���Ƶ�intת��Ϊ�����Ƶ�String��������
	 * @param i
	 */
	public void toBinaryStringTest(int i) {
		String s = Integer.toBinaryString(i);
		System.out.println(s);
	}
	
	/**
	 * ����һ��ʮ�����Ƶ�String��������
	 * Integer���toHexString()��������̬����
	 * ��ʮ���Ƶ�intת��Ϊʮ�����Ƶ�String��������
	 * @param i
	 * 
	 * 1 2 3 4 5 6 7 8 9 a b c d e f
	 */
	public void toHexStringTest(int i) {
		String s = Integer.toHexString(i);
		System.out.print(s);
	}
//	public void toHexStringTest(long i) {
//		System.out.println(Long.toHexString(i));
//	}
	
	/**
	 * ����һ���˽��Ƶ�String�����ַ���
	 * Integer���toOctalString()��������̬����
	 * ��ʮ���� ��intת��Ϊ�˽��Ƶ�String��������
	 * @param i
	 */
	public void toOctalStringTest(int i) {
		String s = Integer.toOctalString(i);
		System.out.println(s);
	}
	
	/**
	 * ����һ��Integer���͵����ݣ�ͨ������� int ��������
	 * Integer��valueOf()��������̬����
	 * @param i
	 */
	public void valueOfTest(int i) {
		Integer integer = Integer.valueOf(i);
		System.out.println(integer);
	}
	
	/**
	 * ����һ��Integer���͵����ݣ�ͨ������� String ��������
	 * Integer��valueOf()��������̬����
	 * @param s
	 */
	public void valueOf(String s) {
		Integer integer = Integer.valueOf(s);
		System.out.println(integer);
	}
}
