package edu.hebeu.annotation;

/**
 * 注解中有属性：
	属性的类型有哪些？
		byte、short、int、long、float、double、boolean、char、String、Class、枚举enum、
		以及上面每种类型的数组形式；
	注意如果使用注解时。
		1、如果注解有属性且该属性没有默认值，就必须要对属性赋值；
		2、属性赋值的形式为： 属性名 = 值(注意值要与属性指定的类型相同);
		3、如果注解中的属性名为value时且注解只有这一个属性时，属性名可以不写，直接赋值，如 "123"，即 值；
 * @author 13651
 *
 */
public @interface MyAnnotation2 {
	
	/**
	 * 这是MyAnnotation2注解的name属性
	 * @return
	 */
	String name();
	
	/**
	 * 这是MyAnnotation2注解的sex属性
	 * @return
	 */
	char sex(); 
	
	/**
	 * 这是MyAnnotation2注解的age属性，默认值为20
	 * @return
	 */
	int age() default 20;
	
}
