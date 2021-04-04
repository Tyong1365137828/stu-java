package edu.hebeu.observer.observer;

/**
 * 观察者接口
 * @author 13651
 *
 */
public interface Observer {
	
	void update(float temperature, float pressure, float humidity);
}
