package edu.hebeu.service.impl;

import edu.hebeu.exceptions.AddWeaponException;
import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * ����
 * @author 13651
 *
 */
public class Army {
	private Weapon[] weapons; // �������飬�����洢���ӵ���������

	/**
	 * ���ӵĹ��췽��
	 * @param count ��������
	 */
	public Army(int count) {
		weapons = new Weapon[count]; // ��̬��ʼ�������ʱĬ��ֵΪnull
	}
	
	/**
	 * �������������
	 * @param weapon
	 */
	public void addWeapon(Weapon weapon) throws AddWeaponException {
		for(int i = 0; i < weapons.length; i++) {
			if(null == weapons[i]) { // ��null��Ԫ���������
				weapons[i] = weapon;
				System.out.println(weapon + "��ӳɹ�");
				return; // ��������
			}
		}
		
		// �������ִ�е��˴�����ʾ�������ʧ��
		throw new AddWeaponException("�������" + weapon + "ʧ�ܣ�");
	}
	
	/**
	 * ���п��Թ�������������
	 */
	public void attackAll() {
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i] instanceof Attackable) { // ����������ǿɹ�����
				Attackable attack = (Attackable)weapons[i]; // ������������ת��Ϊ�ɹ�����
				attack.attack(); // ���й���
			}
		}
	}
	
	/**
	 * ���п����ƶ��������ƶ�
	 */
	public void moveAll() {
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i] instanceof Moveable) { // ����������ǿ��ƶ���
				Moveable move = (Moveable)weapons[i]; // ������������ת��Ϊ���ƶ���
				move.move(); // �����ƶ�
			}
		}
	}
	
	
}
