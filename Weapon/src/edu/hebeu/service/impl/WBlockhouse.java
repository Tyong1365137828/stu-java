package edu.hebeu.service.impl;

import edu.hebeu.service.Attackable;

/**
 * ÎäÆ÷£ºµï±¤
 * @author 13651
 *
 */
public class WBlockhouse extends Weapon implements Attackable {
	@Override
	public void attack() {
		System.out.println("µï±¤Éä»÷£¡");
	}
}
