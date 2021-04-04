package edu.hebeu.annotation;

/**
 * 这个例子展示Override注解的使用和作用；
 * 	
 * 	在 java.lang包下的注解；
 * 
 * 	源代码：
 * 		public @interface Override {
 * 		}
 * 
 * 	1、Override这个注解只能注解方法；
 * 	2、Override这个注解只能给编译器参考，和运行阶段没有关系；
 * 	3、凡是在Java中的方法带有这个注解，编译器对注解的方法会进行编译检查，如果这个方法不是重写父类的方法，编译器会报错；
 * 
 * 	由此可见Override这个注解是为了防止程序员在重写父类方法时出错，是标识性注解；
 * 	
 * @author 13651
 *
 */
public class OverrideAnnotation {

}
