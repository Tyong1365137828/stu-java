package edu.hebeu.flyweight.flyweight;

import edu.hebeu.flyweight.outside.User;

public class ConcreteWebSite extends WebSite {
	
	private String type; // 网站发布的形式
	
	public ConcreteWebSite(String type) {
		this.type = type;
	}

	@Override
	public void use(User user) {
		System.out.println("--------------------" + type + "---------------------------发布人：" + user.getName());
		System.out.println("你看见的是该网站的信息......");
	}

}
