package edu.hebeu.bridging.abstraction;

import edu.hebeu.bridging.implementor.PhoneBrand;

public class SildePhone extends PhoneBridge {

	public SildePhone(PhoneBrand phoneBrand) {
		super(phoneBrand); // ���ø���Ĺ��췽��
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open() {
		System.out.print("���ǵ�");super.open(); // ���ø����open()����
	}

	@Override
	public void close() {
		System.out.print("���ǵ�");super.close(); // ���ø����close()����
	}

	@Override
	public void call() {
		System.out.print("���ǵ�");super.call(); // ���ø����call()����
	}

	@Override
	public void internet() {
		System.out.print("���ǵ�");super.internet(); // ���ø����internet()����
	}

}
