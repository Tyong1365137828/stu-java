package edu.hebeu.test;

import java.util.Scanner;

import edu.hebeu.entity.Hotel;

public class HotelTest {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		Hotel hotel = new Hotel();
		
		System.out.println("��ӭʹ�ö���ϵͳ��[1]��չʾ���з��䣬[2]��������[3]���˷���[4]���˳�����");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("�����빦�ܱ��:"); int i = scanner.nextInt();
			if(i == 1) {
				hotel.showAllRooms();				
			} else if(i == 2) {
				System.out.println("�����붩�ķ����"); int code = scanner.nextInt();
				hotel.orderRoom(code);
			} else if(i == 3) {
				System.out.println("�������˵ķ����"); int code = scanner.nextInt();
				hotel.returnRoom(code);				
			} else if(i == 0) {
				System.out.println("�ݰݣ���ӭ�´�����������"); break;
			} else {
				System.out.println("�����������������빦�ܱ��");
			}
		}
	}
}
