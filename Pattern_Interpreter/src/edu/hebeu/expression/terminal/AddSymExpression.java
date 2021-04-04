package edu.hebeu.expression.terminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

/**
 * �Ӻ�(+)�Ľ�����
 * @author 13651
 *
 */
public class AddSymExpression extends SymbolExpression{

	public AddSymExpression(Expression left, Expression right) {
		super(left, right);
	}

	/**
	 * ��д����ķ������������
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		
		/*
		 * super.left.interpreter(var)������left���ʽ��Ӧ��ֵ���磺a = 10
		 * super.right.interpreter(var)������right���ʽ��Ӧ��ֵ���磺b = 21
		 */
		return super.left.interpreter(var) + super.right.interpreter(var); // �����ұ��ʽ��ֵ��Ӳ�����
	}

}
