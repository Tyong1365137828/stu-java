package edu.hebeu.service.impl;

import edu.hebeu.service.Moveable;

/**
 * �����������
 * @author 13651
 *
 */
public class WTransportPlane  extends Weapon implements Moveable {

	@Override
	public void move() {
		System.out.println("��������");
	}

}
