package edu.hebeu.sources;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * 1��BigDecimal���� �����ݣ����ȼ��ߡ������ڻ����������ͣ�����Java����(����������������)��SUN�ṩ��һ���࣬ר�����ڲ���������У�
 * 2��ע�⣺����������ʱ��double���͵������ǲ�����ȷ�ģ�����Ҫ������java.math.BigDecimal��
 * @author 13651
 *
 */
public class BigDecimalStu {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(400); // ����һ���߾��ȵ�400
		BigDecimal b = new BigDecimal(200); // ����һ���߾��ȵ�200
		
		/**
		 * ע�⣺BigDecimal���ɵ��Ƕ�������Ҫ���л�����������ʱ����ͳ�� + - * / �����ǲ���ʹ�õ�
		 */
		BigDecimal c1 = a.add(b); // ʵ��a + b
		System.out.println("c1=" + c1);
		BigDecimal c2 = a.subtract(b); // ʵ��a - b
		System.out.println("c2=" + c2);
		BigDecimal c3 = a.divide(b); // ʵ��a / b
		System.out.println("c3 = " + c3);
//		BigDecimal c3 = a.abs(new MathContext(2));
//		System.out.println("c3=" + c3);
	}
}
