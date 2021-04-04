package oushu;

public class Test {
	
	public static void main(String[] args) {
		OuShu ouShu = new OuShu();
		ouShu.math();
	}
	
}


class OuShu{
	
	void math() {
		
		int sum = 0;
		int n =0;
		for(int i=1;i<=100;i++) {
			
			if(i%2==0) {
				sum+=i;
				n+=1;
				System.out.print(i+"	");
			}
			
			if(n%5==0) {
				System.out.println();
			}
			
		}
		
		System.out.println("ºÍÎª£º"+sum);
		
	}
	
	
}