package edu.hebeu.visitor;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;

public class Success extends Action {

	@Override
	public void getManResult(Man man) {
		System.out.println("�й��ڣ��ɹ���ͨ����");
	}

	@Override
	public void getWomanResult(Woman woman) {
		System.out.println("Ů���ڣ��ɹ���ͨ����");
	}

}
