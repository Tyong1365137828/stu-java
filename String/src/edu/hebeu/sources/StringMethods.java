package edu.hebeu.sources;

/**
 * String类内部的常用方法
 * @author 13651
 *
 */
public class StringMethods {
	
	/**
	 * charAt()方法测试，会返回指定索引的一个char类型数据
	 * @param s 字符串
	 * @param index 字符串对应的索引，从0开始
	 */
	public void charAtTest(String s, int index) {
		System.out.println(s.charAt(index));
	}
	
	/**
	 * 按照字典的<顺序(从左至右)>比较两个字符串的大小，发现不相等就return值，相等就继续比较，直至比较完毕
	 * 相同相同(前.compareTo(后))：0
	 * 前小后大(前.compareTo(后))：负数(-1)
	 * 前大后小(前.compareTo(后))：正数(1)
	 * @param s1
	 * @param s2
	 */
	public void compareToTest(String s1, String s2) {
		System.out.println(s1.compareTo(s2));
	}
	
	/**
	 * 判断当前的字符串是否包含后面的子字符串，存在为true，反之为false
	 * @param s 字符串
	 * @param sChild 子字符串
	 */
	public void containsTest(String s, String sChild) {
		System.out.println(s.contains(sChild));
	}
	
	/**
	 * 判断当前字符串是否以某一字符结尾
	 * @param s 字符串
	 * @param endS 结尾字符串
	 */
	public void endsWithTest(String s, String endS) {
		System.out.println(s.endsWith(endS));
	}
	
	/**
	 * 判断两个字符串是否相等
	 * @param s1
	 * @param s2
	 */
	public void equalsTest(String s1, String s2) {
		System.out.println(s1.equals(s2));
	}
	
	/**
	 * 判断两个字符串是否相等(忽略大小写)
	 * @param s1
	 * @param s2
	 */
	public void equalsIgnoreCaseTest(String s1, String s2) {
		System.out.println(s1.equalsIgnoreCase(s2));
	}
	
	/**
	 * 返回一个byte[]数组，此数组是将字符串对象转化为字节的数组
	 * @param s
	 */
	public void getBytesTest(String s) {
		byte[] sBytes = s.getBytes();
		System.out.print(s + "的字节数组为:[");
		for(int i = 0; i < sBytes.length; i++) {
			System.out.print(sBytes[i]);
			if(i < sBytes.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}
	
	/**
	 * 判断某个子字符串在当前字符串首次出现的第一个字符的索引<类似于数组下标>，没有就返回 -1
	 * @param s 字符串
	 * @param sChild 子字符串
	 */
	public void indexOfTest(String s, String sChild) {
		System.out.println(s.indexOf(sChild));
	}
	
	/**
	 * 判断字符串是否为空，空为true，非空为false
	 * 注意s为null时会出现空指针异常
	 * @param s
	 */
	public void isEmptyTest(String s) {
		System.out.println(s.isEmpty());
	}
	
	/**
	 * 获取字符串的长度
	 * 注意获取数组长度的length是属性，获取字符串长度的length()是方法，两者是不一样的
	 * @param s
	 */
	public void lengthTest(String s) {
		System.out.println(s.length());
	}
	
	/**
	 * 判断某个子字符串在当前字符串最后出现的第一个字符的索引<类似于数组下标>，没有就返回 -1
	 * @param s
	 * @param sChild
	 */
	public void lastIndexOfTest(String s, String sChild) {
		System.out.println(s.lastIndexOf(sChild));
	}
	
	/**
	 * 返回一个新字符串，通过一个newChar替换一个oldChar得到<newChar替换此字符串中出现的所有oldChar>
	 * @param s
	 */
	public void replaceArgsIsCharTest(String s, char oldChar, char newChar) {
		System.out.println(s.replace(oldChar, newChar));
	}
	
	/**
	 * 返回一个新的字符串，通过oldString替换newString得到<newString替换字符串中出现的oldString>
	 * CharSequence是String类的父接口
	 * @param s
	 * @param oldString
	 * @param newString
	 */
	public void replaceArgsIsCharSequenceTest(String s, CharSequence oldString, CharSequence newString) {
		System.out.println(s.replace(oldString, newString));
	}
	
	/**
	 * 返回一个String[] 数组，数组通过split传入的参数为分割线进行分割
	 * @param s 被切割的字符串
	 * @param regex 可以是正则表达式，也可以是普通字符串
	 */
	public void splitTest(String s, String regex) {
		String[] array = s.split(regex);
		System.out.print(s + "字符串被切割为字符串数组:[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}
	
	/**
	 * 判断当前字符串是否以某个子字符串开始
	 * @param s 字符串
	 * @param sChild 子字符串
	 */
	public void startsWith(String s, String sChild) {
		System.out.println(s.startsWith(sChild));
	}
	
	/**
	 * 返回一个字符串，通过起始下标开始截取到的字符串
	 * @param s 字符串
	 * @param startSubScript 开始截取的下标 <截取时包括>
	 */
	public void subStringTest(String s, int startSubScript) {
		System.out.println(s.substring(startSubScript));
	}
	
	/**
	 * 返回一个字符串，通过起始下标和结束下标截取到的字符串
	 * @param s 字符串
	 * @param startSubScript 开始截取的下标 <截取时包括>
	 * @param endSubScript 终止截取的下标的后一位*********************** <截取时不包括>
	 */
	public void subStringTest(String s, int startSubScript, int endSubScript) {
		System.out.println(s.substring(startSubScript, endSubScript));
	}
	
	/**
	 * 将一个字符串转换为char[] 数组
	 * @param s
	 */
	public void toCharArrayTest(String s) {
		char[] array = s.toCharArray();
		System.out.print(s + "字符串被转换为字符数组:[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}
	
	/**
	 * 将一个字符串转都转换为小写
	 * @param s
	 */
	public void toLowerCaseTest(String s) {
		System.out.println(s.toLowerCase());
	}
	
	/**
	 * 将一个字符串转都转换为大写
	 * @param s
	 */
	public void toUpperCaseTest(String s) {
		System.out.println(s.toUpperCase());
	}
	
	/**
	 * 去除字符串前后空白
	 * @param s
	 */
	public void trimTest(String s) {
		System.out.println(s.trim());
	}
	
	/**
	 * valueOf()方法，String类中的静态方法
	 * 将boolean类型的数据转化为字符串
	 * @param flag
	 */
	public void valueOfTest(boolean flag) {
		System.out.println(String.valueOf(flag));
	}
	/**将int[]数组转换为字符串*/
	public void valueOfTest(int[] array) {
		System.out.println(String.valueOf(array));
	}
	/**将int类型的数据转换为字符串*/
	public void valueOfTest(int value) {
		System.out.println(String.valueOf(value));
	}
	/**如果是对象会默认调用对象的toString()方法*/
	public void valueOfTest(User user) {
		System.out.println(String.valueOf(user));
	}
	
	/**
	 * System.out.println()方法本质上在输出任何数据时都会调用String.valueOf()静态方法，进而把输出的任何类型数据变成String类型的数据，
	 * 因此控制台上输出的任何数据都是转换为String类型后的！！！
	 */
	
}
