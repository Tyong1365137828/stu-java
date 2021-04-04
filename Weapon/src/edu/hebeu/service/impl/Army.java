package edu.hebeu.service.impl;

import edu.hebeu.exceptions.AddWeaponException;
import edu.hebeu.service.Attackable;
import edu.hebeu.service.Moveable;

/**
 * 军队
 * @author 13651
 *
 */
public class Army {
	private Weapon[] weapons; // 武器数组，用来存储军队的所有武器

	/**
	 * 军队的构造方法
	 * @param count 武器数量
	 */
	public Army(int count) {
		weapons = new Weapon[count]; // 动态初始化数组此时默认值为null
	}
	
	/**
	 * 添加武器至数组
	 * @param weapon
	 */
	public void addWeapon(Weapon weapon) throws AddWeaponException {
		for(int i = 0; i < weapons.length; i++) {
			if(null == weapons[i]) { // 将null的元素添加武器
				weapons[i] = weapon;
				System.out.println(weapon + "添加成功");
				return; // 结束方法
			}
		}
		
		// 如果程序执行到此处，表示武器添加失败
		throw new AddWeaponException("添加武器" + weapon + "失败！");
	}
	
	/**
	 * 所有可以攻击的武器攻击
	 */
	public void attackAll() {
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i] instanceof Attackable) { // 如果该武器是可攻击的
				Attackable attack = (Attackable)weapons[i]; // 将该武器向下转型为可攻击的
				attack.attack(); // 进行攻击
			}
		}
	}
	
	/**
	 * 所有可以移动的武器移动
	 */
	public void moveAll() {
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i] instanceof Moveable) { // 如果该武器是可移动的
				Moveable move = (Moveable)weapons[i]; // 将该武器向下转型为可移动的
				move.move(); // 进行移动
			}
		}
	}
	
	
}
