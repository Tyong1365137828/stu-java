package edu.hebeu.sources;

/**
 * ��Ϊ�쳣������ִ�й����еĲ��������
 * �쳣�����ã���ǿ����Ľ�׳��
 * 
 * ִ��һ�³������������ʾ��
 * 		Exception in thread "main" java.lang.ArithmeticException: / by zero
			at edu.hebeu.sources.ExceptionExample.exceptionDemo1(ExceptionExample.java:21)
			at edu.hebeu.sources.ExceptionExample.main(ExceptionExample.java:17)

	�����Ϣ���ǳ�֮Ϊ�쳣��Ϣ������Ϣ��JVM��ӡ��
	
	Java�е��쳣������ʽ��
		1���쳣��Java���������ʽ���ڣ�ÿһ���쳣�඼���Դ����쳣����
		
	�ڿ��������ѡ��try {}catch() {}��throws��
		���ϣ�������ߴ���ѡ��throws�ϱ����������ѡ��try {}catch() {}��׽ <���ڱ���ʱ�쳣>
		ʹ���ڴ������ֱ��ʹ��throw�׳������ý��������������ַ�ʽ <��������ʱ�쳣>
		
	�����г����쳣��
		�������¿�����̨����Ϣ��ͨ������ȷ���쳣λ�ã�
		ע�⣺��Ҫ��SUN��˾�ģ����Լ�д�Ĵ����һ�б����λ�ã�����
		
 * @author 13651
 *
 */
public class ExceptionExample {

	public static void main(String[] args) {
		newExceptionObj();
		exceptionDemo1(10, 0);
	}
	
	/**
	 * ͨ��new�������ʽ�����쳣���󲢴�ӡ���
	 */
	public static void newExceptionObj() {
		// ���� ArithmeticException ���쳣����
		ArithmeticException arithmeticException = new ArithmeticException("ArithmeticException�쳣���󴴽���");
		// java.lang.ArithmeticException: ArithmeticException�쳣���󴴽���
		System.err.println(arithmeticException);
//		System.err.println(arithmeticException.toString());
		
		// ���� NullPointerException �쳣����
		NullPointerException nullPointerException = new NullPointerException("NullPointerException�쳣���󴴽���");
		// java.lang.NullPointerException: NullPointerException�쳣���󴴽���
		System.err.println(nullPointerException);
//		System.err.println(nullPointerException.toString());
	}

	/**
	 * �쳣��ԭ��
	 * @param a
	 * @param b
	 */
	public static void exceptionDemo1(int a, int b) {
		int c = a / b; // ʵ���ϣ�JVM��ִ�е��˴�ʱ����new�쳣����new ArithmeticException("/ by zero");����JVM���쳣��Ϣ�׳�������Ϣ�����ӡ������̨��
		
		System.out.println("c=" + c);
	}
	
}
