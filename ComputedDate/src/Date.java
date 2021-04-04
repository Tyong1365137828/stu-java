import java.util.Scanner;

public class Date {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner date = null;
		int year;
		int month;

		int day; // 没过去的月,即的前月的天数
		int days; // 记录已经过去的月中每个月的天数
		int monthDay; // 记录所有已经过去月的天数
		int allDay; // 记录已经过去的月和当前月的天数,即总天数

		while (true) {
			date = new Scanner(System.in);
			System.out.println("请输入年：");
			year = date.nextInt();
			System.out.println("请输入月：");
			month = date.nextInt();
			System.out.println("请输入日：");

			day = date.nextInt();
			days = 0;
			monthDay = 0;
			allDay = 0;

			if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > 31) {
				System.out.println("输入错误，请重新输入！");
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
		System.out.println("提示：" + year + "年 " + month + "月" + day + "日是这一年的第" + allDay + "天");
		int x = (allDay + 2) % 7;
		if (x == 0) {
			System.out.println("提示：" + year + "年" + month + "月" + day + "日是这一年的星期日");
		} else {
			System.out.println("提示：" + year + "年" + month + "月" + day + "日是这一年的星期" + x);
		}
	}
}