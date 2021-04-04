package edu.hebeu;

import java.util.HashMap;
import java.util.Stack;

import edu.hebeu.expression.Expression;
import edu.hebeu.expression.nonterminal.VarExpression;
import edu.hebeu.expression.terminal.AddSymExpression;
import edu.hebeu.expression.terminal.SubSymExpression;

public class Computer {
	// ������ʽ
	private Expression expression;

	// ���캯�����Σ�������
	public Computer(String expStr) { // expStr = a+b
		// ���������Ⱥ�˳��
		Stack<Expression> stack = new Stack<>();
		// ���ʽ��ֳ��ַ�����
		char[] charArray = expStr.toCharArray();// �磺[a, +, b]

		Expression left = null;
		Expression right = null;
		// �������ǵ��ַ����飬 ������ [a, +, b]
		// ��Բ�ͬ�������������
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
			case '+': //
				left = stack.pop();// ��stackȡ��left => "a"
				right = new VarExpression(String.valueOf(charArray[++i]));// ȡ���ұ��ʽ "b"
				stack.push(new AddSymExpression(left, right));// Ȼ����ݵõ�left �� right ���� AddExpresson����stack
				break;
			case '-': //
				left = stack.pop();
				right = new VarExpression(String.valueOf(charArray[++i]));
				stack.push(new SubSymExpression(left, right));
				break;
			default:
				// �����һ�� Var �ʹ���Ҫ�� VarExpression ���󣬲�push�� stack
				stack.push(new VarExpression(String.valueOf(charArray[i])));
				break;
			}
		}
		// ������������ charArray �����stack �͵õ����Expression
		this.expression = stack.pop();
	}

	public int run(HashMap<String, Integer> var) {
		// ��󽫱��ʽa+b�� var = {a=10,b=20}
		// Ȼ�󴫵ݸ�expression��interpreter���н���ִ��
		return this.expression.interpreter(var);
	}
}
