package edu.hebeu.visitor;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;

public abstract class Action {

	// 获取男性观众的评测
	public abstract void getManResult(Man man);
	
	// 获取女性观众的评测
	public abstract void getWomanResult(Woman woman);
}
