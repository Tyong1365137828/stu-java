package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * ������̹��
 * @author 13651
 *
 */
public class WTank extends Weapon implements Attackable, Moveable {

	@Override
	public void move() {
		System.out.println("̹��ǰ��");
	}

	@Override
	public void attack() {
		System.out.println("̹�˹�����");
	}

}
