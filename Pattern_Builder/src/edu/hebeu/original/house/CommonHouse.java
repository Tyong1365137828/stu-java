package edu.hebeu.original.house;

public class CommonHouse extends House{

	@Override
	public void piling() {
		System.out.println("普通房子打地基...");
	}

	@Override
	public void buildWall() {
		System.out.println("普通房子砌墙...");
	}

	@Override
	public void capping() {
		System.out.println("普通房子封顶...");
	}

}
