package edu.hebeu.test;

import edu.hebeu.sources.StringMethods;
import edu.hebeu.sources.User;

/**
 * ����String��ķ����ķ���
 * @author 13651
 *
 */
public class StringMethodsTest {
	public static void main(String[] args) {
		StringMethods stringMethods = new StringMethods();
		
		/**
		 * ����charAtTest()����
		 */
		String s = "�й���";
		stringMethods.charAtTest(s, 1);
		
		/**
		 * ����compareToTest()����
		 */
		stringMethods.compareToTest("abc", "abb");
		
		/**
		 * ����containsTest()����
		 */
		stringMethods.containsTest("abc", "d");
		
		/**
		 * ����endsWithTest()����
		 */
		stringMethods.endsWithTest("abc", "bc");
		
		/**
		 * ����equalsTest()����
		 */
		stringMethods.equalsTest("abc", "abd");
		
		/**
		 * ����equalsIgnoreCaseTest()����
		 */
		stringMethods.equalsIgnoreCaseTest("abc", "AbC");
		
		/**
		 * ����getBytesTest()����
		 */
		stringMethods.getBytesTest("abcvdh");
		
		/**
		 * ����indexOfTest()����
		 */
		stringMethods.indexOfTest("abcdefg", "1");
		
		/**
		 * ����isEmptyTest()����
		 */
//		String s2 = null;
		stringMethods.isEmptyTest("");
		
		/**
		 * ����lengthTest()����
		 */
		stringMethods.lengthTest("12ssad");
		
		/**
		 * ����lastIndexOfTest()����
		 */
		stringMethods.lastIndexOfTest("javapythonnodevuereact", "java");
		
		/**
		 * ����replaceArgsIsCharTest()����
		 */
		stringMethods.replaceArgsIsCharTest("abadkakaakxa", 'a', 'w');
		
		/**
		 * ����replaceArgsIsCharSequenceTest()����
		 */
		stringMethods.replaceArgsIsCharSequenceTest("http://127.0.0.1:3000", "http://", "https://");
		
		/**
		 * ����splitTest()����
		 */
		stringMethods.splitTest("2000-10-02", "-");
		
		/**
		 * ����startsWithTest()����
		 */
		stringMethods.startsWith("javapythonnodevuereact", "ja");
		
		/**
		 * ����subStringTest()����
		 */
		stringMethods.subStringTest("abcdefg", 2); // cdefg
		
		/**
		 * ��������ֹ�±��subStringTest()����
		 */
		stringMethods.subStringTest("abcdefghigklmno", 2, 5); // cde
		
		/**
		 * ����toCharArrayTest()����
		 */
		stringMethods.toCharArrayTest("abcdefghigklmn");
		
		/**
		 * ����toLowerCaseTest()����
		 */
		stringMethods.toLowerCaseTest("ABHcvvddvKFDKFD");
		
		/**
		 * ����toUpperCaseTest()����
		 */
		stringMethods.toUpperCaseTest("HJDFHJDFHjskdjsdjfdjnnJKCnc");
		
		/**
		 * ����trimTest()����
		 */
		stringMethods.trimTest(" assaj jkjkcxn jjc j  ");
		
		/**
		 * ����valueOfTest()����
		 */
		stringMethods.valueOfTest(true);
		stringMethods.valueOfTest(2);
//		int[] array = {1, 5, 9, 8, 8, 4, 2};
		stringMethods.valueOfTest(new int[]{1, 2, 5, 6, 8});
		stringMethods.valueOfTest(new User(180, "tyong"));
		
	}
}
