package edu.hebeu.sources;

/**
 * String类的构造方法讲解
 * @author 13651
 *
 */
public class StringConstructor {
	
	/**
	 * 当String类的构造方法传入的是byte类型的数组时
	 * @param array byte类型的数组
	 */
	public void argsIsIsByteArray(byte[] array) {
		String s = new String(array);
		System.out.println(s);
	}
	
	/**
	 * 当String类的构造方法传入的是byte类型的数组、偏移量、长度时。
	 * @param array byte类型的数组
	 * @param offset 偏移量(最小为0，最大为数组长度 - 1，即可以理解为数组下标)
	 * @param length 长度，即元素的个数
	 */
	public void argsIsIsByteArrayAndOffsetAndLength(byte[] array, int offset, int length) {
		String s = new String(array, offset, length);
		System.out.println(s);
	}
	
	/*其他类型的数组(如char、String、...)也有上述同样的方法*/
	
	
	/**
	 * 通过输出可以得出结论，String类内的toString()方法已经重写了，
	 * 因为toString()方法在Object中默认是输出内存地址的，这里本应输出byte[]数组的内存地址(即首元素的内存地址)，
	 * 但是发现实际输出的是将byte[]数组元素拼接成字符串的值
	 */
}
