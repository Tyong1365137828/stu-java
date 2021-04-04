package edu.hebeu;

import edu.hebeu.approver.CollegeApprover;
import edu.hebeu.approver.DepartmentApprover;
import edu.hebeu.approver.SchoolMasterApprover;
import edu.hebeu.approver.ViceSchoolMasterApprover;

public class Client {
	public static void main(String[] args) {
		// 创建请求
		PurchaseRequest request = new PurchaseRequest(1, "001", 6000000F);
		
		// 创建职责链的相关对象
		DepartmentApprover departmentApprover = new DepartmentApprover("万主任");
		CollegeApprover collegeApprover = new CollegeApprover("张院长");
		ViceSchoolMasterApprover viceSchollMasterApprover = new ViceSchoolMasterApprover("贾副校长");
		SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("汤校长");
		
		// 设置链
		departmentApprover.setNextApprover(collegeApprover);
		collegeApprover.setNextApprover(viceSchollMasterApprover);
		viceSchollMasterApprover.setNextApprover(schoolMasterApprover);
		schoolMasterApprover.setNextApprover(departmentApprover); // 最好将链设置为环状的，保证不论从哪个职责链结点处理请求都没有问题
		
		departmentApprover.handler(request); // 通过系主任进行处理(通过系主任来进行职责链的传递)
//		viceSchollMasterApprover.handler(request); // 通过副校长进行处理(通过副校长来进行职责链的传递)
		
	}
}
