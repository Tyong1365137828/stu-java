package edu.hebeu.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 这个类用来学习JDK8的新特性之一：Lamda表达式
 * 
 * 须知：
 * 	1、函数式接口：如果接口内只有声明了一个抽象方法，该接口就称为函数式接口；我们可以在定义的函数式接口上添加一个 @FunctionalInterface 注解，
 * 此时如果在编写这个接口出现不符合函数式接口的特点时(如声明了多个抽象方法)，编译器会给出我们相应的提示；
 * 	2、Lamda表达式的本质，作为接口的实例；
 * 
 * 例子：(o1, o2) -> Integer.compare(o1, o2);
 * 如上的格式：
 * 	->： Lamda操作符 或 箭头操作符
 * 	->左边部分：Lamda形参列表(其实就是 函数式接口 中抽象方法的形参列表)
 *  ->右边部分：Lamda方法体(其实就是函数式接口 中重写的抽象方法的方法体)
 *  
 *  Lamda表达式的6种情况：
 *  	1、无参无返回值
 *  	2、有1个参数，无返回值
 *  	3、数据类型可省略，因为可以有编译器推出，称为“类型推断”
 *  	4、Lamda若只需1个参数，参数的小括号可以省略
 *  	5、有2个或2个以上的参数，多条执行语句，且可以有返回值
 *  	6、当Lamda体只有一条语句，且该语句是return时，可以将 return和大括号省略
 *  	总结：
 *  		->左边：Lamda形参列表的参数类型可以省略(类型推断机制)；如果Lamda形参列表只有一个参数，其一对()也可以省略
 *  		->右边：Lamda体应该由一对{}包裹，如果Lamda体只有一条语句时：当该语句是不是return语句，可将{}省略；当该条语句是return语句，可以将{}省略，但是注意：{}省略后，return语句的return关键字必须也要省略
 *			  
 * @author 13651
 *
 */
public class LamdaStu {
	
	/**
	 * Lamda表达式的第一种情况
	 */
	@Test
	public void demo1() {
		/*Runnable runnable = () -> { // 此时Lamda体相当于Runnable函数式接口类的 run()方法的重写
			System.out.println("Demo1执行了...");
		};*/
		// 也可以写成
		Runnable runnable = () -> System.out.println("demo1执行了...");
		
		runnable.run();
	}
	
	/**
	 * Lamda表达式的第二种情况
	 */
	@Test
	public void demo2() {
		Consumer<String> consumer = (String s) -> { // 此时Lamda体就相当于Consumer函数式接口类的accept()方法的重写
			System.out.println("accept()方法执行了");
			System.out.println("s = " + s);
		};
		
		consumer.accept("demo2，你好，Lamda！");
	}
	
	/**
	 * Lamda表达式的第三种情况
	 */
	@Test
	public void demo3() {
		Consumer<String> consumer = (s) -> { // 此时Lamda体就相当于Consumer函数式接口类的accept()方法的重写
			System.out.println("accept()方法执行了");
			System.out.println("s = " + s);
		};
		
		consumer.accept("demo3");
	}
	
	/**
	 * Lamda表达式的第四种情况
	 */
	@Test
	public void demo4() {
		Consumer<String> consumer = s -> { // 此时Lamda体就相当于Consumer函数式接口类的accept()方法的重写
			System.out.println("accept()方法执行了");
			System.out.println("s = " + s);
		};
		
		consumer.accept("demo4");
	}
	
	/**
	 * Lamda表达式的第五种情况
	 */
	@Test
	public void demo5() {
		Comparator<Integer> comparator = (o1, o2) -> {
			System.out.println("demo5，compare方法执行了");
			System.out.println("o1 = " + o1);
			System.out.println("o2 = " + o2);
			return o1 * o2;
		};
		
		Integer comparatorValue = comparator.compare(10,  85);
		System.out.println(comparatorValue);
	}
	
	/**
	 * Lamda表达式的第六种情况
	 */
	@Test
	public void demo6() {
		Comparator<Integer> comparator = (o1, o2) -> o1 * o2;
		
		Integer comparatorValue = comparator.compare(10,  85);
		System.out.println("demo6，compare()方法执行了，comparatorValue = " + comparatorValue);
	}

}
