package edu.hebeu.methodfactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ������� ͨ����������ģʽ ��ʵ�������Ĺ���
 * 
 * ��Ʒ�������������Ŀ��ʵ�������ܳ���ɳ��󷽷����ڲ�ͬ�Ŀ�ζ��������о���ʵ�֣�
 * 
 * @author 13651
 *
 */
public class PizzaStore {
	public static void main(String[] args) {
		System.out.println("***��������ģʽʵ��***");
		String location = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����빺����ĸ��ط���������");
		try {
			location = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("����".equals(location)) {
			new BJOrederPizza();
		} else if("�׶�".contentEquals(location)) {
			new LDOrderPizza();
		} else {
			System.out.println("û���ҵ��˵ط�~~~");
		}
	}
}
