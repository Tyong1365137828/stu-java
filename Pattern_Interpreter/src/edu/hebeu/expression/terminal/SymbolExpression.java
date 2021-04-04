package edu.hebeu.expression.terminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

/**
 * ������Ž������Ļ��࣬ÿ��������Ŷ�־���Լ��������������йأ���������
 * ���������п���Ҳ��һ�������Ľ�������ۺ������ͣ���һ����Expression���
 * ʵ���ࣻ
 * @author 13651
 *
 */
public class SymbolExpression extends Expression{
	
	protected Expression left; // �����ŵ�����ʽ
	protected Expression right; // �����ŵ��ұ��ʽ
	
	public SymbolExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * ��Ҫע��������������еķ��Ž������Ļ��࣬��˸÷�����Ĭ
	 * ��ʵ��(��ʵ��)�ģ�����ʵ��ϸ�ڽ�������ȥ��д�÷���
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return 0;
	}
	
}
