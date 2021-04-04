package edu.hebeu.sources;

import java.text.DecimalFormat;

/**
 * 数字格式化类的学习
 * @author 13651
 *
 */
public class NumberClass {
	public static void main(String[] args) {
		/**
		 * 数字格式化类DecimalFormat类的使用
		 * # 任意数字
		 * , 千分位
		 * . 小数点
		 * 0 不够补0
		 */
		DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
		String number1 = decimalFormat.format(12345685355.23560555);
		System.out.println("number1=" + number1);
		
		DecimalFormat decimalFormat2 = new DecimalFormat("###,###.00000000");
		String number2 = decimalFormat2.format(2552.322);
		System.out.println("number2=" + number2);
	}
}
