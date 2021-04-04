package jiecheng;

public class JTest {
	
	public static void main(String[] args) {
		JieCheng jieCheng = new JieCheng();
		jieCheng.comput();
	}
	
}


class JieCheng{
	
	void comput() {
		
		int sum =0;
		for(int t=2;t<=10;t=t+2) {
			int n=1;
			
			for(int i=1;i<=t;i++) {
				n*=i;
			}
			
			sum+=n;
		}
		
		System.out.println("sum="+sum);
		
	}
}