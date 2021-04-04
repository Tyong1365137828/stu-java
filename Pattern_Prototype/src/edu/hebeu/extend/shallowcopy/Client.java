package edu.hebeu.extend.shallowcopy;

/**
 * 这里使用浅克隆
 * @author 13651
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Sheep sheep = new Sheep("肖恩", 1, "黑色");
		sheep.friendSheep = new Sheep("喜羊羊", 1, "白色");
		
		Sheep sheep1 = (Sheep) sheep.clone();
		Sheep sheep2 = (Sheep) sheep.clone();
		Sheep sheep3 = (Sheep) sheep.clone();
		
		/*此时发现通过sheep实例克隆出的sheep1、sheep2、sheep3对象的hashCode都是不一样的，可以
		证明以上三个对象是通过sheep克隆出来的；但是这三个对象内的friendSheep属性(Sheep引用类型)
		的hashCode是一样的，说明该属性没有克隆，而是直接引用的sheep实例的friendSheep属性对应的
		实例！
		*/
		System.out.println("sheep：" + sheep + "&《" + sheep.hashCode() + "》;friendSheep = " + sheep.friendSheep + "&《" + sheep.friendSheep.hashCode() + "》");
		System.out.println("sheep1：" + sheep + "&《" + sheep1.hashCode() + "》;friendSheep = " + sheep1.friendSheep + "&《" + sheep1.friendSheep.hashCode() + "》");
		System.out.println("sheep2：" + sheep + "&《" + sheep2.hashCode() + "》;friendSheep = " + sheep2.friendSheep + "&《" + sheep2.friendSheep.hashCode() + "》");
		System.out.println("sheep3：" + sheep + "&《" + sheep3.hashCode() + "》;friendSheep = " + sheep3.friendSheep + "&《" + sheep3.friendSheep.hashCode() + "》");
		
	}
}
