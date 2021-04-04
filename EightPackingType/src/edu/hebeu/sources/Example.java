package edu.hebeu.sources;

public class Example {
	public static void main(String[] args) {
		Integer integer = new Integer(123); // 将 123 这个int基本数据类型转换为Integer引用数据类型(手动装箱)
		Float floa = new Float(236); // 将 236 这个int基本数据类型转换为Float引用数据类型(手动装箱)
		float f = integer.floatValue(); // 将Integer引用数据类型转换为float基本数据类型(手动拆箱)
		int a = integer.intValue(); // 将Integer引用数据类型转换为int基本数据类型(手动拆箱)
		byte bytee = floa.byteValue(); // 将Float引用数据类型转换为byte基本数据类型(手动拆箱)
		System.out.println("integer=" + integer + "; floa=" + floa + "; f=" + f + "; a=" + a + "; bytee=" + bytee);
		
		/**自jdk1.5之后，支持自动装箱和自动拆箱了*/
		Integer integer2 = 100; // 自动装箱
		int b = integer2; // 自动拆箱
		
		/**
		 * 构造方法，可以传入一个该包装类型的数据或者一个字符串<字符串必须是能够转换为数字的形式>
		 */
//		Integer integerr = new Integer(567);
		Integer integerr = new Integer("56565"); // 可以转换为数字
//		Integer integerr = new Integer("8855.6"); // 不能转换为数字<编译没问题，运行出问题>
//		Integer integerr = new Integer("dds测试"); // 不能转换为数字<编译没问题，运行出问题>
		System.out.println(integerr);
		
//		Double doublee = new Double(3.14);
//		Double doublee = new Double("sss"); // 不能转化为数字，会报错<编译没问题，运行出问题>
		Double doublee = new Double("1589"); // 可以转换为数字
		System.out.println(doublee);
		
		/**通过常量可以自动获取最大值和最小值*/
		System.out.println(Integer.MAX_VALUE); // 获取Integer的最大值
		System.out.println(Integer.MIN_VALUE); // 获取Integer的最小值
		System.out.println(Byte.MAX_VALUE); // 获取Byte的最大值
		System.out.println(Byte.MIN_VALUE); // 获取Byte的最小值
		
		
		/**整数型常量池概念的引入*/
		Integer a1 = 128;
		Integer a2 = 128;
		System.out.println(a1 == a2); // false
		
		Integer b1 = 127;
		Integer b2 = 127;
		System.out.println(b1 == b2); // true
		/**面试：
		 * Java中为了提高效率，在方法区内存在一个整数型常量池，这个池中有256个Integer对象(-128到127)，这些对象随着类加
		 * 载而加载，即用户在使用Integer时会加载，如果用户创建的Integer类型数据在 -128到127之间，就不会再堆中开辟空间，
		 * 而是直接使用该池的数据；反之，就要在堆中创建新的Integer对象
		 * 
		 * 上述的几行代码中之所以出现那种情况：因为 == 运算符在比较对象、引用数据类型时，永远比较的所示内存地址，128不在
		 * -128到127之间，所以会在堆内存中开辟空间；127在 -128到127之间，所以不会再堆中开辟空间；在对象中存储的是引用的
		 * 内存地址，所以，a1和a2因为不在 -127到127 之间而使用的是在堆中新建的两个Integer对象地址；b1和b2因为在 -128到127 
		 * 之间而使用的是在方法区内的整数型常量池中的地址，因此会出现false、true
		 */
	}
}
