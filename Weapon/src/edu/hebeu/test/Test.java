package edu.hebeu.test;

import edu.hebeu.exceptions.AddWeaponException;
import edu.hebeu.service.impl.Army;
import edu.hebeu.service.impl.WBlockhouse;
import edu.hebeu.service.impl.WFighterPlane;
import edu.hebeu.service.impl.WRifle;
import edu.hebeu.service.impl.WTank;
import edu.hebeu.service.impl.WTransportPlane;
import edu.hebeu.service.impl.WWarship;

/**
 * 测试
 * @author 13651
 *
 */
public class Test {
	public static void main(String[] args) {
		// 创建军队，该军队可以装备6种武器
		Army army = new Army(6);
		
		try {
			army.addWeapon(new WBlockhouse());
			army.addWeapon(new WFighterPlane());
			army.addWeapon(new WRifle());
			army.addWeapon(new WTank());
			army.addWeapon(new WTransportPlane());
			army.addWeapon(new WWarship());
			// 添加第7个武器会异常
			army.addWeapon(new WBlockhouse());
		} catch (AddWeaponException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
		
		army.moveAll(); // 军队移动(所有可移动的武器移动)
		army.attackAll(); // 军队攻击(所有可攻击的武器攻击)
	}
}
