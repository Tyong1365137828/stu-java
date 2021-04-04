package edu.hebeu.sources;

import java.util.Random;

/**
 * Random���������ѧϰ
 * @author 13651
 *
 */
public class RandomStu {
	public static void main(String[] args) {
		Random random = new Random();
		int a1 = random.nextInt(); // ����һ��int���͵������
		System.out.println("a1=" + a1);
		
		int a2 = random.nextInt(101); // ����һ��0-100��int���������(ע��û��101)
		System.out.println("a2=" + a2);
		
	}
	
	/**
	 * ��small��big��Χ�ڻ�ȡnum�������
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
		int whileNum = 0; // ��¼ѭ������
		while(index < array.length) {
			int temp = random.nextInt(big); // ����0-big�������(������big)
			System.out.println("��" + ++whileNum + "��ѭ����temp=" + temp);
			if(!selectEleByArray(temp, array)) {
				array[index] = temp;
				index++;
			}
			
			if(index == array.length - 1) break;
		}
		
		return array;		
	}

	/**
	 * ��ѯ�������Ƿ����ĳ��Ԫ��
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
