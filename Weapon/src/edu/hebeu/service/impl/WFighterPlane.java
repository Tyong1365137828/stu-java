package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * 武器：战斗机
 * @author 13651
 *
 */
public class WFighterPlane extends Weapon implements Attackable, Moveable{

	@Override
	public void move() {
		System.out.println("战斗机起飞");
	}

	@Override
	public void attack() {
		System.out.println("战斗机攻击！");
	}

}
