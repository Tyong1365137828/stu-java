package edu.hebeu.approver;

import edu.hebeu.PurchaseRequest;

/**
 * 请求处理者
 * @author 13651
 *
 */
public abstract class Approver {
	
	protected String name; // 处理人的姓名
	protected Approver nextApprover; // 当自己处理不了时，要传递给的下一个处理结点对象
	
	public Approver(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * 处理请求的方法，得到一个请求，因为是子类去处理完成的，所以将处理细节交由子类去实现
	 * @param purchaseRequest 要处理的请求
	 */
	public abstract void handler(PurchaseRequest purchaseRequest);

	public void setNextApprover(Approver nextApprover) {
		this.nextApprover = nextApprover;
	}
	
}
