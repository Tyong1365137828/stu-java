package edu.hebeu.resources;

/**
 * �������չʾ���������
 * @author 13651
 *
 */
public class ArrayCopy {
	public static void main(String[] args) {
		int[] srcArray = {1, 5, 1, 8, 9}; // ����Դ����
		int[] destArray = new int[10]; // ����Ŀ������
		/*��������Ŀ�����
		 * ����1������Դ����
		 * ����2����ԭ����ĵڼ����±꿪ʼ����
		 * ����3������Ŀ������
		 * ����4��������Ԫ�ؿ�������Ŀ������ĵڼ����±�
		 * ����5�������ĳ���*/
		System.arraycopy(srcArray, 2, destArray, 4, 2);
		
		for(int i = 0; i < destArray.length; i++) {
			System.out.print(destArray[i] + ", ");
		}
	}
}
