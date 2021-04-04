package edu.hebeu.bridging.implementor;

public class XiaoMi implements PhoneBrand {

	public void open() {
		System.out.println("小米手机打开");
	}
	
	public void close() {
		System.out.println("小米手机关闭");
	}
	
	public void call() {
		System.out.println("小米手机打电话");
	}
	
	public void internet() {
		System.out.println("小米手机上网");
	}

}
