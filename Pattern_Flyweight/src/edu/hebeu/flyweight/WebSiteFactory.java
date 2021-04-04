package edu.hebeu.flyweight;

import java.util.HashMap;
import java.util.Map;

import edu.hebeu.flyweight.flyweight.ConcreteWebSite;
import edu.hebeu.flyweight.flyweight.WebSite;

// ��վ�����࣬��������һ���������͵���վ
public class WebSiteFactory {
	
	// �䵱�ص����ã�������Ԫ ConcreteWebSite �����
	private Map<String, WebSite> concreteWebSitePool = new HashMap<>();
	
	/**
	 * ͨ�� type���ӳ�webSitePool�з���һ��ָ�����͵���վ�����û�и� type ������վ�����ȴ���
	 * һ�������͵���վ���ټ��뵽���У�
	 * @param type
	 * @return
	 */
	public ConcreteWebSite getWebSite(String type) {
		if(!concreteWebSitePool.containsKey(type)) { // �������û����� type ���͵���վ
			System.out.println("����û�и����͵���վ�����ڴ��������뵽��....");
			concreteWebSitePool.put(type, new ConcreteWebSite(type));
		}
		return (ConcreteWebSite) concreteWebSitePool.get(type);
	}

	/**
	 * ��ȡ��վ���������
	 */
	public int getConcreteWebSiteCount() {
		return concreteWebSitePool.size();
	}
	
}
