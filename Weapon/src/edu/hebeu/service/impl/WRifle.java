package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;

/**
 * ÎäÆ÷£º²½Ç¹
 * @author 13651
 *
 */
public class WRifle extends Weapon implements Attackable {

	@Override
	public void attack() {
		System.out.println("²½Ç¹Éä»÷£¡");
	}
	
}
