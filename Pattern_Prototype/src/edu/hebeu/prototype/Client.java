package edu.hebeu.prototype;

public class Client {
	public static void main(String[] args) {
		Sheep tomSheep = new Sheep("tom", 1, "白色");
		
		// 使用原型模式实现克隆
		Sheep tomSheep1 = (Sheep) tomSheep.clone();
		Sheep tomSheep2 = (Sheep) tomSheep.clone();
		Sheep tomSheep3 = (Sheep) tomSheep.clone();
		// ...
		
		// 注意：输出发现hashCode也是不同的，因此这些对象都是通过克隆创建出的对象
		System.out.println("tomSheep = " + tomSheep + ";hashCode" + tomSheep.hashCode());
		System.out.println("tomSheep1 = " + tomSheep1 + ";hashCode" + tomSheep1.hashCode());
		System.out.println("tomSheep2 = " + tomSheep2 + ";hashCode" + tomSheep2.hashCode());
		System.out.println("tomSheep3 = " + tomSheep3 + ";hashCode" + tomSheep3.hashCode());
		// ...
		
		
	}
}
