package edu.hebeu.sources;

/**
 * JDK1.5
 * ������ʾ�Զ�װ����Զ������ʱ���������ɴ��������ǵĺô�
 * 
 * �Զ�װ�����ĺô���
 * 		�Զ���������󣬾Ϳ��Բ��õ���Number�ڵķ������в����ˣ�
 * @author 13651
 *
 */
public class PackingAndUnpackin {
	public static void main(String[] args) {
		Integer x = 100; // �Զ�װ��(int�����������Ͱ�װΪInteger������������)����ͬ�� Integer x = new Integer(100);
		float f = x; // �Զ�����(Integer�����������Ͳ��Ϊfloat������������)����ͬ�� float f = x.floatValue();
		System.out.println("x=" + x + "; f=" + f);
		
		Integer a = 1000;
		Integer b = 1000;
		System.out.println(a == b); // false
		/**�ɼ� == ������ǲ��ܴ����Զ�������Ƶ�*/
		
		/**
		 * ���ۣ� == ������Ƚ϶�������ʱ���Ƚϵ�ʱ�ڴ��ַ
		 * 		 == ��������ᴥ���Զ��������(ֻ�� +��-��*��/�������ʱ�Żᴥ��)
		 */
	}
}
