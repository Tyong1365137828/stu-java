package edu.hebeu.annotation;

/**
 * ע���������ԣ�
	���Ե���������Щ��
		byte��short��int��long��float��double��boolean��char��String��Class��ö��enum��
		�Լ�����ÿ�����͵�������ʽ��
	ע�����ʹ��ע��ʱ��
		1�����ע���������Ҹ�����û��Ĭ��ֵ���ͱ���Ҫ�����Ը�ֵ��
		2�����Ը�ֵ����ʽΪ�� ������ = ֵ(ע��ֵҪ������ָ����������ͬ);
		3�����ע���е�������Ϊvalueʱ��ע��ֻ����һ������ʱ�����������Բ�д��ֱ�Ӹ�ֵ���� "123"���� ֵ��
 * @author 13651
 *
 */
public @interface MyAnnotation2 {
	
	/**
	 * ����MyAnnotation2ע���name����
	 * @return
	 */
	String name();
	
	/**
	 * ����MyAnnotation2ע���sex����
	 * @return
	 */
	char sex(); 
	
	/**
	 * ����MyAnnotation2ע���age���ԣ�Ĭ��ֵΪ20
	 * @return
	 */
	int age() default 20;
	
}
