package edu.hebeu.test;

import edu.hebeu.sources.*;

public class IntegerMethodsTest {
	public static void main(String[] args) {
		IntegerMethods integerMethods = new IntegerMethods();
		
		/**
		 * 测试Integer类的parseInt()静态方法
		 */
		integerMethods.parseIntTest("123");
//		integerMethods.parseIntTest("中文或英文abcd");
		
		/**
		 * 测试Integer类的toBinaryString()静态方法
		 */
		integerMethods.toBinaryStringTest(50);
		
		/**
		 * 测试Integer类的toHexString()静态方法
		 */
		integerMethods.toHexStringTest(1365137828); // 515e59a4
		integerMethods.toHexStringTest(20001002);
		integerMethods.toHexStringTest(182605);
		System.out.println();
		System.out.println("18000071902101240028182597445728".length());
		
		/**
		 * long类型的赋值，在编译器中输入的数组皆为int类型，可以在数组后面加上L就能将输入变成long进行赋值
		 * long：最好控制在18位内，因为最多可以满足18个9，但是19个9就不行了，所以为了保证任意数字能在有效位数内使用，
		 * 最好在18个9之内；
		 * 
		 * 单号生成的思路：保证生成的单号没有明显的规律，应该将 狭义上固定不变的数据(出生日期、买家账号、卖家账号、商品信息等)与随机数进行搭配，
		 * 并且还要保证随机数能对固定数产生较大的影响，要将随机数放在固定数之；
		 * 将 狭义上会改变的数据(下单时间等)单独提取生成单号
		 * 
		 * 18abef7846071c718abef7846071c727797f26d671c7		44位			18 + 18 + 17 位全为1
		 * de0b6b3a763ffffde0b6b3a763ffff16345785d89ffff	45位			18 + 18 + 17 位全为9
		 * */
//		int randomFirst = ?????; // 在头部加点随机数
		long time = 20190125192605300L; // 4位年 2位月 2位日 2位时 2位分 2位秒 3位毫秒；17位下单日期精确至毫秒		System.out.println("long l1=" + l1 + "; l2=" + l2 + "; l3=" + l3);
		long buy = 136513782820001002L; // 10位卖家账号 + 8位出生日期；18位
		long businessGoods = 292501796600000017L; // 10位商家账号  + 8位商品id；18位
//		int randomLast = ?????; // 在尾部加点随机数	
		String code = Long.toHexString(time) + Long.toHexString(buy) + Long.toHexString(businessGoods);
//		code = code.toUpperCase(); // 将所有的英文变成大写
		System.out.println("code=" + code + "; code的长度为" + code.length()); // 47cd00395de4741e4fe8febee54ea40f2cd59281ae11		44位
		// 47cd0074f8ae741e4fe8febee54ea40f2cd59281ae11		47bacfd8136e741e4fe8febee54ea40f2cd59281ae11
		
		/**
		 * 测试Integer类的toOctalString()静态方法
		 */
		integerMethods.toOctalStringTest(562);
		
		/**
		 * 测试Integer类的valueOf()静态方法
		 */
		integerMethods.valueOfTest(200);
		integerMethods.valueOf("300");
	}
}
