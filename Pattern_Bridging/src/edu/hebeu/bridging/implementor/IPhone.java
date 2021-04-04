package edu.hebeu.bridging.implementor;

public class IPhone implements PhoneBrand {

	public void open() {
		System.out.println("IPhone手机打开");
	}
	
	public void close() {
		System.out.println("IPhone手机关闭");
	}
	
	public void call() {
		System.out.println("IPhone手机打电话");
	}
	
	public void internet() {
		System.out.println("IPhone手机上网");
	}

}
