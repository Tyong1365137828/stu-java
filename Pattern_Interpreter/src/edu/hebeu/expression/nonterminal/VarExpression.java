package edu.hebeu.expression.nonterminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

/**
 * 变量的解释器
 * @author 13651
 *
 */
public class VarExpression extends Expression{

	private String key; // key相当于表达式的a、b、c、...等
	
	public VarExpression(String key) {
		this.key = key;
	}
	
	/**
	 * 通过变量的名称(key)返回对应的值(value)
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(key);
	}

}
