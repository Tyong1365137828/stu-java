package edu.hebeu.sources;

/**
 * 面试题
 * @author 13651
 *
 */
public class StringInterview {
	public static void main(String[] args) {
		
		/**
		 * 下面的代码中，一共创建了几个对象？
		 * 3个，一个在方法区的字符串数据常量池中，为"abc"，
		 * 另外两个是在堆中的String对象，两个的值都是方法区的字符串数据常量池中存储"abc"的内存地址
		 */
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		/**
		 * 下面代码中，一共创建了几个对象？
		 * 4个，
		 * 两个在方法区的字符串数据常量池中，分别为"ty"、"test"
		 * 另外两个是在堆中的String对象，两个的值分别是方法区的字符串数据常量池中存储"ty"和"test"的内存地址
		 */
		String s3 = new String("ty");
		String s4 = new String("test");
		
		/**
		 * 下面代码中，一共创建了几个对象？
		 * 2个，
		 * 两个对象均在方法区的字符串数据常量池中，分别为"sdf"和"fg"
		 */
		String s5 = "sdf";
		String s6 = "fg";
		
		/**
		 * 下面代码中，一共创建了几个对象？
		 * 1个，
		 * 在方法区的字符串数据常量池中，为"tyong"
		 */
		String s7 = "tyong";
		String s8 = "tyong";
		
		/**
		 * 注意判断数组长度和字符串长度的length是不一样的
		 * 数组长度的length是属性，字符串长度的length()是方法
		 */
		
	}
}
