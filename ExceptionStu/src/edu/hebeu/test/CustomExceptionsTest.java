package edu.hebeu.test;

import edu.hebeu.sources.*;

public class CustomExceptionsTest {

	public static void main(String[] args) {
		/**编译时异常测试*/
		CustomException customException = new CustomException("我的编译时异常");
		// 测试getMessage()方法
		String s1 = customException.getMessage();
		System.out.println(s1);
		// 测试printStackTrace()方法
		customException.printStackTrace();
		
		/**测试运行时异常*/
		CustomRuntimeException customRuntimeException = new CustomRuntimeException("我的运行时异常");
		// 测试getMessage()方法
		String s2 = customRuntimeException.getMessage();
		System.out.println(s2);
		// 测试printStackTrace()方法
		customRuntimeException.printStackTrace();
	}

}
