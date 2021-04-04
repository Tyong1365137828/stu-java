package edu.hebeu.entity;

import java.util.Arrays;

/**
 * 酒店类
 * @author 13651
 *
 */
public class Hotel {
	private Room[][] rooms; // 所有的房间

	public Hotel(Room[][] rooms) {
		super();
		this.rooms = rooms;
	}

	public Hotel() {
		rooms = new Room[5][10]; // 创建一个4层，每层10个房间的酒店
		
		for(int floor = 0; floor < rooms.length; floor++) { // 循环遍历每一层
			for(int room = 0; room < rooms[floor].length; room++) { // 循环每一层的房间
				if(floor + 1 == 1 || floor + 1 == 5) { // 第一层和第五层表示VIP
					rooms[floor][room] = new Room((floor + 1) * 100 + room + 1, true, "VIP"); // 给每一个房间创建一个Room对象
				} else if(floor + 1 == 2) { // 第二层表示双人间
					rooms[floor][room] = new Room((floor + 1) * 100 + room + 1, true, "双人间"); // 给每一个房间创建一个Room对象
				} else { // 其他层次，三、四表示单人间
					rooms[floor][room] = new Room((floor + 1) * 100 + room + 1, true, "单人间"); // 给每一个房间创建一个Room对象
				}
				
			}
		}
	}
	
	/**
	 * 展示所有的房间
	 */
	public void showAllRooms() {
		for(int floor = 0; floor < rooms.length; floor++) {
			for(int room = 0; room < rooms[floor].length; room++) {
				System.out.println(rooms[floor][room]);
			}
		}
	}
	
	/**
	 * 订房
	 * @param code
	 */
	public void orderRoom(int code) {
		rooms[code / 100 - 1][code % 100 - 1].setFree(false);
		System.out.println("订房成功！！！");
	}
	
	/**
	 * 退房
	 * @param code
	 */
	public void returnRoom(int code) {
		rooms[code / 100 - 1][code % 100 - 1].setFree(true);
		System.out.println("退房成功！！！");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(rooms);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (!Arrays.deepEquals(rooms, other.rooms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hotel [rooms=" + Arrays.toString(rooms) + "]";
	}

	public Room[][] getRooms() {
		return rooms;
	}

	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}
	
	
	
}
