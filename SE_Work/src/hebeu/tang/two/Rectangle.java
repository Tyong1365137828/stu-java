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
		System.out.println("�þ��ε��ܳ�Ϊ��" + (width * 2 + height * 2));
	}

	public void mianji() {
		System.out.println("�þ��ε����Ϊ��" + width * height);
	}

	public static void main(String[] args) {

		Rectangle king=new Rectangle(3.0, 4.0);
		king.zhouchang();
		king.mianji();
	}
}