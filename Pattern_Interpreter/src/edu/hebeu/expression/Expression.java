package edu.hebeu.expression;

import java.util.HashMap;

/**
 * 抽象类表达式，通过HashMap键值对，可以获取到变量的值
 * @author 13651
 *
 */
public abstract class Expression {

	/**
	 * 参数var：表示表达式的非终结符名和值
	 * 	如：a + b - c
	 * 	HashMap的key就是[a、b、c]，value就是对应的具体值
	 * @param var
	 * @return
	 */
	public abstract int interpreter(HashMap<String, Integer> var);
}
