package edu.hebeu.classadapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V { // 这个类相当于适配器

	@Override
	public int outputVeltage5() {
		int sourceVoltage = outputVeltage220();
		int targetVoltage = sourceVoltage / 44;
		System.out.println("输出了" + targetVoltage + "V-直流电");
		return targetVoltage;
	}
	
}
