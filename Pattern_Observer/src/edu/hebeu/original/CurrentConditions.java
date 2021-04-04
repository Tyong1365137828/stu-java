package edu.hebeu.original;

public class CurrentConditions {
	// �¶ȣ���ѹ��ʪ��
	private float temperature; 
	private float pressure; 
	private float humidity;

	/**
	 * ����������������� WeatherData�Ķ���ʵ�������ã���ʹ������ģʽ
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure; this.humidity = humidity; display();
	}

	/**
	 * ��ʾ����
	 */
	public void display() {
		System.out.println("***Today mTemperature: " + temperature + "***"); 
		System.out.println("***Today mPressure: " + pressure + "***"); 
		System.out.println("***Today mHumidity: " + humidity + "***");
	}

}