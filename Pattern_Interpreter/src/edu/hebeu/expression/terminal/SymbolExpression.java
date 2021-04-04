package edu.hebeu.expression.terminal;

import java.util.HashMap;

import edu.hebeu.expression.Expression;

/**
 * 运算符号解析器的基类，每个运算符号斗志和自己左右两个数字有关，但是左右
 * 两个数字有可能也是一个解析的结果，无论何种类型，都一旦是Expression类的
 * 实现类；
 * @author 13651
 *
 */
public class SymbolExpression extends Expression{
	
	protected Expression left; // 本符号的左表达式
	protected Expression right; // 本符号的右表达式
	
	public SymbolExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * 需要注意这个方法是所有的符号解析器的基类，因此该方法是默
	 * 认实现(空实现)的，具体实现细节交给子类去重写该方法
	 */
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return 0;
	}
	
}
