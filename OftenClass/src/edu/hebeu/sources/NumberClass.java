package edu.hebeu.sources;

import java.text.DecimalFormat;

/**
 * ���ָ�ʽ�����ѧϰ
 * @author 13651
 *
 */
public class NumberClass {
	public static void main(String[] args) {
		/**
		 * ���ָ�ʽ����DecimalFormat���ʹ��
		 * # ��������
		 * , ǧ��λ
		 * . С����
		 * 0 ������0
		 */
		DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
		String number1 = decimalFormat.format(12345685355.23560555);
		System.out.println("number1=" + number1);
		
		DecimalFormat decimalFormat2 = new DecimalFormat("###,###.00000000");
		String number2 = decimalFormat2.format(2552.322);
		System.out.println("number2=" + number2);
	}
}
