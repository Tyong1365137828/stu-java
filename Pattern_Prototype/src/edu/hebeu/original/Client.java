package edu.hebeu.original;

/**
 * �������ʹ�� ��ͳ��ʽ �����¡�����⣻
 * 
 * ��ȱ�������
 * 	1���ŵ��ǱȽϺ���⣬���ײ�����
 *	2���ڴ����µĶ���ʱ��������Ҫ���»�ȡԭʼ��������ԣ���������Ķ���Ƚϸ���ʱ��Ч�ʽϵ�
 *	3��������Ҫ���³�ʼ�����󣬶����Ƕ�̬�ػ�ö�������ʱ��״̬, �������
 *
 *	�����Java �� Object ����������ĸ��࣬Object ���ṩ��һ�� clone()�������÷������Խ�һ��
 * Java ������һ�ݣ�������Ҫʵ�� clone �� Java �����Ҫʵ��һ���ӿ� Cloneable���ýӿڱ�ʾ��
 * ���ܹ������Ҿ��и��Ƶ�����  =>ԭ��ģʽ
 * 
 * @author 13651
 *
 */
public class Client {
	public static void main(String[] args) {
		
		Sheep tomSheep = new Sheep("tom", 1, "��ɫ");

		//��ͳ�ķ���
		Sheep tomSheep1 = new Sheep(tomSheep.getName(), tomSheep.getAge(), tomSheep.getColor()); 
		Sheep tomSheep2 = new Sheep(tomSheep.getName(), tomSheep.getAge(), tomSheep.getColor()); 
		Sheep tomSheep3 = new Sheep(tomSheep.getName(), tomSheep.getAge(), tomSheep.getColor());
		// ...
		
		System.out.println(tomSheep);
		System.out.println(tomSheep1);
		System.out.println(tomSheep2);
		System.out.println(tomSheep3);
		// ...
	}
}
