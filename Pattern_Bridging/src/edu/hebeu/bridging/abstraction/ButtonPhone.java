package edu.hebeu.bridging.abstraction;

import edu.hebeu.bridging.implementor.PhoneBrand;

public class ButtonPhone extends PhoneBridge {

	public ButtonPhone(PhoneBrand phoneBrand) {
		super(phoneBrand); // ���ø���Ĺ��췽��
	}

	@Override
	public void open() {
		System.out.print("������");super.open(); // ���ø����open()����
	}

	@Override
	public void close() {
		System.out.print("������");super.close(); // ���ø����close()����
	}

	@Override
	public void call() {
		System.out.print("������");super.call(); // ���ø����call()����
	}

	@Override
	public void internet() {
		System.out.print("������");super.internet(); // ���ø����internet()����
	}

}
