package edu.hebeu.objectadapter;

public class Phone {
	
	public void charging(Voltage5V voltage5v) {
		int voltage = voltage5v.outputVeltage5();
		if(voltage != 5) {
			System.out.println("��Ҫը���ˣ���������");
			return;
		}
		System.out.println("���ڳ��...");
	}
}
