package hebeu.tang;

import java.util.ArrayList;

public class Move_Test {

	public static void main(String[] args) {
//		ArrayList array;
//		array=new ArrayList();
		
		ArrayList<Animals> list=new ArrayList<Animals>();
		Animals a;
		
		a=new DaiShu();
		list.add(a);
		
		a=new Fish();
		list.add(a);
		
		a=new HuDie();
		list.add(a);
		
		a=new MaoMaoChong();
		list.add(a);
		
		a=new Person();
		list.add(a);
		
		for(int i=0;i<list.size();i++) {
			a=(Animals)list.get(i);
			a.move();
		}
	}

}

abstract class Animals{
	public abstract void move();
}

class Person extends Animals{
	public void move() {
		System.out.println("ֱ������");
	}
}

class HuDie extends Animals{
	public void move() {
		System.out.println("����");
	}
}

class DaiShu extends Animals{
	public void move() {
		System.out.println("��Ծ");
	}
}

class MaoMaoChong extends Animals{
	public void move() {
		System.out.println("����");
	}
}

class Fish extends Animals{
	public void move() {
		System.out.println("��Ӿ");
	}
}