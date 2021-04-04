package edu.hebeu.observer.subject;

import java.util.ArrayList;
import java.util.List;

import edu.hebeu.observer.observer.Observer;

public class WeatherData implements Subject{
	
	// 温度，气压，湿度
	private float temperatrue; 
	private float pressure; 
	private float humidity;
	
	/**
	 * 观察者集合
	 */
	private List<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<>();
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
	 * 当数据有更新时，调用的函数
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		//调用 notifyObservers， 将最新的信息 推送给 接入方 所有的观察者
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		if(observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
		}
	}

}
