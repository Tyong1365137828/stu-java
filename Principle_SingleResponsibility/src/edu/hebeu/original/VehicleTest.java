package edu.hebeu.original;

/**
 * 通过这个例子引出问题，进而引出单一职责原则
 * @author 13651
 *
 */
public class VehicleTest {
	/**
	 * 经过main()方法的测试可以看到此类的run()方法已经违反了单一职责原则，
	 * 如何解决？
	 * 	可以根据交通工具运行方法的不同，分解成不同的类即可(见edu.hebeu.principle.VehicleTest1.java类)
	 */
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.run("火车");
		vehicle.run("飞机");
		vehicle.run("轮船");
	}
	
}

class Vehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "在路上跑...");
	}
}
