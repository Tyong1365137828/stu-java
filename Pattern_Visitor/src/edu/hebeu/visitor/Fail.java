package edu.hebeu.visitor;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;

public class Fail extends Action{

	@Override
	public void getManResult(Man man) {
		System.out.println("�й��ڣ�ʧ�ܣ�δͨ��");
	}

	@Override
	public void getWomanResult(Woman woman) {
		System.out.println("Ů���ڣ�ʧ�ܣ�δͨ��");
	}

}
