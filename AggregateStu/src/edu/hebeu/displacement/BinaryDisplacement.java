package edu.hebeu.displacement;

/**
 * 本例讲解如何进行二进制的移位运算
 * @author 13651
 *
 */
public class BinaryDisplacement {
	public static void main(String[] args) {
		/**
		 * >> 1		二进制右移1位
		 * >> 2		二进制右移2位
		 * 
		 * 如：10 >> 1		表示将10的二进制右移1位
		 * 	10的二进制： 00001010	【10】
		 * 	10的二进制右移一位：00000101		【5】
		 * 结论：向右移动1位，等于除以2
		 */
		System.out.println(10 >> 1); // 输出为5
		
		/**
		 * 10 << 1		表示将10的二进制左移1位
		 * 10的二进制：00001010			【10】
		 * 10的二进制左移1位：00010100	【20】
		 */
		System.out.println(10 << 1); // 输出20
	}
}
