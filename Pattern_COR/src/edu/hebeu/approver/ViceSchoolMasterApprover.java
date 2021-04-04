package edu.hebeu.approver;

import edu.hebeu.PurchaseRequest;

public class ViceSchoolMasterApprover extends Approver{

	public ViceSchoolMasterApprover(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handler(PurchaseRequest purchaseRequest) {
		if(purchaseRequest.getPrice() > 10000 && purchaseRequest.getPrice() <= 30000) { // 如果能够处理
			System.out.println("已处理！【请求编号：" + purchaseRequest.getId() + 
					"；请求类型：" + purchaseRequest.getType() + 
					"；请求金额：" + purchaseRequest.getPrice() + 
					"；处理人：" + name + "】");
		} else { // 如果不能处理
			System.out.println("未处理，已上报：【请求编号】" + purchaseRequest.getId() + 
					"；请求类型：" + purchaseRequest.getType() + 
					"；请求金额：" + purchaseRequest.getPrice() + 
					"；上报人：" + name + "；接收人：" + nextApprover.name +  "】");
			nextApprover.handler(purchaseRequest); // 将请求交由下一个处理者处理
		}
	}

}
