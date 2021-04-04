package edu.hebeu.reflectmethod;

/**
 * 这个例子展示可变长度参数的使用
 * 	语法：
 * 		类型... 名(如 int... args)
 * 	
 * 	1、可变长度的参数要求参数的个数是0-n个；
 * 	2、可变长度参数在参数列表中必须是在最后一个位置上(那么可变长度参数就只能有1个)；
 * 	3、可变长度参数可以当作一个数组来看待；
 * @author 13651
 *
 */
public class VariableLengthOfParameter {
	public static void main(String[] args) {
		m1(); // 可以不传
		m1(13); // 可以传1个
		m1(13, 15, 88, 99); // 可以传多个
//		m1("gsdg"); // 但是不能传入其他类型
				
		m3(2);
		m3(5, "abc");
		m3(9, "abc", "bvf", "sdfsfd", "ryss", "ssfsf");
		
		String[] strings = {"dsdfsf", "gfdfggd", "ddd", "ahadgh", "iqwuiq"};
		m4(strings); // 可以传入一个和可变参数类型一样的数组
		m4(new String[] {"abc", "bvf", "sdfsfd","ddd", "ahadgh", "iqwuiq"}); // 或者直接传入一个匿名数组
		
	}
	
	public static void m1(int... args) {
		System.out.println("m1()执行...");
	}
	
//	public static void m2(int... args, String... strings) {} //错误！可变长度参数只能有一个，且必须在最后一个位置上
//	public static void m2(int...is, String a) {}
	
	public static void m3(int a, String... strings) {
		System.out.println("m3()执行...");
	}
	
	public static void m4(String...strings) {
		// 可变长度参数有length属性，相当于数组
		for(int i = 0; i < strings.length; i++) {
			System.out.print(strings[i]);
			if(i < strings.length - 1) System.out.print(", ");
		}System.out.println();
	}
	
}
