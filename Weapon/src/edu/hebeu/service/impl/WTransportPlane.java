package edu.hebeu.service.impl;

import edu.hebeu.service.Moveable;

/**
 * 武器：运输机
 * @author 13651
 *
 */
public class WTransportPlane  extends Weapon implements Moveable {

	@Override
	public void move() {
		System.out.println("运输机起飞");
	}

}
