package edu.hebeu.expression;

import java.util.HashMap;

/**
 * ��������ʽ��ͨ��HashMap��ֵ�ԣ����Ի�ȡ��������ֵ
 * @author 13651
 *
 */
public abstract class Expression {

	/**
	 * ����var����ʾ���ʽ�ķ��ս������ֵ
	 * 	�磺a + b - c
	 * 	HashMap��key����[a��b��c]��value���Ƕ�Ӧ�ľ���ֵ
	 * @param var
	 * @return
	 */
	public abstract int interpreter(HashMap<String, Integer> var);
}
