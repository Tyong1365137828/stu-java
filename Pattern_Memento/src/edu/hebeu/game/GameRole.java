package edu.hebeu.game;

public class GameRole {

	private int vit;
	private int def;
	
	/**
	 * 创建并返回一个Memento对象(备份)
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(vit, def);
	}
	
	/**
	 * 通过Memento对象恢复当前的信息
	 * @param memento
	 */
	public void recover(Memento memento) {
		vit = memento.getVit();
		def = memento.getDef();
	}
	
	/**
	 * 显示当前角色的状态
	 */
	public void display() {
		System.out.println("攻击力：" + vit + "；防御力：" + def);
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
}
