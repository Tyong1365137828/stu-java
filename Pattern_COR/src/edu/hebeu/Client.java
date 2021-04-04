package edu.hebeu;

import edu.hebeu.approver.CollegeApprover;
import edu.hebeu.approver.DepartmentApprover;
import edu.hebeu.approver.SchoolMasterApprover;
import edu.hebeu.approver.ViceSchoolMasterApprover;

public class Client {
	public static void main(String[] args) {
		// ��������
		PurchaseRequest request = new PurchaseRequest(1, "001", 6000000F);
		
		// ����ְ��������ض���
		DepartmentApprover departmentApprover = new DepartmentApprover("������");
		CollegeApprover collegeApprover = new CollegeApprover("��Ժ��");
		ViceSchoolMasterApprover viceSchollMasterApprover = new ViceSchoolMasterApprover("�ָ�У��");
		SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("��У��");
		
		// ������
		departmentApprover.setNextApprover(collegeApprover);
		collegeApprover.setNextApprover(viceSchollMasterApprover);
		viceSchollMasterApprover.setNextApprover(schoolMasterApprover);
		schoolMasterApprover.setNextApprover(departmentApprover); // ��ý�������Ϊ��״�ģ���֤���۴��ĸ�ְ������㴦������û������
		
		departmentApprover.handler(request); // ͨ��ϵ���ν��д���(ͨ��ϵ����������ְ�����Ĵ���)
//		viceSchollMasterApprover.handler(request); // ͨ����У�����д���(ͨ����У��������ְ�����Ĵ���)
		
	}
}
