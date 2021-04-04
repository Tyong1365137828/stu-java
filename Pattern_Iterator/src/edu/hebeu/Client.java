package edu.hebeu;

import java.util.ArrayList;
import java.util.List;

import edu.hebeu.aggregate.College;
import edu.hebeu.aggregate.ComputerCollege;
import edu.hebeu.aggregate.MaterialCollege;

public class Client {
	public static void main(String[] args) {
		
		// ����ѧԺ�ļ��϶���ʵ��
		List<College> colleges = new ArrayList<>();
		
		// ����ѧԺ����
		ComputerCollege computerCollege = new ComputerCollege();
		MaterialCollege materialCollege = new MaterialCollege();
		
		// ��ѧԺ���������ѧԺ����
		colleges.add(computerCollege);
		colleges.add(materialCollege);
		
		// ����
		OutputInfo outputInfo = new OutputInfo(colleges);
		outputInfo.print();
		
	}
}
