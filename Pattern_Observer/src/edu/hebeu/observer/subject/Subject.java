package edu.hebeu.observer.subject;

import edu.hebeu.observer.observer.Observer;

public interface Subject {
	
	/**
	 * ע��۲���
	 * @param observer
	 */
	void registerObserver(Observer observer);
	
	/**
	 * ɾ���۲���
	 * @param observer
	 */
	void removeObserver(Observer observer);
	
	/**
	 * ֪ͨ���еĹ۲���
	 */
	void notifyObservers();
}
