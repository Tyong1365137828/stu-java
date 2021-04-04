package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * 武器：坦克
 * @author 13651
 *
 */
public class WTank extends Weapon implements Attackable, Moveable {

	@Override
	public void move() {
		System.out.println("坦克前进");
	}

	@Override
	public void attack() {
		System.out.println("坦克攻击！");
	}

}
