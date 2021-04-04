package edu.hebeu.flyweight.flyweight;

import edu.hebeu.flyweight.outside.User;

public class ConcreteWebSite extends WebSite {
	
	private String type; // ��վ��������ʽ
	
	public ConcreteWebSite(String type) {
		this.type = type;
	}

	@Override
	public void use(User user) {
		System.out.println("--------------------" + type + "---------------------------�����ˣ�" + user.getName());
		System.out.println("�㿴�����Ǹ���վ����Ϣ......");
	}

}
