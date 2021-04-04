//规范写法
package hebeu.tang.shuinumber;

public class faer {

	public static void main(String[] args) {
		B cd=new B();
		cd.s2();
	}
}

//法二
class B{
	int i,a2,b2,c2;
	
	void s2() {
		
		System.out.print("水仙花数是:    ");
		for(i=100;i<=999;i++) {
			String s=String.valueOf(i);
			int a2=Integer.parseInt(s.substring(0,1));
			int b2=Integer.parseInt(s.substring(1,2));
			int c2=Integer.parseInt(s.substring(2,3));
			if(a2*a2*a2+b2*b2*b2+c2*c2*c2==i) {
				System.out.print(i+"	");
			}
		}
	}
}