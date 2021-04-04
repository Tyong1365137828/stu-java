package edu.hebeu.classadapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V { // ������൱��������

	@Override
	public int outputVeltage5() {
		int sourceVoltage = outputVeltage220();
		int targetVoltage = sourceVoltage / 44;
		System.out.println("�����" + targetVoltage + "V-ֱ����");
		return targetVoltage;
	}
	
}
