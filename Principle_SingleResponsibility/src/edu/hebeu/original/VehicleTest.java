package edu.hebeu.original;

/**
 * ͨ����������������⣬����������һְ��ԭ��
 * @author 13651
 *
 */
public class VehicleTest {
	/**
	 * ����main()�����Ĳ��Կ��Կ��������run()�����Ѿ�Υ���˵�һְ��ԭ��
	 * ��ν����
	 * 	���Ը��ݽ�ͨ�������з����Ĳ�ͬ���ֽ�ɲ�ͬ���༴��(��edu.hebeu.principle.VehicleTest1.java��)
	 */
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.run("��");
		vehicle.run("�ɻ�");
		vehicle.run("�ִ�");
	}
	
}

class Vehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "��·����...");
	}
}
