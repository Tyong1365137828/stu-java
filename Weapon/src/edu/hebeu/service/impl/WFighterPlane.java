package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * ������ս����
 * @author 13651
 *
 */
public class WFighterPlane extends Weapon implements Attackable, Moveable{

	@Override
	public void move() {
		System.out.println("ս�������");
	}

	@Override
	public void attack() {
		System.out.println("ս����������");
	}

}
