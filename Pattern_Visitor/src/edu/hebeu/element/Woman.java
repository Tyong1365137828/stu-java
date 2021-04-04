package edu.hebeu.element;

import edu.hebeu.visitor.Action;

/**
 * 这里使用了双分派，即首先在客户端程序中，将具体状态作为参数传入Woman中(第一次分派)。
 * 然后在Woman类调用了作为参数的 “具体方法” 中getWomanResult()方法，同时将自己(this)作为参数
 * 传入(第二次分派)
 * 
 * @author 13651
 *
 */
public class Woman extends Person{

	@Override
	public void accept(Action action) {
		action.getWomanResult(this);
	}

}
