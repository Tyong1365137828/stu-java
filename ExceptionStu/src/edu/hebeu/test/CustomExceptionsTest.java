package edu.hebeu.test;

import edu.hebeu.sources.*;

public class CustomExceptionsTest {

	public static void main(String[] args) {
		/**����ʱ�쳣����*/
		CustomException customException = new CustomException("�ҵı���ʱ�쳣");
		// ����getMessage()����
		String s1 = customException.getMessage();
		System.out.println(s1);
		// ����printStackTrace()����
		customException.printStackTrace();
		
		/**��������ʱ�쳣*/
		CustomRuntimeException customRuntimeException = new CustomRuntimeException("�ҵ�����ʱ�쳣");
		// ����getMessage()����
		String s2 = customRuntimeException.getMessage();
		System.out.println(s2);
		// ����printStackTrace()����
		customRuntimeException.printStackTrace();
	}

}
