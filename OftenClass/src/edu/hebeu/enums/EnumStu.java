package edu.hebeu.enums;

/**
 * ö�٣�
 * 	1��ö����һ��������������
 * 	2��ö�����͵Ķ��塢�﷨��
 * 		enum ö������ {
 * 			ö��ֵ1��ö��ֵ2��......
 * 		}
 * 	3�����ֻ����������ģ�����ʹ��boolean���ͣ�������ڶ���������ܹ�һöһö���оٳ����Ľ���ʹ��ö�٣�
 * 	4��ö�ٱ���֮��Ҳ������class�ļ�
 * 	5��ö�ٵ�ÿһ��ֵ���Կ����ǳ���
 * 	6������ʹ��switch���
 * @author 13651
 *
 */
public class EnumStu {
	
	public static void main(String[] args) {
		Res r = computerNum(10, 2); // ���շ��� enum ���͵ķ���
		
		System.out.println(r == Res.SUCCESS ? "ִ�гɹ�" : "ִ��ʧ�ܣ�����");
	}
	
	/**
	 * ͨ�� enum ö��������Լ����������ֵ
	 * @param a
	 * @param b
	 * @return
	 */
	public static Res computerNum(int a, int b) {
		try {
			int c = a / b;
			System.out.println("a / b=" + c);
			
			return Res.SUCCESS;
		} catch(Exception e) {
			System.err.println("�Ѳ�׽�쳣��");
			return Res.FATURE;
		}
	}
	
	/**
	 * ����ö��
	 */
	enum Res {
		SUCCESS, FATURE
	}
}
