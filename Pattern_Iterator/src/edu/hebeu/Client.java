package edu.hebeu;

import java.util.ArrayList;
import java.util.List;

import edu.hebeu.aggregate.College;
import edu.hebeu.aggregate.ComputerCollege;
import edu.hebeu.aggregate.MaterialCollege;

public class Client {
	public static void main(String[] args) {
		
		// 创建学院的集合对象实例
		List<College> colleges = new ArrayList<>();
		
		// 创建学院对象
		ComputerCollege computerCollege = new ComputerCollege();
		MaterialCollege materialCollege = new MaterialCollege();
		
		// 将学院对象添加入学院集合
		colleges.add(computerCollege);
		colleges.add(materialCollege);
		
		// 遍历
		OutputInfo outputInfo = new OutputInfo(colleges);
		outputInfo.print();
		
	}
}
