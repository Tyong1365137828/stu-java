package edu.hebeu.test;

import edu.hebeu.annotation.MyAnnotation2;
import edu.hebeu.annotation.MyAnnotation3;

public class MyAnnotation2Test {
	public static void main(String[] args) {
		
		
		
	}
}

class UseMyAnnotation2 {
	
	/**
	 * 注意如果使用注解时。
	 * 如果注解有属性且该属性没有默认值，就必须要对属性赋值；
	 * 属性赋值的形式为： 属性名 = 值(注意值要与属性指定的类型相同);
	 * 
	 * 当属性为数组类型时：
	 * 		当给该属性赋值时，形式为：属性名 = {值1, 值2, 值3, ...};
	 * 		当该属性赋值只有1个值的时候，大括号可以省略，如：属性名 = 值1
	 * 如下所示：
	 */
	@MyAnnotation2(name = "tyong", sex = '男')
	public void doSome() {
		System.out.println("doSome...");
	}
	
	/**
	 * 注意：如果注解中的属性名为value时且注解只有这一个属性时，属性名可以不写，直接赋值，如 "123"，即 值；
	 * 如下所示：
	 */
	@MyAnnotation3("value的值")
	public void doOther() {
		System.out.println("doOther...");
	}
	
}
