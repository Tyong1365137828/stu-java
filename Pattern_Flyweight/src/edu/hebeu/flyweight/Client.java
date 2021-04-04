package edu.hebeu.flyweight;

import edu.hebeu.flyweight.flyweight.ConcreteWebSite;
import edu.hebeu.flyweight.outside.User;

public class Client {
	public static void main(String[] args) {
		WebSiteFactory webSiteFactory = new WebSiteFactory();
		
		// 使用微信小程序发布网站
		ConcreteWebSite webSite1 = webSiteFactory.getWebSite("微信小程序");
		webSite1.use(new User("tyong"));
		
		System.out.println();
		System.out.println();
		
		ConcreteWebSite webSite2 = webSiteFactory.getWebSite("微信小程序");
		webSite2.use(new User("test"));
		
		System.out.println();
		System.out.println();

		// 使用新闻的形式发布网站
		ConcreteWebSite webSite3 = webSiteFactory.getWebSite("新闻");
		webSite3.use(new User("test001"));
		
		System.out.println();
		System.out.println();
		
		// 使用博客的形式发布网站
		ConcreteWebSite webSite4 = webSiteFactory.getWebSite("博客");
		webSite4.use(new User("测试用户001"));
	}
}
