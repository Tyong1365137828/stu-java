package edu.hebeu.observer.subject;

import java.util.ArrayList;
import java.util.List;

import edu.hebeu.observer.observer.Observer;

public class WeatherData implements Subject{
	
	// �¶ȣ���ѹ��ʪ��
	private float temperatrue; 
	private float pressure; 
	private float humidity;
	
	/**
	 * �۲��߼���
	 */
	private List<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}
	
	/**
	 * ��ȡ�¶�
	 * @return
	 */
	public float getTemperature() {
		return temperatrue;
	}

	/**
	 * ��ȡ��ѹ
	 * @return
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * ��ȡʪ��
	 * @return
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * �������и���ʱ�����õĺ���
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		//���� notifyObservers�� �����µ���Ϣ ���͸� ���뷽 ���еĹ۲���
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
