package edu.hebeu.flyweight;

import java.util.HashMap;
import java.util.Map;

import edu.hebeu.flyweight.flyweight.ConcreteWebSite;
import edu.hebeu.flyweight.flyweight.WebSite;

// 网站工厂类，用来返回一个具体类型的网站
public class WebSiteFactory {
	
	// 充当池的作用，用来享元 ConcreteWebSite 这个类
	private Map<String, WebSite> concreteWebSitePool = new HashMap<>();
	
	/**
	 * 通过 type，从池webSitePool中返回一个指定类型的网站，如果没有该 type 类型网站，就先创建
	 * 一个该类型的网站，再加入到池中；
	 * @param type
	 * @return
	 */
	public ConcreteWebSite getWebSite(String type) {
		if(!concreteWebSitePool.containsKey(type)) { // 如果池中没有这个 type 类型的网站
			System.out.println("池中没有该类型的网站，正在创建并加入到池....");
			concreteWebSitePool.put(type, new ConcreteWebSite(type));
		}
		return (ConcreteWebSite) concreteWebSitePool.get(type);
	}

	/**
	 * 获取网站分类的总数
	 */
	public int getConcreteWebSiteCount() {
		return concreteWebSitePool.size();
	}
	
}
