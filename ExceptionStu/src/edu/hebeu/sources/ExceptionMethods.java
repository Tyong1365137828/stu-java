package edu.hebeu.sources;

/**
 * �쳣��ĳ��÷���
 * 
 * �쳣�����������ǳ���Ҫ�ĳ��÷�����
 * 	String msg = �쳣����.getMessage(); // ��ȡ�쳣�ļ���Ϣ����
 * �쳣����.printStackTrace(); // ��ӡ�쳣׷�ٵĶ�ջ��Ϣ
 * @author 13651
 *
 */
public class ExceptionMethods {
	public static void main(String[] args) {
		NullPointerException nulllPointerException = new NullPointerException("****���ǿ�ָ���쳣****");
		
		// ��ȡ�쳣�ļ�������Ϣ������Ϣʵ�����Ǵ����쳣�����빹�췽����String����
		String nulllPointerExceptionMSG = nulllPointerException.getMessage();
		System.out.println(nulllPointerExceptionMSG);
		
		// ��ӡ�쳣��ջ��Ϣ
		nulllPointerException.printStackTrace();
		/**���Կ���Java��ӡ�쳣��ջ׷����Ϣʱ�����첽�ģ���Ϊ����һ���߳�*/
		
		for(int i = 0; i <= 1000; i++) {
			System.out.println("i=" + i);
		}
		System.out.println("��ϣ�����");
		
	}
	
}
