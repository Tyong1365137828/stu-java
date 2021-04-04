package edu.hebeu.visitor;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;

public class Fail extends Action{

	@Override
	public void getManResult(Man man) {
		System.out.println("男观众：失败，未通过");
	}

	@Override
	public void getWomanResult(Woman woman) {
		System.out.println("女观众：失败，未通过");
	}

}
