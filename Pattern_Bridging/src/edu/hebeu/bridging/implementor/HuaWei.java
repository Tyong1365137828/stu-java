package edu.hebeu.bridging.implementor;

public class HuaWei implements PhoneBrand{
	
	public void open() {
		System.out.println("华为手机打开");
	}
	
	public void close() {
		System.out.println("华为手机关闭");
	}
	
	public void call() {
		System.out.println("华为手机打电话");
	}
	
	public void internet() {
		System.out.println("华为手机上网");
	}
}
