package edu.hebeu.original;

import edu.hebeu.original.house.CommonHouse;
import edu.hebeu.original.house.HighHouse;
import edu.hebeu.original.house.House;

/**
 * 通过 传统的方式 实现
 * 
 * 优缺点分析：
 * 	1、优点是比较好理解，简单易操作。
 * 	2、设计的程序结构，过于简单，没有设计缓存层对象，程序的扩展和维护不好. 也就是说，这种设计
 * 方案，把产品(即：房子) 和 创建产品的过程(即：建房子流程) 封装在一起，耦合性增强了。
 * 
 * 解决方案：将产品和产品建造过程解耦  =>	建造者模式.
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		// 建造普通房子
		CommonHouse commonHouse = new CommonHouse();
		commonHouse.build();
		
		System.out.println("-------------------------");
		
		// 也可以通过这种构造方式建造房子
		House house = new HighHouse();
		house.build();
	}
}
