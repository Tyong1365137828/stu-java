import java.util.Scanner;

public class Date {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner date = null;
		int year;
		int month;

		int day; // û��ȥ����,����ǰ�µ�����
		int days; // ��¼�Ѿ���ȥ������ÿ���µ�����
		int monthDay; // ��¼�����Ѿ���ȥ�µ�����
		int allDay; // ��¼�Ѿ���ȥ���º͵�ǰ�µ�����,��������

		while (true) {
			date = new Scanner(System.in);
			System.out.println("�������꣺");
			year = date.nextInt();
			System.out.println("�������£�");
			month = date.nextInt();
			System.out.println("�������գ�");

			day = date.nextInt();
			days = 0;
			monthDay = 0;
			allDay = 0;

			if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > 31) {
				System.out.println("����������������룡");
			} else {
				break;
			}
		}

		if (month == 1) {
			allDay = day;
		} else {
			for (int i = 1; i < month; i++) {
				switch (i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					days = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					days = 30;
					break;
				case 2:
					if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
						days = 29;
					} else {
						days = 28;
					}
					break;
				}
				monthDay = monthDay + days;
			}
		}
		allDay = monthDay + day;
		System.out.println("��ʾ��" + year + "�� " + month + "��" + day + "������һ��ĵ�" + allDay + "��");
		int x = (allDay + 2) % 7;
		if (x == 0) {
			System.out.println("��ʾ��" + year + "��" + month + "��" + day + "������һ���������");
		} else {
			System.out.println("��ʾ��" + year + "��" + month + "��" + day + "������һ�������" + x);
		}
	}
}