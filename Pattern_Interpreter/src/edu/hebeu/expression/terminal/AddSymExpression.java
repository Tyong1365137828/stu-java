package edu.hebeu.expression.terminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

/**
 * 加号(+)的解析器
 * @author 13651
 *
 */
public class AddSymExpression extends SymbolExpression{

	public AddSymExpression(Expression left, Expression right) {
		super(left, right);
	}

	/**
	 * 重写父类的方法，处理相加
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		
		/*
		 * super.left.interpreter(var)：返回left表达式对应的值，如：a = 10
		 * super.right.interpreter(var)：返回right表达式对应的值，如：b = 21
		 */
		return super.left.interpreter(var) + super.right.interpreter(var); // 将左右表达式的值相加并返回
	}

}
