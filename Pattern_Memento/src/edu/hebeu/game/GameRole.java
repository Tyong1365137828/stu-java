package edu.hebeu.game;

public class GameRole {

	private int vit;
	private int def;
	
	/**
	 * ����������һ��Memento����(����)
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(vit, def);
	}
	
	/**
	 * ͨ��Memento����ָ���ǰ����Ϣ
	 * @param memento
	 */
	public void recover(Memento memento) {
		vit = memento.getVit();
		def = memento.getDef();
	}
	
	/**
	 * ��ʾ��ǰ��ɫ��״̬
	 */
	public void display() {
		System.out.println("��������" + vit + "����������" + def);
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
