package edu.hebeu.element;

import edu.hebeu.visitor.Action;

public class Man extends Person {

	@Override
	public void accept(Action action) {
		action.getManResult(this);
	}

}
