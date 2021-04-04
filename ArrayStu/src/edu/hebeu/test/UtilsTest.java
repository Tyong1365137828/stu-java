package edu.hebeu.test;

import edu.hebeu.utils.*;

public class UtilsTest {
	public static void main(String[] args) {
		
//		int[] array = {11, 2, 9, 0, 55, 80, 99, 30, 56, 87, 6, 3, 8, 2, 100};
//		System.out.println("初始数组："); Utils.printArrays(array);
		
//		Utils.bubblingSort(array); // 调用冒泡排序算法对数组进行排序
//		System.out.println("冒泡排序之后数组："); Utils.printArrays(array);
		
//		Utils.selectSort(array);
//		System.out.println("选择排序之后数组："); Utils.printArrays(array);
		
//		int[] array = {1, 5, 9, 12, 88, 99, 100, 100, 100, 100, 556, 668, 669, 700, 702, 800, 805, 890, 900, 950};
//		int searchElement = 668; // 查找的元素
//		int subScript = Utils.dichotomySelect(array, searchElement);
//		System.out.println(subScript == -1 ? "未找到要查找的" + searchElement + "元素" : "要查找的" + searchElement + "元素在数组的第" + subScript + "下标中");
		
		
		int[] array = {1, 2, 5, 8, 1};
		System.out.println(array[100]);
		
		
//		userArray();
	}
	
	/**
	 * 这个方法展示如何定义使用数组
	 */
	public static void userArray() {
		// 定义方式1
//		int[] array = new int[]{1, 2, 3, 8, 9};
		// 定义方式2
//		int[] array = {1, 2, 5, 9};
		// 定义方式3(动态创建，默认值根据数组声明的类型对应的创建，如0、null、等)
		int[] array = new int[5];
		array[0] = 5;
		array[1] = 88999;
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
