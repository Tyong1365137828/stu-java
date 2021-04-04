package edu.hebeu.observer;

import edu.hebeu.observer.observer.BaiDu;
import edu.hebeu.observer.observer.WangYi;
import edu.hebeu.observer.observer.XinLang;
import edu.hebeu.observer.subject.WeatherData;

public class Client {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		// 注册观察者
		weatherData.registerObserver(new BaiDu());
		weatherData.registerObserver(new XinLang());
		weatherData.registerObserver(new WangYi());
		
		// 更新信息
		weatherData.setData(37f, 158.9f, 29f);
		
		// 再次更新天气
		System.out.println("--------------------------------------------天气再次更新-------------------------------");
		weatherData.setData(37.4f, 159.1f, 27.3f);
		
	}
}
