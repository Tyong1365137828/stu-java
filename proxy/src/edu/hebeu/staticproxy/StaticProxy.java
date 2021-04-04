package edu.hebeu.staticproxy;

/**
 * �������չʾ�Ͳ��Ծ�̬�����ʵ�֣�
 * ���Կ�������̬������ص㣺������ͱ��������ڱ����ڼ�ͱ�ȷ��������
 * @author 13651
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		ProxyFactory nikeProxyFactory = new ProxyFactory(new NikeFactory()); // ͨ��NikeFactory���ʵ�������������ʵ��
		nikeProxyFactory.produceCloth();
	}

}

/**
 * �·������Ľӿ���
 */
interface ClothFactory {
	
	/**
	 * ����һ���������÷���������������
	 */
	void produceCloth();
}

/**
 * ��������
 */
class NikeFactory implements ClothFactory {

	@Override
	public void produceCloth() {
		System.out.println("Nike����������һ����Ʒ");
	}
	
}

/**
 * ��̬������
 */
class ProxyFactory implements ClothFactory {
	
	private ClothFactory clothFactory;
	
	public ProxyFactory(ClothFactory clothFactory) {
		this.clothFactory = clothFactory;
	}

	@Override
	public void produceCloth() {
		System.out.println("������׼������...");
		clothFactory.produceCloth(); // ���ñ�������ʵ���ķ���
		System.out.println("������������ϣ�");
	}
	
}
