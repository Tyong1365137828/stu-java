package edu.hebeu.principle;

public class VehicleTest1 {

	/**
	 * 这种方式遵守了单一职责原则；
	 * 但是这样的改动很大(即这个类被分解，同时还要改变客户端)；
	 *	如何解决？
	 *		可以直接修改Vehicle类中的代码，改动代码较少(参考)
	 * @param args
	 */
	public static void main(String[] args) {
		RoadVehicle roadVehicle = new RoadVehicle();
		roadVehicle.run("汽车");
		
		AirVehicle airVehicle = new AirVehicle();
		airVehicle.run("飞机");
		
		WaterVehicle waterVehicle = new WaterVehicle();
		waterVehicle.run("轮船");
	}

}

// 路上的交通工具类
class RoadVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "在路上跑...");
	}
}

// 天上的交通工具类
class AirVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "在天上飞...");
	}
}

// 水中的交通工具类
class WaterVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "在水上航行...");
	}
}
