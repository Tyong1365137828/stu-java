package edu.hebeu.objectadapter;

public class Voltage220V { // 这个类相当于被适配的类target
	
	public int outputVeltage220() {
		System.out.println("提供了220V的交流~电");		
		return 220;
	}
}
