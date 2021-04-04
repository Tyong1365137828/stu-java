package table;

public class table {

	private String name;
	private double weight;
	private double kuan;
	private double chang;
	private double gao;

	// 初始化
	public table(String name, double weight, double kuan, double chang, double gao) {
		super();
		this.name = name;
		this.weight = weight;
		this.kuan = kuan;
		this.chang = chang;
		this.gao = gao;
	}

	public void area() {
		System.out.println("桌面面积是" + chang * kuan);
	}

	public void display() {
		System.out.println(
				"桌子编号:" + name + "    桌子重量:" + weight + "    桌面宽度" + kuan + "     桌面长度" + chang + "    桌子高度" + gao);
	}

	// 输出索引值为1到索引值为3的字符
	public void sunNum() {
		String s = name + "";
		System.out.println(s.substring(1, 4));
	}

	// 改变桌子重量
	public double changeweight(double w) {
		return weight = w;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public double getKuan() {
		return kuan;
	}

	public void setKuan(double kuan) {
		this.kuan = kuan;
	}

	public double getChang() {
		return chang;
	}

	public void setChang(double chang) {
		this.chang = chang;
	}

	public double getGao() {
		return gao;
	}

	public void setGao(double gao) {
		this.gao = gao;
	}

	public static void main(String[] args) {

		table shuchu = new table("38302", 32.1, 2.3, 3.9, 1.6);
		shuchu.changeweight(200);
		shuchu.area();
		shuchu.display();
		shuchu.sunNum();
	}
}
