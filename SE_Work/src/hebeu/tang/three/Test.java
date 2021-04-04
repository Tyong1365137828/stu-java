package hebeu.tang.three;

class Test {

	private int j;
	private int i;
	private long k=1;

	public Test(int j) {
		super();
		this.j = j;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void s() {
		for (i = 1; i <= j; i++) {
			k*=i;
			System.out.println("1µ½10µÄ½×³ËÊÇ" + k);
		}

	}

	public static void main(String[] args) {

		Test de=new Test(10);
		de.s();
	}

}
