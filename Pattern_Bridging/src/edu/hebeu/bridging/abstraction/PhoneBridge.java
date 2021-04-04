package edu.hebeu.bridging.abstraction;

import edu.hebeu.bridging.implementor.PhoneBrand;

public abstract class PhoneBridge { // 这个类用来作为桥接类
	
	private PhoneBrand phoneBrand;
	
	public PhoneBridge(PhoneBrand phoneBrand) {
		this.phoneBrand = phoneBrand;
	}
	
	public void open() {
		phoneBrand.open();
	}
	
	public void close() {
		phoneBrand.close();
	}

	public void call() {
		phoneBrand.call();
	}
	
	public void internet() {
		phoneBrand.internet();
	}
	
}
