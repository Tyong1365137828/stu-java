package edu.hebeu.sources;

/**
 * 本程序展示String、int、Integer之间的互转
 * @author 13651
 *
 */
public class StringTOIntTOInteger {
	
	public static void main(String[] args) {
		/**String转int*/
		String s1 = "123";
		int i1 = Integer.parseInt(s1);
		System.out.println("s1=" + s1 + "; i1=" + i1);
		
		/**int转String*/
		String s2 = i1 + "";
		// String + int = String
		String s3 = s2 + 1; // 		
		System.out.println("s2=" + s2 + "; s3=" + s3);
		
		/**int转Integer*/
		Integer integer1 = i1; // 自动装箱
		System.out.println("i1=" + i1);
		
		/**Integer转int*/
		int i2 = integer1; // 自动拆箱
		System.out.println("i2=" + i2);
		
		/**String转Integer*/
		Integer integer2 = Integer.valueOf(s1);
		System.out.println("integer2=" + integer2);
		
		/**Integer转String*/
		String s4 = String.valueOf(integer2);
		System.out.println("s4=" + s4);
	}
}
