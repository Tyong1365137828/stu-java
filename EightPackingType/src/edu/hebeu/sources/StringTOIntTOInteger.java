package edu.hebeu.sources;

/**
 * ������չʾString��int��Integer֮��Ļ�ת
 * @author 13651
 *
 */
public class StringTOIntTOInteger {
	
	public static void main(String[] args) {
		/**Stringתint*/
		String s1 = "123";
		int i1 = Integer.parseInt(s1);
		System.out.println("s1=" + s1 + "; i1=" + i1);
		
		/**intתString*/
		String s2 = i1 + "";
		// String + int = String
		String s3 = s2 + 1; // 		
		System.out.println("s2=" + s2 + "; s3=" + s3);
		
		/**intתInteger*/
		Integer integer1 = i1; // �Զ�װ��
		System.out.println("i1=" + i1);
		
		/**Integerתint*/
		int i2 = integer1; // �Զ�����
		System.out.println("i2=" + i2);
		
		/**StringתInteger*/
		Integer integer2 = Integer.valueOf(s1);
		System.out.println("integer2=" + integer2);
		
		/**IntegerתString*/
		String s4 = String.valueOf(integer2);
		System.out.println("s4=" + s4);
	}
}
