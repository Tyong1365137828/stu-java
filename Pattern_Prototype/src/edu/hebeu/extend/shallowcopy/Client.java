package edu.hebeu.extend.shallowcopy;

/**
 * ����ʹ��ǳ��¡
 * @author 13651
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Sheep sheep = new Sheep("Ф��", 1, "��ɫ");
		sheep.friendSheep = new Sheep("ϲ����", 1, "��ɫ");
		
		Sheep sheep1 = (Sheep) sheep.clone();
		Sheep sheep2 = (Sheep) sheep.clone();
		Sheep sheep3 = (Sheep) sheep.clone();
		
		/*��ʱ����ͨ��sheepʵ����¡����sheep1��sheep2��sheep3�����hashCode���ǲ�һ���ģ�����
		֤����������������ͨ��sheep��¡�����ģ����������������ڵ�friendSheep����(Sheep��������)
		��hashCode��һ���ģ�˵��������û�п�¡������ֱ�����õ�sheepʵ����friendSheep���Զ�Ӧ��
		ʵ����
		*/
		System.out.println("sheep��" + sheep + "&��" + sheep.hashCode() + "��;friendSheep = " + sheep.friendSheep + "&��" + sheep.friendSheep.hashCode() + "��");
		System.out.println("sheep1��" + sheep + "&��" + sheep1.hashCode() + "��;friendSheep = " + sheep1.friendSheep + "&��" + sheep1.friendSheep.hashCode() + "��");
		System.out.println("sheep2��" + sheep + "&��" + sheep2.hashCode() + "��;friendSheep = " + sheep2.friendSheep + "&��" + sheep2.friendSheep.hashCode() + "��");
		System.out.println("sheep3��" + sheep + "&��" + sheep3.hashCode() + "��;friendSheep = " + sheep3.friendSheep + "&��" + sheep3.friendSheep.hashCode() + "��");
		
	}
}
