package edu.hebeu.original.house;

public class HighHouse extends House {

	@Override
	public void piling() {
		System.out.println("高房子打地基...");
	}

	@Override
	public void buildWall() {
		System.out.println("高房子砌墙...");
	}

	@Override
	public void capping() {
		System.out.println("高房子封顶...");
	}

}
