package edu.hebeu.expression.terminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

public class SubSymExpression extends SymbolExpression {

	public SubSymExpression(Expression left, Expression right) {
		super(left, right);
	}

	/**
	 * ��д����ķ������������
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		
		/*
		 * super.left.interpreter(var)������left���ʽ��Ӧ��ֵ���磺a = 20
		 * super.right.interpreter(var)������right���ʽ��Ӧ��ֵ���磺b = 1
		 */
		return super.left.interpreter(var) - super.right.interpreter(var); // �����ұ��ʽ��ֵ���������
	}
	
}
