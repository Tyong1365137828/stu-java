package edu.hebeu.test;

import edu.hebeu.sources.*;

public class IntegerMethodsTest {
	public static void main(String[] args) {
		IntegerMethods integerMethods = new IntegerMethods();
		
		/**
		 * ����Integer���parseInt()��̬����
		 */
		integerMethods.parseIntTest("123");
//		integerMethods.parseIntTest("���Ļ�Ӣ��abcd");
		
		/**
		 * ����Integer���toBinaryString()��̬����
		 */
		integerMethods.toBinaryStringTest(50);
		
		/**
		 * ����Integer���toHexString()��̬����
		 */
		integerMethods.toHexStringTest(1365137828); // 515e59a4
		integerMethods.toHexStringTest(20001002);
		integerMethods.toHexStringTest(182605);
		System.out.println();
		System.out.println("18000071902101240028182597445728".length());
		
		/**
		 * long���͵ĸ�ֵ���ڱ�����������������Ϊint���ͣ�����������������L���ܽ�������long���и�ֵ
		 * long����ÿ�����18λ�ڣ���Ϊ����������18��9������19��9�Ͳ����ˣ�����Ϊ�˱�֤��������������Чλ����ʹ�ã�
		 * �����18��9֮�ڣ�
		 * 
		 * �������ɵ�˼·����֤���ɵĵ���û�����ԵĹ��ɣ�Ӧ�ý� �����Ϲ̶����������(�������ڡ�����˺š������˺š���Ʒ��Ϣ��)����������д��䣬
		 * ���һ�Ҫ��֤������ܶԹ̶��������ϴ��Ӱ�죬Ҫ����������ڹ̶���֮��
		 * �� �����ϻ�ı������(�µ�ʱ���)������ȡ���ɵ���
		 * 
		 * 18abef7846071c718abef7846071c727797f26d671c7		44λ			18 + 18 + 17 λȫΪ1
		 * de0b6b3a763ffffde0b6b3a763ffff16345785d89ffff	45λ			18 + 18 + 17 λȫΪ9
		 * */
//		int randomFirst = ?????; // ��ͷ���ӵ������
		long time = 20190125192605300L; // 4λ�� 2λ�� 2λ�� 2λʱ 2λ�� 2λ�� 3λ���룻17λ�µ����ھ�ȷ������		System.out.println("long l1=" + l1 + "; l2=" + l2 + "; l3=" + l3);
		long buy = 136513782820001002L; // 10λ�����˺� + 8λ�������ڣ�18λ
		long businessGoods = 292501796600000017L; // 10λ�̼��˺�  + 8λ��Ʒid��18λ
//		int randomLast = ?????; // ��β���ӵ������	
		String code = Long.toHexString(time) + Long.toHexString(buy) + Long.toHexString(businessGoods);
//		code = code.toUpperCase(); // �����е�Ӣ�ı�ɴ�д
		System.out.println("code=" + code + "; code�ĳ���Ϊ" + code.length()); // 47cd00395de4741e4fe8febee54ea40f2cd59281ae11		44λ
		// 47cd0074f8ae741e4fe8febee54ea40f2cd59281ae11		47bacfd8136e741e4fe8febee54ea40f2cd59281ae11
		
		/**
		 * ����Integer���toOctalString()��̬����
		 */
		integerMethods.toOctalStringTest(562);
		
		/**
		 * ����Integer���valueOf()��̬����
		 */
		integerMethods.valueOfTest(200);
		integerMethods.valueOf("300");
	}
}
