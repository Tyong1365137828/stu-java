package edu.hebeu.test;

import edu.hebeu.sources.StringConstructor;

/**
 * 测试StringConstructor方法
 * @author 13651
 *
 */
public class StringConstructorTest {
	public static void main(String[] args) {
		StringConstructor stringConstructor = new StringConstructor();
		
		/**
		 * 测试String类的构造方法参数是byte[]类型的数组
		 */
		byte[] array = {97, 98, 99}; // byte[]类型的数组，97是a，98是b，99是c
		stringConstructor.argsIsIsByteArray(array);
		
		
		/**
		 * 测试String类的构造方法参数是byte[]数组、偏移量、长度
		 */
		byte[] array2 = {97, 98, 99, 100, 101};
		stringConstructor.argsIsIsByteArrayAndOffsetAndLength(array2, 2, 3);
		
	}
}
