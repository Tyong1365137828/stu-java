package hebeu.tang.shuinumber;
//��һ
public class Number {
	public static void main(String[] args) {
		for (int i=100;i<1000;i++) {
			int BaiNum=i/100;
			int ShiNum=i/10%10;			//�������λ����10���̣��ں�ʮλ�͸�λ�����ڶԴ���ȥ����λ����ʮλ��
			int GeNum=i%10;
			if(BaiNum*BaiNum*BaiNum+ShiNum*ShiNum*ShiNum+GeNum*GeNum*GeNum==i) {
				System.out.println(i+"��ˮ�ɻ���");
			}
		}
	}
}