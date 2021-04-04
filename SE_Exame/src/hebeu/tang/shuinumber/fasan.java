//法二
package hebeu.tang.shuinumber;

public class fasan {

	public static void main(String[] args) {
		A san=new A();
		san.s();
	}

}
class A{
	int i,a,b,c;
	void s() {
		for(i=100;i<1000;i++) {
			a=i/100;
			b=i/10%10;
			c=i%10;
			if(a*a*a+b*b*b+c*c*c==i) {
				System.out.println("水仙花数是"+i);
			}
		}
	}
}