package edu.hebeu.sources;

public class Example {
	public static void main(String[] args) {
		Integer integer = new Integer(123); // �� 123 ���int������������ת��ΪInteger������������(�ֶ�װ��)
		Float floa = new Float(236); // �� 236 ���int������������ת��ΪFloat������������(�ֶ�װ��)
		float f = integer.floatValue(); // ��Integer������������ת��Ϊfloat������������(�ֶ�����)
		int a = integer.intValue(); // ��Integer������������ת��Ϊint������������(�ֶ�����)
		byte bytee = floa.byteValue(); // ��Float������������ת��Ϊbyte������������(�ֶ�����)
		System.out.println("integer=" + integer + "; floa=" + floa + "; f=" + f + "; a=" + a + "; bytee=" + bytee);
		
		/**��jdk1.5֮��֧���Զ�װ����Զ�������*/
		Integer integer2 = 100; // �Զ�װ��
		int b = integer2; // �Զ�����
		
		/**
		 * ���췽�������Դ���һ���ð�װ���͵����ݻ���һ���ַ���<�ַ����������ܹ�ת��Ϊ���ֵ���ʽ>
		 */
//		Integer integerr = new Integer(567);
		Integer integerr = new Integer("56565"); // ����ת��Ϊ����
//		Integer integerr = new Integer("8855.6"); // ����ת��Ϊ����<����û���⣬���г�����>
//		Integer integerr = new Integer("dds����"); // ����ת��Ϊ����<����û���⣬���г�����>
		System.out.println(integerr);
		
//		Double doublee = new Double(3.14);
//		Double doublee = new Double("sss"); // ����ת��Ϊ���֣��ᱨ��<����û���⣬���г�����>
		Double doublee = new Double("1589"); // ����ת��Ϊ����
		System.out.println(doublee);
		
		/**ͨ�����������Զ���ȡ���ֵ����Сֵ*/
		System.out.println(Integer.MAX_VALUE); // ��ȡInteger�����ֵ
		System.out.println(Integer.MIN_VALUE); // ��ȡInteger����Сֵ
		System.out.println(Byte.MAX_VALUE); // ��ȡByte�����ֵ
		System.out.println(Byte.MIN_VALUE); // ��ȡByte����Сֵ
		
		
		/**�����ͳ����ظ��������*/
		Integer a1 = 128;
		Integer a2 = 128;
		System.out.println(a1 == a2); // false
		
		Integer b1 = 127;
		Integer b2 = 127;
		System.out.println(b1 == b2); // true
		/**���ԣ�
		 * Java��Ϊ�����Ч�ʣ��ڷ������ڴ���һ�������ͳ����أ����������256��Integer����(-128��127)����Щ�����������
		 * �ض����أ����û���ʹ��Integerʱ����أ�����û�������Integer���������� -128��127֮�䣬�Ͳ����ٶ��п��ٿռ䣬
		 * ����ֱ��ʹ�øóص����ݣ���֮����Ҫ�ڶ��д����µ�Integer����
		 * 
		 * �����ļ��д�����֮���Գ��������������Ϊ == ������ڱȽ϶���������������ʱ����Զ�Ƚϵ���ʾ�ڴ��ַ��128����
		 * -128��127֮�䣬���Ի��ڶ��ڴ��п��ٿռ䣻127�� -128��127֮�䣬���Բ����ٶ��п��ٿռ䣻�ڶ����д洢�������õ�
		 * �ڴ��ַ�����ԣ�a1��a2��Ϊ���� -127��127 ֮���ʹ�õ����ڶ����½�������Integer�����ַ��b1��b2��Ϊ�� -128��127 
		 * ֮���ʹ�õ����ڷ������ڵ������ͳ������еĵ�ַ����˻����false��true
		 */
	}
}
