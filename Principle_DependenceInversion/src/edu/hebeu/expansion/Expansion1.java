package edu.hebeu.expansion;

/**
 * �������ʾ������ϵ���ݵ����ַ�ʽ
 * @author 13651
 *
 */
public class Expansion1 {

	public static void main(String[] args) {
		// ���Է�ʽһ
		OpenAndClose1 openAndClose1 = new OpenAndClose1();
		openAndClose1.open(new ChangHong());
		
		
		// ���Է�ʽ��
		OpenAndClose2 openAndClose2 = new OpenAndClose2(new HaiXin());
		openAndClose2.open();
		
		// ���Է�ʽ��
		OpenAndClose3 openAndClose3 = new OpenAndClose3();
		openAndClose3.setTv3(new LianXiang());
		openAndClose3.open();
		
	}
}

// �������ݵĵ�һ�ַ�ʽ��ͨ���ӿ�ʵ����������
interface IOpenAndClose1 {
	void open(ITV1 tv); // ���սӿ�
}

interface ITV1 {
	void play();
}

class ChangHong implements ITV1 {

	@Override
	public void play() {
		System.out.println("�������ڲ���...");
	}	
}

class OpenAndClose1 implements IOpenAndClose1 { // ʵ�ֽӿ�

	@Override
	public void open(ITV1 tv) {
		System.out.println("ͨ��ң��������ITV1...");
		tv.play();
	}
}



// �������ݵĵڶ��ַ�ʽ��ͨ�����췽��ʵ����������
interface IOpenAndClose2 {
	void open();
}

interface ITV2 {
	void play();
}

class HaiXin implements ITV2 {

	@Override
	public void play() {
		System.out.println("�������ڲ���...");
	}
}

class OpenAndClose2 implements IOpenAndClose2 {
	
	private ITV2 tv2;
	
	public OpenAndClose2(ITV2 tv2) {
		this.tv2 = tv2;
	}

	@Override
	public void open() {
		System.out.println("ͨ��ң��������ITV2...");
		tv2.play();
	}
}



// �������ݵĵ����ַ�ʽ��ͨ��setter��ʽʵ����������
interface IOpenAndClose3 {
	void open();
	void setTv3(ITV3 tv3);
}

interface ITV3 {
	void play();
}

class LianXiang implements ITV3 {

	@Override
	public void play() {
		System.out.println("�������ڲ���...");
	}
}

class OpenAndClose3 implements IOpenAndClose3 {
	private ITV3 tv3;

	@Override
	public void open() {
		System.out.println("ͨ��ң��������ITV3...");
		tv3.play();
	}

	@Override
	public void setTv3(ITV3 tv3) {
		this.tv3 = tv3;
	}
}
