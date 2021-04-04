package edu.hebeu.generic;

/**
 * 自定义泛型
 * 	自定义泛型时 <> 中是一个标识符，随便写;
 * 	泛型 <> 内最常使用的英文是E和T；E表示Element，T表示Type；
 * 
 * @author 13651
 *
 */
public class GenericsCustom<随便写> {
	public void doSome(随便写 t) {
		System.out.println("doSome()方法：" + t);
	}
	
	public 随便写 returnSome(随便写 t) {
		return t;
	}
	
	
	public static void main(String[] args) {
		GenericsCustom<String> gc = new GenericsCustom<>();
//		gc.doSome(210); // 此时编译器会报错
		gc.doSome("泛型学习");
		
//		Integer a = gc.returnSome(200); // 此时编译器会报错
//		int b = gc.returnSome(58); // 此时编译器会报错
//		String c = gc.returnSome(5.8); // 此时编译器会报错
		String d = gc.returnSome("泛型，泛型，泛型");
		System.out.println(d);
		
		
		/**如果定义泛型，但是没有使用，Java会将默认为Object类型*/
		GenericsCustom gc2 = new GenericsCustom();
		gc2.doSome("泛型");
//		String a = gc2.returnSome("你好"); // 此时编译器会报错
//		String b = gc2.returnSome(500); // 此时编译器会报错
//		String c = gc2.returnSome(new Object()); // 此时编译器会报错
		Object o = gc2.returnSome(new Object());
		System.out.println(o);
	}
}
