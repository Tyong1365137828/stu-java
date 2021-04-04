package edu.hebeu.enums;

/**
 * 枚举：
 * 	1、枚举是一种引用数据类型
 * 	2、枚举类型的定义、语法：
 * 		enum 枚举类名 {
 * 			枚举值1、枚举值2、......
 * 		}
 * 	3、结果只有两者情况的，建议使用boolean类型；结果存在多种情况且能够一枚一枚的列举出来的建议使用枚举；
 * 	4、枚举编译之后也是生成class文件
 * 	5、枚举的每一个值可以看作是常量
 * 	6、可以使用switch语句
 * @author 13651
 *
 */
public class EnumStu {
	
	public static void main(String[] args) {
		Res r = computerNum(10, 2); // 接收返回 enum 类型的方法
		
		System.out.println(r == Res.SUCCESS ? "执行成功" : "执行失败！！！");
	}
	
	/**
	 * 通过 enum 枚举类型来约束方法返回值
	 * @param a
	 * @param b
	 * @return
	 */
	public static Res computerNum(int a, int b) {
		try {
			int c = a / b;
			System.out.println("a / b=" + c);
			
			return Res.SUCCESS;
		} catch(Exception e) {
			System.err.println("已捕捉异常！");
			return Res.FATURE;
		}
	}
	
	/**
	 * 定义枚举
	 */
	enum Res {
		SUCCESS, FATURE
	}
}
