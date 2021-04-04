package edu.hebeu.objectadapter;

public class VoltageAdapter implements Voltage5V { // ������൱��������
	
	private Voltage220V voltage220v;
	
	public VoltageAdapter(Voltage220V voltage220v) {
		this.voltage220v = voltage220v;
	}

	@Override
	public int outputVeltage5() {
		int sourceVoltage = voltage220v.outputVeltage220();
		int targetVoltage = sourceVoltage / 44;
		System.out.println("�����" + targetVoltage + "V-ֱ����");
		return targetVoltage;
	}
	
}
