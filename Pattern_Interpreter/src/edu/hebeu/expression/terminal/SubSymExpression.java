package edu.hebeu.expression.terminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

public class SubSymExpression extends SymbolExpression {

	public SubSymExpression(Expression left, Expression right) {
		super(left, right);
	}

	/**
	 * 重写父类的方法，处理相减
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		
		/*
		 * super.left.interpreter(var)：返回left表达式对应的值，如：a = 20
		 * super.right.interpreter(var)：返回right表达式对应的值，如：b = 1
		 */
		return super.left.interpreter(var) - super.right.interpreter(var); // 将左右表达式的值相减并返回
	}
	
}
