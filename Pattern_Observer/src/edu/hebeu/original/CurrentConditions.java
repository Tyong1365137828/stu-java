package edu.hebeu.original;

public class CurrentConditions {
	// 温度，气压，湿度
	private float temperature; 
	private float pressure; 
	private float humidity;

	/**
	 * 更新天气情况，是由 WeatherData的对象实例来调用，即使用推送模式
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure; this.humidity = humidity; display();
	}

	/**
	 * 显示数据
	 */
	public void display() {
		System.out.println("***Today mTemperature: " + temperature + "***"); 
		System.out.println("***Today mPressure: " + pressure + "***"); 
		System.out.println("***Today mHumidity: " + humidity + "***");
	}

}
