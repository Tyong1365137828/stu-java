package edu.hebeu.bridging.abstraction;

import edu.hebeu.bridging.implementor.PhoneBrand;

public class SmartPhone extends PhoneBridge {

	public SmartPhone(PhoneBrand phoneBrand) {
		super(phoneBrand); // ���ø���Ĺ��췽��
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		System.out.print("���ܵ�");super.open(); // ���ø����open()����
	}

	@Override
	public void close() {
		System.out.print("���ܵ�");super.close(); // ���ø����close()����
	}

	@Override
	public void call() {
		System.out.print("���ܵ�");super.call(); // ���ø����call()����
	}

	@Override
	public void internet() {
		System.out.print("���ܵ�");super.internet(); // ���ø����internet()����
	}

}
