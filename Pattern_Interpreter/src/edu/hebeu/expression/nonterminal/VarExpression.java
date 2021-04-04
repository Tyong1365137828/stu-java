package edu.hebeu.expression.nonterminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

/**
 * �����Ľ�����
 * @author 13651
 *
 */
public class VarExpression extends Expression{

	private String key; // key�൱�ڱ��ʽ��a��b��c��...��
	
	public VarExpression(String key) {
		this.key = key;
	}
	
	/**
	 * ͨ������������(key)���ض�Ӧ��ֵ(value)
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(key);
	}

}
