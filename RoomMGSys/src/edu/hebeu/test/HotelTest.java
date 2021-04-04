package edu.hebeu.test;

import java.util.Scanner;

import edu.hebeu.entity.Hotel;

public class HotelTest {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		Hotel hotel = new Hotel();
		
		System.out.println("欢迎使用订房系统，[1]、展示所有房间，[2]、订房，[3]、退房，[4]、退出程序");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("请输入功能编号:"); int i = scanner.nextInt();
			if(i == 1) {
				hotel.showAllRooms();				
			} else if(i == 2) {
				System.out.println("请输入订的房间号"); int code = scanner.nextInt();
				hotel.orderRoom(code);
			} else if(i == 3) {
				System.out.println("请输入退的房间号"); int code = scanner.nextInt();
				hotel.returnRoom(code);				
			} else if(i == 0) {
				System.out.println("拜拜，欢迎下次再来！！！"); break;
			} else {
				System.out.println("输入有误，请重新输入功能编号");
			}
		}
	}
}
