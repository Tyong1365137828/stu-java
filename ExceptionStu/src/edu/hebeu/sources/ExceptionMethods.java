package edu.hebeu.sources;

/**
 * 异常类的常用方法
 * 
 * 异常对象有两个非常重要的常用方法：
 * 	String msg = 异常对象.getMessage(); // 获取异常的简单信息描述
 * 异常对象.printStackTrace(); // 打印异常追踪的堆栈信息
 * @author 13651
 *
 */
public class ExceptionMethods {
	public static void main(String[] args) {
		NullPointerException nulllPointerException = new NullPointerException("****这是空指针异常****");
		
		// 获取异常的简单描述信息，此信息实际上是创建异常对象传入构造方法的String参数
		String nulllPointerExceptionMSG = nulllPointerException.getMessage();
		System.out.println(nulllPointerExceptionMSG);
		
		// 打印异常堆栈信息
		nulllPointerException.printStackTrace();
		/**可以看出Java打印异常堆栈追踪信息时，是异步的，因为是另一个线程*/
		
		for(int i = 0; i <= 1000; i++) {
			System.out.println("i=" + i);
		}
		System.out.println("完毕！！！");
		
	}
	
}
