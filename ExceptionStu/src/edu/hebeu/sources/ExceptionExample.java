package edu.hebeu.sources;

/**
 * 何为异常：程序执行过程中的不正常情况
 * 异常的作用：增强程序的建壮性
 * 
 * 执行一下程序出现如下所示：
 * 		Exception in thread "main" java.lang.ArithmeticException: / by zero
			at edu.hebeu.sources.ExceptionExample.exceptionDemo1(ExceptionExample.java:21)
			at edu.hebeu.sources.ExceptionExample.main(ExceptionExample.java:17)

	这个信息我们称之为异常信息，此信息是JVM打印的
	
	Java中的异常存在形式：
		1、异常在Java中以类的形式存在，每一个异常类都可以创建异常对象
		
	在开发中如何选择try {}catch() {}或throws：
		如果希望调用者处理，选择throws上报，其他情况选择try {}catch() {}捕捉 <对于编译时异常>
		使用在代码块中直接使用throw抛出，不用借助与上述的两种方式 <对于运行时异常>
		
	开发中出现异常：
		从上往下看控制台的信息，通过包名确定异常位置，
		注意：不要看SUN公司的，看自己写的代码第一行报错的位置！！！
		
 * @author 13651
 *
 */
public class ExceptionExample {

	public static void main(String[] args) {
		newExceptionObj();
		exceptionDemo1(10, 0);
	}
	
	/**
	 * 通过new对象的形式创建异常对象并打印输出
	 */
	public static void newExceptionObj() {
		// 创建 ArithmeticException 的异常对象
		ArithmeticException arithmeticException = new ArithmeticException("ArithmeticException异常对象创建！");
		// java.lang.ArithmeticException: ArithmeticException异常对象创建！
		System.err.println(arithmeticException);
//		System.err.println(arithmeticException.toString());
		
		// 创建 NullPointerException 异常对象
		NullPointerException nullPointerException = new NullPointerException("NullPointerException异常对象创建！");
		// java.lang.NullPointerException: NullPointerException异常对象创建！
		System.err.println(nullPointerException);
//		System.err.println(nullPointerException.toString());
	}

	/**
	 * 异常是原理
	 * @param a
	 * @param b
	 */
	public static void exceptionDemo1(int a, int b) {
		int c = a / b; // 实际上，JVM在执行到此处时，会new异常对象：new ArithmeticException("/ by zero");并且JVM将异常信息抛出，把信息输出打印至控制台上
		
		System.out.println("c=" + c);
	}
	
}
