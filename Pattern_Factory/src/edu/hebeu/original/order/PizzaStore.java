package edu.hebeu.original.order;

/**
 * 
 * �������������ʵ�������Ĺ���(�൱��һ���ͻ��ˣ���������Ķ�������)
 * 
 * �������ִ�ͳ�ķ�ʽ����ȱ�㣺
 * 	1���ŵ��ǱȽϺ���⣬���ײ�����
 * 	2��ȱ����Υ�������ԭ���OCPԭ��(������չ���ţ����޸Ĺر�)��
 * 	3�������ʱ����Ҫ����һ��Pizza������ChinaPizza��������Ҫ�޸ĺܶ�ط������ڴ���Pizza����ʱ
 * (OrderPizza��Ĺ��췽��)�������Ƕ��OrderPizza����й���ģ������м���OrderPizza���Ҫ���
 * ���ٸ�������Pizza���͵Ĵ���
 * 
 * 
 * ���˼·��
 * 	�Ѵ���Pizza�����װ��һ�����У������������µ�Pizza����ʱ��ֻ��Ҫ�޸ĸ����еĴ��뼴�ɣ�����
 * �д���Pizza����Ĵ���Ͳ�Ҫ�޸���--> �򵥹���ģʽ�����simplefactory��ʾ
 * 	
 * @author 13651
 *
 */
public class PizzaStore {

	public static void main(String[] args) {
		new OrderPizza1();
	}
}
