package edu.hebeu.observer;

import edu.hebeu.observer.observer.BaiDu;
import edu.hebeu.observer.observer.WangYi;
import edu.hebeu.observer.observer.XinLang;
import edu.hebeu.observer.subject.WeatherData;

public class Client {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		// ע��۲���
		weatherData.registerObserver(new BaiDu());
		weatherData.registerObserver(new XinLang());
		weatherData.registerObserver(new WangYi());
		
		// ������Ϣ
		weatherData.setData(37f, 158.9f, 29f);
		
		// �ٴθ�������
		System.out.println("--------------------------------------------�����ٴθ���-------------------------------");
		weatherData.setData(37.4f, 159.1f, 27.3f);
		
	}
}
