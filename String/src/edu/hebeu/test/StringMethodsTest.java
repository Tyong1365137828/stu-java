package edu.hebeu.test;

import edu.hebeu.sources.StringMethods;
import edu.hebeu.sources.User;

/**
 * 测试String类的方法的方法
 * @author 13651
 *
 */
public class StringMethodsTest {
	public static void main(String[] args) {
		StringMethods stringMethods = new StringMethods();
		
		/**
		 * 测试charAtTest()方法
		 */
		String s = "中国人";
		stringMethods.charAtTest(s, 1);
		
		/**
		 * 测试compareToTest()方法
		 */
		stringMethods.compareToTest("abc", "abb");
		
		/**
		 * 测试containsTest()方法
		 */
		stringMethods.containsTest("abc", "d");
		
		/**
		 * 测试endsWithTest()方法
		 */
		stringMethods.endsWithTest("abc", "bc");
		
		/**
		 * 测试equalsTest()方法
		 */
		stringMethods.equalsTest("abc", "abd");
		
		/**
		 * 测试equalsIgnoreCaseTest()方法
		 */
		stringMethods.equalsIgnoreCaseTest("abc", "AbC");
		
		/**
		 * 测试getBytesTest()方法
		 */
		stringMethods.getBytesTest("abcvdh");
		
		/**
		 * 测试indexOfTest()方法
		 */
		stringMethods.indexOfTest("abcdefg", "1");
		
		/**
		 * 测试isEmptyTest()方法
		 */
//		String s2 = null;
		stringMethods.isEmptyTest("");
		
		/**
		 * 测试lengthTest()方法
		 */
		stringMethods.lengthTest("12ssad");
		
		/**
		 * 测试lastIndexOfTest()方法
		 */
		stringMethods.lastIndexOfTest("javapythonnodevuereact", "java");
		
		/**
		 * 测试replaceArgsIsCharTest()方法
		 */
		stringMethods.replaceArgsIsCharTest("abadkakaakxa", 'a', 'w');
		
		/**
		 * 测试replaceArgsIsCharSequenceTest()方法
		 */
		stringMethods.replaceArgsIsCharSequenceTest("http://127.0.0.1:3000", "http://", "https://");
		
		/**
		 * 测试splitTest()方法
		 */
		stringMethods.splitTest("2000-10-02", "-");
		
		/**
		 * 测试startsWithTest()方法
		 */
		stringMethods.startsWith("javapythonnodevuereact", "ja");
		
		/**
		 * 测试subStringTest()方法
		 */
		stringMethods.subStringTest("abcdefg", 2); // cdefg
		
		/**
		 * 测试由终止下标的subStringTest()方法
		 */
		stringMethods.subStringTest("abcdefghigklmno", 2, 5); // cde
		
		/**
		 * 测试toCharArrayTest()方法
		 */
		stringMethods.toCharArrayTest("abcdefghigklmn");
		
		/**
		 * 测试toLowerCaseTest()方法
		 */
		stringMethods.toLowerCaseTest("ABHcvvddvKFDKFD");
		
		/**
		 * 测试toUpperCaseTest()方法
		 */
		stringMethods.toUpperCaseTest("HJDFHJDFHjskdjsdjfdjnnJKCnc");
		
		/**
		 * 测试trimTest()方法
		 */
		stringMethods.trimTest(" assaj jkjkcxn jjc j  ");
		
		/**
		 * 测试valueOfTest()方法
		 */
		stringMethods.valueOfTest(true);
		stringMethods.valueOfTest(2);
//		int[] array = {1, 5, 9, 8, 8, 4, 2};
		stringMethods.valueOfTest(new int[]{1, 2, 5, 6, 8});
		stringMethods.valueOfTest(new User(180, "tyong"));
		
	}
}
