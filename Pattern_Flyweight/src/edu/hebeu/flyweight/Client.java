package edu.hebeu.flyweight;

import edu.hebeu.flyweight.flyweight.ConcreteWebSite;
import edu.hebeu.flyweight.outside.User;

public class Client {
	public static void main(String[] args) {
		WebSiteFactory webSiteFactory = new WebSiteFactory();
		
		// ʹ��΢��С���򷢲���վ
		ConcreteWebSite webSite1 = webSiteFactory.getWebSite("΢��С����");
		webSite1.use(new User("tyong"));
		
		System.out.println();
		System.out.println();
		
		ConcreteWebSite webSite2 = webSiteFactory.getWebSite("΢��С����");
		webSite2.use(new User("test"));
		
		System.out.println();
		System.out.println();

		// ʹ�����ŵ���ʽ������վ
		ConcreteWebSite webSite3 = webSiteFactory.getWebSite("����");
		webSite3.use(new User("test001"));
		
		System.out.println();
		System.out.println();
		
		// ʹ�ò��͵���ʽ������վ
		ConcreteWebSite webSite4 = webSiteFactory.getWebSite("����");
		webSite4.use(new User("�����û�001"));
	}
}
