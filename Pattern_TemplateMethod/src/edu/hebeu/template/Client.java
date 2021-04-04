package edu.hebeu.template;

import edu.hebeu.template.soybean.JujubeSoybean;
import edu.hebeu.template.soybean.MakeSoybean;
import edu.hebeu.template.soybean.MilkSoybean;
import edu.hebeu.template.soybean.PureSoybean;

public class Client {
	public static void main(String[] args) {
		// �������涹��
		MakeSoybean makeSoybean = new JujubeSoybean();
		makeSoybean.make();
		
		System.out.println("----------------------------------------------------");
		
		// ����ţ�̶���
		MakeSoybean makeSoybean2 = new MilkSoybean();
		makeSoybean2.make();
		
		System.out.println("----------------------------------------------------");
		
		// ����������
		MakeSoybean makeSoybean3 = new PureSoybean();
		makeSoybean3.make();
		
	}
}
