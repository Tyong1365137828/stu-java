package edu.hebeu.test;

import edu.hebeu.utils.*;

public class UtilsTest {
	public static void main(String[] args) {
		
//		int[] array = {11, 2, 9, 0, 55, 80, 99, 30, 56, 87, 6, 3, 8, 2, 100};
//		System.out.println("��ʼ���飺"); Utils.printArrays(array);
		
//		Utils.bubblingSort(array); // ����ð�������㷨�������������
//		System.out.println("ð������֮�����飺"); Utils.printArrays(array);
		
//		Utils.selectSort(array);
//		System.out.println("ѡ������֮�����飺"); Utils.printArrays(array);
		
//		int[] array = {1, 5, 9, 12, 88, 99, 100, 100, 100, 100, 556, 668, 669, 700, 702, 800, 805, 890, 900, 950};
//		int searchElement = 668; // ���ҵ�Ԫ��
//		int subScript = Utils.dichotomySelect(array, searchElement);
//		System.out.println(subScript == -1 ? "δ�ҵ�Ҫ���ҵ�" + searchElement + "Ԫ��" : "Ҫ���ҵ�" + searchElement + "Ԫ��������ĵ�" + subScript + "�±���");
		
		
		int[] array = {1, 2, 5, 8, 1};
		System.out.println(array[100]);
		
		
//		userArray();
	}
	
	/**
	 * �������չʾ��ζ���ʹ������
	 */
	public static void userArray() {
		// ���巽ʽ1
//		int[] array = new int[]{1, 2, 3, 8, 9};
		// ���巽ʽ2
//		int[] array = {1, 2, 5, 9};
		// ���巽ʽ3(��̬������Ĭ��ֵ�����������������Ͷ�Ӧ�Ĵ�������0��null����)
		int[] array = new int[5];
		array[0] = 5;
		array[1] = 88999;
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
