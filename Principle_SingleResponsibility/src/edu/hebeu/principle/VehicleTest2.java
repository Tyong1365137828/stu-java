package edu.hebeu.principle;

public class VehicleTest2 {
	/**
	 * ������
	 * 	1�����ַ���û�ж�ԭ�ȵ���������޸ģ����������˷���
	 * 	2�����Ǹ÷�ʽ��һ���̶���û�����ص�һְ��ԭ��(������û�����أ������ڷ��������������˵�һְ��ԭ��)
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		
		vehicle.roadRun("����");
		vehicle.airRun("�ɻ�");
		vehicle.waterRun("�ִ�");
		
	}
}

class Vehicle {
	/**
	 * ·�ϵĽ�ͨ���߶�Ӧ�ķ���
	 * @param vehicle
	 */
	public void roadRun(String vehicle) {
		System.out.println(vehicle + "����·����...");
	}
	
	/**
	 * ����еĽ�ͨ���߶�Ӧ�ķ���
	 * @param vehicle
	 */
	public void airRun(String vehicle) {
		System.out.println(vehicle + "�������Ϸ�...");
	}
	
	/**
	 * ˮ�ϵĽ�ͨ���߶�Ӧ�Ľ�ͨ����
	 * @param vehicle
	 */
	public void waterRun(String vehicle) {
		System.out.println(vehicle + "����ˮ�Ϻ���...");
	}
}
