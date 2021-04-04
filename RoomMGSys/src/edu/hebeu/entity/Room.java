package edu.hebeu.entity;

/**
 * ������
 * @author 13651
 *
 */
public class Room {
	private int code; // ������
	private boolean isFree; // �������
	private String type; // ��������
	
	public Room() {
		super();
	}
	
	public Room(int code, boolean isFree, String type) {
		super();
		this.code = code;
		this.isFree = isFree;
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Room)) return false; // ��������objΪ�ջ���obj�����Ͳ�ʱroom���򷵻�false
		if(obj == this) return true; // ��������obj��this�ĵ�ַ����ͬ��������equals�����Ƚϵ���ͬһ��		
		/**���򵽴ˣ���ʾ�����obj��Ϊ����obj��Room����*/
		Room room = (Room)obj; // �Ѵ����obj����ת��ΪRoom
		return room.code == this.getCode(); // �������obj��code�뵱ǰRoom�����code��ͬ������true����ʾͬһ�����䣻��֮������flase����ʾ��Ϊͬһ�����䣻
	}
	
	@Override
	public String toString() {
		return "Room [code=" + code + ", isFree=" + (isFree ? "����" : "ռ��") + ", type=" + type + "]";
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public boolean isFree() {
		return isFree;
	}
	
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}	
	
}
