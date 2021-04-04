package edu.hebeu.game;

/**
 * 进行备份的类
 * @author 13651
 *
 */
public class Memento {
	
	private int vit; // 攻击力
	private int def; // 防御力
	
	public Memento(int vit, int def) {
		super();
		this.vit = vit;
		this.def = def;
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
