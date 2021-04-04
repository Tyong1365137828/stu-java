package edu.hebeu.approver;

import edu.hebeu.PurchaseRequest;

public class ViceSchoolMasterApprover extends Approver{

	public ViceSchoolMasterApprover(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handler(PurchaseRequest purchaseRequest) {
		if(purchaseRequest.getPrice() > 10000 && purchaseRequest.getPrice() <= 30000) { // ����ܹ�����
			System.out.println("�Ѵ����������ţ�" + purchaseRequest.getId() + 
					"���������ͣ�" + purchaseRequest.getType() + 
					"�������" + purchaseRequest.getPrice() + 
					"�������ˣ�" + name + "��");
		} else { // ������ܴ���
			System.out.println("δ�������ϱ����������š�" + purchaseRequest.getId() + 
					"���������ͣ�" + purchaseRequest.getType() + 
					"�������" + purchaseRequest.getPrice() + 
					"���ϱ��ˣ�" + name + "�������ˣ�" + nextApprover.name +  "��");
			nextApprover.handler(purchaseRequest); // ����������һ�������ߴ���
		}
	}

}
