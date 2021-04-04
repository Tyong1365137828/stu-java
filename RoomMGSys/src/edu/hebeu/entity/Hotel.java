package edu.hebeu.entity;

import java.util.Arrays;

/**
 * �Ƶ���
 * @author 13651
 *
 */
public class Hotel {
	private Room[][] rooms; // ���еķ���

	public Hotel(Room[][] rooms) {
		super();
		this.rooms = rooms;
	}

	public Hotel() {
		rooms = new Room[5][10]; // ����һ��4�㣬ÿ��10������ľƵ�
		
		for(int floor = 0; floor < rooms.length; floor++) { // ѭ������ÿһ��
			for(int room = 0; room < rooms[floor].length; room++) { // ѭ��ÿһ��ķ���
				if(floor + 1 == 1 || floor + 1 == 5) { // ��һ��͵�����ʾVIP
					rooms[floor][room] = new Room((floor + 1) * 100 + room + 1, true, "VIP"); // ��ÿһ�����䴴��һ��Room����
				} else if(floor + 1 == 2) { // �ڶ����ʾ˫�˼�
					rooms[floor][room] = new Room((floor + 1) * 100 + room + 1, true, "˫�˼�"); // ��ÿһ�����䴴��һ��Room����
				} else { // ������Σ������ı�ʾ���˼�
					rooms[floor][room] = new Room((floor + 1) * 100 + room + 1, true, "���˼�"); // ��ÿһ�����䴴��һ��Room����
				}
				
			}
		}
	}
	
	/**
	 * չʾ���еķ���
	 */
	public void showAllRooms() {
		for(int floor = 0; floor < rooms.length; floor++) {
			for(int room = 0; room < rooms[floor].length; room++) {
				System.out.println(rooms[floor][room]);
			}
		}
	}
	
	/**
	 * ����
	 * @param code
	 */
	public void orderRoom(int code) {
		rooms[code / 100 - 1][code % 100 - 1].setFree(false);
		System.out.println("�����ɹ�������");
	}
	
	/**
	 * �˷�
	 * @param code
	 */
	public void returnRoom(int code) {
		rooms[code / 100 - 1][code % 100 - 1].setFree(true);
		System.out.println("�˷��ɹ�������");
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
