package edu.hebeu.sources;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * 1、BigDecimal属于 大数据，精度极高。不属于基本数据类型，属于Java对象(属于引用数据类型)是SUN提供的一个类，专门用于财务软件当中；
 * 2、注意：处理财务软件时，double类型的数据是不够精确的，而是要借助于java.math.BigDecimal类
 * @author 13651
 *
 */
public class BigDecimalStu {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(400); // 创建一个高精度的400
		BigDecimal b = new BigDecimal(200); // 创建一个高精度的200
		
		/**
		 * 注意：BigDecimal生成的是对象，所以要进行基本数据运算时，传统的 + - * / 符号是不能使用的
		 */
		BigDecimal c1 = a.add(b); // 实现a + b
		System.out.println("c1=" + c1);
		BigDecimal c2 = a.subtract(b); // 实现a - b
		System.out.println("c2=" + c2);
		BigDecimal c3 = a.divide(b); // 实现a / b
		System.out.println("c3 = " + c3);
//		BigDecimal c3 = a.abs(new MathContext(2));
//		System.out.println("c3=" + c3);
	}
}
