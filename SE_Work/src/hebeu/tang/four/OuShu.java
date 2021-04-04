package hebeu.tang.four;

public class OuShu {

	public static void main(String[] args) {
		fu ag=new zi(100);
		ag.a();
	}

}
class fu{
	public void a() {
		System.out.println("1到100的偶数是：");
	}
}
class zi extends fu{
	private int i,j;

	public zi(int j) {
		super();
		this.j = j;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void a() {
		for(i=1;i<=j;i++) {
			if(i%2==0) {
				System.out.println("1到100的偶数是："+i);
			}
		}
	}
	
}