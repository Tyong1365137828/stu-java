package edu.hebeu.sources;

/**
 * 关于finally的一个面试题
 * @author 13651
 *
 */
public class FinallyInterview {
	public static void main(String[] args) {
		int res = m1();
		System.out.println(res);; // 问，此时输出多少? 输出100
	}
	
	
	/**
	 * Java中的语法规则一：
	 * 		方法体中的代码必须从上到下依次执行(不可违背！！！)
	 * Java中的语法规则二：
	 * 		return语句一旦执行，方法必须结束(不可违背！！！)
	 * 
	 * 下面的这个方法理论来说应该是返回101，但是为了能保证上述的两条语法规则不可违背，因此返回100而非101；
	 * 		但是注意：finally{}内的代码还是在 “return i;” 之前执行的，“return i;” 也还是在最后执行的，但
	 * 	是为了保证上述两条语法规则i仍为100；
	 * 
	 * 借助工具反编译解析出的class文件如下：
	 * 	public static int m1() {
	 * 		int i = 100;
	 * 		int j = i;
	 * 		i++;
	 * 		return j;
	 *	
	 *		// 异常相关，无需分析
	 * 		Exception exception;
	 * 		exception;
	 * 		i++;
	 * 		throw exception;
	 * 	}
	 * 可以发现此代码即遵守了上述的两个Java语法规则且保证了return 语句最后执行，因此得到返回值100而非101 ！！！
	 * @return
	 */
	public static int m1() {
		int i = 100;
		try {
			return i;
		} finally {
			i++;
		}
	}
	
	
	
	/**
	 * 面试题二：final、finally、finalize的区别
	 * 	final是关键字，表示最终的、不可变的；
	 * 		final修饰的变量只能赋一次值(不能重新赋值)
	 * 		final修饰的方法不能被覆盖
	 * 		final修饰的类不能被继承
	 * 
	 * 	finally是关键字，和try联合使用，使用在异常处理机制中，
	 * 	在finally{}内的代码一定会执行；
	 * 
	 * 	finalize是Object类的方法，是由JVM的垃圾回收器GC负责调用
	 */
}
