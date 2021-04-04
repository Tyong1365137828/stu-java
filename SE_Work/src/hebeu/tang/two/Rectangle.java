package hebeu.tang.two;

class Rectangle {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void zhouchang() {
		System.out.println("该矩形的周长为：" + (width * 2 + height * 2));
	}

	public void mianji() {
		System.out.println("该矩形的面积为：" + width * height);
	}

	public static void main(String[] args) {

		Rectangle king=new Rectangle(3.0, 4.0);
		king.zhouchang();
		king.mianji();
	}
}