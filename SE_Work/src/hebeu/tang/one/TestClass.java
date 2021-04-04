package hebeu.tang.one;

public class TestClass {

	public static void main(String[] args) {
		Clock go=new Clock(11,30,56);
		go.show();
		Clock df=new Clock(8,49,23);
		df.show();
		Clock kh=new Clock(17,29,2);
		kh.show();
		
	}

}
class Clock{
	private int hour;
	private int minute;
	private int second;
			//	初始化
	public Clock(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public void chushihua() {
		
	}
	public void show() {
		System.out.println("现在的时间是:"+hour+" :"+minute+" :"+second);
	}
	
}