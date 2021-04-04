package edu.hebeu.entity;

/**
 * 房间类
 * @author 13651
 *
 */
public class Room {
	private int code; // 房间编号
	private boolean isFree; // 空闲与否
	private String type; // 房间类型
	
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
		if(obj == null || !(obj instanceof Room)) return false; // 如果传入的obj为空或者obj的类型不时room，则返回false
		if(obj == this) return true; // 如果传入的obj与this的地址码相同，即调用equals方法比较的是同一个		
		/**程序到此，表示传入的obj不为空且obj是Room类型*/
		Room room = (Room)obj; // 把传入的obj向下转型为Room
		return room.code == this.getCode(); // 当传入的obj的code与当前Room对象的code相同，返回true，表示同一个房间；反之，返回flase，表示不为同一个房间；
	}
	
	@Override
	public String toString() {
		return "Room [code=" + code + ", isFree=" + (isFree ? "空闲" : "占用") + ", type=" + type + "]";
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
