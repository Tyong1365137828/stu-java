package edu.hebeu.visitor;

import edu.hebeu.element.Man;
import edu.hebeu.element.Woman;

public abstract class Action {

	// ��ȡ���Թ��ڵ�����
	public abstract void getManResult(Man man);
	
	// ��ȡŮ�Թ��ڵ�����
	public abstract void getWomanResult(Woman woman);
}
