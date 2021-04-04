package edu.hebeu.original;

/**
 * 1. 包含最新的天气情况信息
 * 2. 含有 CurrentConditions 对象
 * 3.  当数据有更新时，就主动的调用	CurrentConditions 对象 update 方法(含 display),  这样他
 * 们（接入方）就看到最新的信息
 * @author 13651
 *
 */
public class WeatherData {
	
	private float temperatrue; // 温度
	private float pressure; // 气压
	private float humidity;// 湿度
	
	//加入新的第三方
	private CurrentConditions currentConditions;

	public WeatherData(CurrentConditions currentConditions) {
		this.currentConditions = currentConditions;
	}

	/**
	 * 获取温度
	 * @return
	 */
	public float getTemperature() {
		return temperatrue;
	}

	/**
	 * 获取气压
	 * @return
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * 获取湿度
	 * @return
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * 当数据改变时调用的函数
	 */
	public void dataChange() {
		//调用 接入方的 update
		currentConditions.update(getTemperature(), getPressure(), getHumidity());
	}

	/**
	 * 当数据有更新时，调用的函数
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure; this.humidity = humidity;
		//调用 dataChange， 将最新的信息 推送给 接入方 currentConditions
		dataChange();
	}

}
