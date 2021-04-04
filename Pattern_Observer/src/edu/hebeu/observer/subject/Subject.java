package edu.hebeu.observer.subject;

import edu.hebeu.observer.observer.Observer;

public interface Subject {
	
	/**
	 * 注册观察者
	 * @param observer
	 */
	void registerObserver(Observer observer);
	
	/**
	 * 删除观察者
	 * @param observer
	 */
	void removeObserver(Observer observer);
	
	/**
	 * 通知所有的观察者
	 */
	void notifyObservers();
}
