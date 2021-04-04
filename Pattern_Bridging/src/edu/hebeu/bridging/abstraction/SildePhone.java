package edu.hebeu.bridging.abstraction;

import edu.hebeu.bridging.implementor.PhoneBrand;

public class SildePhone extends PhoneBridge {

	public SildePhone(PhoneBrand phoneBrand) {
		super(phoneBrand); // 调用父类的构造方法
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		System.out.print("滑盖的");super.open(); // 调用父类的open()方法
	}

	@Override
	public void close() {
		System.out.print("滑盖的");super.close(); // 调用父类的close()方法
	}

	@Override
	public void call() {
		System.out.print("滑盖的");super.call(); // 调用父类的call()方法
	}

	@Override
	public void internet() {
		System.out.print("滑盖的");super.internet(); // 调用父类的internet()方法
	}

}
