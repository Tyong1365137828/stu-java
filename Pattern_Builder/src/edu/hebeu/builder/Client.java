package edu.hebeu.builder;

import edu.hebeu.builder.builder.CommonHouseBuilder;
import edu.hebeu.builder.builder.HighHouseBuilder;
import edu.hebeu.builder.director.HouseDirector;
import edu.hebeu.builder.product.House;

/**
 * 
 * @author 13651
 *
 */
public class Client {
	
	public static void main(String[] args) {
		// ������ͨ�ķ���
		HouseDirector director = new HouseDirector(new CommonHouseBuilder());
		House commonHouseBuilder = director.startBuild();
		System.out.println("-------------------------------------------------");
		// ����߷���
		director.setBuilder(new HighHouseBuilder());
		House highHouseBuilder = director.startBuild();
	}
}
