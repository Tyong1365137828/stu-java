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
 * ����
 * @author 13651
 *
 */
public class Test {
	public static void main(String[] args) {
		// �������ӣ��þ��ӿ���װ��6������
		Army army = new Army(6);
		
		try {
			army.addWeapon(new WBlockhouse());
			army.addWeapon(new WFighterPlane());
			army.addWeapon(new WRifle());
			army.addWeapon(new WTank());
			army.addWeapon(new WTransportPlane());
			army.addWeapon(new WWarship());
			// ��ӵ�7���������쳣
			army.addWeapon(new WBlockhouse());
		} catch (AddWeaponException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
		
		army.moveAll(); // �����ƶ�(���п��ƶ��������ƶ�)
		army.attackAll(); // ���ӹ���(���пɹ�������������)
	}
}
