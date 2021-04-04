package edu.hebeu.sources;

/**
 * 介绍Integer类的方法，可以借此推出其他7个包装类的方法以及这些方法的性质
 * @author 13651
 *
 */
public class IntegerMethods {
	
	/**
	 * Integer类的parseInt()方法，静态方法
	 * 返回一个整数型 int 数据，通过String类型的数据得到
	 * @param s
	 */
	public void parseIntTest(String s) {
		int i = Integer.parseInt(s);
		System.out.println(i);
	}
	
	/**
	 * 返回一个二进制的String类型数据
	 * Integer类的toBinaryString()方法，静态方法
	 * 将十进制的int转换为二进制的String类型数据
	 * @param i
	 */
	public void toBinaryStringTest(int i) {
		String s = Integer.toBinaryString(i);
		System.out.println(s);
	}
	
	/**
	 * 返回一个十六进制的String类型数据
	 * Integer类的toHexString()方法，静态方法
	 * 将十进制的int转换为十六进制的String类型数据
	 * @param i
	 * 
	 * 1 2 3 4 5 6 7 8 9 a b c d e f
	 */
	public void toHexStringTest(int i) {
		String s = Integer.toHexString(i);
		System.out.print(s);
	}
//	public void toHexStringTest(long i) {
//		System.out.println(Long.toHexString(i));
//	}
	
	/**
	 * 返回一个八进制的String类型字符串
	 * Integer类的toOctalString()方法，静态方法
	 * 将十进制 的int转换为八进制的String类型数据
	 * @param i
	 */
	public void toOctalStringTest(int i) {
		String s = Integer.toOctalString(i);
		System.out.println(s);
	}
	
	/**
	 * 返回一个Integer类型的数据，通过传入的 int 类型数据
	 * Integer的valueOf()方法，静态方法
	 * @param i
	 */
	public void valueOfTest(int i) {
		Integer integer = Integer.valueOf(i);
		System.out.println(integer);
	}
	
	/**
	 * 返回一个Integer类型的数据，通过传入的 String 类型数据
	 * Integer的valueOf()方法，静态方法
	 * @param s
	 */
	public void valueOf(String s) {
		Integer integer = Integer.valueOf(s);
		System.out.println(integer);
	}
}
