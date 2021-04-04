package edu.hebeu.original;

import edu.hebeu.original.house.CommonHouse;
import edu.hebeu.original.house.HighHouse;
import edu.hebeu.original.house.House;

/**
 * ͨ�� ��ͳ�ķ�ʽ ʵ��
 * 
 * ��ȱ�������
 * 	1���ŵ��ǱȽϺ���⣬���ײ�����
 * 	2����Ƶĳ���ṹ�����ڼ򵥣�û����ƻ������󣬳������չ��ά������. Ҳ����˵���������
 * �������Ѳ�Ʒ(��������) �� ������Ʒ�Ĺ���(��������������) ��װ��һ���������ǿ�ˡ�
 * 
 * �������������Ʒ�Ͳ�Ʒ������̽���  =>	������ģʽ.
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		// ������ͨ����
		CommonHouse commonHouse = new CommonHouse();
		commonHouse.build();
		
		System.out.println("-------------------------");
		
		// Ҳ����ͨ�����ֹ��췽ʽ���췿��
		House house = new HighHouse();
		house.build();
	}
}
