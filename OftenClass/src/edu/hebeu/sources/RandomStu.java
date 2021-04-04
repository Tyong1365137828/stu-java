package edu.hebeu.sources;

import java.util.Random;

/**
 * Random随机数的类学习
 * @author 13651
 *
 */
public class RandomStu {
	public static void main(String[] args) {
		Random random = new Random();
		int a1 = random.nextInt(); // 产生一个int类型的随机数
		System.out.println("a1=" + a1);
		
		int a2 = random.nextInt(101); // 产生一个0-100的int类型随机数(注意没有101)
		System.out.println("a2=" + a2);
		
	}
	
	/**
	 * 在small到big范围内获取num个随机数
	 * @param num
	 * @param small
	 * @param big
	 * @return
	 */
	public int[] getRandomNumbers(int num, int small, int big) {
		int[] array = new int[num];
//		for(int i = 0; i < array.length; i++) {
//			array[i] = -1;
//		}
		
		Random random = new Random();
		int index = 0;
		int whileNum = 0; // 记录循环次数
		while(index < array.length) {
			int temp = random.nextInt(big); // 生成0-big个随机数(不包括big)
			System.out.println("第" + ++whileNum + "次循环，temp=" + temp);
			if(!selectEleByArray(temp, array)) {
				array[index] = temp;
				index++;
			}
			
			if(index == array.length - 1) break;
		}
		
		return array;		
	}

	/**
	 * 查询数组中是否存在某个元素
	 * @param elem
	 * @param array
	 * @return
	 */
	public static boolean selectEleByArray(int elem, int[] array) {
		for(int index = 0; index < array.length; index++) {
			if(elem == array[index]) return true;
		}
		return false;
	}
}
