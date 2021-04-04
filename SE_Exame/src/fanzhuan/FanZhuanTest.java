package fanzhuan;

public class FanZhuanTest {
	
	public static void main(String[] args) {
		FanZhuan fanZhuan = new FanZhuan();
		fanZhuan.out();
		
	}

}


class FanZhuan{
	
//	//·¨Ò»
//	void out() {
//		int a=5826,b=0,c;
//		while(a>0) {
//			c=a%10;
//			b=b*10+c;
//			a=a/10;
//		}
//		System.out.println(b);
//	}
	
	void out() {
		
		int a=5826;
		String a1=String.valueOf(a);
		
		int b1 = Integer.parseInt(a1.substring(0, 1));
		int b2 = Integer.parseInt(a1.substring(1, 2));
		int b3 = Integer.parseInt(a1.substring(2, 3));
		int b4 = Integer.parseInt(a1.substring(3, 4));
		
		int a2 = b4*1000+b3*100+b2*10+b1;
		System.out.println(a2);
	
	}
	
	
}