package edu.hebeu.utils;

public class Utils {
	
	/**
	 * ð������:ÿ��ʹ�õ�ǰ������a�뵱ǰ���ݵĺ�һ������b�Ƚϣ����a > b, �򽻻�����֮��������
	 * ��һ��ѭ�����������ұߵ�ֵ���Ǳ������ڵ����ֵ���ڽ���֮���ѭ�����Ƚ����������ݣ�
	 * ��˽�������Դ��ŷ����Ҳ࣬ʵ�ִ����ҵĴ�С������������
	 * 
	 * �磬ԭʼ����Ϊ��{1, 5, 8, 0, 99, 52, 31}
	 * ��һ��ѭ����
	 * 		��һ�αȽϣ�"1", "5", 8, 0, 99, 52, 31	(1 < 5, ������)
	 *  	�ڶ��αȽϣ�1, "5", "8", 0, 99, 52, 31	(5 < 8, ������)
	 *  	�����αȽϣ�1, 5, "8", "0", 99, 52, 31	(8 > 0, ����)
	 *  	���ĴαȽϣ�1, 5, 0, "8", "99", 52, 31	(8 < 99, ������)
	 *  	����αȽϣ�1, 5, 0, 8, "99", "52", 31	(99 > 52, ����)
	 *  	�����αȽϣ�1, 5, 0, 8, 52, "99", "31"	(99 > 31, ����)
	 *  ��һ��ѭ���ȽϵĽ����{1, 5, 0, 8, 52, 31, 99}
	 *  
	 * ��ʱ���Ƚϵ����ݣ�{1, 5, 0, 8, 52, 31}
	 * �ڶ���ѭ����
	 * 		��һ�αȽϣ�"1", "5", 0, 8, 52, 31	(1 < 5, ������)
	 * 		�ڶ��αȽϣ�1, "5", "0", 8, 52, 31	(5 > 0, ����)
	 * 		�����αȽϣ�1, 0, "5", "8", 52, 31	(5 < 8, ������)
	 * 		���ĴαȽϣ�1, 0, 5, "8", "52", 31	(8 < 52, ������)
	 * 		����αȽϣ�1, 0, 5, 8, "52", "31"	(52 > 31, ����)
	 * 	�ڶ���ѭ���ȽϵĽ����{1, 0, 5, 8, 31, 52}
	 * 
	 * ��ʱ���Ƚϵ����ݣ�{1, 0, 5, 8, 31}
	 * ������ѭ����
	 * 		��һ�αȽϣ�"1", "0", 5, 8, 31	(1 > 0, ����)
	 * 		�ڶ��αȽϣ�0, "1", "5", 8, 31	(1 < 5, ������)
	 * 		�����αȽϣ�0, 1, "5", "8", 31	(5 < 8, ������)
	 * 		���ĴαȽϣ�0, 1, 5, "8", "31"	(8 < 31, ������)
	 * 	������ѭ���ȽϵĽ����{0, 1, 5, 8, 31}
	 * 
	 * ��ʱ���Ƚϵ����ݣ�{0, 1, 5, 8}
	 * ���Ĵ�ѭ����
	 * 		��һ�αȽϣ�"0", "1", 5, 8	(0 < 1, ������)
	 * 		�ڶ��αȽϣ�"0", "1", 5, 8	(0 < 1, ������)
	 * 		�����αȽϣ�"0", "1", 5, 8	(0 < 1, ������)
	 * 	���Ĵ�ѭ���ȽϵĽ����{0, 1, 5, 8}
	 * 
	 * ��ʱ���Ƚϵ����ݣ�{0, 1, 5}
	 * �����ѭ����
	 * 		��һ�αȽϣ�"0", "1", 5	(0 < 1, ������)
	 * 		�ڶ��αȽϣ�0, "1", "5"	(1 < 5, ������)
	 * 	�����ѭ���Ƚ϶�����{0, 1, 5}
	 * 
	 * ��ʱ���Ƚϵ����ݣ�{0, 1}
	 * ������ѭ����
	 * 		��һ�αȽϣ�"0", "1"	(0 < 1, ������)
	 * 	������ѭ���ȽϵĽ����{0, 1}
	 * 
	 * ���Ϸ�����ð�������㷨������ (����ĳ��� - 1) ��ѭ����ÿ��ѭ�������� (���鳤�� - ��ǰѭ���Ĵ���) �αȽ�
	 * 
	 * ������������{0, 1, 5, 8, 31, 52, 99}
	 * @param array
	 */
	public static void bubblingSort(int[] array) {
		for(int i = array.length - 1; i > 0; i--) { // ���� (���鳤�� - 1) ��ѭ��
			for(int j = 0; j < i; j++) { // ��ǰѭ������ (���鳤�� - ��ǰѭ������) �αȽ�
				int temp = 0;
				if(array[j] > array[j + 1]) { // �����ǰ��Ԫ�ر����һ��Ԫ�ش�
					/*���н���*/
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	/**
	 * ѡ������ÿ�δӴ�������������ҵ�ֵ��С�����ݣ�������������������ݵ���������ݽ��н�����ֱ����ߵ����ݶ������Ƚ�
	 * �����ð������ѡ�������Ч�ʸ��ߣ����ڽ��������ϣ���Ϊѡ������ÿ�εĽ��������������
	 * 
	 * �磺ԭʼ����Ϊ��{0, 5, 88, 3, 6, 7}
	 * ��һ��ѭ����"0", 5, 88, 3, 6, 7	(����ߵ�����Ϊ0�����±�Ϊ0����С����Ϊ0�����±�Ϊ0�����н���)
	 * 	��һ��ѭ�������{0, 5, 88, 3, 6, 7}
	 * 
	 * ��ʱ�����������Ϊ��{5, 88, 3, 6, 7}
	 * �ڶ���ѭ����5, 88, "3", 6, 7	(���������Ϊ5�����±�Ϊ1����С����Ϊ3�����±�Ϊ3�����н���)
	 * 	�ڶ���ѭ�������{3, 88, 5, 6, 7}
	 * 
	 * ��ʱ����������Ϊ��{88, 5, 6, 7}
	 * ������ѭ����88, "5", 6, 7	(���������Ϊ88����С��Ϊ2����С����Ϊ5����С��Ϊ3�����н���)
	 * 	������ѭ�������{5, 88, 6, 7}
	 * 
	 * ��ʱ����������Ϊ��{88, 6, 7}
	 * ���Ĵ�ѭ����88, "6", 7	(���������Ϊ88�����±�Ϊ3����С����Ϊ6�����±�Ϊ4�����н���)
	 * 	���Ĵ�ѭ�������{6, 88, 7}
	 * 
	 * ��ʱ����������Ϊ��{88, 7}
	 * �����ѭ����88, "7"	(���������Ϊ88�����±�Ϊ4����С����Ϊ7�����±�Ϊ5�����н���)
	 * �����ѭ�������{7, 88}
	 * 
	 * ���ս�����������Ҵ�С����Ϊ��{0, 3, 5, 6, 7, 88}
	 * 
	 * �����������������ݵ���������ݵ��±����ͨ��forѭ��ȡ����
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) { // ��ȡ������������ߵ��±�
			
			int minSubScript = i; // ������������Сֵ���±�,����Ϊ��ǰ���������ݵ�������±�Ϊi(�������������������±�ֵ���Ǵ�������Ԫ����Сֵ���±�)
			for(int j = i + 1; j < array.length; j++) { // ����������������������ݵ��������ݣ�����ѡ����Сֵ���±�
//				System.out.println("array[j]=" + array[j]);
//				System.out.println("array[minSubScript]=" + array[minSubScript]);
				if(array[j] < array[minSubScript]) { // �����Ԫ��С��������������ߵ����ݣ�������ʧ�ܣ�����С�±��޸�Ϊ��Ԫ��
					minSubScript = j;
				}
			}			
//			System.out.println("������±�=" + i);
//			System.out.println("minSubScript=" + minSubScript);
			
			/**ʵ�ִ�����������Сֵ����������������ֵ���н���*/
			if(minSubScript != i) { // �����Сֵ���±겻�����������������Ԫ��i���������Ԫ��i����СԪ��minSubScript���н���
				int temp = 0;
				temp = array[minSubScript];
				array[minSubScript] = array[i];
				array[i] = temp;
			}
		}
	}
	
	/**
	 * ���ֲ���(�۰����)���������������ǰ����(������������)��ͨ�� �м��±��ֵ �� ����ѯ��Ԫ��ֵ ���бȽϣ��� ����ѯ������ һ��Ϊ����
	 *
	 * ��� �м�Ԫ�ص�ֵ > ����ѯԪ��ֵ�����ʾ ����ѯ��Ԫ�����м�Ԫ�ص���ߣ�
	 * 		��ʼ�±겻�䣬�����±����м��±� - 1���м��±���(��ʼ�±� + �����±�) / 2
	 * 		��ʱӦ�ö���ߵ�������������ķ�����
	 * ��� �м�Ԫ�ص�ֵ < ����ѯԪ��ֵ�����ʾ ����ѯ��Ԫ�����м�Ԫ�ص��ұߣ�
	 * 		��ʼ�±����м��±� + 1�������±겻�䣬�м��±���(��ʼ�±� + �����±�) / 2
	 * 		��ʱӦ�ö��ұߵ�������������ķ�����
	 * 
	 * ����������һ��startSubScript��ʼ�±��ʼΪ0��endSubScript�����±��ʼΪ����ĳ��� - 1���м��±�midSubScript��ʼΪ(��ʼ�±� + �����±�) / 2
	 * @param array ����ѯ������
	 * @param dest ����ѯֵ
	 * @return ���ز�ѯ�����±꣬��� >= 0, ���ʾ�ҵ��˴�Ԫ�ص��±ꣻ��� == -1, ��ʾδ�ҵ���Ԫ��
	 */
	public static int dichotomySelect(int[] array, int dest) {
		int startSubScript = 0; // ��ʼ�±�
		int endSubScript = array.length - 1; // �����±�
		
		while(startSubScript <= endSubScript) { // �����ʼ�±�С�ڻ��ߵ��ڽ����±꣬����ʾ�����Ѿ��з����ˣ���ʱ�ͽ���ѭ��Ҳ�ʹ�����û���ҵ�Ҫ��ѯ��Ԫ��
			int midSubScript = (startSubScript + endSubScript) / 2; // �м��±�
			if(array[midSubScript] == dest) { // ����м��±��ֵ����Ҫ���ҵ�Ԫ��ֵ�����ҵ��˴�Ԫ��
				return midSubScript; // ���ش��±�
			} else if(array[midSubScript] > dest) { // ����м��±��ֵ����Ҫ���ҵ�Ԫ��ֵ����Ҫ���ҵ�Ԫ�����м��±�����
//				System.out.println("�����");
				endSubScript = midSubScript - 1; // �������±����м��±� - 1
			} else if(array[midSubScript] < dest) { // ����м��±��ֵС��Ҫ���ҵ�Ԫ��ֵ����Ҫ���ҵ�Ԫ�����м��±���ұ�
//				System.out.println("���ұ�");
				startSubScript = midSubScript + 1; // ����ʼ�±����м��±� + 1
			}			
		}
		
		/**���򵽴˱�ʾδ�ҵ�Ҫ���ҵ�Ԫ��*/
		return -1;
	}
	
	/**
	 * ��ӡ���鷽��
	 * @param array
	 */
	public static void printArrays(int[] array) {
		System.out.print("[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}