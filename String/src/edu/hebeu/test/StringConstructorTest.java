package edu.hebeu.test;

import edu.hebeu.sources.StringConstructor;

/**
 * ����StringConstructor����
 * @author 13651
 *
 */
public class StringConstructorTest {
	public static void main(String[] args) {
		StringConstructor stringConstructor = new StringConstructor();
		
		/**
		 * ����String��Ĺ��췽��������byte[]���͵�����
		 */
		byte[] array = {97, 98, 99}; // byte[]���͵����飬97��a��98��b��99��c
		stringConstructor.argsIsIsByteArray(array);
		
		
		/**
		 * ����String��Ĺ��췽��������byte[]���顢ƫ����������
		 */
		byte[] array2 = {97, 98, 99, 100, 101};
		stringConstructor.argsIsIsByteArrayAndOffsetAndLength(array2, 2, 3);
		
	}
}
