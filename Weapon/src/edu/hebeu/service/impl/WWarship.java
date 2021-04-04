package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * 武器：战舰
 * @author 13651
 *
 */
public class WWarship extends Weapon implements Attackable, Moveable {

	@Override
	public void move() {
		System.out.println("战舰移动");
	}

	@Override
	public void attack() {
		System.out.println("战舰开炮！");
	}

}
