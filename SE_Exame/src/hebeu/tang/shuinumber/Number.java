package hebeu.tang.shuinumber;
//法一
public class Number {
	public static void main(String[] args) {
		for (int i=100;i<1000;i++) {
			int BaiNum=i/100;
			int ShiNum=i/10%10;			//先求出百位数除10的商（内含十位和个位），在对此数去掉个位及得十位；
			int GeNum=i%10;
			if(BaiNum*BaiNum*BaiNum+ShiNum*ShiNum*ShiNum+GeNum*GeNum*GeNum==i) {
				System.out.println(i+"是水仙花数");
			}
		}
	}
}