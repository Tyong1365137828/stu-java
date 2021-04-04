package edu.hebeu.objectadapter;

public class Phone {
	
	public void charging(Voltage5V voltage5v) {
		int voltage = voltage5v.outputVeltage5();
		if(voltage != 5) {
			System.out.println("我要炸开了！！！！！");
			return;
		}
		System.out.println("正在充电...");
	}
}
