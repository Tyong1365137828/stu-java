package edu.hebeu.enums;

/**
 * switch������ʹ��enumö�٣�Ҳ����ʹ��int��String;			byte, short, boolean, charҲ������ʹ��(���Ǵ����Զ�����ת��)
 * �Ͱ汾��JDK��switchֻ��ʹ��int
 * @author 13651
 *
 */
public class SwitchUseEnumTest {

	public static void main(String[] args) {
		switch(Season.SUMMER) {
			case SPRING: 
				System.out.println("��");
				break;
			case SUMMER: 
				System.out.println("��");
				break;
			case AUTUMN:
				System.out.println("��");
				break;
			case WINTER:
				System.out.println("��");
				break;
		}
	}

}
