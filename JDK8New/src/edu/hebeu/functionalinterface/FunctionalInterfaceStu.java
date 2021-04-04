package edu.hebeu.functionalinterface;

/**
 * 这个类用来学习JDK8的型特性之一：函数式接口
 * Java内置的四个核心函数式接口：
 * 	函数式接口						参数类型		返回类型		用途
 * 	Consumer<T>消费型接口			  T			 void		对类型为T的对象应用操作，包含方法 void accept(T t)
 * 	Supplier<T>供给型接口			   无			 T			返回类型为T的对象，包含方法：T get()
 * 	Function<T, R>函数型接口			  T			 R			对类型为T 的对象应用操作，并返回结果，结果是R类型的对象，包含方法：R apply(T t)
 * 	Predicate<T>断定型接口			  T			 boolean	确定类型为T 的对象是否满足某约束，并返回boolean值，包含方法：boolean test(T t)
 * @author 13651
 *
 */
public class FunctionalInterfaceStu {

}
