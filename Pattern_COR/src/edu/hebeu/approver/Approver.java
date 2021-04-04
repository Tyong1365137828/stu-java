package edu.hebeu.approver;

import edu.hebeu.PurchaseRequest;

/**
 * ��������
 * @author 13651
 *
 */
public abstract class Approver {
	
	protected String name; // �����˵�����
	protected Approver nextApprover; // ���Լ�������ʱ��Ҫ���ݸ�����һ�����������
	
	public Approver(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * ��������ķ������õ�һ��������Ϊ������ȥ������ɵģ����Խ�����ϸ�ڽ�������ȥʵ��
	 * @param purchaseRequest Ҫ���������
	 */
	public abstract void handler(PurchaseRequest purchaseRequest);

	public void setNextApprover(Approver nextApprover) {
		this.nextApprover = nextApprover;
	}
	
}
