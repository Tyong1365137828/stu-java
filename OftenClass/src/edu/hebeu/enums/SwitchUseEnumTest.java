package edu.hebeu.enums;

/**
 * switch语句可以使用enum枚举，也可以使用int、String;			byte, short, boolean, char也都可以使用(但是存在自动类型转换)
 * 低版本的JDK，switch只能使用int
 * @author 13651
 *
 */
public class SwitchUseEnumTest {

	public static void main(String[] args) {
		switch(Season.SUMMER) {
			case SPRING: 
				System.out.println("春");
				break;
			case SUMMER: 
				System.out.println("夏");
				break;
			case AUTUMN:
				System.out.println("秋");
				break;
			case WINTER:
				System.out.println("冬");
				break;
		}
	}

}
