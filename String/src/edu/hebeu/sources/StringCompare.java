package edu.hebeu.sources;

/**
 * 通过这个案例深度说明String两种写法的内部存储原理，
 * 并且给出适当的字符串比较方法来避免空指针异常
 * @author 13651
 *
 */
public class StringCompare {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2); // 输出true
		/*首先 == 比较的是String对象存储的内存地址，因为这种方式没有new对象，则不会在堆中重新开辟空间，
		 * s1和s2存储的是方法区的字符串数据常量池中的"abc"内存地址，又因为在字符串数据常量池中会公用相同的值，
		 * 即只创建一个"abc"，s1和s2公用"abc"，因此s1 == s2对比的内存地址相同，为true*/
		
		String x = new String("xyz");
		String y = new String("xyz");
		System.out.println(x == y);
		/*首先 == 比较的是String对象存储的内存地址，因为这种方式new对象了，所以会在堆中开辟空间(有几个new就开辟几个)，
		 * x和y存储的是堆的对应地址，堆中存储的是方法区内的字符串数据常量池中的地址(因为都是"xyz"，则方法区内的字符串数据常量池会公用
		 * 此"xyz"，队中两个对象new出的空间内数据指向的都是"xyz"的地址)，但是x和y中存储的是堆地址，且每次new对象都会开辟地址，则x == 必定是false*/
	
		
		/**
		 * 由此案例可以得出：在字符串比较时，最好使用equals方法，尽量不适应 == ，并且写的格式也要注意，如下：
		 */
		String k = null;
		System.out.println("abc".equals(k));
//		System.out.println(k.equals("abc")); // 这样子写如果k为空会报空指针异常
	}
}
