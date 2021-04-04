package edu.hebeu.sources;

/**
 * JDK1.5
 * 本例演示自动装箱和自动拆箱何时触发，并由此引出他们的好处
 * 
 * 自动装箱拆箱的好处：
 * 		自动拆箱引入后，就可以不用调用Number内的方法进行拆箱了；
 * @author 13651
 *
 */
public class PackingAndUnpackin {
	public static void main(String[] args) {
		Integer x = 100; // 自动装箱(int基本数据类型包装为Integer引用数据类型)，等同于 Integer x = new Integer(100);
		float f = x; // 自动拆箱(Integer引用数据类型拆分为float基本数据类型)，等同于 float f = x.floatValue();
		System.out.println("x=" + x + "; f=" + f);
		
		Integer a = 1000;
		Integer b = 1000;
		System.out.println(a == b); // false
		/**可见 == 运算符是不能触发自动拆箱机制的*/
		
		/**
		 * 结论： == 运算符比较对象、引用时，比较的时内存地址
		 * 		 == 运算符不会触发自动拆箱机制(只有 +、-、*、/等运算符时才会触发)
		 */
	}
}
