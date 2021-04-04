package edu.hebeu.principle;

public class VehicleTest1 {

	/**
	 * ���ַ�ʽ�����˵�һְ��ԭ��
	 * ���������ĸĶ��ܴ�(������౻�ֽ⣬ͬʱ��Ҫ�ı�ͻ���)��
	 *	��ν����
	 *		����ֱ���޸�Vehicle���еĴ��룬�Ķ��������(�ο�)
	 * @param args
	 */
	public static void main(String[] args) {
		RoadVehicle roadVehicle = new RoadVehicle();
		roadVehicle.run("����");
		
		AirVehicle airVehicle = new AirVehicle();
		airVehicle.run("�ɻ�");
		
		WaterVehicle waterVehicle = new WaterVehicle();
		waterVehicle.run("�ִ�");
	}

}

// ·�ϵĽ�ͨ������
class RoadVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "��·����...");
	}
}

// ���ϵĽ�ͨ������
class AirVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "�����Ϸ�...");
	}
}

// ˮ�еĽ�ͨ������
class WaterVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "��ˮ�Ϻ���...");
	}
}
