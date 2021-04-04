package edu.hebeu.principle;

public class VehicleTest2 {
	/**
	 * 分析：
	 * 	1、这种方法没有对原先的类做大的修改，至少增加了方法
	 * 	2、但是该方式在一定程度上没有遵守单一职责原则(在类上没有遵守，但是在方法级别上遵守了单一职责原则)
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		
		vehicle.roadRun("汽车");
		vehicle.airRun("飞机");
		vehicle.waterRun("轮船");
		
	}
}

class Vehicle {
	/**
	 * 路上的交通工具对应的方法
	 * @param vehicle
	 */
	public void roadRun(String vehicle) {
		System.out.println(vehicle + "正在路上跑...");
	}
	
	/**
	 * 天空中的交通工具对应的方法
	 * @param vehicle
	 */
	public void airRun(String vehicle) {
		System.out.println(vehicle + "正在天上飞...");
	}
	
	/**
	 * 水上的交通工具对应的交通方法
	 * @param vehicle
	 */
	public void waterRun(String vehicle) {
		System.out.println(vehicle + "正在水上航行...");
	}
}
